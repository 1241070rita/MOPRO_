package org.example.ui;

import org.example.model.Federacao;
import org.example.model.Voluntario;
import org.example.model.VoluntarioStock;
import org.example.model.VoluntarioVendas;
import org.example.utils.Utils;

public class RegistarVoluntario_UI {
    private Federacao federacao;

    public RegistarVoluntario_UI(Federacao federacao) {
        this.federacao = federacao;
    }

    public void run() {
        System.out.println("Novo Voluntário:");

        Voluntario novoVoluntario = introduzDados();
        apresentaDados(novoVoluntario);

        if (Utils.confirma("Confirma os dados? (S/N)")) {
            if (federacao.adicionarVoluntario(novoVoluntario)) {
                System.out.println("Voluntário registrado com sucesso.");
            } else {
                System.out.println("Não foi possível registrar o voluntário.");
            }
        }
    }

    private static Voluntario introduzDados() {
        System.out.println("Tipos de Voluntário:");
        System.out.println("1. Voluntário de Stock");
        System.out.println("2. Voluntário de Vendas");

        int tipo = Utils.readIntFromConsole("Escolha o tipo de voluntário: ");
        String nome = Utils.readLineFromConsole("Introduza o nome do voluntário: ");
        int numeroAluno = Utils.readIntFromConsole("Introduza o número do aluno: ");
        String curso = Utils.readLineFromConsole("Introduza o curso: ");
        String instituicao = Utils.readLineFromConsole("Introduza a instituição: ");
        String password = Utils.readLineFromConsole("Introduza a password: ");

        switch (tipo) {
            case 1:
                return new VoluntarioStock(nome, numeroAluno, curso, instituicao, password);
            case 2:
                return new VoluntarioVendas(nome, numeroAluno, curso, instituicao, password);
            default:
                throw new IllegalArgumentException("Tipo de voluntário inválido.");
        }
    }

    private void apresentaDados(Voluntario voluntario) {
        System.out.println("Voluntário: " + voluntario.toString());
    }
}