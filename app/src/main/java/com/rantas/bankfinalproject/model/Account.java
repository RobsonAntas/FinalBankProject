package com.rantas.bankfinalproject.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties({"__v"})
public class Account implements Serializable {
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

//    public int get__v() {
//        return __v;
//    }
//
//    public void set__v(int __v) {
//        this.__v = __v;
//    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", bank_branch='" + bank_branch + '\'' +
                ", code='" + code + '\'' +
                ", user=" + user +
                ", account_balance=" + account_balance +
                ", status=" + status +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}





