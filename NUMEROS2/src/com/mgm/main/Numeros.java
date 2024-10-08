/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Numeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una lista de numeros separados por espacios");
        String numbersString = scanner.nextLine();
        
        numbersString = numbersString.trim(); // to get rid of unnecesary white-spaces
        String[] numbersArray = numbersString.split(" ");
        
        for(String stringNumber : numbersArray){
            numbers.add(Integer.parseInt(stringNumber));
        }
        numbers.add(0); // so that the process terminates correctly, since it needs the 0 number
        
        BufferedWriter bw1 = null;
        BufferedWriter bw2 = null;
        BufferedWriter bw3 = null;
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedReader br3 = null;
        
        String[] commands_1 = {"java", "OperacionNumerica.java"};
        String[] commands_2 = {"java", "OperacionNumerica.java", "-s"};
        String[] commands_3 = {"java", "OperacionNumerica.java" , "-m"};
        
        Runtime runtime = Runtime.getRuntime();
        Process process_1;
        Process process_2;
        Process process_3;
        
        String positiveNumbers;
        String sum;
        String average;
        
        try{
            process_1 = runtime.exec(commands_1);
            process_2 = runtime.exec(commands_2);
            process_3 = runtime.exec(commands_3);
            
            bw1 = new BufferedWriter(new OutputStreamWriter(process_1.getOutputStream()));
            bw2 = new BufferedWriter(new OutputStreamWriter(process_2.getOutputStream()));
            bw3 = new BufferedWriter(new OutputStreamWriter(process_3.getOutputStream()));
            
            for(Integer number : numbers){
                bw1.write(Integer.toString(number));
                bw1.newLine();
                bw2.write(Integer.toString(number));
                bw2.newLine();
                bw3.write(Integer.toString(number));
                bw3.newLine();
            }
            
            bw1.flush();bw1.close();
            bw2.flush();bw2.close();
            bw3.flush();bw3.close();
            
            br1 = new BufferedReader(new InputStreamReader(process_1.getInputStream()));
            br2 = new BufferedReader(new InputStreamReader(process_2.getInputStream()));
            br3 = new BufferedReader(new InputStreamReader(process_3.getInputStream()));
            
            positiveNumbers = br1.readLine();
            sum = br2.readLine();
            average = br3.readLine();
            
            br1.close();br2.close();br3.close();
            
            System.out.println("Numeros: " + positiveNumbers);
            System.out.println("Suma: " + sum);
            System.out.println("Media: " + average);
        }
        catch(IOException ioe){
            System.out.println("Se ha producido un error en el lanzamiento de los procesos"); // this is unnecessary
        }
    }
    
}
