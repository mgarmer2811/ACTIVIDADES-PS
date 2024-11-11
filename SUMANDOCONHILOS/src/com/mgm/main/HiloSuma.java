/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class HiloSuma extends Thread{
    private int[] numeros;
    private int suma;
    
    public HiloSuma(int[] numeros) {
        super();
        this.numeros = numeros;
        suma = 0;
    }
    
    public void suma() {
        for(int num : numeros){
            suma += num;
        }
    }
    
    public int getSuma() {
        return suma;
    }
    
    @Override
    public void run() {
        suma();
    }
}
