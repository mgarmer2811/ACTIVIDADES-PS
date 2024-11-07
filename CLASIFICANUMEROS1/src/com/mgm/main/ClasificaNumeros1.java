/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class ClasificaNumeros1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numerosString;
        
        System.out.println("Introduce numeros separados por espacio");
        numerosString = scanner.nextLine();
        
        ClasificaPares pares = new ClasificaPares(numerosString);
        ClasificaPrimos primos = new ClasificaPrimos(numerosString);
        ClasificaPositivos positivos = new ClasificaPositivos(numerosString);
        
        pares.start();
        primos.start();
        positivos.start();
        
        try{
            pares.join();
            primos.join();
            positivos.join();
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error en la ejecucion de alguno de los hilos");
        }
        
        ClasificaPares.mostrar();
        ClasificaPrimos.mostrar();
        ClasificaPositivos.mostrar();
    }
    
}
