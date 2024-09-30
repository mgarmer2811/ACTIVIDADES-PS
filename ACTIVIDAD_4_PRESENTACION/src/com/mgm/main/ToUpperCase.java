/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class ToUpperCase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String mayus = "";
        
        if(args.length == 0){
            System.out.println("Se necesita un parametro");
            System.exit(1);
        }
        mayus = args[0].toUpperCase();
        System.out.println(mayus);
        System.exit(0);
    }
    
}
