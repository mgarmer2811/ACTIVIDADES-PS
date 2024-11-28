/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ordenador[] ordenadores = new Ordenador[10];
        Copisteria impresora = new Copisteria();
        Random random = new Random();
        
        for(int i = 0; i < 10; i++){
            int randomTime = random.nextInt(3,7);
            String nombre = "Ordenador " + (i + 1);
            ordenadores[i] = new Ordenador(nombre, randomTime, impresora);
            ordenadores[i].start();
        }
        
        for(Ordenador ord : ordenadores){
            try{
                ord.join();
            }
            catch(InterruptedException ie){
                System.err.println("Se ha producido un error esperando a terminar de imprimir");
            }
        }
        System.out.println("SE HA TERMINADO DE IMPRIMIR TODO");
    }
    
}
