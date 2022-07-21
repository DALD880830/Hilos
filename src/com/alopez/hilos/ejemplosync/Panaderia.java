package com.alopez.hilos.ejemplosync;

public class Panaderia {

    private String pan;
    private boolean disponible; //Bandera de true o false

    //Syncronized nos permite utilizar los metodos wait() y notify()

    public synchronized void hornear(String masa){ //Metodo sincronizado, pasamos por argumento la materia prima
        while (disponible){ //Mientras disponible este en true, se aplica el wait
            try {
                wait(); //Anidamos el wait a un Try-catch, el wait esperará a que se haga el metodo consumir y así disponible quede en false nuevamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.pan = masa;
        System.out.println("El panadero hornea: " + this.pan);
        this.disponible = true; //Disponible cambia a true
        notify(); //Notificamos que puede pasar a consumir
    }

    //Syncronized nos permite utilizar los metodos wait() y notify()

    public synchronized String  consumir(){ //Metodo contrario a hornear
        while (!disponible){ //Mientras disponible sea diferente de true
            try {
                wait(); //Espera a que se lleve a cabo el metodo hornear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El cliente consume el " + this.pan);
        this.disponible = false; //Cambiamos el estado a false
        notify(); //Notificamos que se puede pasar a hornear
        return pan; //Retornamos pan, para que podamos hacer algo con el objeto
    }

}