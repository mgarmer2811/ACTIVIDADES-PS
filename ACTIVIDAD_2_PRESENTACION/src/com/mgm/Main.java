/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] commands = new String[]{"Notepad.exe"};
        Process process;
        int exitCode;
        try{
            process = Runtime.getRuntime().exec(commands);
            System.out.println("Se ha lanzado el proceso correctamente");
            exitCode = process.waitFor();
            System.out.println("El proceso ha finalizado con el codigo " + exitCode);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
