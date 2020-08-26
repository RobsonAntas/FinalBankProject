package com.rantas.bankfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;


@JsonIgnoreProperties({"_id","source_transaction","amount","createdAt","updatedAt","__v"})
public class Comprovante implements Serializable {


    private List<String> bank_account;

    public Comprovante() {
    }

    public List<String> getBank_account() {
        return bank_account;
    }

    public void setBank_account(List<String> bank_account) {
        this.bank_account = bank_account;
    }

    @Override
    public String toString() {
        return "Comprovante{" +
                "bank_account=" + bank_account +
                '}';
    }
}
