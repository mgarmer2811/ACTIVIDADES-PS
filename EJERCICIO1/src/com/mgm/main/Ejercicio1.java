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
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stringNumber;
        String fileName;
        
        System.out.println("Introduzca un numero entero entre 10 y 20");
        stringNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce ahora el nombre del fichero donde escribir las cadenas");
        fileName = scanner.nextLine();
        
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        Process process_2 = null;
        String[] command_1 = {"java","CreaCadenas.java",Integer.toString(1)};
        String[] command_2 = {"java","Cadenas.java"};
        BufferedWriter bw = null;
        BufferedReader br = null;
        ArrayList<String> texts = new ArrayList<String>();
        
        try{
            for(int i = 0; i < stringNumber; i++){
                process = runtime.exec(command_1);
                br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                texts.add(br.readLine());
            }
            br.close();
            texts.add("FIN");
            process_2 = runtime.exec(command_2);
            bw = new BufferedWriter(new OutputStreamWriter(process_2.getOutputStream()));
            
            for(String text : texts){
                bw.write(text);
                bw.newLine();
            }
            bw.write(fileName);
            bw.newLine();
            
            bw.flush();
            bw.close();
        }
        catch(IOException ioe){}
    }
    
}
