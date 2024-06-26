package org.ewallet;

public class Expense {
    String source;
    double amount;
    int yearlyFrequency; // 1 for 1 time or once a year, 12 for monthly or 24 for biweekly

    public Expense() {
        source = "";
        amount = 0;
        yearlyFrequency = 0;
    }

    public Expense(String source, double amount, int yearlyFrequency) {
        this.source = source;
        this.amount = amount;
        this.yearlyFrequency = yearlyFrequency;
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public int getYearlyFrequency() { return yearlyFrequency; }
    public void setYearlyFrequency(int yearlyFrequency) { this.yearlyFrequency = yearlyFrequency; }
}
