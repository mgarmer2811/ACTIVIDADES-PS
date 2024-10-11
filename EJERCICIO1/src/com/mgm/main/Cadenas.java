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
        Scanner scanner = new Scanner(System.in);
        String fileName;
        
        System.out.println("Introduzca cadenas de texto (Introduzca el texto 'FIN' para terminar la introduccion de datos)");
        getTexts(texts);
        fileName = scanner.nextLine();
        
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String[] command = {"java", "Frecuencia.java", fileName};
        BufferedWriter bw;
         
        try{
            for(String text : texts){
                process = runtime.exec(command);
                bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                bw.write(text);
                bw.newLine();
                
                bw.flush();
                bw.close(); 
            }
        }
        catch(IOException ioe){}
    }
    
    public static void getTexts(ArrayList<String> texts) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        String text;
        
        while(!finished){
            text = scanner.nextLine();
            if(!text.equalsIgnoreCase("fin")){
                texts.add(text);
            }
            else{
                finished = true;
            }
        }
    }
}
