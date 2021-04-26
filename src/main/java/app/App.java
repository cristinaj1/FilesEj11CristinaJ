/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cris
 */
public class App {

    private int codUnico;
    private String nombre;
    private String descripcion;
    private double tamanioKb;
    private LocalDate fechaCreacion;

    private final double MIN = 100.0;
    private final double MAX = 1024.0;
    private Random random = new Random();
    private static int contadorApps = 1;

    public App() {
        this.codUnico = contadorApps;
        this.nombre = generarNombre();
        this.descripcion = descripcion();
        this.tamanioKb = generarTamanio();
        this.fechaCreacion = fechaAleatoria();
        contadorApps++;
    }

    public App(int codUnico, String nombre, String descripcion, double tamanioKb, LocalDate fechaCreacion) {
        this.codUnico = codUnico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanioKb = tamanioKb;
        this.fechaCreacion = fechaCreacion;
        contadorApps++;
    }

    private double generarTamanio() {
        return random.doubles(1, MIN, MAX).sum();
    }

    private String generarNombre() {
        char letra = (char) (random.nextInt(122 - 97 + 1) + 97);
        return "app" + codUnico + letra;
    }

    private String descripcion() {
        int numero = random.nextInt(10) + 1;
        String texto = "";
        switch (numero) {
            case 1:
                texto = "Un programa de cocina";
                break;
            case 2:
                texto = "Un simulador de ps2";
                break;
            case 3:
                texto = "Spotify";
                break;
            case 4:
                texto = "Youtube";
                break;
            case 5:
                texto = "Intagram";
                break;
            case 6:
                texto = "Recreador de misas";
                break;
            case 7:
                texto = "Mando a distancia";
                break;
            case 8:
                texto = "Zoom";
                break;
            case 9:
                texto = "Juego de snake";
                break;
            case 10:
                texto = "Monopoly";
                break;
        }
        return texto;
    }

    private LocalDate fechaAleatoria() {
        int mes = random.nextInt(12 - 1 + 1) + 1;
        int dia = 0;

        if (mes == 2) {
            dia = random.nextInt(28) + 1;
        } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            dia = random.nextInt(30) + 1;
        } else {
            dia = random.nextInt(30) + 1;
        }
        int anio = random.nextInt(2021 - 2010 + 1) + 2010;

        LocalDate fecha = LocalDate.of(anio, mes, dia);
        return fecha;
    }

    public int getCodUnico() {
        return codUnico;
    }

    public void setCodUnico(int codUnico) {
        this.codUnico = codUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanioKb() {
        return tamanioKb;
    }

    public void setTamanioKb(double tamanioKb) {
        this.tamanioKb = tamanioKb;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return nombre + "," + descripcion + "," + tamanioKb + "," + fechaCreacion;
    }

}
