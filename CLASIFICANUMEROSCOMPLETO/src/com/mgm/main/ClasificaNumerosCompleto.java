/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ClasificaNumerosCompleto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        getNumbers(numbers);
        
        Runtime runtime = Runtime.getRuntime();
        Process process_1;
        Process process_2;
        Process process_3;
        String[] commands_1 = {"java", "ClasificaNumeros.java"};
        String[] commands_2 = {"java", "FiltroPosNeg.java"};
        String[] commands_3 = {"java", "FiltroPosNeg.java", "-neg"};
        
        try{
            process_1 = runtime.exec(commands_1);
            process_2 = runtime.exec(commands_2);
            process_3 = runtime.exec(commands_3);
            
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(process_1.getOutputStream()));
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(process_2.getOutputStream()));
            BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(process_3.getOutputStream()));
            
            for(Integer number : numbers){
                bw1.write(Integer.toString(number));
                bw1.newLine();
                bw2.write(Integer.toString(number));
                bw2.newLine();
                bw3.write(Integer.toString(number));
                bw3.newLine();
            }
            
            bw1.flush();bw2.flush();bw3.flush();
            bw1.close();bw2.close();bw3.close();
            
            BufferedReader br1 = new BufferedReader(new InputStreamReader(process_1.getInputStream()));
            process_1.waitFor();
            String evenNumbers = br1.readLine();
            String oddNumbers = br1.readLine();
            
            BufferedReader br2 = new BufferedReader(new InputStreamReader(process_2.getInputStream()));
            process_2.waitFor();
            String positiveNumbers = br2.readLine();
            
            BufferedReader br3 = new BufferedReader(new InputStreamReader(process_3.getInputStream()));
            process_3.waitFor();
            String negativeNumbers = br3.readLine();
            
            br1.close();br2.close();br3.close();
            
            System.out.println(evenNumbers);
            System.out.println(oddNumbers);
            System.out.println("Numeros positivos: " + positiveNumbers);
            System.out.println("Numeros negativos: " + negativeNumbers);
        }
        catch(IOException ioe){}
        catch(InterruptedException ie){}
    }
    
    public static void getNumbers(ArrayList<Integer> numbers) {
        
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        
        while(!finished){
            int number = scanner.nextInt();
            
            if(number != 0){
                numbers.add(number);
            }
            else{
                numbers.add(number);
                finished = true;
            }
        }
    }
}
