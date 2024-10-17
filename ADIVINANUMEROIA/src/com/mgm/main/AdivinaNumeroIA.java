/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.AdivinaNumeroIA to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class AdivinaNumeroIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String[] command = {"java","AdivinaNumero.java"};
        BufferedReader br = null;
        BufferedWriter bw = null;
        String processInfo = "";
        int guess;
        int lowerBound = 1;
        int upperBound = 100;
        int rounds = 1;
        
        try{
            
            process = runtime.exec(command);
            guess = (lowerBound + random.nextInt((upperBound - lowerBound) + 1));

            bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            bw.write(Integer.toString(guess));
            bw.newLine();
            bw.flush();
            
            processInfo = br.readLine();
            System.out.println("Ronda " + rounds + ": " + guess + processInfo);
            
            while(!processInfo.equals("=")){
                rounds++;
                if(processInfo.equals("-")){
                    upperBound = guess - 1;
                }
                else{
                    lowerBound = guess + 1;
                }
                
                guess = (lowerBound + random.nextInt((upperBound - lowerBound) + 1));
                bw.write(Integer.toString(guess));
                bw.newLine();
                bw.flush();

                processInfo = br.readLine();
                System.out.println("Ronda " + rounds + ": " + guess + processInfo);
            }
            process.waitFor();
            System.out.println("Numero adivinado (" + guess + ") en " + rounds + " rondas");
        }
        catch(IOException e){
            System.out.println("Se ha producido un error en la lectura/escritura sobre el proceso hijo");
        }
        catch(InterruptedException ie){
            System.out.println("Se ha producido un error en la espera de la ejecucion del proceso");
        }
        finally{
            try{
                if(br != null){
                    br.close();
                }
                
                if(bw != null){
                    bw.close();
                }
            }
            catch(IOException ioe){
                System.out.println("Se ha producido un error al cerrar los writer y los reader");
            }
        }
    }
    
}
