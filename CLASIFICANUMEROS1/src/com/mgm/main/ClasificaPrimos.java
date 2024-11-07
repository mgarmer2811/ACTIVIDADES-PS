/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.ArrayList;

/**
 *
 * @author Usuario14
 */
public class ClasificaPrimos extends Thread{
    private static ArrayList<Integer> numeros;
    private static ArrayList<Integer> primos;
    private static ArrayList<Integer> noPrimos;
    
    public ClasificaPrimos(String nums) {
        super();
        numeros = new ArrayList<>();
        primos = new ArrayList<>();
        noPrimos = new ArrayList<>();
        String[] numsArray = nums.trim().split(" ");
        
        for(String numero : numsArray){
            numeros.add(Integer.parseInt(numero));
        }
    }
    
    private static void clasifica() {
        for (int numero : numeros) {
            if (numero <= 1) {
                noPrimos.add(numero);
                continue;
            }
            boolean esPrimo = true;
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                primos.add(numero);
            } else {
                noPrimos.add(numero);
            }
        }
    }
    
    public static void mostrar() {
        System.out.println("Numeros primos: " + primos.toString());
        System.out.println("Numeros no primos: " + noPrimos.toString());
    }
    
    @Override
    public void run() {
        clasifica();
    }
}
