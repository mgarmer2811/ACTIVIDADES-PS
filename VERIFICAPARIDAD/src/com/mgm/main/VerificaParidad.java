/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class VerificaParidad extends Thread{
    private int numero;
    
    public VerificaParidad(int numero) {
        this.numero = numero;
    }
    
    public void esPar() {
        if((numero % 2) == 0){
            System.out.println(numero + " es par");
        }
        else{
            System.out.println(numero + " es impar");
        }
    }
    
    @Override
    public void run() {
        this.esPar();
    }
}
