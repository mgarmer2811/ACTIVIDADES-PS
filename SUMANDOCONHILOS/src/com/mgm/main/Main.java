/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numerosString;
        int suma = 0;
        ArrayList<Integer> numeros = new ArrayList<>();
        HiloSuma mitad1;
        HiloSuma mitad2;
        
        System.out.println("Introduzca numeros separados por espacios");
        numerosString = scanner.nextLine();
        
        String[] numsArray = numerosString.trim().split(" ");
        for(String num : numsArray){
            numeros.add(Integer.parseInt(num));
        }
        
        int[] arrayNumeros = numeros.stream().mapToInt(Integer::intValue).toArray();
        
        int mitad = arrayNumeros.length / 2;
        int[] primeraMitad = Arrays.copyOfRange(arrayNumeros,0,mitad);
        int[] segundaMitad = Arrays.copyOfRange(arrayNumeros,mitad,numeros.size());
        
        mitad1 = new HiloSuma(primeraMitad);
        mitad2 = new HiloSuma(segundaMitad);
        
        mitad1.start();
        mitad2.start();
        
        try{
            mitad1.join();
            mitad2.join();
        }
        catch(InterruptedException ie){
            System.err.println("Ha ocurrido un error en alguno de los hilos de suma");
        }
        
        suma += mitad1.getSuma();
        suma += mitad2.getSuma();
        System.out.println("La suma de todos los numeros introducidos es: " + suma);
    }
    
}
