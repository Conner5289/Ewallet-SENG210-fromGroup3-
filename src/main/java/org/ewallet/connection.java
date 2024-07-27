package org.ewallet;

import java.sql.*;

public class connection {
    private String dbUrl = "jdbc:mysql://localhost:3307/EWalletApp";
    private String user = "root";
    private String password = "92348mexico";

    public connection() {
        // Constructor can remain empty or print a message if needed
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
