/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Usuario14
 */
public class Piscina {
    private Semaphore pool;
    
    public Piscina(int capacity){
        this.pool = new Semaphore(capacity);
    }
    
    public void enterPool(String personName){
        try{
            System.out.println(personName + " esta esperando a entrar a la piscina");
            pool.acquire();
            System.out.println(personName + " esta nadando");
        }
        catch(InterruptedException ie){
            System.err.println(personName + " se ha ahogado");
        }
    }
    
    public void exitPool(String personName){
        System.out.println(personName + " ha salido de la piscina");
        pool.release();
    }
}
