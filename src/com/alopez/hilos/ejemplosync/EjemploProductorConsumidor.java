package com.alopez.hilos.ejemplosync;

import com.alopez.hilos.ejemplosync.runnable.Consumidor;
import com.alopez.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {

    public static void main(String[] args) {

        Panaderia p = new Panaderia(); //Creamos un nuevo objeto panaderia
        new Thread(new Panadero(p)).start(); // Creamos un nuevo hilo y empieza con start
        new Thread(new Consumidor(p)).start(); // Creamos un nuevo hilo y empieza con start

    }

}
