/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

/**
 *
 * @author Usuario14
 */
public class HiloInfinito extends Thread{
    private boolean corriendo = true;
    
    public HiloInfinito(String nombre) {
        super(nombre);
    }
    
    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }
    
    @Override
    public void run() {
        while(corriendo){
            try{
                System.out.println(this.getName());
                Thread.sleep(500);
            }
            catch(InterruptedException ie){}
        }
    }
}
