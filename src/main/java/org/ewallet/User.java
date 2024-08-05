package org.ewallet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private ArrayList<Currency> currencyRates;
    private ArrayList<Wage> income; // user income sources that user can record or view or search by type or month
    private ArrayList<Expense> spending; // user's expenses
    private String username;
    private String password;
    // current total income - total
    private double balance;
    // possible monthly savings, calculated using monthly income (most recent)
    // assuming the data we have is for one year, and monthly and biweekly expenses,
    // here you can assume yearly expenses that are recorded have already been paid.
    private double monthlySavings;

    public User(String username, String password) {
        currencyRates = new ArrayList<>();
        income = new ArrayList<>();
        spending = new ArrayList<>();
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.monthlySavings = 0;
    }

    public void addCurrencyRate(Currency currency) {
        currencyRates.add(currency);
    }

    public void addIncome(Wage wage) {
        this.income.add(wage);
    }

    public void addExpense(Expense expense) {
        this.spending.add(expense);
    }

    public ArrayList<Currency> getCurrencyRates() {
        return currencyRates;
    }

    public void setCurrencyRates(ArrayList<Currency> currencyRates) {
        this.currencyRates = currencyRates;
    }

    public ArrayList<Wage> getIncome() {
        return income;
    }

    public void setIncome(ArrayList<Wage> income) {
        this.income = income;
    }

    public ArrayList<Expense> getSpending() {
        return spending;
    }

    public void setSpending(ArrayList<Expense> spending) {
        this.spending = spending;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMonthlySavings() {
        return monthlySavings;
    }

    public void setMonthlySavings(double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }
}
