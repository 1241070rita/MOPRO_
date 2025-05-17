/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.ui;

import org.example.model.Federacao;
import org.example.model.Voluntario;
import org.example.utils.Utils;

import java.io.IOException;


public class MenuVoluntarioVendas {
    private Federacao federacao;
    private Voluntario voluntario;
    private String opcao;

    public MenuVoluntarioVendas(Federacao federacao, Voluntario voluntario) {
        this.federacao = federacao;
        this.voluntario = voluntario;
    }

    public void run() throws IOException {
        do {
            System.out.println("###### MENU #####");
            System.out.println("1. Fazer venda");
            // Completar
            System.out.println("0. Voltar");
            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if (opcao.equals("1")) {
                EfetuarVenda_UI ui = new EfetuarVenda_UI(federacao, voluntario);
                ui.run();
            }
        }
        while (!opcao.equals("0"));
    }
}


