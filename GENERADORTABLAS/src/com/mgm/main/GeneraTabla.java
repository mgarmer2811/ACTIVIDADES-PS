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
public class GeneraTabla {
    public static void main(String[] args) {
        String fileName;
        Scanner scanner = new Scanner(System.in);
        String tableNumber;
        int result;
        
        if((args.length < 1) || (args.length > 1)){
            System.exit(1);
        }
        
        fileName = args[0];
        System.out.println("De que numero quieres la tabla de multiplicar");
        tableNumber = scanner.nextLine();
        
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){}
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + "_" + tableNumber + ".txt",true));
            
            for(int i = 1; i <= 10; i++){
                result = Integer.parseInt(tableNumber) * i;
                bw.write(tableNumber + " x " + Integer.toString(i) + " = " + Integer.toString(result));
                bw.newLine();
            }
            bw.flush();bw.close();
        }
        catch(IOException ioe){
            System.exit(2);
        }
    }
}
