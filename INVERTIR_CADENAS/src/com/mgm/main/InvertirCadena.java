/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class InvertirCadena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        String reversedText = new StringBuilder(text).reverse().toString();
        System.out.println(reversedText);
    }
    
}
