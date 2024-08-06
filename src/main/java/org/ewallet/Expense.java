package org.ewallet;

import java.util.Date;

public class Expense {
    private double amount;
    private Date date;
    private int yearlyFrequency; // 1 for 1 time or once a year, 12 for monthly or 24 for biweekly

    public Expense(double amount, Date date, int yearlyFrequency) {
        this.amount = amount;
        this.date = date;
        this.yearlyFrequency = yearlyFrequency;
    }

    public void resetExpense(double amount, Date date, int yearlyFrequency) {
        this.amount = 0.0;
        this.date = null;
        this.yearlyFrequency = 0;

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getYearlyFrequency() {
        return yearlyFrequency;
    }

    public void setYearlyFrequency(int yearlyFrequency) {
        this.yearlyFrequency = yearlyFrequency;
    }
}
