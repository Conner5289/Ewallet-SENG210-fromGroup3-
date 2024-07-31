package org.ewallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class UserRepository {

    public static void queryAllUsers() {
        connection dbConnection = new connection();
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to the database");

                // Execute a query
                stmt = conn.createStatement();
                String sql = "SELECT * FROM users"; // Adjust the table name as needed
                ResultSet rs = stmt.executeQuery(sql);

                // Extract data from result set
                while (rs.next()) {
                    // Retrieve by column name
                    String name = rs.getString("username");

                    // Display values
                    System.out.print(", Name: " + name);
                }

                // Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int getUserIdByUsername(String username) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int userID = -1;

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to the database");

                String sql = "SELECT userID FROM users WHERE username = ?";

                pstmt = conn.prepareStatement(sql);
                // By setting a string this way instead of directly we can Avoid SQL injection
                pstmt.setString(1, username);

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    userID = rs.getInt("userID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return userID;
    }

}
