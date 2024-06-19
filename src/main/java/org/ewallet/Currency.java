package org.ewallet;

public class Currency {
    public double rate;
    public String name;

    public Currency() {
        rate = 0;
        name = "";
    }

    public Currency(double rate, String name) {
        this.rate = rate;
        this.name = name;
    }
}
