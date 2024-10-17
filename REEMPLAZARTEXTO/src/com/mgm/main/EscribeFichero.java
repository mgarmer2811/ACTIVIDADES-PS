/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class EscribeFichero {
    public static void main(String[] args) {
        String fileToWrite = "";
        String line = "";
        Scanner scanner = new Scanner(System.in);
        
        try{
            fileToWrite = args[0];
        }
        catch(Exception e){
            System.exit(1);
        }
        
        BufferedWriter bw = null;
        boolean reading = true;
        
        while(reading){
            line = scanner.nextLine();
            if(!line.equalsIgnoreCase("fin")){
                try{
                    bw = new BufferedWriter(new FileWriter(fileToWrite,true));
                    bw.write(line);
                    bw.newLine();
                    
                    bw.flush();bw.close();
                }
                catch(IOException ioe){
                    System.exit(1);
                }
            }
            else{
                reading = false;
            }
        }
    }
}
