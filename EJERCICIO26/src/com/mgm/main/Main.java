/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class Main {
    private static final int NUM_CLIENTES = 10;
    
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[NUM_CLIENTES];
        Supermercado supermercado = new Supermercado();
        Random random = new Random();
        
        for(int i = 0; i < NUM_CLIENTES; i++){
            String nombre = "CLIENTE " + (i + 1);
            int tiempoComprar = random.nextInt(5,16);
            int tiempoPagar = random.nextInt(5,11);
            clientes[i] = new Cliente(nombre,tiempoComprar,tiempoPagar,supermercado);
            clientes[i].start();
        }
        
        for(Cliente cli : clientes){
            try{
                cli.join();
            }
            catch(InterruptedException ie){
                System.err.println("Ha pasado algo mientras el cliente compra");
            }
        }
        
        System.out.println("TODOS LOS CLIENTES HAN TERMINADO DE COMPRAR");
    }
    
}
