/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm;

/**
 *
 * @author Usuario14
 */
public class HilosMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo miHilo = new Hilo("Mi hilo", 10);
        miHilo.start();
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){}
        System.out.println("Han pasado 3 segundos");
    }
    
}
