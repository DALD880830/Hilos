package com.alopez.hilos.ejemplos;

import com.alopez.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {

    public static void main(String[] args) throws InterruptedException {

/*        Runnable viaje = new Runnable() { //Instancia del tipo Runnable
            @Override
            public void run() { //Implementación del metodo ru que será sobreescrito
                for (int i = 0; i < 10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName()); //Thread cuenta con el metodo
                    // estatico currentThread Retorna la instancia del hilo que se está ejecutando, con getName() Obtenemos el nombre
                    try {
//                Thread.sleep(1000); //Damos una pausa, al hilo actual que se está ejecutando
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName()); //Finaliza el hilo
            }
        };*/

        //Convertimos lo anterior a expresion Lambda

        Thread main = Thread.currentThread(); //Obtenemos el Thread principal del main
        Runnable viaje = () -> { //Los parentesis no llevan argumento, luego la flecha, y despues el cuerpo del metodo run
                for (int i = 0; i < 10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName()); //Thread cuenta con el metodo
                    // estatico currentThread Retorna la instancia del hilo que se está ejecutando, con getName() Obtenemos el nombre
                    try {
//                Thread.sleep(1000); //Damos una pausa, al hilo actual que se está ejecutando
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName()); //Finaliza el hilo
            System.out.println(main.getState()); //Imprimimos el estado del Thread main
            };

/*        //Los Threads son independientes y corren en paralelo
        new Thread(viaje, "Islas Caiman").start(); //Pasamos la instancia del Runnable y el nombre del Thread
        new Thread(viaje, "Rio de Janeiro").start();
        new Thread(viaje, "Paris").start();
        new Thread(viaje, "Japon").start();
        Aqui
 */
        Thread v1 = new Thread(viaje, "Islas Caiman");
        Thread v2 = new Thread(viaje, "Rio de Janeiro");
        Thread v3 = new Thread(viaje, "Paris");
        Thread v4 = new Thread(viaje, "Japon");

        v1.start(); //Iniciamos los Threads
        v2.start();
        v3.start();
        v4.start();
        v1.join(); //Unimos el Thread con el main, por lo que hasta que terminen los Thread, se continuará con el main
        v2.join();
        v3.join();
        v4.join();


//        Thread.sleep(7000); //Esta es una pausa en el main
        System.out.println("Aqui continua el metodo main" + main.getName());

    }

}