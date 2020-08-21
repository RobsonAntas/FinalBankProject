package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class AddAccount implements Serializable {

    private String cpf;
    private int account_balance;
    private int status;

    public AddAccount() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddAccount{" +
                "cpf='" + cpf + '\'' +
                ", account_balance=" + account_balance +
                ", status=" + status +
                '}';
    }
}
