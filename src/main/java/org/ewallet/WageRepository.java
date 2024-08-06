package org.ewallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;

public class WageRepository {

    public static List<Wage> queryWageByUsername(String username) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Wage> wages = new ArrayList<>();

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                // System.out.println("Connected to the database");

                // SQL query to get wage based on username
                // Doing an inner join with the two tables so we can just search by username
                // given that the userIDs match
                String sql = "SELECT income.incomeID, income.userID, income.amount, income.source, income.date FROM income "
                        + "JOIN users ON income.userID = users.userID "
                        + "WHERE users.username = ?";

                pstmt = conn.prepareStatement(sql);
                // By setting a string this way instead of directly we can Avoid SQL injection
                pstmt.setString(1, username);

                rs = pstmt.executeQuery();

                // Extract data from result set
                while (rs.next()) {
                    double amount = rs.getDouble("amount");
                    String source = rs.getString("source");
                    Date date = rs.getDate("date");

                    Wage wage = new Wage(amount, source, date);
                    wages.add(wage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
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

        return wages;
    }

    public static boolean saveWage(Wage wage, String username) {
        connection dbConnection = new connection();
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isSaved = false;

        try {
            conn = dbConnection.getConnection();

            if (conn != null) {
                // System.out.println("Connected to the database");

                int userID = UserRepository.getUserIdByUsername(username);
                if (userID == -1) {
                    System.out.println("User not found.");
                    return false;
                }

                String sql = "INSERT INTO income (userID, amount, source, date) VALUES (?, ?, ?, ?)";

                pstmt = conn.prepareStatement(sql);
                // By setting a string this way instead of directly we can Avoid SQL injection
                pstmt.setInt(1, userID);
                pstmt.setDouble(2, wage.getAmount());
                pstmt.setString(3, wage.getSource());
                pstmt.setDate(4, new java.sql.Date(wage.getDate().getTime()));

                int rowsAffected = pstmt.executeUpdate();
                isSaved = (rowsAffected > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isSaved;
    }
}
