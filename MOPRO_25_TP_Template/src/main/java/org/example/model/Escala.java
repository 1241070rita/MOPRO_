package org.example.model;

import org.example.utils.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Escala implements Serializable {
    private Data data;
    private List<Voluntario> voluntarios;
    private List<Venda> vendas;


    public Escala(Data data, List<Voluntario> voluntarios) {
        this.data = data;
        this.voluntarios = voluntarios;
        this.vendas = new ArrayList<>();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public void adicionarVoluntario(Voluntario voluntario) {
        voluntarios.add(voluntario);
    }

    public boolean voluntarioJaAssociado(Voluntario voluntario) {
        return voluntarios.contains(voluntario);
    }

    // Adicionar venda
    public boolean efetuarVenda(Barraca barraca, Voluntario voluntario, Produto produto, int quantidade, Data dataVenda) { // Adicionada dataVenda
        if (!(voluntario instanceof VoluntarioVendas)) {
            System.out.println("Apenas voluntários de vendas podem efetuar a venda.");
            return false;
        }

        // Verificar se a quantidade está disponível no stock da escala
        // Agora precisamos calcular o stock disponível para esta escala
        int stockDisponivel = barraca.calcularStockDisponivel(produto, dataVenda); // Usar dataVenda
        if (stockDisponivel < quantidade) {
            System.out.println("Stock insuficiente para o produto: " + produto.getNome());
            return false;
        }

        // Registrar a venda
        Venda venda = new Venda((VoluntarioVendas) voluntario, produto, quantidade);
        vendas.add(venda);
        System.out.println("Venda realizada com sucesso!");
        return true;
    }

    public int calcularTotalVendas(Data data) {
        int totalVendas = 0;
        for (Venda venda : vendas) {
            totalVendas += venda.getQuantidade();
        }
        return totalVendas;
    }

    @Override
    public String toString() {
        return "Escala{" +
                "data=" + data +
                ", voluntarios=" + voluntarios +
                ", vendas=" + vendas +
                '}';
    }
}
