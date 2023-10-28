package service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.Account;
import model.Friend;
import model.Logout;
import model.People;
import model.Register;
import model.Text;

public class Client extends Thread {

    private Socket socket;
    private static Object obj;
    private static ObjectOutputStream oos = null;

    public Client() {
    }

    public Client(Socket socket) {
        this.socket = socket;
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
                Object object = (Object) ois.readObject();
                setObj(object);
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

    public static void send(Object obj) {
        try {
            if (obj instanceof Account) {
                oos.writeObject((Account) obj);
            } else if (obj instanceof Register) {
                oos.writeObject((Register) obj);
            } else if (obj instanceof Text) {
                oos.writeObject((Text) obj);
            } else if (obj instanceof Logout) {
                oos.writeObject((Logout) obj);
            } else if (obj instanceof People) {
                oos.writeObject((People) obj);
            } else if (obj instanceof Friend) {
                oos.writeObject((Friend) obj);
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
        this.socket = socket;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
