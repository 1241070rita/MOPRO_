package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.utils.Utils;

public class RegistarBarraca_UI {
    private Federacao federacao;

    public RegistarBarraca_UI(Federacao federacao) {
        this.federacao = federacao;
    }

    public void run() {
        System.out.println("Nova Barraca:");

        Barraca novaBarraca = introduzDados();
        apresentaDados(novaBarraca);

        if (Utils.confirma("Confirma os dados? (S/N)")) {
            if (federacao.adicionarBarraca(novaBarraca)) {
                System.out.println("Barraca registrada com sucesso.");
            } else {
                System.out.println("Não foi possível registrar a barraca.");
            }
        }
    }

    private static Barraca introduzDados() {
        String nome = Utils.readLineFromConsole("Introduza o nome da barraca: ");
        String instituicao = Utils.readLineFromConsole("Introduza a instituição associada: ");
        return new Barraca(nome, instituicao);
    }

    private void apresentaDados(Barraca barraca) {
        System.out.println("Barraca: " + barraca.toString());
    }
}