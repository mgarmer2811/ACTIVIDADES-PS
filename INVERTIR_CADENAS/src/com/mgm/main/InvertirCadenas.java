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
public class InvertirCadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> texts = new ArrayList<String>();
        ArrayList<String> reversedTexts = new ArrayList<String>();
        String stopFlag = "FIN";
        System.out.println("Introduzca textos para revertir (Escriba FIN para terminar la introduccion de texto)");
        
        while(true){
            String inputText = scanner.nextLine();
            if(inputText.equalsIgnoreCase(stopFlag)){
                break;
            }
            texts.add(inputText);
        }
        
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String[] command = {"java","InvertirCadena.java"};
        
        for(String text : texts){
            try{
            process = runtime.exec(command);
            OutputStream out = process.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            
            writer.write(text);
            writer.newLine();
            writer.flush();
            writer.close();
            
            InputStream in = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String reversedText = reader.readLine();
            reader.close();
            process.waitFor();

            System.out.println("Original: " + text);
            System.out.println("Invertido: " + reversedText);
            }
            catch(IOException e){
                System.err.println("Ha ocurrido un error en la comunicacion entre procesos");
                e.printStackTrace();
            } catch (InterruptedException ex) {
                System.err.println("Ha ocurrido un error en la ejecucion del proceso hijo");
                ex.printStackTrace();
            }
        }
    }
    
}
