/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario14
 */
public class Ordenador extends Thread{
    private final int id;
    private final Copisteria copisteria;
    
    public Ordenador(int id, Copisteria copisteria) {
        this.id = id;
        this.copisteria = copisteria;
    }
    
    public void print() {
        copisteria.acquirePrinter(id);
        int time = new Random().nextInt(3,7);
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Ha ocurrido un error en medio de la impresion");
        }
        copisteria.releasePrinter(id);
    }
    
    @Override
    public void run() {
        print();
    }
}
