/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloNumeros hiloDos = new HiloNumeros("Hilo dos",2);
        HiloNumeros hiloTres = new HiloNumeros("Hilo tres",3);
        HiloNumeros hiloCinco = new HiloNumeros("Hilo cinco",5);
        
        Random random = new Random();
        int tiempoAleatorio = random.nextInt(5000) + 1000;
        
        hiloDos.start();
        hiloTres.start();
        hiloCinco.start();
        try{
            Thread.sleep(tiempoAleatorio);
        }
        catch(InterruptedException ie){}
        System.out.println("Tiempo agotado");
        hiloDos.detener();
        hiloTres.detener();
        hiloCinco.detener();
    }
    
}
