/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CreaCadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        
        if((args.length < 1) || (args.length > 1)){
            System.out.println("Error en el numero de parametros proporcionados");
        }
        else if(!isNumber(args[0])){
            System.out.println("Error en el parametro proporcionado, no es un numero");
        }
        else{
            int numberStrings = Integer.parseInt(args[0]);
            BufferedReader br;
            Runtime runtime = Runtime.getRuntime();
            Process process;
            String[] command = {"java", "GenerarCadena.java"};
            
            for(int i = 0; i < numberStrings; i++){
                try{
                    process = runtime.exec(command);
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String randomString = br.readLine();
                    
                    br.close();
                    strings.add(randomString);
                }
                catch(IOException ioe){}
            }
            
            for(String randomString : strings){
                System.out.println(randomString);
            }
        }
    }
    
    public static boolean isNumber(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException nfe){
            return false;
        }
    }
}
