package com.alopez.hilos.ejemplosync;

import com.alopez.hilos.ejemplosync.runnable.Consumidor;
import com.alopez.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {

    public static void main(String[] args) {

        Panaderia p = new Panaderia(); //Creamos un nuevo objeto panaderia
        new Thread( () -> { //Usamos expresiones lamda de Java 8
            for (int i = 0; i < 10; i ++){
                p.hornear("Pan n°: " + i); //Crea 10 panes
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000)); //Pausa random con la clase
                    //ThreadLocalRandom, permite mediante el hilo actual invocar un Random con un rango
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // Creamos un nuevo hilo y empieza con start

        new Thread( () -> { //Usamos expresiones lamda de Java 8
            for (int i = 0; i < 10; i++){
                p.consumir(); //Consume 10 panes
            }
        }).start(); // Creamos un nuevo hilo y empieza con start

    }

}