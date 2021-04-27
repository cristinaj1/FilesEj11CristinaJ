/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cristina
 */
public class ServicioFicheroJSON {

    public void generarFicheroJSON(ArrayList<App> listaApps, String idFichero) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File("aplicaciones.json"), listaApps);
        System.out.println("El fichero " + idFichero + " se ha creado correctamente");

    }
}
