/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class Pajarillo extends Thread {
    private int id;
    private Nido nido;

    public Pajarillo(int id, Nido nido) {
        super();
        this.id = id;
        this.nido = nido;
    }

    public void jugar(){
        try{
            System.out.println("El pajarillo " + this.id + " esta jugando");
            Thread.sleep(new Random().nextInt(1000, 2001));
        }
        catch(InterruptedException ie){
            System.err.println(ie.getMessage());
        }
    }
    
    @Override
    public void run(){
        while(true){
            jugar();
            nido.comerUnGusano(this.id);
        }
    }
}
