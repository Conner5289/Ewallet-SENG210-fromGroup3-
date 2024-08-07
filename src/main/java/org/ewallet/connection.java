package org.ewallet;

import java.sql.*;

public class connection {

     private String dbUrl = "jdbc:mysql://localhost:3307/EWalletApp";
     private String user = "root";
     private String password = "92348mexico";

//    private String dbUrl = "jdbc:mysql://localhost:3306/EWalletApp";
//    private String user = "root";
//    private String password = "Oreo2019!";

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
