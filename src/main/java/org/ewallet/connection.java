package org.ewallet;

import java.sql.*;

public class connection {
    private String dbUrl = "jdbc:mysql://127.0.0.1:3306/EWalletApp";
    private String user = "root";
    private String password = "Oreo2019!";

    public connection() {

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
