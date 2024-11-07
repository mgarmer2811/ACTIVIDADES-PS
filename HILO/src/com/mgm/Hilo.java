/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

/**
 *
 * @author Usuario14
 */
public class Hilo extends Thread{
    private int num;
    
    public Hilo(String nombre, int n) {
        super(nombre);
        num = n;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < num; i++){
            try{
                System.out.println(this.getName());
                Thread.sleep(500);
            }
            catch(InterruptedException ie){}
        }
        System.out.println("FIN - " + this.getName());
    }
}
