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
public class Cliente extends Thread{
    private String nombre;
    private int tiempoComprar;
    private int tiempoPagar;
    private Supermercado supermercado;
    
    public Cliente(String nombre, int tiempoComprar, int tiempoPagar, Supermercado supermercado) {
        this.nombre = nombre;
        this.tiempoComprar = tiempoComprar;
        this.tiempoPagar = tiempoPagar;
        this.supermercado = supermercado;
    }
    
    public void comprar() {
        int numCaja;
        System.out.println("El cliente " + nombre + " ha entrado en la tienda");
        try{
            Thread.sleep(tiempoComprar * 1000);
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error mientras el cliente elige la compra");
        }
        try{
            System.out.println("El cliente " + nombre + " ha elegido la compra y esta esperando una caja");
            supermercado.getCajas().acquire();
            numCaja = supermercado.getCaja();
            System.out.println("El cliente" + nombre + " va a la caja " + numCaja);
            try{
                Thread.sleep(tiempoPagar * 1000);
                System.out.println("El cliente " + nombre + " ha terminado de pagar en la caja " + numCaja);
                supermercado.leaveCaja(numCaja);
                supermercado.getCajas().release();
            }
            catch(InterruptedException iei){
                System.err.println("Se ha producido un error mientras el cliente paga");
            }
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error mientras el cliente espera por una caja");
        }
    }
    
    @Override
    public void run() {
        comprar();
    }
}
