package org.ewallet;

public class Currency {
    public double amount;
    public CurrencyType type;

    public static final float[] toUSDValue = new float[]{ // Values last updated: 6/22/24
            1.0f,
            0.93f,
            159.78f,
            0.79f,
            1.5f,
            1.37f
    };

    public Currency() {
        amount = 0;
        type = CurrencyType.USD;
    }

    public Currency(double amount, CurrencyType type) {
        this.amount = amount;
        this.type = type;
    }
}
