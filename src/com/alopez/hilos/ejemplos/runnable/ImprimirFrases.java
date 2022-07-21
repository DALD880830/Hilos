package com.alopez.hilos.ejemplos.runnable;

import static com.alopez.hilos.ejemplos.EjemploSincronizacionThread.imprimirFrases; //Imprimimos de forma estatica el metodo de la clase

public class ImprimirFrases implements Runnable{

    private String frase1;
    private String frase2;

    public ImprimirFrases(String frase1, String frase2) { //Constructor con las dos frases que se pasan por parametro
        this.frase1 = frase1;
        this.frase2 = frase2;
    }


    @Override
    public void run() {
        imprimirFrases(this.frase1, this.frase2); //Usamos el metodo estático imprimirFrases
        // de la clase EjemploSincronizacionThread
    }
}