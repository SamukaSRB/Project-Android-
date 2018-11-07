package com.example.aryane.srbcomercial.Model;

import java.util.Date;

public class ProdutoModel {


    public int codigo;
    public String  ean;
    public String nome;
    public String descrição;
    public String categoria;
    public int valor;
    public int quantidade;
    public int quantDispon;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantDispon() {
        return quantDispon;
    }

    public void setQuantDispon(int quantDispon) {
        this.quantDispon = quantDispon;
    }



}
