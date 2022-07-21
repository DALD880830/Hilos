package com.alopez.hilos.ejemploexecutor;

import com.alopez.hilos.ejemplosync.Panaderia;
import com.alopez.hilos.ejemplosync.runnable.Consumidor;
import com.alopez.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //ThreadPoolExecutor tipo concreto, se debe hacer el cast

        System.out.println("Tamaño del pool" + executor.getPoolSize()); //Obtenemos el tamaño actual del pool
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size()); //Obtenemos la cantidad de tareas en espera

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        //Quedan sincronizados, panadero y consumidor, usando ExecutorService, el Thread pool tendrá que ser de 2 o más porque si no se cuelga

        Future<?> futuroUno = executor.submit(productor); //Metodo submit, para enviar una tarea, devuelve un objeto Future
        Future<?> futuroDos = executor.submit(consumidor);

        System.out.println("Tamaño del pool" + executor.getPoolSize()); //Obtenemos el tamaño actual del pool
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size()); //Obtenemos la cantidad de tareas en espera

        executor.shutdown(); //Apaga cuando se finaliza la ejecucion, también espera a que se ejecuten todas las tareas que estén en cola
        System.out.println("Continua el metodo main");


    }

}