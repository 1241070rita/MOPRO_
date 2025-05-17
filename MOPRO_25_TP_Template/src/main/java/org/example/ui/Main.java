package org.example.ui;

import org.example.model.DadosPersistentes;
import org.example.model.Federacao;

import java.io.*;

public class Main {
    //Informação guardada
    protected static DadosPersistentes dadosPersistentes; //Cria o objeto que vai receber a informação
    private static String appFilePath = "src/main/resources/fap.dat"; //Caminho do ficheiro onde a informação é guardada

    public static void main(String[] args) {
        try {
            //Informação persistente
            carregarDados();

            // Usa a federação já carregada
            Federacao fap = dadosPersistentes.getFederacao();
            fap.inicializarSistema(); // garante que existe admin

            System.out.println(fap);

            MenuInicial_UI uiMenu = new MenuInicial_UI(fap);
            uiMenu.run();

            // Atualiza o objeto e guarda
            dadosPersistentes.setFederacao(fap);
            salvarDados();

            System.out.println(fap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salvarDados() {
        try {
            FileOutputStream fileOut = new FileOutputStream(appFilePath);
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(dadosPersistentes);
            outStream.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void carregarDados() {
        try {
            FileInputStream fileIn = new FileInputStream(appFilePath);
            ObjectInputStream inStream = new ObjectInputStream(fileIn);
            dadosPersistentes = (DadosPersistentes) inStream.readObject();
            inStream.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException ex) {
            // Se falhar a leitura, cria um novo objeto por defeito
            dadosPersistentes = new DadosPersistentes();
        }
    }
}
