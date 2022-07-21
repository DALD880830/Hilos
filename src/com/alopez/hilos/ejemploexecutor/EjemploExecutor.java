package com.alopez.hilos.ejemploexecutor;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor(); //Executor ejecuta una tarea, con
        // ExecutorService, ejecuta una tarea y le da seguimiento //newSingleThreadExecutor() ejecuta un solo hilo

        Runnable tarea = () -> { //Iniciamos una tarea
            System.out.println("Inicio de la tarea :)");
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName()); //Obtenemos el nombre del hilo actual
                TimeUnit.SECONDS.sleep(3); //Clase TimeUnit, cantidad de tiempo, sleep al hilo actual
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //Interrumpimos el hilo actual
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea");

        };

        executor.submit(tarea); //Metodo submit, para enviar una tarea
        executor.shutdown(); //Apaga cuando se finaliza la ejecucion, también espera a que se ejecuten todas las tareas que estén en cola
        System.out.println("Continua el metodo main");
        executor.awaitTermination(2, TimeUnit.SECONDS); //Espera a que finalicen todas las tareas, que se detenga el executor y despues continuar con la ejecucion del metodo main
        //se deben pasar un time out y la unidad de tiempo
        System.out.println("Continua el metodo main2");

    }

}