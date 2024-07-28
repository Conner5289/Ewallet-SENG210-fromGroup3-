package org.ewallet;

import java.util.Date;

public class Wage {
    private float amount;
    private String source;
    private Date date;

    // Constructor
    public Wage(float amount, String source, Date date) {
        this.amount = amount;
        this.source = source;
        this.date = date;
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
