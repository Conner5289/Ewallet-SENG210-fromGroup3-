package org.ewallet;

import java.util.ArrayList;

public class User {
    private ArrayList <Currency>currencyRates;
    private ArrayList <Wage>Income;  // user income sources that user can record or view or search by type or month
    private ArrayList <Expense>Spending; //user's expenses
    String username;
    String password;
    //current total income - total
    double balance;
    // possible monthly savings, calculated using monthly income (most recent) assuming the data we have is for one year, and monthly and biweekly expenses, here you can assume yearly expenses that are recorded have already been paid.
    double monthlysavings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}