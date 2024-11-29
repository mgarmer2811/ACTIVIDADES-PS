/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Main {
    private static final int NUM_IMPRESORAS = 4;
    private static final int NUM_ORDENADORES = 10;
    
    public static void main(String[] args) {
        Copisteria copisteria = new Copisteria(NUM_IMPRESORAS);
        for(int i = 1; i <= NUM_ORDENADORES; i++){
            Ordenador ordenador = new Ordenador(i,copisteria);
            ordenador.start();
        }
    }
    
}
