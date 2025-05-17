package org.example.model;

import static org.example.model.ConfiguracaoClassificacao.LIMITE_VENDAS_BRONZE;
import static org.example.model.ConfiguracaoClassificacao.LIMITE_VENDAS_PRATA;

public class ClassificacaoVoluntario implements Classificacao {
    private double vendasDiarias;

    public ClassificacaoVoluntario(double vendasDiarias) {
        this.vendasDiarias = vendasDiarias;
    }

    @Override
    public String calcularClassificacao() {
        if (vendasDiarias < LIMITE_VENDAS_BRONZE) {
            return "Bronze";
        } else if (vendasDiarias <= LIMITE_VENDAS_PRATA) {
            return "Prata";
        } else {
            return "Ouro";
        }
    }
}
