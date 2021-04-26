/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class ServicioFicheroTSV {

    public static ArrayList<App> crearLista(ArrayList<App> lista) {
        for (int i = 0; i < 10; i++) {
            lista.add(new App());
        }
        return lista;
    }

    public static void main(String[] args) {
        ArrayList<App> lista = new ArrayList<>();
        crearLista(lista);

        String idFichero = "App.tsv";
        String tmp;

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            flujo.newLine();
            for (App app : lista) {
                tmp = String.valueOf(app);
                flujo.write(tmp.toString().replace(",", "\t"));
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("El fichero " + idFichero + " se ha creado correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
