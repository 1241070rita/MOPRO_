package org.example.ui;

import org.example.model.*;
import org.example.utils.Data;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RegistarEscala_UI {
    private Federacao federacao;

    public RegistarEscala_UI(Federacao federacao) {
        this.federacao = federacao;
    }

    public void run() {
        List<Barraca> barracas = federacao.getLstBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Não há barracas registradas.");
            return;
        }

        Utils.apresentaLista(barracas, "Selecione uma barraca:");
        Barraca barraca = (Barraca) Utils.selecionaObject(barracas);
        if (barraca == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        Data data = Utils.readDateFromConsole("Introduza a data da escala (dd-MM-yyyy): ");

        // Obter apenas VoluntarioVendas da mesma instituição da barraca
        List<Voluntario> voluntarios = federacao.getLstVoluntariosVendasPorInstituicao(barraca.getInstituicao());
        if (voluntarios.isEmpty()) {
            System.out.println("Não há voluntários de vendas registados para a instituição desta barraca.");
            return;
        }

        // Seleção de múltiplos voluntários
        Utils.apresentaLista(voluntarios, "Selecione voluntários de vendas um a um. Para terminar, introduza opção 0");
        List<Voluntario> voluntariosSelecionados = new ArrayList<>();

        while (true) {
            Voluntario voluntario = (Voluntario) Utils.selecionaObject(voluntarios);
            if (voluntario == null) {
                System.out.println("Parou de adicionar voluntários.");
                break;
            }

            if (voluntariosSelecionados.contains(voluntario)) {
                System.out.println("Voluntário já selecionado.");
                continue;
            }

            // Verifica se o voluntário está em outra barraca na mesma data
            boolean emOutraBarraca = false;
            for (Barraca outraBarraca : federacao.getLstBarracas()) {
                for (Escala escala : outraBarraca.getEscalas()) {
                    if (escala.getData().equals(data) && escala.voluntarioJaAssociado(voluntario)) {
                        emOutraBarraca = true;
                        break;
                    }
                }
            }

            if (emOutraBarraca) {
                System.out.println("Este voluntário já está associado a outra barraca nessa data.");
                continue;
            }

            voluntariosSelecionados.add(voluntario);
        }

        if (voluntariosSelecionados.size() < 2) {
            System.out.println("É necessário pelo menos 2 voluntários de vendas para criar uma escala.");
            return;
        }

        // Criar nova escala ou atualizar existente
        Escala escala = barraca.getEscalaPorData(data); // Você precisa implementar esse método em Barraca
        if (escala != null) {
            System.out.println("Escala já criada.");
            return;
        }
        apresentaDados(escala);

        if (Utils.confirma("Confirma os dados? (S/N)")) {
            escala = new Escala(data, voluntariosSelecionados);
            barraca.getEscalas().add(escala);
            System.out.println("Escala registrada com sucesso com os voluntários de vendas selecionados.");
        }
    }

    private void apresentaDados(Escala escala) {
        System.out.println("Escala: " + escala.toString());
    }
}