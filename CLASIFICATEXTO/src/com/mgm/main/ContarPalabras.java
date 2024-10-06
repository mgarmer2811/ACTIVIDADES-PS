/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.ContarPalabras to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class ContarPalabras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        FileReader fr;
        BufferedReader br;
        int wordsNumber = 0;
        String line;
        String[] wordsInLine;
        
        if((args.length > 3) || (args.length == 0) || (args.length == 2)){
            System.out.println("Este programa se ejecuta con 1 solo parametro o con 3 {nombreFicheroParaLeer}, {'-g' / '-l'} y {X, donde 'X' es un numero}");
        }
        else{
            if(args.length > 1){
                if(args[0].equals("-g")){
                    try{
                        File file = new File(args[2]);
                        fr = new FileReader(file);
                        br = new BufferedReader(fr);
                        
                        while((line = br.readLine()) != null){
                            if(!line.trim().isEmpty()){
                                wordsInLine = line.split(" ");
                                
                                for(String word : wordsInLine){
                                    if(word.length() > Integer.parseInt(args[1])){
                                        wordsNumber++;
                                    }
                                }
                            }
                        }
                        
                        System.out.println(wordsNumber);
                    }
                    catch(IOException ioe){}
                }
                else if(args[0].equals("-l")){
                    try{
                        File file = new File(args[2]);
                        fr = new FileReader(file);
                        br = new BufferedReader(fr);
                        
                        while((line = br.readLine()) != null){
                            if(!line.trim().isEmpty()){
                                wordsInLine = line.split(" ");
                                
                                for(String word : wordsInLine){
                                    if(word.length() < Integer.parseInt(args[1])){
                                        wordsNumber++;
                                    }
                                }
                            }
                        }
                        
                        System.out.println(wordsNumber);
                    }
                    catch(IOException ioe){}
                }
                else{
                    System.out.println("Este programa se ejecuta con 1 solo parametro o con 3 {nombreFicheroParaLeer}, {'-g' / '-l'} y {X, donde 'X' es un numero}");
                }
            }
            else{
                try{
                    File file = new File(args[0]);
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                    
                    while((line = br.readLine()) != null){
                        wordsInLine = line.split(" "); // Separating by space, commas and points dont matter
                        wordsNumber += wordsInLine.length;
                    }
                    
                    System.out.println(wordsNumber);
                }
                catch(IOException ioe){}
            }
        }
    }
    
}
