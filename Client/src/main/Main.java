package main;

import form.frmLogin;
import service.Client;
import java.io.IOException;
import java.net.Socket;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main {

    //192.168.0.100
    private static final String ADDRESS = "localhost";
    private static final int PORT = 9999;
    private Socket socket;
    private Client client;

    public void startClient() {
        try {
            socket = new Socket(ADDRESS, PORT);
            client = new Client(socket);
            client.start();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        new Main().startClient();
        new frmLogin().setVisible(true);
    }
}
