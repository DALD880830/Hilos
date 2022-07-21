package com.alopez.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriodo {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        //Interfaz ScheduledExecutorService, clase Executors, implementacion para varias tareas newScheduledThreadPool

        System.out.println("Alguna tarea en main");

        AtomicInteger contador = new AtomicInteger(5); //Usamos un Integer atómico

//        CountDownLatch lock = new CountDownLatch(5); //Bloquea al Thread hasta que se termine la cuenta regresiva

        Future<?> future = executor.scheduleAtFixedRate(() ->{  //Comienza el executor programado
            try {
                TimeUnit.MILLISECONDS.sleep(1000); //Colocamos un delay
//                lock.countDown(); //Decrementa la cuenta
                contador.getAndDecrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Tarea programada");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

//        lock.await(); //Bloquea el Thread hasta que el contador esté en cero
//        future.cancel(true); //Cancela de forma automatica estando en true, en false, cancela cuando termina la tarea en ejecucion

        while (contador.get() >= 0){ //Mientras contador sea mayor o igual a cero
            if (contador.get()==0){ //si contador es igual a 0
                future.cancel(true); //cancela la ejecucion de la tarea
                contador.getAndDecrement(); //Decrementamos el contador
            }
        }

//        TimeUnit.SECONDS.sleep(7); //Bloqueamos el main para que el proceso se repite n cantidad de veces

        System.out.println("Otra tarea del main");
        executor.shutdown(); //Terminamos el executor

    }

}