package com.rantas.bankfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties({"__v"})
public class User implements Serializable {

    private String _id;
    private String name;
    private String cpf;
    private String pws;
    private String telefone;
    private String avatar;
    private String createdAt;
    private String updatedAt;
//    private int __v;

    public User() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
//
//    public int get_v() {
//        return __v;
//    }
//
//    public void set_v(int _v) {
//        this.__v = _v;
//    }


    @Override
    public String toString() {
        return "Nome: "+getName()+"\n"+
                "CPF: "+getCpf()+"\n"+
                "Telefone: "+getTelefone()+"\n"+
                "Cliente do Mybank desde: "+getCreatedAt()+"\n"+
                "Última Atualização: "+getUpdatedAt()+"\n";
    }
}
