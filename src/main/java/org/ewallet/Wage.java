package org.ewallet;

public class Wage {
    String source;
    double amount;
    String month;

    public Wage() {
        source = "";
        amount = 0;
        month = "";
    }

    public Wage(String source, double amount, String month) {
        this.source = source;
        this.amount = amount;
        this.month = month;
    }
}
