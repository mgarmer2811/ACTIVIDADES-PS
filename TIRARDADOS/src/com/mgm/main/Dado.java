/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class Dado {
    public static void main(String[] args) {
        final int MIN_DICE = 1;
        final int MAX_NORMAL_DICE = 6;
        
        Random random = new Random();
        int result;
        int numberFaces = 0;
        
        if((args.length > 0) && (args.length < 2)){ // number of dice faces
            try{
                numberFaces = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e){
                System.err.println("Ha ocurrido un error lanzando el dado");
            }
            result = random.nextInt((numberFaces - MIN_DICE + 1) + MIN_DICE);
            System.out.println(result);
        }
        else{
            result = random.nextInt((MAX_NORMAL_DICE - MIN_DICE + 1) + MIN_DICE);
            System.out.println(result);
        }
    }
}
