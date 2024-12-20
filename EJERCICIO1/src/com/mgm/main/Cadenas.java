/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Cadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> texts = new ArrayList<>();
        String fileName;
        String text;
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduzca cadenas de texto (Introduzca el texto 'FIN' para terminar la introduccion de datos)");
        while(!finished){
            text = scanner.nextLine();
            if(!text.equalsIgnoreCase("fin")){
                texts.add(text);
            }
            else{
                finished = true;
            }
        }
        System.out.println("Introduzca el nombre del fichero donde se guardara el resultado");
        fileName = scanner.nextLine();
        
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String[] command = {"java","Frecuencia.java",fileName};
        BufferedWriter bw;
         
        try{
            for(String string : texts){
                process = runtime.exec(command);
                bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                bw.write(string);
                bw.newLine();
                
                bw.flush();
                bw.close(); 
            }
        }
        catch(IOException ioe){}
    }
}
