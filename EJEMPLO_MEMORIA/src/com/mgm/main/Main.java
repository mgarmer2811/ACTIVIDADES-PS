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
        Runtime r = Runtime.getRuntime();
        System.out.println("Max memory: " + r.maxMemory());
        System.out.println("Total memory: " + r.totalMemory());
        System.out.println("Free memory: " + r.freeMemory());
        
        for(int i = 0; i < 1000000; i++){
            new Main();
        }
        
        System.out.println("After creating 1000000 instances, Free memory: " + r.freeMemory());
        System.out.println("After creating 1000000 instances, Used memory: " + (r.totalMemory() - r.freeMemory()));
        r.gc();
        System.out.println("After calling garbage collector 'gc()', Free memory: " + r.freeMemory());
        System.out.println("Afer calling garbage collector 'gc()', Used memory: " + (r.totalMemory() - r.freeMemory()));
    }
    
}
