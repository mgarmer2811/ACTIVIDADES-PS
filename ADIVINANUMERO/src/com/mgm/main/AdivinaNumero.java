/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class AdivinaNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        final int secretNumber = (random.nextInt(100) + 1);
        
        Scanner scanner = new Scanner(System.in);
        int guess;
        int numRounds = 0;
        boolean guessed = false;
        
        while(!guessed){
            System.out.println("Introduce un numero");
            guess = Integer.parseInt(scanner.nextLine());
            
            if(guess != secretNumber){
                if(guess > secretNumber){
                    System.out.println("-");
                    numRounds++;
                }
                else{
                    System.out.println("+");
                    numRounds++;
                }
            }
            else{
                guessed = true;
                System.out.println("=");
                System.out.println("Enhorabuena! Has adivinado el numero en " + numRounds + " rondas");
            }
        }
    }
    
}
