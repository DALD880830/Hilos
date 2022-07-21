package com.alopez.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {

    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); //Clase Toolkit, metodo estatico getDefaultToolkit()
        AtomicInteger contador = new AtomicInteger(3); //AtomicInteger, permite que la variable sea utilizable en el metodo run
        Timer timer = new Timer();
 /*       timer.schedule(new TimerTask() { //Metodo schedule, al cual se le pasa una clase TimerTask, y la tarea empezará con una tardanza o delay
            @Override
            public void run() { //Implementamos el metodo run
                System.out.println("Tarea realizada en: " + new Date() + " nombre del Thread: " //Con new Date() imprime la fecha
                + Thread.currentThread().getName()); //Ontenemos el nombre del hilo actual
                System.out.println("Finaliza el tiempo");
                timer.cancel(); //Cerramos el recurso timer
            }
        }, 5000); //Retraso de 5000 milisegundos
 */
        timer.schedule(new TimerTask() { //Metodo schedule, al cual se le pasa una clase TimerTask, y la tarea empezará con una tardanza o delay
//            private int contador = 3; //Inicializamos un contador
            @Override
            public void run() { //Implementamos el metodo run
//                if (contador > 0) { //Si el contador es mayor que cero, imprime
                int i = contador.getAndDecrement();
                if (i > 0) { //metodo getAndDecrement() Obtiene el valor y lo decrementa
                    toolkit.beep(); //Cada que entra a una tarea, crea un sonido de alerta
                    System.out.println("Tarea " + i + " periodica en: " +
                            new Date() + " nombre del Thread: " //Con new Date() imprime la fecha
                            + Thread.currentThread().getName()); //Ontenemos el nombre del hilo actual
//                    contador--; //El contador descrece en 1
                } else { //Cuando contador es 0, entonces imprimer este
                    System.out.println("Finaliza el tiempo");
                    timer.cancel(); //Cerramos el recurso timer
                }
            }
        }, 2000, 5000); //Retraso de 5000 milisegundos

        System.out.println("Tarea que se realizará dentro de 2 segundos y cada tarea se realizará cada 5 segundos");

    }

}