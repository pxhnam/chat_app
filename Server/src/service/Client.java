package service;

import connection.DataAccess;
import form.frmServer;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import utils.DateUtils;
import security.MD5;
import list.*;
import model.*;
import validation.*;

public class Client implements Runnable {

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private DataAccess access;
    private Server server;
    private frmServer fServer;
    private int id;

    public Client(Socket socket, Server server, frmServer fServer) {
        this.socket = socket;
        this.server = server;
        this.fServer = fServer;
        try {
            access = new DataAccess();
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = (Object) ois.readObject();
                if (obj instanceof Account) {
                    Account acc = (Account) obj;
                    String query = "SELECT * FROM account Where username = '" + acc.getUsername() + "' AND password = '" + MD5.hash(acc.getPassword()) + "'";
                    ResultSet result = access.Query(query);
                    if (result.next()) {
                        if (result.getBoolean("Active")) {
                            if (!result.getBoolean("Status")) {
                                setId(result.getInt("id"));
                                send(new User(result.getInt("id"), result.getString("fullname")));
                                server.Logger(result.getString("fullname") + " đã đăng nhập");
                                access.Update("UPDATE Account SET Status = 1 WHERE ID = " + result.getInt("id"));
                                server.broadcast(new Login(id));
                                fServer.loadStatus(id, true);
                            } else {
                                send(new Response(false, "Đang đăng nhập!"));
                            }
                        } else {
                            send(new Response(false, "Tài khoản bị khóa!"));
                        }
                    } else {
                        send(new Response(false, "Sai tài khoản hoặc mật khẩu!"));
                    }
                } else if (obj instanceof Register) {
                    Register reg = (Register) obj;
                    String fullname = reg.getFullname().trim();
                    String email = reg.getUsername().trim();
                    String password = reg.getPassword().trim();
                    String dob = DateUtils.toSqlDate(reg.getDob());
                    int gender = reg.getGender();
                    String[] date = dob.split("-");
                    int day = Integer.parseInt(date[2]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[0]);

                    if (email.equals("") || password.trim().equals("") || fullname.equals("")) {
                        send(new Response(false, "Nhập đầy đủ thông tin!"));
                    } else if (!EmailValidator.isValidEmail(email)) {
                        send(new Response(false, "Email không hợp lệ!"));
                    } else if (!DateValidator.isValidDate(day, month, year)) {
                        send(new Response(false, "Ngày sinh không hợp lệ!"));
                    } else {
                        String query = "INSERT INTO Account(`Username`, `Password`, `Fullname`, `Gender`, `DOB`) "
                                + "VALUES ('" + email + "','" + MD5.hash(password) + "','" + fullname + "'," + gender + ",'" + dob + "')";
                        int result = access.Update(query);
                        if (result > 0) {
                            ResultSet getUser = access.Query("SELECT * FROM account Where username = '" + email + "'");
                            if (getUser.next()) {
                                setId(getUser.getInt("id"));
                                Register register = new Register(getUser.getInt("id"), getUser.getString("fullname"));
                                send(register);
                                server.broadcast(register, id);
                                fServer.addElement(id, fullname, true);
                            }
                            server.Logger(fullname + " đã đăng ký");
                        } else {
                            send(new Response(false, "Xem lại thông tin"));
                        }
                    }
                } else if (obj instanceof Text) {
                    Text text = (Text) obj;
                    if (text.getFrom() != 0 && text.getTo() != 0) {
                        int result = access.Update("INSERT INTO Message VALUES (" + text.getTo() + "," + text.getFrom() + ",'" + text.getMsg() + "', null)");
                        if (result > 0) {
                            text.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                            server.chat(text, text.getTo(), text.getFrom());
                        }
                    }
                } else if (obj instanceof Logout) {
                    Logout out = (Logout) obj;
                    access.Update("UPDATE Account SET Status = 0 WHERE ID = " + out.getId());
                    server.broadcast(new Logout(out.getId()));
                    server.Logger(out.getUsername() + " đã đăng xuất");
                    fServer.loadStatus(out.getId(), false);
                    //server.closeConnect(out.getId());
                } else if (obj instanceof People) {
                    send(loadUserOnline());
                } else if (obj instanceof Friend) {
                    Friend friend = (Friend) obj;
                    send(loadMessage(friend));
                } else if (obj instanceof Object) {
                } else {
                }
            }
        } catch (EOFException e) {
            try {
                ois.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void send(Object obj) {
        try {
            Thread.sleep(100);
            oos.writeObject(obj);
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    public ListPeople loadUserOnline() {
        ResultSet result = access.Query("SELECT * FROM Account WHERE ID != " + id);
        ListPeople listPeople = new ListPeople();
        try {
            while (result.next()) {
                listPeople.add(new People(result.getInt("id"), result.getString("username"), result.getString("fullname"), result.getBoolean("status")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return listPeople;
    }

    public ListMessage loadMessage(Friend friend) {
        ListMessage listMessage = new ListMessage();
        ResultSet result;
        Timestamp createdAt;
        String msg;
        if (friend.getId() == 0) {
            result = access.Query("SELECT * FROM broadcast");
            try {
                while (result.next()) {
                    msg = result.getString("message");
                    createdAt = result.getTimestamp("created_at");
                    listMessage.add(new Message(msg, createdAt));
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        } else {
            result = access.Query("SELECT * FROM Message WHERE idTo = " + id + " OR idFrom = " + id);
            int to;
            int from;
            try {
                while (result.next()) {
                    to = result.getInt("idTo");
                    from = result.getInt("idFrom");
                    msg = result.getString("message");
                    createdAt = result.getTimestamp("created_at");
                    if (to == friend.getId() || from == friend.getId()) {
                        listMessage.add(new Message(to, from, msg, createdAt));
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return listMessage;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
