package service;

import form.frmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Block;

public class Server {

    private static final int PORT = 9999;
    private final List<Client> Cliens = new ArrayList<>();
    private final frmServer frmServer;

    public Server() {
        frmServer = new frmServer(this);
        frmServer.setVisible(true);
    }

    public void Logger(String log) {
        frmServer.logger(log);
    }

    private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Logger("Listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Logger("Client : " + clientSocket.toString());

                Client client = new Client(clientSocket, this, frmServer);
                Cliens.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void chat(Object obj, int to, int from) {
        Cliens.forEach((client) -> {
            if (client.getId() == to || client.getId() == from) {
                client.send(obj);
            }
        });
    }

    public void broadcast(Object obj) {
        Cliens.forEach((client) -> {
            if (client.getSocket().isConnected()) {
                client.send(obj);
            }
        });
    }

    public void broadcast(Object obj, int id) {
        Cliens.forEach((client) -> {
            if (client.getSocket().isConnected()) {
                if (client.getId() != id) {
                    client.send(obj);
                }
            }
        });
    }

    public void blockUser(int id) {
        Cliens.forEach((client) -> {
            if (client.getId() == id) {
                client.send(new Block(id));
            }
        });
    }

    public void closeConnect(int id) {
        Cliens.forEach((client) -> {
            if (client.getId() == id) {
                try {
                    if (client.getSocket().isConnected()) {
                        client.getSocket().close();
                        Cliens.remove(client);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        new Server().startServer();
    }
}
