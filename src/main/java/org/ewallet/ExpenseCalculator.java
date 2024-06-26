package org.ewallet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ExpenseCalculator implements IExpenseCalculator {

    private User userAtHand = null;

    @Override
    public void setUser(User user) {
        userAtHand = user;
    }

    @Override
    public void addExpense(Expense expense) {
        if (userAtHand == null)
            return;

        userAtHand.addExpense(expense);
    }

    @Override
    public void addMonthlyIncome(Wage w) {
        if (userAtHand == null)
            return;

        userAtHand.addIncome(w);
    }

    @Override
    public void printFullReport(boolean pretty) {
        if (userAtHand == null)
            return;

        Gson gson = new GsonBuilder().create();
        String data = gson.toJson(userAtHand);
        String filePath = "output/UserFullReport.txt";
        File newFile = new File(filePath);
        try {
            if (newFile.createNewFile()) {
                try (PrintWriter out = new PrintWriter(filePath)) {
                    out.print(data);
                }
                System.out.println(data);
            }
        } catch (Exception ignored) {
            System.out.println("Unable to print full report.");
        }
    }

    @Override
    public void printExpenseReport() {
        if (userAtHand == null)
            return;

        Gson gson = new GsonBuilder().create();
        String data = gson.toJson(userAtHand.getSpending().toArray());
        String filePath = "output/UserExpenseReport.txt";
        File newFile = new File(filePath);
        try {
            if (newFile.createNewFile()) {
                try (PrintWriter out = new PrintWriter(filePath)) {
                    out.print(data);
                }
                System.out.println(data);
            }
        } catch (Exception ignored) {
            System.out.println("Unable to print expense report.");
        }
    }

    @Override
    public void printIncomeReport() {
        if (userAtHand == null)
            return;

        Gson gson = new GsonBuilder().create();
        String data = gson.toJson(userAtHand.getIncome().toArray());
        String filePath = "output/UserIncomeReport.txt";
        File newFile = new File(filePath);
        try {
            if (newFile.createNewFile()) {
                try (PrintWriter out = new PrintWriter(filePath)) {
                    out.print(data);
                }
                System.out.println(data);
            }
        } catch (Exception ignored) {
            System.out.println("Unable to print income report.");
        }
    }

    @Override
    public void printIncomeReportByType() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void printExpenseByType() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void exportReport(String reportTitle) {
        if (userAtHand == null)
            return;
    }

    @Override
    public Currency convertCurrency(Currency fromCurrency, CurrencyType toType) {
        Currency newCurrency = new Currency(0, toType);
        // Get the value in USD
        newCurrency.amount = fromCurrency.amount / Currency.toUSDValue[fromCurrency.type.getValue()];
        // Convert from USD to desired type
        newCurrency.amount *= Currency.toUSDValue[toType.getValue()];
        return newCurrency;
    }

    @Override
public boolean loadExpenseFile(String ExReport) {
    	
    	String ExpenseReport = "output/UserExpenseReport.txt";
        if (userAtHand == null)
            return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(ExpenseReport))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String source = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    int yearlyFrequency = Integer.parseInt(parts[2]);
                    Expense expense = new Expense(source, amount, yearlyFrequency);
                    userAtHand.addExpense(expense);
                } else {
                    
                    return false;
                }
            }
            return true;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean loadIncomeFile(String InReport) {
    	String IncomeReport = "output/UserIncomeReport.txt";
    	 if (userAtHand == null)
             return false;

         try (BufferedReader reader = new BufferedReader(new FileReader(IncomeReport))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 String[] parts = line.split(",");
                 if (parts.length == 3) {
                     String source = parts[0];
                     double amount = Double.parseDouble(parts[1]);
                     String month = parts[2];
                     Wage wage = new Wage(source, amount, month);
                     userAtHand.addIncome(wage);
                 } else {
                     // Invalid line format
                     return false;
                 }
             }
             return true;
         } catch (IOException | NumberFormatException e) {
             e.printStackTrace();
             return false;
         }
    }

    @Override
    public int whenCanIBuy(String itemName, double price) {
        return 0;
    }

    @Override
    public void updateMonthlySavings() {

    }
}
