package org.ewallet;

import java.util.Date;

public class Expense {
    private int expenseID;
    private int userID;
    private float amount;
    private Date date;
    private int yearlyFrequency; // 1 for 1 time or once a year, 12 for monthly or 24 for biweekly

    public Expense(int expenseID, int userID, float amount, Date date, int yearlyFrequency) {
        this.expenseID = expenseID;
        this.userID = userID;
        this.amount = amount;
        this.date = date;
        this.yearlyFrequency = yearlyFrequency;
    }

    public Expense(String string, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
