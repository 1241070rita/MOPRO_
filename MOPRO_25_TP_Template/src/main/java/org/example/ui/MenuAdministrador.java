package org.example.ui;

import org.example.model.Federacao;
import org.example.utils.Utils;

import java.io.IOException;

public class MenuAdministrador {
    private Federacao federacao;
    private String opcao;

    public MenuAdministrador(Federacao federacao)
    {
        this.federacao = federacao;
    }

    public void run() throws IOException
    {
        do
        {
            System.out.println("###### MENU #####");
            System.out.println("1. Registar Produto");
            System.out.println("2. Registar Voluntario");
            System.out.println("3. Registar Barraca");
            System.out.println("4. Associar Produto a Barraca");
            System.out.println("5. Registar Escala");
            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if (opcao.equals("1")) {
                RegistarProduto_UI ui = new RegistarProduto_UI(federacao);
                ui.run();
            } else if (opcao.equals("2")) {
                RegistarVoluntario_UI ui = new RegistarVoluntario_UI(federacao);
                ui.run();
            } else if (opcao.equals("3")) {
                RegistarBarraca_UI ui = new RegistarBarraca_UI(federacao);
                ui.run();
            } else if (opcao.equals("4")) {
                AssociarProdutoBarraca_UI ui = new AssociarProdutoBarraca_UI(federacao);
                ui.run();
            } else if (opcao.equals("5")) {
                RegistarEscala_UI ui = new RegistarEscala_UI(federacao);
                ui.run();
            }
        }
        while (!opcao.equals("0") );
    }
}
