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
    private int[] mitad;
    private int numMitad;
    
    public HiloSuma(int[] numeros, int numMitad) {
        super();
        this.numeros = numeros;
        this.numMitad = numMitad;
    }
    
    public void suma() {
        switch(numMitad){
            case 1:
            case 2:
            default:
                System.err.println("Opcion no valida de numero de mitad");
        }
    }
}
