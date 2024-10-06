/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Usuario
 */
public class ClasificaTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader br1, br2, br3;
        int wordsNumber = 0;
        String line, totalWords, longWords, shortWords;
        String[] wordsInLine;
        Runtime runtime = Runtime.getRuntime();
        Process process_1, process_2, process_3;
        String textToClasify = "texto_1.txt";
        String[] commands_1 = {"java","ContarPalabras.java",textToClasify};
        String[] commands_2 = {"java","ContarPalabras.java","-g","7",textToClasify};
        String[] commands_3 = {"java","ContarPalabras.java","-l","5",textToClasify};
        
        if(args.length  == 1){
            File file = new File(args[0]);
            if(file.exists()){
                try{
                    process_1 = runtime.exec(commands_1);
                    process_2 = runtime.exec(commands_2);
                    process_3 = runtime.exec(commands_3);
                    
                    br1 = new BufferedReader(new InputStreamReader(process_1.getInputStream()));
                    totalWords = br1.readLine();
                    
                    br2 = new BufferedReader(new InputStreamReader(process_2.getInputStream()));
                    longWords = br2.readLine();
                    
                    br3 = new BufferedReader(new InputStreamReader(process_3.getInputStream()));
                    shortWords = br3.readLine();
                    
                    br1.close();br2.close();br3.close();
                    
                    System.out.println("Numero de palabras: " + totalWords);
                    System.out.println("Palabras largas: " + longWords);
                    System.out.println("Palabras cortas: " + shortWords);
                }
                catch(IOException ioe){}
            }
            else{
                System.out.println("El fichero no existe o el nombre proporcionado es erroneo");
            }
        }
        else{
            System.out.println("No se ha introducido el nombre de ningun fichero O se ha introducido erroneamente O se ha introducido mas de 1 parametro");
        }
    }
    
}
