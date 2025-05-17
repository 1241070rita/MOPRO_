package org.example.model;

import java.io.Serializable;

public class Administrador extends Ator {
    private String curso;
    private String instituicao;

    public Administrador(String nome, int numeroAluno, String curso, String instituicao, String password) {
        super(nome, numeroAluno, password);
        this.curso = curso;
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + getNome() + '\'' +
                ", numeroAluno=" + getNumeroAluno() +
                ", curso='" + curso + '\'' +
                ", instituicao='" + instituicao + '\'' +
                '}';
    }
}