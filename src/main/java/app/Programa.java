/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author cristina
 */
public class Programa {

    public static void main(String[] args) throws IOException, JAXBException {
        //genera 50 aplicaciones y la añado en una lista
        ArrayList<App> listaApps = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listaApps.add(App.crearAppAleatoria());
        }
        for (App listaApp : listaApps) {
            System.out.println(listaApp);
        }
        //Creamos el fichero con el metodo de otra clase(Creada anteriormente).
        ServicioFicheroTSV ficheroTSV = new ServicioFicheroTSV();
        ficheroTSV.generarFicheroDesdeLista(listaApps, "./aplicaciones.tsv");
        //Hacer lo mismo que en lo de los muebles(en el siguiente ejercicio)

        ServicioFicheroJSON ficheroJSON = new ServicioFicheroJSON();
        ficheroJSON.generarFicheroJSON(listaApps, "./aplicaciones.json");
//        ServicioFicheroXML ficheroXML = new ServicioFicheroXML();
//        ficheroXML.generarFicheroXML(listaApps, "aplicaciones.xml");
    }

}
