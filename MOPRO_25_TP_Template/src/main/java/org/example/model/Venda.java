package org.example.model;

import java.io.Serializable;

public class Venda implements Serializable {
    private VoluntarioVendas voluntarioVendas;
    private Produto produto;
    private int quantidade;

    public Venda(VoluntarioVendas voluntarioVendas, Produto produto, int quantidade) {
        this.voluntarioVendas = voluntarioVendas;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public VoluntarioVendas getVoluntarioVendas() {
        return voluntarioVendas;
    }

    public void setVoluntarioVendas(VoluntarioVendas voluntarioVendas) {
        this.voluntarioVendas = voluntarioVendas;
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

    @Override
    public String toString() {
        return "Venda{" +
                "voluntarioVendas=" + voluntarioVendas +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
