package com.rantas.bankfinalproject.model;

public class Deposito {

    private int amount;

    public Deposito() {
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
