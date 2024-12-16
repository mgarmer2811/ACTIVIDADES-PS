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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nido nido = new Nido(3);
        PajaroPadre gallo = new PajaroPadre(nido);
        gallo.start();
        for(int i = 0; i < 5; i++){
            Pajarillo pollito = new Pajarillo(i+1,nido);
            pollito.start();
        }
    }
    
}
