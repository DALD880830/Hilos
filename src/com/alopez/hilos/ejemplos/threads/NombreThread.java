package com.alopez.hilos.ejemplos.threads;

public class NombreThread extends Thread{ //Clase que extiende de la clase Thread


    public NombreThread(String name) { //Constructor que reciba el nombre String
        super(name); //Podemos personalizar un nombre para el Thread
    }

    @Override
    public void run() { //Gererar Override Method, metodo run | Cuando comienza el run empieza el hilo
        System.out.println("Se inicia el método run del hilo" + getName());

        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }

        System.out.println("Termina el método run del hilo" + this.getName());
    } //Cuando termina el run, termina el hilo

}