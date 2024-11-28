/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class RatonHilo extends Thread{
    private String nombre;
    private int tiempo;
    private int unidades;
    private final Comedero comedero;
    
    public RatonHilo(String nombre,int tiempo, int unidades,Comedero comedero) {
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.unidades = unidades;
        this.comedero = comedero;
    }
    
    private void comer() {
        comedero.consumirComida(nombre,unidades);
        try{
            Thread.sleep(tiempo * 1000);
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error mientras el raton " + nombre + " estaba comiendo");
        }
    }
    
    @Override
    public void run() {
        this.comer();
    }
}