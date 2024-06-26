package org.ewallet;

import java.awt.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EWalletApp extends GUI {
    //this is the app class, has the GUI and create one object of your expense calculator class. The expense calculator class is the implementation of the Expenser interface

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EWalletApp window = new EWalletApp();
                window.frmEWalletApp.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EWalletApp() {
        super();
        initialize();
    }

    public void initialize() {
        ExpenseCalculator expenseCalculator = new ExpenseCalculator();

        User[] users = {
            CreateUser("JohnDoe123", "password12345"),
            CreateUser("JaneDoe456", "1111")
        };

        for (User user : users) {
            expenseCalculator.setUser(user);
            expenseCalculator.addExpense(new Expense("Groceries", 100, 1));
            expenseCalculator.addMonthlyIncome(new Wage("Job", 1200, "January"));
        }

        expenseCalculator.printFullReport(false);
        expenseCalculator.printExpenseReport();
        expenseCalculator.printIncomeReport();
    }

    private ArrayList<User> AllData;
    public User CreateUser(String username, String password) {
        return new User(username, password);
    }
}