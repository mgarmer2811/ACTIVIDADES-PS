/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Frecuencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        int a,e,i,o,u;
        
        a = 0;
        e = 0;
        i = 0;
        o = 0;
        u = 0;
        
        if(args.length != 0){
            System.out.println("Introduzca una cadena de texto");
            word = scanner.nextLine();
            
            for(int k = 0; k < word.length(); k++){
                char letter = word.charAt(k);
                
                switch(letter)
                {
                    case 'a':
                    {
                        a += 1;
                        break;
                    }
                    case 'e':
                    {
                        e += 1;
                        break;
                    }
                    case 'i':
                    {
                        i += 1;
                        break;
                    }
                    case 'o':
                    {
                        o += 1;
                        break;
                    }
                    case 'u':
                    {
                        u += 1;
                        break;
                    }
                }
            }
            FileWriter fw;
            BufferedWriter bw;
            
            try{
                File file = new File(args[0]);
                fw = new FileWriter(file,true);
                bw = new BufferedWriter(fw);
                
                String textToWrite = word + ": " + a + " " + e + " " + i + " " + o + " " + u;
                bw.write(textToWrite);
                bw.newLine();
                
                bw.flush();
                bw.close();
            }
            catch(IOException ioe){}
        }
        else{
            System.out.println("No has introducido un nombre de fichero");
        }
    }
    
}
