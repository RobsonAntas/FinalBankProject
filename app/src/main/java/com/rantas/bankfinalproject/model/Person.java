package com.rantas.bankfinalproject.model;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String cpf;
    private String pws;
    private String telefone;
    private String avatar;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", pws='" + pws + '\'' +
                ", telefone='" + telefone + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
