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
public class OperacionNumerica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        if((args.length > 0) && (args.length < 2)){
            switch(args[0]){
                case "-s":
                {
                    scanNumbers(numbers);
                    System.out.println(sumElements(numbers));
                    break;
                }
                case "-m":
                {
                    scanNumbers(numbers);
                    System.out.println(averageElements(numbers));
                    break;
                }
                default:
                    System.out.println("Has introducido un parametro incorrecto");
            }
        }
        else{
            scanNumbers(numbers);
            System.out.println(numbers.toString());
        }
    }
    
    public static void scanNumbers(ArrayList<Integer> numbers) {
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        
        while(!finished){
            int number = scanner.nextInt();
            if((number != 0) && (number > 0)){
                numbers.add(number);
            }
            else if (number == 0){
                finished = true;
            }
        }
    }
    
    public static int sumElements(ArrayList<Integer> numbers){
        int sum = 0;
        
        for(Integer number : numbers){
            sum += number;
        }
        return sum;
    }
    
    public static float averageElements(ArrayList<Integer> numbers){
        float average = 0.0f;
        int sum = sumElements(numbers);
        average = (float)(sum / (float)numbers.size());
        
        return average;
    }
}
