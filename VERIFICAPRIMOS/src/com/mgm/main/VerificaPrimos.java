/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class VerificaPrimos extends Thread{
    private int numero;
    
    public VerificaPrimos(int numero) {
        super();
        this.numero = numero;
    }
    
    public void esPrimo() {
        if (numero <= 1) {
            System.out.println(numero + " no es primo.");
            return;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                System.out.println(numero + " no es primo.");
                return;
            }
        }
        System.out.println(numero + " es primo.");
    }
    
    @Override
    public void run() {
        this.esPrimo();
    }
}
