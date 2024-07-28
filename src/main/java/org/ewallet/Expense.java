package org.ewallet;

import java.util.Date;

public class Expense {
    private float amount;
    private Date date;
    private int yearlyFrequency; // 1 for 1 time or once a year, 12 for monthly or 24 for biweekly

    public Expense(float amount, Date date, int yearlyFrequency) {
        this.amount = amount;
        this.date = date;
        this.yearlyFrequency = yearlyFrequency;
    }

    public float getAmount() {
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
