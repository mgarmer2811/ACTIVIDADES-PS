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
    public static void main(String[] args) {
        Barberia barberia = new Barberia(10);
        
        Barbero barbero = new Barbero(barberia);
        barbero.setDaemon(true);
        barbero.start();
        
        for (int i = 0; i < 10; i++) {
            new Cliente(i, barberia).start();
        }
    }
}
