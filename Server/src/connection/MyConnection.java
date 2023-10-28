package connection;

import java.sql.*;

public class MyConnection {

    private static Connection connection = null;
    private static final String ADDRESS = "localhost";
    private static final String DATABASE = "chat_app";
    private static final int PORT = 3306;

    public Connection getConnection() {
        try {
            String URL = "jdbc:mysql://" + ADDRESS + ":" + PORT + "/" + DATABASE;
            connection = DriverManager.getConnection(URL, "root", "");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return connection;
    }
}
