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
import security.MD5;
import list.*;
import model.*;
import utils.*;
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
                    ResultSet rs = access.Query(query);
                    if (rs.next()) {
                        if (rs.getBoolean("Active")) {
                            if (!rs.getBoolean("Status")) {
                                setId(rs.getInt("id"));
                                send(new User(rs.getInt("id"), rs.getString("fullname")));
                                server.Logger(rs.getString("fullname") + " đã đăng nhập");
                                access.Update("UPDATE Account SET Status = 1 WHERE ID = " + id);
                                //server.broadcast(new Login(id));
                                notification(id, new Login(id));
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

                    if (email.equals("") || password.trim().equals("") || fullname.equals("")) {
                        send(new Response(false, "Nhập đầy đủ thông tin!"));
                    } else if (!EmailValidator.isValidEmail(email)) {
                        send(new Response(false, "Email không hợp lệ!"));
                    } else if (!DateValidator.isValidDate(dob)) {
                        send(new Response(false, "Ngày sinh không hợp lệ!"));
                    } else {
                        if (reg.getCode() == null) {
                            send(reg);
                            OTP.generate(email);
                        } else {
                            if (OTP.verification(reg.getCode())) {
                                reg.setVeri(true);
                                String query = "INSERT INTO Account(`Username`, `Password`, `Fullname`, `Gender`, `DOB`) "
                                        + "VALUES ('" + email + "','" + MD5.hash(password) + "','" + fullname + "'," + gender + ",'" + dob + "')";
                                int result = access.Update(query);
                                if (result > 0) {
                                    ResultSet getUser = access.Query("SELECT * FROM account Where username = '" + email + "'");
                                    if (getUser.next()) {
                                        send(new Response(true, "Đăng ký thành công"));
                                        fServer.addElement(getUser.getInt("id"), fullname, false);
                                        server.Logger(fullname + " đã đăng ký");
                                    }
                                } else {
                                    send(new Response(false, "Xem lại thông tin"));
                                }
                            } else {
                                reg.setVeri(false);
                                send(reg);
                            }
                        }
                    }
                } else if (obj instanceof Information) {
                    Information info = (Information) obj;
                    ResultSet rs = access.Query("SELECT * FROM ACCOUNT WHERE ID = " + id);
                    if (info.getId() == 0) {
                        if (rs.next()) {
                            info.setFullname(rs.getString("fullname"));
                            info.setGender(rs.getBoolean("gender") == true ? 1 : 0);
                            info.setDob(rs.getDate("dob"));
                            send(info);
                        }
                    } else {
                        //save
                    }
                } else if (obj instanceof Text) {
                    Text text = (Text) obj;
                    if (text.getFrom() != 0 && text.getTo() != 0) {
                        int result = access.Update("INSERT INTO Message VALUES (" + text.getFrom() + "," + text.getTo() + ",'" + text.getMsg() + "', null)");
                        if (result > 0) {
                            text.setSentAt(new Timestamp(System.currentTimeMillis()));
                            server.chat(text, text.getTo(), text.getFrom());
                        }
                    }
                } else if (obj instanceof Group_Chat) {
                    Group_Chat gc = (Group_Chat) obj;
                    send(loadChat(gc));
                } else if (obj instanceof Chat) {
                    Chat chat = (Chat) obj;
                    if (chat.getGroup() > 0 && !chat.getMessage().trim().equals("")) {
                        int result = access.Update("INSERT INTO Group_Chat VALUES (" + chat.getGroup() + "," + chat.getSender() + ",'" + chat.getMessage() + "',null)");
                        if (result > 0) {
                            chat.setSentAt(new Timestamp(System.currentTimeMillis()));
                            ResultSet rs = access.Query("SELECT * FROM Members WHERE ID = " + chat.getGroup());
                            while (rs.next()) {
                                server.chatGroup(rs.getInt("member"), chat);
                            }
                        }
                    }
                } else if (obj instanceof Logout) {
                    Logout out = (Logout) obj;
                    access.Update("UPDATE Account SET Status = 0 WHERE ID = " + out.getId());
                    //server.broadcast(new Logout(out.getId()));
                    notification(out.getId(), new Logout(out.getId()));
                    server.Logger(out.getUsername() + " đã đăng xuất");
                    fServer.loadStatus(out.getId(), false);
                    //server.closeConnect(out.getId());
                } else if (obj instanceof People) {
                    send(loadUserOnline());
                } else if (obj instanceof Group) {
                    Group gr = (Group) obj;
                    send(loadGroup(gr.getUser()));
                } else if (obj instanceof Friend) {
                    Friend friend = (Friend) obj;
                    send(loadMessage(friend));
                } else if (obj instanceof Add_Friend) {
                    Add_Friend add = (Add_Friend) obj;
                    int idFr = 0;
                    String name = "";
                    boolean status = false;
                    ResultSet rs = access.Query("SELECT * FROM Account WHERE Username = '" + add.getEmail() + "'"
                            + " AND ID NOT IN (SELECT blocked FROM blocks WHERE blocker = " + id + ")"
                            + " AND ID NOT IN (SELECT blocker FROM blocks WHERE blocked = " + id + ")"
                    );

                    if (rs.next()) {
                        idFr = rs.getInt("id");
                        name = rs.getString("fullname");
                        status = rs.getBoolean("status");
                    } else {
                        add.setIsFriend(false);
                        add.setResponse("Thử lại!");
                        send(add);
                    }
                    if (idFr != 0) {
                        ResultSet isValid = access.Query("SELECT EXISTS (SELECT 1 FROM Friends WHERE id = " + add.getMe() + " AND Friend = " + idFr + ");");
                        boolean exists = isValid.next() && isValid.getBoolean(1);
                        if (!exists) {
                            int update = access.Update("INSERT INTO Friends VALUES (" + add.getMe() + "," + idFr + " )");
                            if (update > 0) {
                                send(new Add_Friend(idFr, name, status, true));
                            } else {
                                add.setIsFriend(false);
                                add.setResponse("Kết bạn thất bại!");
                                send(add);
                            }
                        } else {
                            add.setIsFriend(false);
                            add.setResponse("Đã là bạn bè!");
                            send(add);
                        }
                    }
                } else if (obj instanceof Create_Group) {
                    Create_Group cgr = (Create_Group) obj;
                    if (!cgr.getName().trim().equals("")) {
                        int id = 0;
                        int founder = cgr.getFounder();
                        String name = cgr.getName();
                        int update = access.Update("INSERT INTO Groups (`Name`, `Founder`) VALUES ('" + name + "', " + founder + ")");
                        if (update > 0) {
                            ResultSet rs = access.Query("SELECT * FROM Groups WHERE Founder = " + founder + " ORDER BY ID DESC LIMIT 1");
                            if (rs.next()) {
                                id = rs.getInt("id");
                            }
                            if (id > 0) {
                                String code = generate.code(id, name);
                                int upCode = access.Update("UPDATE Groups SET Code = '" + code + "' WHERE ID = " + id);
                                if (upCode > 0) {
                                    int upMem = access.Update("INSERT INTO Members VALUES ('" + id + "'," + founder + ",null,1)");
                                    if (upMem > 0) {
                                        send(new Create_Group(id, code, name, true));
                                        server.Logger(cgr.getUser() + " đã tạo nhóm " + name);
                                    } else {
                                        cgr.setIsSuccess(false);
                                        cgr.setResponse("Tạo thất bại!");
                                        send(cgr);
                                    }
                                } else {
                                    cgr.setIsSuccess(false);
                                    cgr.setResponse("Tạo thất bại!");
                                    send(cgr);
                                }
                            } else {
                                cgr.setIsSuccess(false);
                                cgr.setResponse("Tạo thất bại!");
                                send(cgr);
                            }
                        } else {
                            cgr.setIsSuccess(false);
                            cgr.setResponse("Tạo thất bại!");
                            send(cgr);
                        }
                    }
                } else if (obj instanceof Join_Group) {
                    Join_Group jgr = (Join_Group) obj;
                    int idGr = 0;
                    String code = "";
                    String name = "";
                    ResultSet rs = access.Query("SELECT * FROM Groups WHERE Code = '" + jgr.getCode() + "'");
                    if (rs.next()) {
                        idGr = rs.getInt("id");
                        name = rs.getString("name");
                        code = rs.getString("code");
                    } else {
                        jgr.setIsJoin(false);
                        jgr.setResponse("Nhóm không tồn tại");
                        send(jgr);
                    }
                    if (idGr != 0) {
                        ResultSet isValid = access.Query("SELECT EXISTS (SELECT 1 FROM Members WHERE id = " + idGr + " AND member = " + jgr.getUser() + ");");
                        boolean exists = isValid.next() && isValid.getBoolean(1);
                        if (!exists) {
                            int update = access.Update("INSERT INTO Members VALUES (" + idGr + "," + jgr.getUser() + ", null, 0)");
                            if (update > 0) {
                                fServer.logger(jgr.getUser() + " vừa tham gia nhóm " + name);
                                send(new Join_Group(idGr, code, name, true));
                            } else {
                                jgr.setIsJoin(false);
                                jgr.setResponse("Tham gia thất bại!");
                                send(jgr);
                            }
                        } else {
                            jgr.setIsJoin(false);
                            jgr.setResponse("Đã là thành viên rồi!");
                            send(jgr);
                        }
                    }
                } else if (obj instanceof Block) {
                    Block block = (Block) obj;
                    int result = access.Update("INSERT INTO BLOCKS VALUES (" + block.getBlocker() + "," + block.getBlocked() + ")");
                    if (result > 0) {
                        send(block);
                    }
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
            oos.writeObject(obj);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private synchronized ListPeople loadUserOnline() {
        ResultSet result = access.Query("SELECT * FROM Account WHERE id != " + id
                + " AND ID IN (SELECT Friend FROM Friends WHERE ID = " + id + ")"
                + " AND ID NOT IN (SELECT blocked FROM blocks WHERE blocker = " + id + ")"
                + " AND ID NOT IN (SELECT blocker FROM blocks WHERE blocked = " + id + ")");
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

    private synchronized ListGroup loadGroup(int id) {
        ListGroup groups = new ListGroup();
        ResultSet result = access.Query("SELECT * FROM Groups g INNER JOIN Members m ON g.id = m.id INNER JOIN account a ON m.member = a.id WHERE a.id = " + id);
        try {
            while (result.next()) {
                groups.add(new Group(result.getInt("id"), result.getString("code"), result.getString("name")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return groups;
    }

    private synchronized ListMessage loadMessage(Friend friend) {
        ListMessage listMessage = new ListMessage();
        ResultSet rs;
        Timestamp sentAt;
        String msg;
        if (friend.getId() == 0) {
            rs = access.Query("SELECT * FROM broadcast");
            try {
                while (rs.next()) {
                    msg = rs.getString("message");
                    sentAt = rs.getTimestamp("sent_at");
                    listMessage.add(new Message(msg, sentAt));
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        } else {
            rs = access.Query("SELECT * FROM Message m INNER JOIN Account a ON m.sender = a.ID WHERE m.sender = " + id + " AND m.receiver = " + friend.getId() + " OR m.sender = " + friend.getId() + " AND m.receiver = " + id + " ORDER BY m.sent_at");
            int receiver;
            int sender;
            String nameSender;
            try {
                while (rs.next()) {
                    receiver = rs.getInt("receiver");
                    sender = rs.getInt("sender");
                    nameSender = rs.getString("fullname");
                    msg = rs.getString("message");
                    sentAt = rs.getTimestamp("sent_at");
                    //if (sender == friend.getId() || receiver == friend.getId()) {}
                    listMessage.add(new Message(receiver, sender, nameSender, msg, sentAt));
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return listMessage;
    }

    private synchronized ListChat loadChat(Group_Chat gc) {
        ListChat chats = new ListChat();
        chats.setID(gc.getGroup());
        chats.setTitle(gc.getTitle());
        chats.setCode(gc.getCode());
        ResultSet rs = access.Query("SELECT * FROM Account a INNER JOIN Group_Chat gc ON gc.group_id = " + gc.getGroup() + " AND gc.sender_id = a.ID");
        int sender;
        String name;
        String msg;
        Timestamp sentAt;

        try {
            while (rs.next()) {
                sender = rs.getInt("id");
                name = rs.getString("fullname");
                msg = rs.getString("message");
                sentAt = rs.getTimestamp("sent_at");
                chats.add(new Chat(sender, name, msg, sentAt));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return chats;
    }

    private synchronized void notification(int id, Object obj) {
        ResultSet rs = access.Query("SELECT * FROM Friends WHERE Friend = " + id);
        try {
            while (rs.next()) {
                server.broadcast(rs.getInt("id"), obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
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
