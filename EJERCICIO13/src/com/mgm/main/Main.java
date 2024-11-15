/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comedero comedero = new Comedero();
        System.out.println("Introduce el numero de ratones");
        int numRatones = scanner.nextInt();
        RatonHilo[] ratones = new RatonHilo[numRatones];
        
        for(int i = 1; i <= numRatones; i++){
            ratones[i-1] = new RatonHilo("Raton" + i,3);
            ratones[i-1].start();
        }
        
        for(RatonHilo raton : ratones){
            try{
                raton.join();
            }
            catch(InterruptedException ie){
                System.err.println("Se ha producido un error esperando a que un raton termine de comer");
            }
        }
        
        System.out.println("Total de comida consumida: " + comedero.getComidaConsumida());
    }
}
