package org.ewallet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExpenseCalculator implements IExpenseCalculator {

    private User userAtHand = null;

    public User getUserAtHand() {
		return userAtHand;
	}

	@Override
    public void setUser(User user) {
        userAtHand = user;
    }

    @Override
    public void addExpense(double amount, int yearlyFrequency, Date date) {
    	
    	Expense e = new Expense(amount, date, yearlyFrequency);

        ExpenseRepository.saveExpense(e, userAtHand.getUsername());
    }

    @Override
    public boolean addMonthlyIncome(double amount, String source, Date date) {
    	
    	Wage w = new Wage(amount, source, date);

        if (WageRepository.saveWage(w, userAtHand.getUsername())) {
            return true;
        } else {
            return false;
        }
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
        String filepath1 = "output/UserExpenseReport.txt";
        if (userAtHand == null)
            return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath1))) {
            Gson gson = new Gson();
            Expense[] expenses = gson.fromJson(reader, Expense[].class); // Parse the entire file as an array of Expense
                                                                         // objects

            for (Expense expense : expenses) {
                userAtHand.addExpense(expense); // Add each Expense object to the user
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean loadIncomeFile(String inReport) {
        String filepath2 = "output/UserIncomeReport.txt";
        if (userAtHand == null)
            return false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath2))) {
            Gson gson = new Gson();
            Wage[] wages = gson.fromJson(reader, Wage[].class); // Parse the entire file as an array of Wage objects

            for (Wage wage : wages) {
                userAtHand.addIncome(wage); // Add each Wage object to the user
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int whenCanIBuy(double price, String username) {

        double currentMonthSavings = updateMonthlySavings(username);

        // if their is no remainder return the exact number of months.
        if (price % currentMonthSavings == 0) {

            return (int) (price / currentMonthSavings);

        } else {
            // if their is a remainder return a how many current savings fit in the price
            // and
            // add a one as the reminder get cut out when we are trying to get an Integer
            // that represents the months.
            return (int) (price / currentMonthSavings + 1);
        }
    }

    @Override
    public double updateMonthlySavings(String username) {

        double totalMonthWage = 0.0;
        double totalMonthExpenses = 0.0;
        // Get the current month
        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();

        List<Wage> userWages = new ArrayList<>();
        userWages = WageRepository.queryWageByUsername(username);

        for (Wage wage : userWages) {

            // Converting date variable to local date to extract month value
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(wage.getDate());

            int wageMonth = calendar.get(Calendar.MONTH) + 1; // +1 to adjust for human-readable format
            int wageYear = calendar.get(Calendar.YEAR);

            if (wageMonth == currentMonth && wageYear == currentYear) {

                totalMonthWage += wage.getAmount();
            }
        }

        List<Expense> userExpenses = new ArrayList<>();
        userExpenses = ExpenseRepository.queryExpenseByUsername(username);

        for (Expense expense : userExpenses) {

            // Converting date variable to local date to extract month value
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(expense.getDate());

            int expenseMonth = calendar.get(Calendar.MONTH) + 1; // +1 to adjust for human-readable format
            int expenseYear = calendar.get(Calendar.YEAR);

            if (expenseMonth == currentMonth && expenseYear == currentYear) {

                totalMonthExpenses += expense.getAmount();
            }
        }

        return totalMonthWage - totalMonthExpenses;
    }

    @Override
    public double calculateBalance(String username) {

        double totalWages = 0.0;
        double totalExpenses = 0.0;
        int daysInAYear = 365;

        // Question for professor, when I get a list which was initialized as an
        // arrayList is it still an array list after it gets return and stored in a
        // list.
        List<Wage> userWages = new ArrayList<>(WageRepository.queryWageByUsername(username));
        List<Expense> userExpenses = new ArrayList<>(ExpenseRepository.queryExpenseByUsername(username));

        // Traversing the ArrayList to get the total amount of wages
        for (Wage wage : userWages) {

            totalWages += wage.getAmount();
        }

        for (Expense expense : userExpenses) {

            if (expense.getYearlyFrequency() == 0) {

                totalExpenses += expense.getAmount();

            } else {

                int numOfDaysBetweenExpense = daysInAYear / expense.getYearlyFrequency();

                // We need to convert the date variable to a local date one
                Date input = new Date();
                Instant instant = input.toInstant();
                ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
                LocalDate date = zdt.toLocalDate();

                LocalDate todayDate = LocalDate.now();

                // Calculate the number of days between the two dates
                int daysElapseSinceInitalExpense = (int) ChronoUnit.DAYS.between(date, todayDate);

                int numOfPaymentsMade = daysElapseSinceInitalExpense / numOfDaysBetweenExpense;

                totalExpenses += (numOfPaymentsMade * expense.getAmount());
            }
        }

        return totalWages - totalExpenses;
    }

    public static void main(String[] args) {
        ExpenseCalculator calculator = new ExpenseCalculator();

        double balance = calculator.calculateBalance("admin");
        System.out.println("Balance: " + balance);

        double savings = calculator.updateMonthlySavings("admin");
        System.out.println("Monthly Savings: " + savings);

        int months = calculator.whenCanIBuy(9000, "admin");
        System.out.println("Months to buy item worth $9000: " + months);
    }
}
