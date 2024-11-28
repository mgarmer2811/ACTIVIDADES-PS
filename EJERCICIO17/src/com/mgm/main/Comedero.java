/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario14
 */
public class Comedero {
    private int comidaActual;
    private final int MINIMO_COMIDA = 5;
    private final Random random = new Random();
    private final Lock lock = new ReentrantLock();
    private final Condition comidaDisponible = lock.newCondition();
    private final Condition cuidadorEsperando = lock.newCondition();
    
    public Comedero() {
        comidaActual = 0;
    }
    
    public void consumirComida(String nombreRaton, int unidadesComida) {
        lock.lock();
        try{
            while(comidaActual < unidadesComida){
                System.out.println("No hay suficiente comida llamado desde Raton(" + nombreRaton + ")");
                cuidadorEsperando.signal(); // Aviso al cuidador para rellenar el comedero
                comidaDisponible.await(); // Me espero hasta que tenga suficiente comida
            }
            System.out.println("El raton " + nombreRaton + " ha empezado a comer");
            comidaActual -= unidadesComida;
            System.out.println("El raton " + nombreRaton + " ha terminado de comer");
            comidaDisponible.signalAll();
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error mientras comia el raton");
        }
        finally{
            lock.unlock();
        }
    }
    
    /*
        Por qué necesito poner .lock() && .unlock() aqui???
    */
    
    public void recargarComida(){
        lock.lock();
        try{
            int cantidadNuevaComida = 20 + random.nextInt(11);
            comidaActual += cantidadNuevaComida;
            System.out.println("El cuidador ha rellenado un poco el comedero");
            comidaDisponible.signalAll(); // Aviso a los ratones esperando que vuelve a haber comida.
        }
        finally{
            lock.unlock();
        }
    }
    
    public int getComidaActual() {
        return comidaActual;
    }
    
    public int getMinimoComida() {
        return MINIMO_COMIDA;
    }
    
    public Lock getLock() {
        return lock;
    }
    
    public Condition getCuidadorEsperando() {
        return cuidadorEsperando;
    }
}
