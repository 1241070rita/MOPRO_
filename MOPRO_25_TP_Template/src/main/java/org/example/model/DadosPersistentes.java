package org.example.model;

import java.io.Serializable;

public class DadosPersistentes implements Serializable {
    private Federacao federacao;

    public DadosPersistentes() {
        this.federacao = new Federacao("Federação Académica do Porto");
        this.federacao.inicializarSistema(); // Cria admin padrão se necessário
    }

    public Federacao getFederacao() {
        return federacao;
    }

    public void setFederacao(Federacao federacao) {
        this.federacao = federacao;
    }

    @Override
    public String toString() {
        return "PersistentData{" +
                "federacao=" + federacao +
                '}';
    }
}
