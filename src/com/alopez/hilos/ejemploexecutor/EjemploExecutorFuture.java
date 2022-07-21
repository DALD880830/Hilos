package com.alopez.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor(); //Executor ejecuta una tarea, con
        // ExecutorService, ejecuta una tarea y le da seguimiento //newSingleThreadExecutor() ejecuta un solo hilo

//        Runnable tarea = () -> { //Iniciamos una tarea
        Callable<String> tarea = () -> { //Callable retorna un valor
            System.out.println("Inicio de la tarea :)");
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName()); //Obtenemos el nombre del hilo actual
                TimeUnit.SECONDS.sleep(3); //Clase TimeUnit, cantidad de tiempo, sleep al hilo actual
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //Interrumpimos el hilo actual
                e.printStackTrace();
            }

            System.out.println("Finaliza la tarea");
            return "Algun resultado importante de la tarea";
        };

        Future<String> resultado = executor.submit(tarea); //Metodo submit, para enviar una tarea, devuelve un objeto Future
        //Se coloca ? porque no devuelve nada
        executor.shutdown(); //Apaga cuando se finaliza la ejecucion, también espera a que se ejecuten todas las tareas que estén en cola
        System.out.println("Continua el metodo main");

//        System.out.println(resultado.isDone()); //isDone devuelve true o false dependiento si la tarea termino
        while(!resultado.isDone()){ //Mientras la tarea no haya finalizado
            System.out.println("ejecutando tarea :/");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
//        System.out.println(resultado.get(2, TimeUnit.SECONDS)); //Bloquea el metodo main, espare a que finalice y se retorne el resultado
        //se le puede pasar un timeout, para que la aplicación no se quede colgada
        System.out.println(resultado.get());
        System.out.println(resultado.isDone());


    }

}