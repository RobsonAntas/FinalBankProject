package com.rantas.bankfinalproject.model;
//status 0-cancelado, 1-ativo, 2-bloqueado.
public class CurrentAccount {

    private String cpf;
    private String account_balance;
    private String status;

    public CurrentAccount() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "cpf='" + cpf + '\'' +
                ", account_balance='" + account_balance + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
