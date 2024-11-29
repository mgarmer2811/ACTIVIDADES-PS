/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Persona extends Thread{
    private String name;
    private int numPools;
    private int time;
    private Piscina pool;
    
    public Persona(String name, int numPools, int time, Piscina pool){
        this.name = name;
        this.numPools = numPools;
        this.time = time;
        this.pool = pool;
    }
    
    public void swim(){
        try{
            for(int i = 0; i < numPools; i++){
                pool.enterPool(name);
                Thread.sleep(time * 1000);
                pool.exitPool(name);
            }
        }
        catch(InterruptedException ie){}
    }
    
    @Override
    public void run(){
        swim();
    }
}
