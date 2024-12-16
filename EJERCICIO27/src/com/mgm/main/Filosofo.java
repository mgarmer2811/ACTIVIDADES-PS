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
public class Filosofo extends Thread{
    private int id;
    private Mesa mesa;

    public Filosofo(int id, Mesa mesa) {
        super("Filosofo "+id);
        this.id = id;
        this.mesa = mesa;
    }
    
    private void pensar() throws InterruptedException{
        System.out.println(this.getName() + ": Está pensando");
        Thread.sleep(new Random().nextInt(3000, 6001));
    }
    
    private void comer() throws InterruptedException{
        System.out.println(this.getName() + ": Está comiendo");
        Thread.sleep(new Random().nextInt(3000, 6001));
    }

    @Override
    public void run() {
        try{
            while(true){
                pensar();
                mesa.cogerTenedores(id);
                comer();
                mesa.soltarTenedores(id);
            }
        } catch (InterruptedException ex) {
            System.err.println("Excepcion en " + this.getName() + ": " + ex.getMessage());
        }
    }   
}
