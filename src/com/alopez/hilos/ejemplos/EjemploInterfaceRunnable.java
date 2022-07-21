package com.alopez.hilos.ejemplos;

import com.alopez.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {

    public static void main(String[] args) {

        new Thread(new ViajeTarea("Islas Caiman")).start();
        new Thread(new ViajeTarea("Rio de Janeiro")).start();
        new Thread(new ViajeTarea("Paris")).start();
        new Thread(new ViajeTarea("Japon")).start();

    }

}