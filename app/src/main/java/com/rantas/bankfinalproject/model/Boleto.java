package com.rantas.bankfinalproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties({"mensagem"})
public class Boleto implements Serializable {

    private String mensagem;
    private String codigo_de_barras;
    private String boleto;

    public Boleto() {
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCodigo_de_barras() {
        return codigo_de_barras;
    }

    public void setCodigo_de_barras(String codigo_de_barras) {
        this.codigo_de_barras = codigo_de_barras;
    }

    @Override
    public String toString() {
        return  "Depósito efetuado com sucesso"+"\n"+
               "Código de Barras: "+getCodigo_de_barras()+"\n";
    }
}
