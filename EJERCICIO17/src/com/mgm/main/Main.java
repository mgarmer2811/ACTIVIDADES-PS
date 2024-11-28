/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRatones;
        Random random = new Random();
        Comedero comedero = new Comedero();
        
        Cuidador cuidador = new Cuidador(comedero);
        cuidador.setDaemon(true);
        
        System.out.println("Introduce el numero de ratones");
        numRatones = scanner.nextInt();
        RatonHilo[] ratones = new RatonHilo[numRatones];
        cuidador.start();
        
        for(int i = 0; i < numRatones; i++){
            String nombre = "Raton " + (i + 1);
            int tiempo = 1 + random.nextInt(3);
            int unidades = 1 + random.nextInt(5);
            ratones[i] = new RatonHilo(nombre,tiempo,unidades,comedero);
            ratones[i].start();
        }
        
        
        for(RatonHilo raton : ratones){
            try{
                raton.join();
            }
            catch(InterruptedException ie){
                System.err.println("Se ha producido un error esperando que un raton termine de comer");
            }
        }
        
        System.out.println("TODOS LOS RATONES HAN TERMINADO DE COMER");
    }
}
