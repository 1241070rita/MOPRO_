package org.example.model;

import java.io.Serializable;

public abstract class Voluntario extends Ator {
    private String curso;
    private String instituicao;

    public Voluntario(String nome, int numeroAluno, String curso, String instituicao, String password) {
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
        return "Voluntario{" +
                "nome='" + getNome() + '\'' +
                ", numeroAluno=" + getNumeroAluno() +
                ", curso='" + curso + '\'' +
                ", instituicao='" + instituicao + '\'' +
                '}';
    }
}