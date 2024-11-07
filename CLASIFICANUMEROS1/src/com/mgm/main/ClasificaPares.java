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
public class ClasificaPares extends Thread{
    private static ArrayList<Integer> numeros;
    private static ArrayList<Integer> pares;
    private static ArrayList<Integer> impares;
    
    public ClasificaPares(String nums) {
        super();
        numeros = new ArrayList<>();
        pares = new ArrayList<>();
        impares = new ArrayList<>();
        String[] numsArray = nums.trim().split(" ");
        
        for(String numero : numsArray){
            numeros.add(Integer.parseInt(numero));
        }
    }
    
    private static void clasifica() {
        for (int numero : numeros) {
            if ((numero % 2) == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }
    }
    
    public static void mostrar() {
        System.out.println("Numeros pares: " + pares.toString());
        System.out.println("Numeros impares: " + impares.toString());
    }
    
    @Override
    public void run() {
        clasifica();
    }
}
