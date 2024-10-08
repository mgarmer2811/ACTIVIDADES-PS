/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class GenerarCadena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MIN_STRING_LEN = 1;
        final int MAX_STRING_LEN = 20;
        
        Random random = new Random();
        int length = random.nextInt(MAX_STRING_LEN) + MIN_STRING_LEN;
        String randomString = generateRandomString(length);
        System.out.println(randomString);
    }
    
    public static String generateRandomString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            randomString.append(alphabet.charAt(index));
        }

        return randomString.toString();
    }
    
}
