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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario14
 */
public class ClasificarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howManyLimits = 0; // para saber cuantos numeros de limite quiere usar el usuario
        String fileName;
        ArrayList<String> numbers = new ArrayList<>();
        Runtime runtime = Runtime.getRuntime();
        Process process;
        
        if(args.length > 0){
            if(Integer.parseInt(args[0]) == 1){
                System.out.println("Introduzca el numero que desea como limite");
                int oneNumberLimit = scanner.nextInt(); // el numero limite pequeño
                scanner.nextLine(); // para vaciar el buffer del \n
                System.out.println("Ahora introduzca numeros de 1 en 1 {1 por linea}. Para terminar la introduccion introduzca la cadena 'FIN'");
                askForNumbers(numbers);
                System.out.println("Introduzca el nombre del fichero donde se guardara el resultado");
                fileName = scanner.nextLine();
                
                String numberParameters = getStringNumbers(numbers);
                String[] command_1 = {"java","OrdenaNumeros.java","-l",Integer.toString(oneNumberLimit)};
                String[] command_2 = {"java","OrdenaNumeros.java","-g",Integer.toString(oneNumberLimit)};
                BufferedWriter bw = null;
                BufferedReader br = null;
                
                programThinking();
                
                try{
                    process = runtime.exec(command_1); // Ahora process mostrara y escribira los menores
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                    
                    process = runtime.exec(command_2);
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                }
                catch(IOException ioe){}
                catch(InterruptedException ie){}
            }
            else{
                System.out.println("Introduzca el primer numero que desea como limite");
                int firstLimit = scanner.nextInt();
                System.out.println("Introduzca el segundo numero que desea como limite");
                int secondLimit = scanner.nextInt();
                scanner.nextLine();
                askForNumbers(numbers);
                System.out.println("Introduzca el nombre del fichero donde se guardara el resultado");
                fileName = scanner.nextLine();
                
                String numberParameters = getStringNumbers(numbers);
                String[] command_1 = {"java","OrdenaNumeros.java","-l",Integer.toString(firstLimit)};
                String[] command_2 = {"java","OrdenaNumeros.java","-b",Integer.toString(firstLimit),Integer.toString(secondLimit)};
                String[] command_3 = {"java","OrdenaNumeros.java","-g",Integer.toString(secondLimit)};
                BufferedWriter bw = null;
                BufferedReader br = null;
                
                programThinking();
                
                try{
                    process = runtime.exec(command_1); // Ahora process mostrara y escribira los menores
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                    
                    process = runtime.exec(command_2);
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                    
                    process = runtime.exec(command_3);
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                }
                catch(IOException ioe){}
                catch(InterruptedException ie){}
            }
        }
        else{
            while((howManyLimits != 1) && (howManyLimits != 2)){
                System.out.println("Introduzca cuantos numeros usaras de limite (1 0 2)");
                howManyLimits = scanner.nextInt();
            }
            
            if((howManyLimits == 1)){
                System.out.println("Introduzca el numero que desea como limite");
                int oneNumberLimit = scanner.nextInt(); // el numero limite pequeño
                scanner.nextLine(); // para vaciar el buffer del \n
                System.out.println("Ahora introduzca numeros de 1 en 1 {1 por linea}. Para terminar la introduccion introduzca la cadena 'FIN'");
                askForNumbers(numbers);
                System.out.println("Introduzca el nombre del fichero donde se guardara el resultado");
                fileName = scanner.nextLine();
                
                String numberParameters = getStringNumbers(numbers);
                String[] command_1 = {"java","OrdenaNumeros.java","-l",Integer.toString(oneNumberLimit)};
                String[] command_2 = {"java","OrdenaNumeros.java","-g",Integer.toString(oneNumberLimit)};
                BufferedWriter bw = null;
                BufferedReader br = null;
                
                programThinking();
                
                try{
                    process = runtime.exec(command_1); // Ahora process mostrara y escribira los menores
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                    
                    process = runtime.exec(command_2);
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                }
                catch(IOException ioe){}
                catch(InterruptedException ie){}    
            }
            else{ // significa que ha elegido el 2
                System.out.println("Introduzca el primer numero que desea como limite");
                int firstLimit = scanner.nextInt();
                System.out.println("Introduzca el segundo numero que desea como limite");
                int secondLimit = scanner.nextInt();
                scanner.nextLine();
                askForNumbers(numbers);
                System.out.println("Introduzca el nombre del fichero donde se guardara el resultado");
                fileName = scanner.nextLine();
                
                String numberParameters = getStringNumbers(numbers);
                String[] command_1 = {"java","OrdenaNumeros.java","-l",Integer.toString(firstLimit)};
                String[] command_2 = {"java","OrdenaNumeros.java","-b",Integer.toString(firstLimit),Integer.toString(secondLimit)};
                String[] command_3 = {"java","OrdenaNumeros.java","-g",Integer.toString(secondLimit)};
                BufferedWriter bw = null;
                BufferedReader br = null;
                
                programThinking();
                
                try{
                    process = runtime.exec(command_1); // Ahora process mostrara y escribira los menores
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                    
                    process = runtime.exec(command_2);
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                    
                    process = runtime.exec(command_3);
                    
                    bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    
                    bw.write(numberParameters);
                    bw.newLine();
                    bw.write(fileName);
                    bw.newLine();
                    
                    bw.flush();
                    bw.close();
                    
                    process.waitFor();
                    System.out.println(br.readLine());
                    br.close();
                }
                catch(IOException ioe){}
                catch(InterruptedException ie){}
            }
        }
    }
    
    public static void askForNumbers(ArrayList<String> numbers) {
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        String number;
        
        while(!finished){
            number = scanner.nextLine();
            if(!number.equalsIgnoreCase("FIN")){
                numbers.add(number);
            }
            else{
                finished = true;
            }
        }
    }
    
    public static String getStringNumbers(ArrayList<String> arr) {
        String stringNumbers = "";
        
        for(String value : arr){
            stringNumbers += value + " "; // Con esto hago el formato que recoge el otro programa: 1 3 4 5
        }
        
        return stringNumbers;
    }
    
    public static void programThinking() {
        for(int i = 0; i < 10; i++){
            try {
                System.out.print(".");
                Thread.sleep(200);
            } catch (InterruptedException ex){}
        }
        System.out.println(""); //Para el final de linea
    }
}
