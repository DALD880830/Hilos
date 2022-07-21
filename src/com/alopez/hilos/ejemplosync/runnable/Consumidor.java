package com.alopez.hilos.ejemplosync.runnable;

import com.alopez.hilos.ejemplosync.Panaderia;

public class Consumidor implements Runnable{ //Clase que implementa la interfaz Runnable

    private Panaderia panaderia; //Atributo panaderia, clase Panaderia

    public Consumidor(Panaderia panaderia) { //Constructor
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            panaderia.consumir(); //Consume 10 panes
        }
    }

}