package com.alopez.hilos.ejemplosync.runnable;

import com.alopez.hilos.ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{ //Clase que implementa la interfaz Runnable

    private Panaderia panaderia; //Atributo panaderia, clase Panaderia

    public Panadero(Panaderia panaderia) { //Constructor
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i ++){
            panaderia.hornear("Pan n°: " + i); //Crea 10 panes
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000)); //Pausa random con la clase
                //ThreadLocalRandom, permite mediante el hilo actual invocar un Random con un rango
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}