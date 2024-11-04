/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class VerificaPosNeg extends Thread{
    private int numero;
    
    public VerificaPosNeg(int numero) {
        super();
        this.numero = numero;
    }
    
    public void esPositivo() {
        if(numero > 0){
            System.out.println("El numero " + numero + " es positivo");
        }
        else{
            System.out.println("El numero " + numero + " es negativo");
        }
    }
    
    @Override
    public void run() {
        this.esPositivo();
    }
}
