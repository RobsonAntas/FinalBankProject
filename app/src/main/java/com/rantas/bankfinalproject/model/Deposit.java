package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class Deposit implements Serializable {

    private int amount;

    public Deposit() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "amount=" + amount +
                '}';
    }
}
