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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario14
 */
public class ReemplazarTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String lookFor = "";
        String replacement = "";
        String fileToRead = "";
        String fileToWrite = "";
        String line = "";
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduzca la palabra o frase a sustituir en el fichero");
        lookFor = scanner.nextLine();
        System.out.println("Introduzca la palabra o frase de reemplazo con la que hacer la sustitucion");
        replacement = scanner.nextLine();
        
        try{
            fileToRead = args[0];
            fileToWrite = args[1];
        }
        catch(Exception e){
            System.out.println("Ha ocurrido un error en la recepcion de los ficheros (pon bien los argumentos)");
            System.exit(1);
        }
        
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String[] command_read = {"java","LeeFichero.java"};
        String[] command_write = {"java","EscribeFichero.java",fileToWrite};
        
        BufferedWriter bw = null;
        BufferedReader br = null;
        
        try{
            process = runtime.exec(command_read);
            bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            
            bw.write(fileToRead);
            bw.newLine();
            bw.flush();bw.close();
            
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            lines.add("fin");
            
        }
        catch(IOException ioe){
            
        }
    }
    
}
