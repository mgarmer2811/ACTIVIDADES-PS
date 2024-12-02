/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario14
 */
public class Supermercado {
    private final int NUM_CAJAS = 4;
    private Semaphore cajas = new Semaphore(NUM_CAJAS);
    private boolean[] cajasOcupadas = new boolean[NUM_CAJAS];
    private Lock cerrojoCajas = new ReentrantLock();
    
    public Supermercado(){
        for(int i = 0; i < NUM_CAJAS; i++){
            cajasOcupadas[i] = false;
        }
    }
    
    public Semaphore getCajas() {
        return cajas;
    }
    
    public int getCaja() {
        cerrojoCajas.lock();
        int numCajaLibre = -1;
        for(int i = 0; i < NUM_CAJAS; i++){
            if(!cajasOcupadas[i]){
                cajasOcupadas[i] = true;
                numCajaLibre = i + 1;
                break;
            }
        }
        cerrojoCajas.unlock();
        return numCajaLibre;
    }
    
    public void leaveCaja(int numCaja) {
        cerrojoCajas.lock();
        try {
            cajasOcupadas[numCaja - 1] = false;
        } finally {
            cerrojoCajas.unlock();
        }
    }
}
