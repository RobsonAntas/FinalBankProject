package com.rantas.bankfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"__v"})
public class AccountStatement implements Serializable {

    private List<String> bank_account;
    private String _id;
    private int source_transaction;
    private int amount;
    private String createdAt;
    private String updatedAt;

    public AccountStatement() {
    }

    public List<String> getBank_account() {
        return bank_account;
    }

    public void setBank_account(List<String> bank_account) {
        this.bank_account = bank_account;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getSource_transaction() {
        return source_transaction;
    }

    public void setSource_transaction(int source_transaction) {
        this.source_transaction = source_transaction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
        return "StatementAccount{" +
                "bank_account=" + bank_account +
                ", _id='" + _id + '\'' +
                ", source_transaction=" + source_transaction +
                ", amount=" + amount +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
