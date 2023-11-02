package main;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import form.frmLogin;
import service.Client;
import java.io.IOException;
import java.net.Socket;

public class Main {

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
        FlatArcIJTheme.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new Main().startClient();
        });
        new frmLogin().setVisible(true);
    }
}
