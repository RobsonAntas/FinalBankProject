package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class CancelAccount implements Serializable {

    private String account;
    private String cpf;
    private String pws;

    public CancelAccount() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    @Override
    public String toString() {
        return "CancelAccount{" +
                "account='" + account + '\'' +
                ", cpf='" + cpf + '\'' +
                ", pws='" + pws + '\'' +
                '}';
    }
}
