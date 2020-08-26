package com.rantas.bankfinalproject.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties({"_id","__v"})
public class Account implements Serializable {

    private String bank_branch;
    private String code;
    private String user;
    private int account_balance;
    private int status;
    private String createdAt;
    private String updatedAt;
//    private int __v;

    public Account() {
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return
                "Agência: "+getBank_branch()+"\n"+
                "Conta Corrente: "+getCode()+"\n"+
                "Saldo: "+ getAccount_balance()+"\n"+
                "Criada em: "+ getCreatedAt()+"\n"+
                "Última atualização: "+ getUpdatedAt()+"\n";

    }
}





