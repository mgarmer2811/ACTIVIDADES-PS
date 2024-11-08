/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Reloj extends Thread{
    private int numSegundos;
    
    public Reloj(int numSegundos) {
        super();
        this.numSegundos = numSegundos;
    }
    
    @Override
    public void run() {
        for(int i = 1; i <= numSegundos; i++){
            System.out.println("Reloj: " + i + " segundos");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){}
        }
    }
}
