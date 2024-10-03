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
 * @author Usuario14
 */
public class InvertirCadenaFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        String reversedText;
        System.out.println("Introduzca el texto a invertir");
        text = scanner.nextLine();
        reversedText = new StringBuilder(text).reverse().toString();
        
        if(args.length < 1){
            System.out.println(reversedText);
        }
        else{
            FileWriter fw = null;
            BufferedWriter writer = null;
            
            try{
                File file = new File(args[0] + ".txt");
                fw = new FileWriter(file,false);
                writer = new BufferedWriter(fw);
                
                writer.write(reversedText);
                writer.newLine();
                writer.flush();
                System.out.println("Se ha añadido ");
            }
            catch(IOException e){
                System.err.println("Ha surgido un error en la escritura del archivo");
            }
            finally{
                try{
                    if(writer != null)
                        writer.close();
                }
                catch(IOException e){
                    System.err.println("Ha ocurrido un error con el buffer de escritura");
                }
            }
        }
    }
    
}
