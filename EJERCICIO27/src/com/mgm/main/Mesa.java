/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario14
 */
public class Mesa {
    private Lock tenedoresLock;
    private boolean[] tenedoresLibres;
    private Condition tenedoresCondition;

    public Mesa(int nFilosofos) {
        tenedoresLock = new ReentrantLock(true);
        tenedoresCondition = tenedoresLock.newCondition();
        tenedoresLibres = new boolean[nFilosofos];
        Arrays.fill(tenedoresLibres, true);
    }
    
    public void cogerTenedores(int id) throws InterruptedException{
        int tenedorIzq = id;
        int tenedorDer = (id+1)%tenedoresLibres.length;
        
        tenedoresLock.lock();
        try {
            while(!tenedoresLibres[tenedorIzq] || !tenedoresLibres[tenedorDer]){
                tenedoresCondition.await();
            }
            
            tenedoresLibres[tenedorIzq] = false;
            tenedoresLibres[tenedorDer] = false;
        } finally {
            tenedoresLock.unlock();
        }
    }
    
    public void soltarTenedores(int id){
        int tenedorIzq = id;
        int tenedorDer = (id+1)%tenedoresLibres.length;
        
        tenedoresLock.lock();
        try {
            tenedoresLibres[tenedorIzq] = true;
            tenedoresLibres[tenedorDer] = true;
            tenedoresCondition.signalAll();
        } finally {
            tenedoresLock.unlock();
        }
    }
}
