/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario14
 */
public class Comedero {

    private int comidaActual;
    private final int MINIMO_COMIDA = 5;
    private Lock cerrojo = new ReentrantLock();
    private final Random random = new Random();

    public Comedero() {
        comidaActual = 0;
    }

    public void consumirComida(int unidades) {
        while (comidaActual < unidades) {
            try {
                wait();
            } catch (InterruptedException ie) {
                System.err.println("Se ha producido un error esperando a la comida");
            }
        }
        comidaActual -= unidades;
    }

    public void recargarComida() {
        int cantidadNuevaComida = 20 + random.nextInt(11);
        comidaActual += cantidadNuevaComida;
        System.out.println("El cuidador ha rellenado un poco el comedero");
        notifyAll();
    }

    public synchronized int getComidaActual() {
        return comidaActual;
    }

    public int getMinimoComida() {
        return MINIMO_COMIDA;
    }
}
