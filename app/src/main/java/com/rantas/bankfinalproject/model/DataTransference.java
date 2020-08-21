package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class DataTransference implements Serializable {

    private String origem;
    private String destino;
    private int amount;

    public DataTransference() {
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DataTransference{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", amount=" + amount +
                '}';
    }
}
