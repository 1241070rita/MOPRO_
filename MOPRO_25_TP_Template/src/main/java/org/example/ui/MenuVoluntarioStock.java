package org.example.ui;

import org.example.model.Federacao;
import org.example.model.Voluntario;
import org.example.utils.Utils;

import java.io.IOException;

public class MenuVoluntarioStock {
    private Federacao federacao;
    private Voluntario voluntario;
    private String opcao;

    public MenuVoluntarioStock(Federacao federacao, Voluntario voluntario) {
        this.federacao = federacao;
        this.voluntario = voluntario;
    }

    public void run() throws IOException {
        do {
            System.out.println("###### MENU #####");
            System.out.println("1. Adicionar Stock");
            // Completar
            System.out.println("0. Voltar");
            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if (opcao.equals("1")) {
                // Completar
                ReporStock_UI ui = new ReporStock_UI(federacao, voluntario);

                System.out.println("Selecionou a opção: Adicionar stock");
            }
        }
        while (!opcao.equals("0"));
    }
}

