package org.example.model;

import java.io.Serializable;

public class ProdutoStock implements Serializable {
    private Produto produto;
    private int quantidade;

    public ProdutoStock(Produto produto, int quantidadeInicial) {
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("A quantidade inicial não pode ser negativa.");
        }
        this.produto = produto;
        this.quantidade = quantidadeInicial;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade a adicionar não pode ser negativa.");
        }
        this.quantidade += quantidade;
    }

    public void remover(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade a remover não pode ser negativa.");
        }
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
        }
        this.quantidade -= quantidade;
    }

    @Override
    public String toString() {
        return "ProdutoStock{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
