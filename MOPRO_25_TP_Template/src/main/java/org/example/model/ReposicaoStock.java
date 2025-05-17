package org.example.model;


import org.example.utils.Data;

import java.io.Serializable;

public class ReposicaoStock implements Serializable {
    private VoluntarioStock voluntarioStock;
    private Produto produto;
    private int quantidade;
    private Data data;

    public ReposicaoStock(VoluntarioStock voluntarioStock, Produto produto, int quantidade, Data data) {
        this.voluntarioStock = voluntarioStock;
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = data;
    }

    public VoluntarioStock getVoluntarioStock() {
        return voluntarioStock;
    }

    public void setVoluntarioStock(VoluntarioStock voluntarioStock) {
        this.voluntarioStock = voluntarioStock;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReposicaoStock{" +
                "voluntarioStock=" + voluntarioStock +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }
}
