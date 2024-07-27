package org.ewallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WageRepository {

    public static void main(String[] args) {
        List<Wage> wages = queryWageByUsername("admin");
        for (Wage wage : wages) {
            System.out.println("Income ID: " + wage.getIncomeID());
            System.out.println("User ID: " + wage.getUserID());
            System.out.println("Amount: " + wage.getAmount());
            System.out.println("Source: " + wage.getSource());
            System.out.println("Date: " + wage.getDate());
        }
    }

    public static List<Wage> queryWageByUsername(String username) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Wage> wages = new ArrayList<>();

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to the database");

                // SQL query to get wage based on username
                // Doing an inner join with the two tables so we can just search by username given that the userIDs match
                String sql = "SELECT income.incomeID, income.userID, income.amount, income.source, income.date FROM income "
                           + "JOIN users ON income.userID = users.userID "
                           + "WHERE users.username = ?";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);

                rs = pstmt.executeQuery();

                // Extract data from result set
                while (rs.next()) {
                    int incomeID = rs.getInt("incomeID");
                    int userID = rs.getInt("userID");
                    float amount = rs.getFloat("amount");
                    String source = rs.getString("source");
                    Date date = rs.getDate("date");

                    Wage wage = new Wage(incomeID, userID, amount, source, date);
                    wages.add(wage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return wages;
    }
    
    public static boolean saveWage(Wage wage) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isSaved = false;

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to the database");

                // SQL query to insert a new wage record into the income table
                String sql = "INSERT INTO income (userID, amount, source, date) VALUES (?, ?, ?, ?)";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, wage.getUserID());
                pstmt.setFloat(2, wage.getAmount());
                pstmt.setString(3, wage.getSource());
                pstmt.setDate(4, new java.sql.Date(wage.getDate().getTime()));

                // Execute the insert
                int rowsAffected = pstmt.executeUpdate();
                // Check if the number of rows affected is greater than zero
                isSaved = (rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isSaved;
    }
}
