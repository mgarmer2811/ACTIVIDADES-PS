/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class GeneradorTablas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sNumbers;
        String fileName;
        int times;
        
        System.out.println("Introduzca numeros separados por espacio sobre los que se desea obtener las tablas de multiplicar");
        sNumbers = scanner.nextLine();
        System.out.println("Introduzca el prefijo de los ficheros a crear");
        fileName = scanner.nextLine();

        sNumbers = getStringNumbers(sNumbers);
        times = getQuantity(sNumbers);
        launchProcess(sNumbers,times,fileName);
    }
    
    public static void launchProcess(String numbers,int times,String file) {
        Runtime runtime = Runtime.getRuntime();
        String[] arrayNumbers = numbers.split(" ");
        String[] command = {"java","GeneraTabla.java",file};
        ArrayList<Process> processes = new ArrayList<>();
        int[] outCodes = new int[times];
        int correctExecution = 0;
        BufferedWriter bw;
        
        for(int i = 0; i < times; i++){
            try{
                Process process = runtime.exec(command);
                processes.add(process);
                bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                
                bw.write(arrayNumbers[i]);
                bw.newLine();
                
                bw.flush();bw.close();
            }
            catch(IOException e){
                System.err.println("Ha habido un error llamando a uno de los procesos");
            }
        }
        
        for(int i = 0; i < times; i++){
            try{
                outCodes[i] = processes.get(i).waitFor();
            }
            catch(InterruptedException e){}
        }
        
        for(Integer outCode : outCodes){
            if(outCode == 0){
                correctExecution++;
            }
        }
        
        if(correctExecution == times){
            System.out.println("Se han escrito todas las tablas correctamente");
        }
        else{
            System.err.println("Ha habido algun error en la escritura de las tablas");
        }
    }
    
    /**
     * Esta funcion recibe una string de numeros separados por espacios
     * pero se asegura que solo haya 1 unico espacio entre dichos numeros
     * @param numbers
     * @return propoerString
     */
    public static String getStringNumbers(String numbers) {
        String properString = "";
        
        String[] parts = numbers.trim().split("\\s+");
        properString = String.join(" ", parts);
        
        return properString;
    }
    
    /**
     * Retorna el numero de tablas a realizar.Recibe un parametro String 'numbers'
     * que es una string de numeros separadas por espacios.
     * @param numbers
     * @return quantity;
     */
    public static int getQuantity(String numbers) {
        int quantity = 0;
        String[] arrayNumbers =  numbers.split(" ");
        quantity = arrayNumbers.length;
        
        return quantity;
    }
}
