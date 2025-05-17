package org.example.ui;

import org.example.model.*;
import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EfetuarVenda_UI {
    private Federacao federacao;
    private Voluntario voluntario;

    public EfetuarVenda_UI(Federacao federacao, Voluntario voluntario) {
        this.federacao = federacao;
        this.voluntario = voluntario;
    }

    public void run() {
        List<Barraca> barracas = federacao.getLstBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Não há barracas disponíveis.");
            return;
        }

        Utils.apresentaLista(barracas, "Escolha a barraca:");
        Barraca barracaSelecionada = (Barraca) Utils.selecionaObject(barracas);
        if (barracaSelecionada == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        Data data = Utils.readDateFromConsole("Introduza a data da venda (dd-MM-yyyy): ");
        Escala escala = barracaSelecionada.getEscalaPorData(data);

        if (escala == null) {
            System.out.println("Não existe escala para essa data.");
            return;
        }

        if (!escala.getVoluntarios().contains(voluntario)) {
            System.out.println("Você não está escalado para esta barraca nesta data.");
            return;
        }

        List<ProdutoStock> stocks = barracaSelecionada.getStocks();
        if (stocks.isEmpty()) {
            System.out.println("Não há produtos disponíveis.");
            return;
        }

        //todo: nao deve apresentar quantidade inicial, mas sim a quantidade calculada consoante a data da escala
        //Utils.apresentaLista(stocks, "Selecione o produto que deseja vender:");
        List<ProdutoStock> stocksAtualizados = new ArrayList<>();
        for (ProdutoStock ps : stocks) {
            int stockAtual = barracaSelecionada.calcularStockDisponivel(ps.getProduto(), data);
            ProdutoStock atualizado = new ProdutoStock(ps.getProduto(), stockAtual);
            stocksAtualizados.add(atualizado);
        }

        Utils.apresentaLista(stocksAtualizados, "Selecione o produto que deseja vender:");
        ProdutoStock produtoStockSelecionado = (ProdutoStock) Utils.selecionaObject(stocksAtualizados);
        if (produtoStockSelecionado == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        int quantidade = Utils.readIntFromConsole("Introduza a quantidade a vender: ");
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        boolean sucesso = escala.efetuarVenda(barracaSelecionada, voluntario, produtoStockSelecionado.getProduto(), quantidade, data); // Passar a barracaSelecionada
        if (!sucesso) {
            System.out.println("Venda não realizada.");
        }
    }
}
