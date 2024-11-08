/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.ArrayList;
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
        Scanner scanner = new Scanner(System.in);
        String numerosString;
        ArrayList<Integer> numeros = new ArrayList<>();
        HiloSuma mitad1;
        HiloSuma mitad2;
        
        System.out.println("Introduzca numeros separados por espacios");
        numerosString = scanner.nextLine();
        
        String[] numsArray = numerosString.trim().split(" ");
        for(String num : numsArray){
            numeros.add(Integer.parseInt(num));
        }
        
        
    }
    
}
