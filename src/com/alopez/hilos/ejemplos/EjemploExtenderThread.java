package com.alopez.hilos.ejemplos;

import com.alopez.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {

    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Alejandro"); //Creamos la instancia del Hilo, por argumento le pasamos el nombre
        //Al crear la instancia es un hilo nuevo que aun no se ha ejecutado
        hilo.start(); //El start internamente llama al run | Con el start iniciamos el hilo
//        Thread.sleep(5000); //Despues de que termina el hilo, con el sleep hace una pausa de x milisegundos para hacer la siguiente instruccion
        Thread hiloDos = new NombreThread("Daniel"); //Cada hilo corre en paralelo en su propio procesador
        hiloDos.start();
        NombreThread hiloTres = new NombreThread("Lopez");
        hiloTres.start();
        System.out.println(hilo.getState()); //Mostramos el estado en el que se encuentra el hilo

    }

}