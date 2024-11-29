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
public class Copisteria {
    private final Semaphore printers;
    
    public Copisteria(int printers) {
        this.printers = new Semaphore(printers);
    }
    
    public void acquirePrinter(int computer) {
        try{
            System.out.println("El ordenador " + computer + " ha enviado el documento. Esperando impresora");
            printers.acquire();
            System.out.println("El ordenador " + computer + " ha empezado a imprimir");
        }
        catch(InterruptedException ie){
            System.err.println("Ha surgido un error esperando por una impresora");
        }
    }
    
    public void releasePrinter(int computer) {
        System.out.println("El ordenador " + computer + " ha terminado de imprimir");
        printers.release();
    }
}
