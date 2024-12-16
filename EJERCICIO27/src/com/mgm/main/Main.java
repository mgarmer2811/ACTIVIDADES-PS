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
        Mesa mesa = new Mesa(5);
        
        for (int i = 0; i < 5; i++) {
            new Filosofo(i, mesa).start();
        }
    }
}
