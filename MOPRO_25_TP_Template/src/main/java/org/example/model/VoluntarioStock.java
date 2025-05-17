package org.example.model;

public class VoluntarioStock extends Voluntario {
    public VoluntarioStock(String nome, int numeroAluno, String curso, String instituicao, String password) {
        super(nome, numeroAluno, curso, instituicao, password);
    }

    @Override
    public String toString() {
        return "VoluntarioStock{" +
                "nome='" + getNome() + '\'' +
                ", numeroAluno=" + getNumeroAluno() +
                ", curso='" + getCurso() + '\'' +
                ", instituicao='" + getInstituicao() + '\'' +
                '}';
    }
}