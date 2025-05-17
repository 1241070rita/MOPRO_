package org.example.model;

public class VoluntarioVendas extends Voluntario {
    public VoluntarioVendas(String nome, int numeroAluno, String curso, String instituicao, String password) {
        super(nome, numeroAluno, curso, instituicao, password);
    }

    @Override
    public String toString() {
        return "VoluntarioVendas{" +
                "nome='" + getNome() + '\'' +
                ", numeroAluno=" + getNumeroAluno() +
                ", curso='" + getCurso() + '\'' +
                ", instituicao='" + getInstituicao() + '\'' +
                '}';
    }
}
