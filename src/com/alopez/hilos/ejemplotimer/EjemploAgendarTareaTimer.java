package com.alopez.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() { //Metodo schedule, al cual se le pasa una clase TimerTask, y la tarea empezará con una tardanza o delay
            @Override
            public void run() { //Implementamos el metodo run
                System.out.println("Tarea realizada en: " + new Date() + " nombre del Thread: " //Con new Date() imprime la fecha
                + Thread.currentThread().getName()); //Ontenemos el nombre del hilo actual
                System.out.println("Finaliza el tiempo");
                timer.cancel(); //Cerramos el recurso timer
            }
        }, 5000); //Retraso de 5000 milisegundos

        System.out.println("Tarea que se realizará dentro de 5 segundos");

    }

}