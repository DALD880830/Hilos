package com.alopez.hilos.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduledExecutorService {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        //Interfaz ScheduledExecutorService, clase Executors, implementacion para varias tareas newScheduledThreadPool

        System.out.println("Alguna tarea en main");

        executor.schedule(() ->{  //Comienza el executor programado
            try {
                TimeUnit.MILLISECONDS.sleep(1000); //Colocamos un delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tarea programada");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Otra tarea del main");
        executor.shutdown(); //Terminamos el executor

    }

}