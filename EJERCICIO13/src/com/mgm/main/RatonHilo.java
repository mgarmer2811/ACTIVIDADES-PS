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
    
    public RatonHilo() {
        super();
    }
    
    public RatonHilo(String nombre,int tiempo) {
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public void comer() {
        System.out.println("El raton " + nombre + " ha empezado a comer");
        try{
            Thread.sleep(tiempo);
        }
        catch(InterruptedException ie){
            System.err.println("Ha ocurrido un error mientras el raton comia");
        }
        Comedero.consumirComida();
        System.out.println("El raton " + nombre + " ha terminado de comer");
    }
    
    @Override
    public void run() {
        this.comer();
    }
}