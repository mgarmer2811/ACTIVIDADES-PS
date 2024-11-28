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
            comedero.getLock().lock();
            try{
                comedero.getCuidadorEsperando().await();
                
                if(comedero.getComidaActual() < comedero.getMinimoComida()){
                    comedero.recargarComida();
                }
            }
            catch(InterruptedException ie){
                System.err.println("Se ha producido un error mientras el cuidador rellena la comida");
            }
            finally{
                comedero.getLock().unlock();
            }
        }
    }
    
    @Override
    public void run(){
        rellenarComedero();
    }
}
