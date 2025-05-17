package org.example.model;

import org.example.utils.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Barraca implements Serializable {
    private String nome;
    private String instituicao;
    private List<ProdutoStock> stocksIniciais;
    private List<Escala> escalas;
    private List<ReposicaoStock> reposicoesStock;

    public Barraca(String nome, String instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
        this.stocksIniciais = new ArrayList<>();
        this.escalas = new ArrayList<>();
        this.reposicoesStock = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public List<ProdutoStock> getStocks() {
        return stocksIniciais;
    }

    public List<Escala> getEscalas() {
        return escalas;
    }

    public void adicionarProduto(Produto produto, int quantidadeInicial) {
        stocksIniciais.add(new ProdutoStock(produto, quantidadeInicial));
    }

    public Escala getEscalaPorData(Data data) {
        for (Escala escala : escalas) {
            if (escala.getData().equals(data)) {
                return escala;
            }
        }
        return null;
    }

    public String calcularClassificacaoBarraca(Data data) {
        int stockFinal = calcularStockFinal(data);
        Classificacao classificacao = new ClassificacaoBarraca(stockFinal);
        return classificacao.calcularClassificacao();
    }

    public boolean reporStock(Voluntario voluntario, Produto produto, int quantidade, Data dataReposicao) {
        if (!(voluntario instanceof VoluntarioStock)) {
            System.out.println("Apenas voluntários de stock podem repor o stock.");
            return false;
        }

        if (!voluntario.getInstituicao().equalsIgnoreCase(this.instituicao)) {
            System.out.println("O voluntário não pertence à mesma instituição da barraca.");
            return false;
        }

        // Procurar o ProdutoStock correspondente
        ProdutoStock psEncontrado = null;
        for (ProdutoStock ps : stocksIniciais) {
            if (ps.getProduto().equals(produto)) {
                psEncontrado = ps;
                break;
            }
        }

        if (psEncontrado == null) {
            System.out.println("Produto não encontrado na barraca.");
            return false;
        }

        //psEncontrado.adicionar(quantidade);
        // Regista a reposição com a data
        reposicoesStock.add(new ReposicaoStock((VoluntarioStock)voluntario, produto, quantidade, dataReposicao));
        System.out.println("Reposição feita com sucesso por " + voluntario.getNome() +
                " | Produto: " + produto.getNome() +
                " | Quantidade: " + quantidade +
                " | Data: " + dataReposicao);
        return true;
    }

    private int calcularStockFinal(Data data) {
        int stockFinal = 0;
        // Stock inicial
        for (ProdutoStock ps : stocksIniciais) {
            stockFinal += ps.getQuantidade();
        }
        // Reposições até à data
        for (ReposicaoStock rs : reposicoesStock) {
            if (data == null || !rs.getData().isMaior(data)) {
                stockFinal += rs.getQuantidade();
            }
        }
        // apenas são consideradas as vendas até à data
        for (Escala escala : escalas) {
            if (data == null || !escala.getData().isMaior(data)) {
                stockFinal -= escala.calcularTotalVendas(data);
            }
        }
        return stockFinal;
    }



    /**
     * Calcula o stock disponível de um produto numa data específica,
     * considerando o stock inicial e as reposições até essa data.
     *
     * @param produto O produto para o qual calcular o stock.
     * @param data    A data para a qual calcular o stock disponível.
     * @return O stock disponível do produto na data especificada.
     */
    public int calcularStockDisponivel(Produto produto, Data data) {
        int stockDisponivel = 0;

        // Encontrar o ProdutoStock inicial
        for (ProdutoStock ps : stocksIniciais) {
            if (ps.getProduto().equals(produto)) {
                stockDisponivel = ps.getQuantidade();
                break;
            }
        }

        // Adicionar as reposições feitas até à data
        for (ReposicaoStock rs : reposicoesStock) {
            if (rs.getProduto().equals(produto) && !rs.getData().isMaior(data)) {
                stockDisponivel += rs.getQuantidade();
            }
        }

        //Subtrair vendas
        for(Escala escala : escalas){
            if(!escala.getData().isMaior(data)){
                for(Venda venda : escala.getVendas()){
                    if(venda.getProduto().equals(produto)){
                        stockDisponivel -= venda.getQuantidade();
                    }
                }
            }
        }
        return stockDisponivel;
    }

    @Override
    public String toString() {
        return "Barraca{" +
                "nome='" + nome + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", stocks=" + stocksIniciais +
                ", escalas=" + escalas +
                '}';
    }
}