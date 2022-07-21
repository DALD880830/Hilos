package com.alopez.hilos.ejemplos.runnable;

public class ViajeTarea implements Runnable{ //Implementa la interfaz Runnable que hereda de Thread

    private String nombre;

    public ViajeTarea(String nombre) { //Generamos el constructor del nombre
        this.nombre = nombre;
    }

    public String getNombre() { //Generamos el Getter de nombre
        return nombre;
    }

    @Override
    public void run() { //Implementamos el metodo run
        for (int i = 0; i < 10; i++){
            System.out.println(i + " - " + nombre);
            try {
//                Thread.sleep(1000); //Damos una pausa, al hilo actual que se está ejecutando
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a " + nombre); //Finaliza el hilo
    }

}