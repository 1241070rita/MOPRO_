package org.example.model;

import java.io.Serializable;

public class ConfiguracaoClassificacao implements Serializable {
    public static int LIMITE_STOCK_BRONZE = 100;
    public static int LIMITE_STOCK_PRATA = 50;

    public static double LIMITE_VENDAS_BRONZE = 500.0;
    public static double LIMITE_VENDAS_PRATA = 1000.0;
}
