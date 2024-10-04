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
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean finished = false;
        System.out.println("Introduzca numeros y pulse enter (introduzca 0 para terminar la introduccion de datos)");

        while (!finished) {
            int number = scanner.nextInt();
            if (number == 0) {
                finished = true;
            } else {
                numbers.add(number);
            }
        }
        
        Runtime runtime = Runtime.getRuntime();
        Process process_1;
        Process process_2;
        String[] command_1 = {"java","FiltroParImpar.java","p"};
        String[] command_2 = {"java","FiltroParImpar.java","i"};
        
        try{
            process_1 = runtime.exec(command_1);
            process_2 = runtime.exec(command_2);
            OutputStream out = process_1.getOutputStream();
            OutputStream out2 = process_2.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(out2));
            
            for(Integer number : numbers){
                bw.write(String.valueOf(number));
                bw2.write(String.valueOf(number));
                bw.newLine();
                bw2.newLine();
            }
            
            /* Todo este bloque es porque para el proceso anterior necesito pasarle 0
                para que se termine la introduccion de datos
            */
            bw.write(String.valueOf(0));
            bw.newLine();
            bw2.write(String.valueOf(0));
            bw2.newLine();
           
            bw.flush();
            bw.close();
            bw2.flush();
            bw2.close();
            
            InputStream in = process_1.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            process_1.waitFor();
            String lineEven = br.readLine();
            
            InputStream in2 = process_2.getInputStream();
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            process_2.waitFor();
            String lineOdd = br2.readLine();
            
            br.close();
            br2.close();
            
            System.out.println("Numeros pares: " + lineEven);
            System.out.println("Numeros impares: " + lineOdd);
        }
        catch(IOException ioe){
            
        }
        catch(InterruptedException ie){
        }
    }
}
