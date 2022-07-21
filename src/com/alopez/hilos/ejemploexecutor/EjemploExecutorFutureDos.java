package com.alopez.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFutureDos {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

//        ExecutorService executor = Executors.newSingleThreadExecutor(); //Executor ejecuta una tarea, con
        // ExecutorService, ejecuta una tarea y le da seguimiento //newSingleThreadExecutor() ejecuta un solo hilo
//        ExecutorService executor = Executors.newFixedThreadPool(2); //newFixedThreadPool() permite que se ejecuten el numero de tareas que pasan, al mismo tiempo

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        //ThreadPoolExecutor tipo concreto, se debe hacer el cast

        System.out.println("Tamaño del pool" + executor.getPoolSize()); //Obtenemos el tamaño actual del pool
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size()); //Obtenemos la cantidad de tareas en espera

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

        Callable<Integer> tareaTres = () -> { //Creamos una tarea diferente
            System.out.println("Iniciando la tarea 3");
            TimeUnit.SECONDS.sleep(3); //Con una tardanza de 3 segundos
            return 10; //Retorna 10
        };

        Future<String> resultado = executor.submit(tarea); //Metodo submit, para enviar una tarea, devuelve un objeto Future
        //Se coloca ? porque no devuelve nada
        Future<String> resultadoDos = executor.submit(tarea); //Enviamos una segunda tarea
        Future<Integer> resultadoTres = executor.submit(tareaTres);

        System.out.println("Tamaño del pool" + executor.getPoolSize()); //Obtenemos el tamaño actual del pool
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size()); //Obtenemos la cantidad de tareas en espera

        executor.shutdown(); //Apaga cuando se finaliza la ejecucion, también espera a que se ejecuten todas las tareas que estén en cola
        System.out.println("Continua el metodo main");

//        System.out.println(resultado.isDone()); //isDone devuelve true o false dependiento si la tarea termino
        while(!(resultado.isDone() && resultadoDos.isDone() && resultadoTres.isDone())){ //Mientras las tareas no hayan finalizado
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone()? "finalizo": "en proceso",
                    resultadoDos.isDone()? "finalizo": "en proceso",
                    resultadoTres.isDone()? "finalizo": "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
//        System.out.println(resultado.get(2, TimeUnit.SECONDS)); //Bloquea el metodo main, espare a que finalice y se retorne el resultado
        //se le puede pasar un timeout, para que la aplicación no se quede colgada
        System.out.println("Tarea 1 " + resultado.get());
        System.out.println("Tarea 1 : " + resultado.isDone());

        System.out.println("Tarea 2 " + resultadoDos.get());
        System.out.println("Tarea 2 : " + resultadoDos.isDone());

        System.out.println("Tarea 3 " + resultadoTres.get());
        System.out.println("Tarea 3 : " + resultadoTres.isDone());


    }

}
