/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Usuario14
 */
public class Proveedor extends Thread{
    private final String ingrediente;
    private final Pasteleria pasteleria;
    private final Lock lock;
    private final Condition condition;
    
    public Proveedor(String ingrediente, Pasteleria pasteleria, Lock lock, Condition condition){
        this.ingrediente = ingrediente;
        this.pasteleria = pasteleria;
        this.lock = lock;
        this.condition = condition;
    }
    
    public void entregarIngrediente(){
        while(true){
            lock.lock();
            try{
                condition.await();
                int tiempo = new Random().nextInt(2,5);
                Thread.sleep(tiempo * 1000);
                pasteleria.entregarIngrediente(ingrediente);
            }
            catch(InterruptedException ie){
                System.err.println("Se ha producido un error en la entrega de: '" + ingrediente + "'");
            }
            finally{
                lock.unlock();
            }
        }
    }
    
    @Override
    public void run(){
        entregarIngrediente();
    }
}
