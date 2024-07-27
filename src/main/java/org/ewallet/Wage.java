package org.ewallet;

import java.util.Date;

public class Wage {
    private int incomeID;
    private int userID;
    private float amount;
    private String source;
    private Date date;

    // Constructor
    public Wage(int incomeID, int userID, float amount, String source, Date date) {
        this.incomeID = incomeID;
        this.userID = userID;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    public Wage(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
