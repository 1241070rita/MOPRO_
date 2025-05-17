package org.example.ui;

import org.example.model.*;
import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ReporStock_UI {
    private Federacao federacao;
    private Voluntario voluntario;

    public ReporStock_UI(Federacao federacao, Voluntario voluntario) {
        this.federacao = federacao;
        this.voluntario = voluntario;
    }

    public void run() {
        //todo: duvida - a reposicao do stock deve ser feita ao nivel por escala ou globalmente? pergunto, porque é preciso dar track dos stock finais de cada escala
        //todo: o voluntario precisa de estar associado a uma dada escala
        if (!(voluntario instanceof VoluntarioStock)) {
            System.out.println("Apenas voluntários de stock podem realizar esta operação.");
            return;
        }


        List<Barraca> barracas = federacao.getLstBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Não existem barracas registadas.");
            return;
        }

        // Filtrar barracas da mesma instituição
        List<Barraca> barracasInstituicao = new ArrayList<>();
        for (Barraca b : barracas) {
            if (b.getInstituicao().equalsIgnoreCase(voluntario.getInstituicao())) {
                barracasInstituicao.add(b);
            }
        }

        if (barracasInstituicao.isEmpty()) {
            System.out.println("Não existem barracas da sua instituição.");
            return;
        }

        Utils.apresentaLista(barracasInstituicao, "Escolha uma barraca:");
        Barraca barraca = (Barraca) Utils.selecionaObject(barracasInstituicao);
        if (barraca == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        List<ProdutoStock> stocks = barraca.getStocks();
        if (stocks.isEmpty()) {
            System.out.println("Esta barraca ainda não tem produtos registados.");
            return;
        }

        List<Produto> produtos = new ArrayList<>();
        for (ProdutoStock ps : stocks) {
            produtos.add(ps.getProduto());
        }

        Utils.apresentaLista(produtos, "Escolha o produto para repor:");
        Produto produto = (Produto) Utils.selecionaObject(produtos);
        if (produto == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        int quantidade = Utils.readIntFromConsole("Quantidade a repor: ");
        Data dataReposicao = Utils.readDateFromConsole("Introduza a data de reposição (dd-MM-yyyy): ");
        boolean sucesso = barraca.reporStock(voluntario, produto, quantidade, dataReposicao);

        if (sucesso) {
            System.out.println("Reposição realizada com sucesso.");
        } else {
            System.out.println("Erro ao realizar a reposição.");
        }
    }
}
