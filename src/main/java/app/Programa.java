/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author cristina
 */
public class Programa {
    //Crea directorios 
    private static void creaDirectorio(String nombre) {

        Path directorio = Paths.get(nombre);
        try {
            Files.createDirectory(directorio);
        } catch (IOException e) {
            System.out.println("No se pudo crear");
            System.out.println(e.toString());
        }
    }
    

    public static void main(String[] args) throws IOException, JAXBException {
        //Creación de directorios
        creaDirectorio("appstsv");
        creaDirectorio("appsxml");
        creaDirectorio("appsjson");
        creaDirectorio("copias");
        creaDirectorio("aplicaciones");
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
        ficheroTSV.generarFicheroDesdeLista(listaApps, "./appstsv/aplicaciones.tsv");
        //Hacer lo mismo que en lo de los muebles(en el siguiente ejercicio)

        ServicioFicheroJSON ficheroJSON = new ServicioFicheroJSON();
        ficheroJSON.generarFicheroJSON(listaApps, "./appsjson/aplicaciones.json");
         for (int i = 0; i < listaApps.size(); i++) {

            ficheroJSON.generarFicheroJSON(listaApps.get(i));

        }
//        ServicioFicheroXML ficheroXML = new ServicioFicheroXML();
//        ficheroXML.generarFicheroXML(listaApps, "aplicaciones.xml");
    }

}
