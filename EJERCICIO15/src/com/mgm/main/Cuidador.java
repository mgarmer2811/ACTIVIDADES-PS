/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario
 */
public class Cuidador extends Thread{
    private final Comedero comedero;
    
    public Cuidador(Comedero comedero){
        super();
        this.comedero = comedero;
    }
    
    private void rellenarComedero(){
        while(true){
            synchronized(comedero){
                if(comedero.getComidaActual() < comedero.getMinimoComida()){
                    comedero.recargarComida();
                }
            }
        }
    }
    
    @Override
    public void run(){
        rellenarComedero();
    }
}
