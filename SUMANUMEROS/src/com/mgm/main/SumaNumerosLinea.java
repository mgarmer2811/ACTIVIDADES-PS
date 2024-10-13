/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class SumaNumerosLinea {
    public static void main(String[] args) {
        String numbers;
        Scanner scanner = new Scanner(System.in);
        int sum;
        
        numbers = scanner.nextLine();
        numbers = getStringNumbers(numbers);
        sum = getSum(numbers);
        
        System.out.println(sum);
    }
    
    /**
     * Esta funcion recibe una string de numeros separados por
     * espacios y devuelve la suma de todos ellos
     * @param numbers
     * @return sum
     */
    public static int getSum(String numbers) {
        int sum = 0;
        String[] arrayNumbers = numbers.split(" ");
        
        for(String number : arrayNumbers){
            try{
                sum += Integer.parseInt(number);
            }
            catch(NumberFormatException e){
                System.err.println("Ha habido un problema con el parseo de la string de numeros");
                e.printStackTrace();
            }
        }
        
        return sum;
    }
    
    /**
     * Esta funcion recibe una string de numeros separados por espacios
     * pero se asegura que solo haya 1 unico espacio entre dichos numeros
     * @param numbers
     * @return propoerString
     */
    public static String getStringNumbers(String numbers) {
        String properString = "";
        
        String[] parts = numbers.trim().split("\\s+");
        properString = String.join(" ", parts);
        
        return properString;
    }
}
