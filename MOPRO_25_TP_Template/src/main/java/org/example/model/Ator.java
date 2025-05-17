package org.example.model;

import java.io.Serializable;

public abstract class Ator implements Serializable {
    private String nome;
    private int numeroAluno;
    private String password;

    public Ator(String nome, int numeroAluno, String password) {
        this.nome = nome;
        this.numeroAluno = numeroAluno;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroAluno() {
        return numeroAluno;
    }

    public void setNumeroAluno(int numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Ator{" +
                "nome='" + nome + '\'' +
                ", numeroAluno=" + numeroAluno +
                ", password='" + password + '\'' +
                '}';
    }
}
