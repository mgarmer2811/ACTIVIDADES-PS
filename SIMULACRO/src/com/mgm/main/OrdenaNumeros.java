/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class OrdenaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers;
        String fileName;
        ArrayList<String> arrayNumbers = new ArrayList<>();
        
        if(args.length == 2){
            switch(args[0])
            {
                case "-g":
                {
                    //System.out.println("Introduzca una serie de numeros separados por espacio");
                    numbers = scanner.nextLine();
                    //System.out.println("Introduzca el nombre del fichero donde guardar el resultado");
                    fileName = scanner.nextLine();
                    
                    String[] numbers2 = numbers.trim().split(" ");
                    for(String text : numbers2){
                        arrayNumbers.add(text);
                    }
                    
                    FileWriter fw = null;
                    BufferedWriter bw = null;
                    ArrayList<String> greater = new ArrayList<>();
                    
                    try{
                        File file = new File(fileName);
                        fw = new FileWriter(file,true);
                        bw = new BufferedWriter(fw);
                        
                        for(String stringNumber : arrayNumbers){
                            if(Integer.parseInt(stringNumber) > Integer.parseInt(args[1])){
                                greater.add(stringNumber);
                            }
                        }
                        String toWrite = "Numeros mayores de " + args[1] + " : " + greater.toString();
                        System.out.println(toWrite);
                        
                        bw.write(toWrite);
                        bw.newLine();
                        
                        bw.flush();
                        bw.close();
                    }
                    catch(IOException ioe){}
                    break;
                }
                case "-l":
                {
                    //System.out.println("Introduzca una serie de numeros separados por espacio");
                    numbers = scanner.nextLine();
                    //System.out.println("Introduzca el nombre del fichero donde guardar el resultado");
                    fileName = scanner.nextLine();
                    
                    String[] numbers2 = numbers.trim().split(" ");
                    for(String text : numbers2){
                        arrayNumbers.add(text);
                    }
                    
                    FileWriter fw = null;
                    BufferedWriter bw = null;
                    ArrayList<String> lower = new ArrayList<>();
                    
                    try{
                        File file = new File(fileName);
                        fw = new FileWriter(file,true);
                        bw = new BufferedWriter(fw);
                        
                        for(String stringNumber : arrayNumbers){
                            if(Integer.parseInt(stringNumber) < Integer.parseInt(args[1])){
                                lower.add(stringNumber);
                            }
                        }
                        String toWrite = "Numeros menores de " + args[1] + " : " + lower.toString();
                        System.out.println(toWrite);
                        
                        bw.write(toWrite);
                        bw.newLine();
                        
                        bw.flush();
                        bw.close();
                    }
                    catch(IOException ioe){}
                    break;
                }
            }
        }
        else if(args.length == 3){ // este seria el parametro -b x y
            //System.out.println("Introduzca una serie de numeros separados por espacio");
            numbers = scanner.nextLine();
            //System.out.println("Introduzca el nombre del fichero donde guardar el resultado");
            fileName = scanner.nextLine();
            
            String[] numbers2 = numbers.trim().split(" ");
            for (String text : numbers2) {
                arrayNumbers.add(text);
            }

            FileWriter fw = null;
            BufferedWriter bw = null;
            ArrayList<String> between = new ArrayList<>();
            
            try {
                File file = new File(fileName);
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);

                for (String stringNumber : arrayNumbers) {
                    if ((Integer.parseInt(stringNumber) > Integer.parseInt(args[1])) && (Integer.parseInt(stringNumber) < Integer.parseInt(args[2]))) {
                        between.add(stringNumber);
                    }
                }
                String toWrite = "Numeros entre " + args[1] + " y " + args[2] + " : " + between.toString();
                System.out.println(toWrite);
                
                bw.write(toWrite);
                bw.newLine();

                bw.flush();
                bw.close();
            } catch (IOException ioe) {}
        }
        else{
            System.out.println("Ha ocurrido un error de entrada de parametros");
        }
    }
}
