package org.example.model;

import static org.example.model.ConfiguracaoClassificacao.LIMITE_STOCK_BRONZE;
import static org.example.model.ConfiguracaoClassificacao.LIMITE_STOCK_PRATA;

public class ClassificacaoBarraca implements Classificacao {
    private ConfiguracaoClassificacao configuracao;
    private int stockFinal;

    public ClassificacaoBarraca(int stockFinal) {
        this.stockFinal = stockFinal;
    }

    @Override
    public String calcularClassificacao() {
        if (stockFinal > LIMITE_STOCK_BRONZE) {
            return "Bronze";
        } else if (stockFinal >= LIMITE_STOCK_PRATA) {
            return "Prata";
        } else {
            return "Ouro";
        }
    }
}
