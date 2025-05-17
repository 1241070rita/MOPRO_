/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.example.ui;

import org.example.model.*;
import org.example.utils.Utils;

import java.io.IOException;

public class MenuInicial_UI {
    private Federacao federacao;
    private String opcao;


    public MenuInicial_UI(Federacao federacao) {
        this.federacao = federacao;
        this.federacao.inicializarSistema();
    }

    public void run() throws IOException {
        do {
            System.out.println("###### MENU #####");
            System.out.println("1. Login Administrador");
            System.out.println("2. Login Voluntário");
            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if (opcao.equals("1")) {
                autenticarAdministrador();
            } else if (opcao.equals("2")) {
                autenticarVoluntario();
            }
        } while (!opcao.equals("0"));
    }

    private void autenticarVoluntario() throws IOException {
        int numeroAluno = Utils.readIntFromConsole("Numero Aluno: ");
        String password = Utils.readLineFromConsole("Password: ");

        Voluntario voluntario = federacao.autenticarVoluntario(numeroAluno, password);

        if (voluntario == null) {
            System.out.println("Credenciais inválidas!");
            return;
        }

        if (voluntario instanceof VoluntarioStock) {
            MenuVoluntarioStock ui = new MenuVoluntarioStock(federacao, voluntario);
            ui.run();
        } else if (voluntario instanceof VoluntarioVendas) {
            MenuVoluntarioVendas ui = new MenuVoluntarioVendas(federacao, voluntario);
            ui.run();
        }
    }

    private void autenticarAdministrador() throws IOException {
        int numeroAluno = Utils.readIntFromConsole("Numero Aluno: ");
        String password = Utils.readLineFromConsole("Password: ");

        Administrador administrador = federacao.autenticarAdministrador(numeroAluno, password);

        if (administrador == null) {
            System.out.println("Credenciais inválidas!");
            return;
        }

        MenuAdministrador ui = new MenuAdministrador(federacao);
        ui.run();
    }
}