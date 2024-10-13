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
        int numStrings = 0;
        int exitCode;
        String fileName;
        String tempLine;
        ArrayList<String> strings = new ArrayList<>();
        
        System.out.println("Introduzca el numero de cadenas a generar {10-20}");
        numStrings = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce el nombre del fichero donde guardar las cadenas");
        fileName = scanner.nextLine();
        
        Runtime runtime = Runtime.getRuntime();
        String[] command_1 = {"java","CreaCadenas.java",Integer.toString(numStrings)};
        String[] command_2 = {"java","Cadenas.java"};
        Process process;
        BufferedWriter bw;
        BufferedReader br;
        
        try{
            process = runtime.exec(command_1);
            
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((tempLine = br.readLine()) != null){
                strings.add(tempLine);
            }
            strings.add("fin");
            br.close();
            process.waitFor();
            
//            for(String string : strings){
//                System.out.println(string);
//            }
            
            process = runtime.exec(command_2);
            bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            
            for(String string : strings){
                bw.write(string);
                bw.newLine();
            }
            
            bw.write(fileName);
            bw.newLine();
            
            bw.flush();
            bw.close();
            
            exitCode = process.waitFor();
            System.out.println("El programa ha terminado con codigo: " + exitCode);
        }
        catch(IOException ioe){}
        catch(InterruptedException ie){}
    }
}
