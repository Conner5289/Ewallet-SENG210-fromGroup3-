package org.ewallet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepository {
	
	public static void main(String[] args) {
        queryAllUsers();
    }

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
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
