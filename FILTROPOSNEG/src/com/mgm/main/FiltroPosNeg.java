/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class FiltroPosNeg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        if((args.length > 0) && (args.length < 2)){
            if(args[0].equals("-pos")){
                getNumbers(positive,negative);
                System.out.println(positive.toString());
            }
            else if(args[0].equals("-neg")){
                getNumbers(positive,negative);
                System.out.println(negative.toString());
            }
            else{
                System.out.println("Solo se puede llamar al programa sin parametros o con los parametros '-pos' o '-neg'");
                System.exit(2); // Exit Code for wrong parameters
            }
        }
        else if(args.length == 0){
            getNumbers(positive,negative);
            System.out.println(positive.toString());
        }
    }
    
    public static void getNumbers(ArrayList<Integer> positive,ArrayList<Integer> negative) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        
        while(!finished){
            int number = scanner.nextInt();
            if(number != 0){
                if(number > 0){
                    positive.add(number);
                }
                else{
                    negative.add(number);
                }
            }
            else{
                finished = true;
            }
        }
    }
}
