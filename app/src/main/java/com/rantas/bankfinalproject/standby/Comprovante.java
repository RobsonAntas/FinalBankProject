package com.rantas.bankfinalproject.model;

import java.util.List;

public class Comprovante {

    private List<Account> bank_account;
    private String _id;
    private int source_transaction;
    private int amount;
    private String createdAt;
    private String updateddAt;
    private int __v;

    public Comprovante() {
    }

    public List<Account> getBank_account() {
        return bank_account;
    }

    public void setBank_account(List<Account> bank_account) {
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

    public String getUpdateddAt() {
        return updateddAt;
    }

    public void setUpdateddAt(String updateddAt) {
        this.updateddAt = updateddAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public String toString() {
        return "Comprovante{" +
                "bank_account=" + bank_account +
                ", _id='" + _id + '\'' +
                ", source_transaction=" + source_transaction +
                ", amount=" + amount +
                ", createdAt='" + createdAt + '\'' +
                ", updateddAt='" + updateddAt + '\'' +
                ", __v=" + __v +
                '}';
    }
}
