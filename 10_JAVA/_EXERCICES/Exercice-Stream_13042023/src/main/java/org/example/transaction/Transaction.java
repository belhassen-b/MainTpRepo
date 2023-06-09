package org.example.transaction;

import org.example.trader.Trader;

public class Transaction {

    public final Trader trader;
    public final int year;
    public final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }
    public String toString() {
        return "{" + this.trader + ", " +
            "year: " + this.year + ", " +
            "value:" + this.value + "}";
    }
}
