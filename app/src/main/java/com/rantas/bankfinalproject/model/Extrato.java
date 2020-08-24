package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class Extrato implements Serializable {

    private String mensagem;
    private Account account;

    public Extrato() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Mensagem: "+this.getMensagem()+"\n"+
                "Conta Corrente: " + this.getAccount().getCode()+"\n"+
                "Agência: "+this.getAccount().getBank_branch()+"\n"+
                "Atualizado em: "+this.getAccount().getUpdatedAt()+"\n";

    }
}
