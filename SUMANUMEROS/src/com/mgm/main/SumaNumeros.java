/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class SumaNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        getNumbers(numbers);
        launchProcess(numbers);
    }
    
    /**
     * Esta funcion recibe un ArrayList de Strings 'numbers' y la rellena con los
     * numeros leidos por teclado de 1 en 1
     * @param numbers 
     */
    public static void getNumbers(ArrayList<String> numbers) {
        boolean finished = false;
        Scanner scanner = new Scanner(System.in);
        String number;
        
        System.out.println("Introduzca numeros {1 por cada linea}.Para terminar introduzca '0'");
        
        while(!finished){
            number = scanner.nextLine();
            try{
                if(Integer.parseInt(number) != 0){
                    numbers.add(number);
                }
                else{
                    finished = true;
                }
            }
            catch(NumberFormatException e){
                System.err.println("Ha habido un problema con el parseo de la string de numeros");
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Esta funcion recibe un ArrayList de numeros 'numbers' y con ello
     * lanza y maneja el proceso.
     * @param numbers 
     */
    public static void launchProcess(ArrayList<String> numbers) {
        String[] command = {"java","SumaNumerosLinea.java"};
        Runtime runtime = Runtime.getRuntime();
        Process process;
        String numbersBySpace = "";
        String inputProcess;
        String inputError;
        
        try{
            process = runtime.exec(command);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            
            for(String number : numbers){
                numbersBySpace += number + " ";
            }
            bw.write(numbersBySpace);
            bw.newLine();
            
            bw.flush();bw.close();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            inputProcess = br.readLine();
            BufferedReader berr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            inputError = berr.readLine();
            
            br.close();berr.close();
            
            if(inputError == null){
                System.out.println("La suma de todos los numeros es: " + inputProcess);
            }
            else{
                System.err.println("Se ha producido el siguiente error en la ejecucion: \n" + inputError);
            }
        }
        catch(IOException e){
            System.err.println("Ha habido un problema lanzando el proceso");
        }
    }
}
