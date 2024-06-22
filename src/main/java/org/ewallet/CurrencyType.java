package org.ewallet;

public enum CurrencyType {
    USD(0),
    EURO(1),
    YEN(2),
    POUND(3),
    AUD(4),
    CA(5);

    private int value;

    CurrencyType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CurrencyType fromInt(int i) {
        for (CurrencyType c : CurrencyType.values()) {
            if (c.getValue() == i)
                return c;
        }
        return null;
    }
}
