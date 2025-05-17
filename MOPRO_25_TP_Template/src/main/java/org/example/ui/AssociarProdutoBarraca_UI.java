package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Produto;
import org.example.utils.Utils;

import java.util.List;

public class  AssociarProdutoBarraca_UI {
    private Federacao federacao;

    public AssociarProdutoBarraca_UI(Federacao federacao) {
        this.federacao = federacao;
    }

    public void run() {
        List<Barraca> barracas = federacao.getLstBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Não há barracas registradas.");
            return;
        }

        Utils.apresentaLista(barracas, "Selecione uma barraca:");
        Barraca barraca = (Barraca) Utils.selecionaObject(barracas);
        if (barraca == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        List<Produto> produtos = federacao.getLstProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos registrados.");
            return;
        }

        Utils.apresentaLista(produtos, "Selecione um produto:");
        Produto produto = (Produto) Utils.selecionaObject(produtos);
        if (produto == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        int quantidade = Utils.readIntFromConsole("Introduza a quantidade inicial: ");
        barraca.adicionarProduto(produto, quantidade);
        System.out.println("Produto associado à barraca com sucesso.");
    }
}