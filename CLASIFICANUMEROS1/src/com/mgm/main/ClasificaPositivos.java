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
public class ClasificaPositivos extends Thread{
    private static ArrayList<Integer> numeros;
    private static ArrayList<Integer> positivos;
    private static ArrayList<Integer> negativos;
    
    public ClasificaPositivos(String nums) {
        super();
        numeros = new ArrayList<>();
        positivos = new ArrayList<>();
        negativos = new ArrayList<>();
        String[] numsArray = nums.trim().split(" ");
        
        for(String numero : numsArray){
            numeros.add(Integer.parseInt(numero));
        }
    }
    
    private static void clasifica() {    
        for(int numero : numeros){
            if(numero > 0){
                positivos.add(numero);
            }
            else{
                negativos.add(numero);
            }
        }
    }
    
    public static void mostrar() {
        System.out.println("Numeros positivos: " + positivos.toString());
        System.out.println("Numeros negativos: " + negativos.toString());
    }
    
    @Override
    public void run() {
        clasifica();
    }
}
