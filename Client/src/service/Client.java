package service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.*;

public class Client extends Thread {

    private static Socket socket;
    private static Object obj;
    private static ObjectOutputStream oos = null;

    public Client() {
    }

    public Client(Socket socket) {
        Client.socket = socket;
        try {
            if (oos == null) {
                oos = new ObjectOutputStream(socket.getOutputStream());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            while (true) {
                setObj((Object) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public static synchronized void send(Object obj) {
        try {
            if (obj instanceof Account) {
                oos.writeObject((Account) obj);
            } else if (obj instanceof Information) {
                oos.writeObject((Information) obj);
            } else if (obj instanceof Register) {
                oos.writeObject((Register) obj);
            } else if (obj instanceof Text) {
                oos.writeObject((Text) obj);
            } else if (obj instanceof Chat) {
                oos.writeObject((Chat) obj);
            } else if (obj instanceof Logout) {
                oos.writeObject((Logout) obj);
            } else if (obj instanceof People) {
                oos.writeObject((People) obj);
            } else if (obj instanceof Friend) {
                oos.writeObject((Friend) obj);
            } else if (obj instanceof Add_Friend) {
                oos.writeObject((Add_Friend) obj);
            } else if (obj instanceof Group) {
                oos.writeObject((Group) obj);
            } else if (obj instanceof Group_Chat) {
                oos.writeObject((Group_Chat) obj);
            } else if (obj instanceof Create_Group) {
                oos.writeObject((Create_Group) obj);
            } else if (obj instanceof Join_Group) {
                oos.writeObject((Join_Group) obj);
            } else if (obj instanceof Block) {
                oos.writeObject((Block) obj);
            } else {
                System.out.println("does not exist!");
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        Client.socket = socket;
    }

    public synchronized Object getObj() {
        return obj;
    }

    public synchronized void setObj(Object obj) {
        Client.obj = obj;
    }

}
