/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class ClasificaNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        ArrayList<Integer> numbers = new ArrayList<>();
        String evenNumbers;
        String oddNumbers;
        
        System.out.println("");
        System.out.println("Introduzca numeros y pulse enter(introduzca 0 cuando quiera terminar la introduccion de datos)");
        while (!finished) {
            int number = scanner.nextInt();
            if (number == 0) {
                finished = true;
                numbers.add(number);
            } else {
                numbers.add(number);
            }
        }
        Runtime runtime = Runtime.getRuntime();
        Process process_1;
        Process process_2;
        String[] command_1 = {"java","FiltroParImpar","p"};
        String[] command_2 = {"java","FiltroParImpar","i"};
        
        try{
            process_1 = runtime.exec(command_1);
            OutputStream out = process_1.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            
            for(Integer number : numbers){
                bw.write(number);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            
            InputStream in = process_1.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            evenNumbers = br.readLine();
            br.close(); // Here i have even numbers in this form: [2,4,6]
            process_1.waitFor();
            
            process_2 = runtime.exec(command_2);
            OutputStream out2 = process_2.getOutputStream();
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(out2));
            
            for(Integer number : numbers){
                bw2.write(number);
                bw2.newLine();
            }
            bw2.flush();
            bw2.close();
            
            InputStream in2 = process_2.getInputStream();
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            oddNumbers = br2.readLine();
            br2.close();
            process_2.waitFor();
        }
        catch(IOException ioe){
            System.err.println("Ha ocurrido un error en la comunicacion entre procesos");
        }
        catch(InterruptedException ie){
            System.err.println("Ha ocurrido un error en la ejecucion de algun proceso");
        }
        
        String onlyEvenNumbers = evenNumbers.substring(1, evenNumbers.length() - 1);
        String onlyOddNumbers = oddNumbers.substring(1, oddNumbers.length() - 1);
        
    }
    
}
