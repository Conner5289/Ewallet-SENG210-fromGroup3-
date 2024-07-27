package org.ewallet;

import java.awt.*;
import java.util.ArrayList;

class EWallet {
    //this is the app class, has the GUI and create one object of your expense calculator class. The expense calculator class is the implementation of the Expenser interface

    public EWallet() {
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
            
            String expenseFilePath = "output/UserExpenseReport.txt";
            String incomeFilePath = "output/UserIncomeReport.txt";
            
            if (expenseCalculator.loadExpenseFile(expenseFilePath)) {
        		System.out.println("Expenses loaded successfully for user: " + user.getUsername());
        	} else {
        		System.out.println("Failed to load expenses for user: " + user.getUsername());
        	}
        	
        	//load the incomes
        	if (expenseCalculator.loadIncomeFile(incomeFilePath)) {
        		System.out.println("Incomes loaded successfully for user: " + user.getUsername());
        	} else {
        		System.out.println("Failed to load incomes for user: " + user.getUsername());
        	}

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

public class EWalletApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInterface frame = new GuiInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


