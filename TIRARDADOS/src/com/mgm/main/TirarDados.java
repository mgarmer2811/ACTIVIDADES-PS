/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class TirarDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numFaces = 0;
        int numDices = 0;
        int numThrows = 0;
        int sum = 0;
        String diceResult;
        ArrayList<Process> processes = new ArrayList<>();
        ArrayList<String> diceResults = new ArrayList<>();
        
        System.out.println("Introduce el numero de caras que tendra el dado");
        numFaces = scanner.nextInt();
        System.out.println("Introduce el numero de dados que quieres tirar");
        numDices = scanner.nextInt();
        System.out.println("Introduce cuantas veces deseas lanzar el/los dado(s)");
        numThrows = scanner.nextInt();
        
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String[] command = {"java","Dado.java",Integer.toString(numFaces)};
        BufferedReader br;
        
        for(int i = 0; i < numThrows; i++){
            diceResults.clear();
            processes.clear();
            
            sum = 0;
            try{
                for(int j = 0; j < numDices; j++){
                    process = runtime.exec(command);
                    processes.add(process);
                }
                for(Process processAux : processes){
                    processAux.waitFor();
                    br = new BufferedReader(new InputStreamReader(processAux.getInputStream()));
                    diceResults.add(br.readLine());
                    br.close();
                }
                System.out.print("Tirada " + (i + 1) + ": ");
                for(String string : diceResults){
                    sum += Integer.parseInt(string);
                    System.out.print(string + " ");
                }
                System.out.print("= " + sum);
                System.out.println("");
            }
            catch(IOException e){
                System.err.println("Se ha producido un error en el lanzamiento de los dados (proceso)");
            }
            catch(InterruptedException ie){}
        }
    }
    
}
