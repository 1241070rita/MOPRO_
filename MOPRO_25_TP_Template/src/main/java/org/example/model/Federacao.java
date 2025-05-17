package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Federacao implements Serializable {
    private String nome;
    private final List<Produto> lstProdutos;
    private final List<Barraca> lstBarracas;
    private final List<Voluntario> lstVoluntarios;
    private Administrador administrador;

    public Federacao(String nome) {
        this.nome = nome;
        this.lstProdutos = new ArrayList<>();
        this.lstBarracas = new ArrayList<>();
        this.lstVoluntarios = new ArrayList<>();
        this.administrador = null;
    }

    public void inicializarSistema() {
        if (administrador == null) {
            // Criar um administrador
            administrador = new Administrador("admin", 0, "Engenharia de Sistemas", "ISEP", "admin123");
            System.out.println("Administrador base criado: Numero Aluno: 0, Senha: admin123");
        }
    }

    public Voluntario autenticarVoluntario(int numeroAluno, String password) {
        for (Voluntario v : lstVoluntarios) {
            if (v.getNumeroAluno() == numeroAluno && v.getPassword().equals(password)) {
                return v;
            }
        }
        return null;
    }

    public Administrador autenticarAdministrador(int numeroAluno, String password) {
        if (administrador == null) {
            return null; // Nenhum administrador criado
        }
        if (administrador.getNumeroAluno() == numeroAluno && administrador.getPassword().equals(password)) {
            return administrador;
        } else {
            return null; // Credenciais inválidas
        }
    }

    public boolean adicionarProduto(Produto produto) {
        if (!listaContemProduto(produto.getNome())) {
            lstProdutos.add(new Produto(produto));
            return true;
        } else {
            return false;
        }
    }

    public boolean listaContemProduto(String nomeProduto) {
        for(Produto produto : lstProdutos){
            if(produto.getNome().equals(nomeProduto)){
                return true;
            }
        }
        return false;
    }

    public boolean adicionarBarraca(Barraca barraca) {
        if (!lstBarracas.contains(barraca)) {
            lstBarracas.add(barraca);
            return true;
        } else {
            return false;
        }
    }

    public List<Barraca> getLstBarracas() {
        return lstBarracas;
    }

    public List<Produto> getLstProdutos() {
        return lstProdutos;
    }

    public List<Voluntario> getLstVoluntarios() {
        return lstVoluntarios;
    }

    public List<Voluntario> getLstVoluntariosVendasPorInstituicao(String instituicao) {
        List<Voluntario> resultado = new ArrayList<>();
        for (Voluntario v : lstVoluntarios) {
            if (v instanceof VoluntarioVendas && v.getInstituicao().equalsIgnoreCase(instituicao)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public boolean adicionarVoluntario(Voluntario voluntario) {
        if (!lstVoluntarios.contains(voluntario)) {
            lstVoluntarios.add(voluntario);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Federacao: ");
        sb.append("nome='").append(nome).append("\n");
        sb.append("Lista de Produtos:");
        if (lstProdutos.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Produto produto : lstProdutos) {
                sb.append("\n\t- ").append(produto);
            }
        }
        sb.append("\nLista de Barracas:");
        if (lstBarracas.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Barraca barraca : lstBarracas) {
                sb.append("\n\t- ").append(barraca);
            }
        }
        sb.append("\nLista de Voluntarios:");
        if (lstVoluntarios.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Voluntario voluntario : lstVoluntarios) {
                sb.append("\n\t- ").append(voluntario);
            }
        }
        return sb.toString();
    }
}
    
    
