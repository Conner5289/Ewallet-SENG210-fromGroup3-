package org.ewallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseRepository {

    public static void main(String[] args) {
        List<Expense> expenses = queryExpenseByUsername("admin");
        for (Expense expense : expenses) {
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Date: " + expense.getDate());
            System.out.println("Yearly Frequency: " + expense.getYearlyFrequency());
        }
    }
    
    // Getting all user expenses
    public static List<Expense> queryExpenseByUsername(String username) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Expense> expenses = new ArrayList<>();

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to the database");

                // SQL query to get expenses based on username
                // Doing an inner join with the two tables so we can just search by username given that the userIDs match
                String sql = "SELECT expense.expenseID, expense.userID, expense.amount, expense.date, expense.yearlyFrequency FROM expense "
                           + "JOIN users ON expense.userID = users.userID "
                           + "WHERE users.username = ?";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);

                rs = pstmt.executeQuery();

                // Extract data from result set
                while (rs.next()) {
                    float amount = rs.getFloat("amount");
                    Date date = rs.getDate("date");
                    int yearlyFrequency = rs.getInt("yearlyFrequency");

                    Expense expense = new Expense(amount, date, yearlyFrequency);
                    expenses.add(expense);
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

        return expenses;
    }
    
    public static boolean saveExpense(Expense expense, String username) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isSaved = false;

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                System.out.println("Connected to the database");
                
                int userID = UserRepository.getUserIdByUsername(username);
                if (userID == -1) {
                    System.out.println("User not found.");
                    return false;
                }


                // SQL query to insert a new expense record into the expense table
                String sql = "INSERT INTO expense (userID, amount, date, yearlyFrequency) VALUES (?, ?, ?, ?)";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, userID);
                pstmt.setFloat(2, expense.getAmount());
                pstmt.setDate(3, new java.sql.Date(expense.getDate().getTime()));
                pstmt.setInt(4, expense.getYearlyFrequency());

                // Execute the insert
                int rowsAffected = pstmt.executeUpdate();
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

