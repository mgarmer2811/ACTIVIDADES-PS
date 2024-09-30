/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String[] commands = {"java","ToUpperCase.java","hola mundo"};
        Runtime runTime = Runtime.getRuntime();
        Process process;
        int exitCode = 2;
        
        try{
            process = runTime.exec(commands);
            exitCode = process.waitFor();
        }
        catch(Exception ex){}
        
        System.out.println("El proceso ha terminado con exitCode: " + exitCode);
    }
    
}
