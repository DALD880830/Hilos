package com.alopez.hilos.ejemplos;

import com.alopez.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFrases("Hola, que ", "tal???")).start();
        new Thread(new ImprimirFrases("Como te ", "encuentras???")).start();
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amiguito"));
        h3.start(); //Este hilo intentará entrar cuando el metodo este ocupado
        Thread.sleep(100); //Agregamos un pequeño delay
        System.out.println(h3.getState()); //Con el delay extra, el estado del hilo 3 estará bloqueado

    }

    public synchronized static void imprimirFrases(String frase1, String frase2){ //Creamos un metodo que recibe dos String
        //Metodo compartido entre varios hilos //Agregamos synchronized al metodo, con esto, cada hilo va a entrar al metodo
        //y lo utiliza en orden, cuando se esta utilizando el resto estará bloqueado, hasta que termine y despues entra el que sigue
        System.out.println(frase1); //Imrpimimos el primer String

        try { //Sleep entre las dos frases, anidado con Try-catch
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(frase2); //Imprimimos el segundo String
    }

}