package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class BankSlip implements Serializable {
    private String boleto;
    private int amount;

    public BankSlip() {
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "boleto='" + boleto + '\'' +
                ", amount=" + amount +
                '}';
    }
}
