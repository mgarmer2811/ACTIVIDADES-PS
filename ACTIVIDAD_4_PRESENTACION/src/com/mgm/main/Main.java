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
        String jarPath = "C:\\Users\\Usuario14\\Desktop\\DEV\\PSPRO\\ACTIVIDAD_3_PRESENTACION\\dist\\ACTIVIDAD_3_PRESENTACION.jar";
        String[] commands = new String[]{"java","-jar",jarPath,"hola"};
        Runtime runTime = Runtime.getRuntime();
        Process process;
        int exitCode = 10;
        
        try{
            process = runTime.exec(commands);
            exitCode = process.waitFor();
        }
        catch(Exception ex){}
        
        System.out.println("El proceso ha terminado con exitCode: " + exitCode);
    }
    
}
