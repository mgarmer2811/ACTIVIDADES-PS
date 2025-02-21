/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author Usuario14
 */
public class ClientHandler extends Thread{
    private Socket socket;
    
    public ClientHandler(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String enviado = "";
            String recibido = "";
            
            do{
                recibido = reader.readLine();
                if(recibido.equalsIgnoreCase("SALIR")){
                    continue;
                }
                
                String[] partes = recibido.split("#");
                String operacion = partes[0].toUpperCase();
                String[] numString = partes[1].split(" ");
                
                switch(operacion){
                    case "SUMA":{
                        int suma = 0;
                        for(String num : numString){
                            suma += Integer.parseInt(num);
                        }
                        writer.write(operacion + "#" + String.valueOf(suma));
                        writer.newLine();writer.flush();
                        
                        break;
                    }
                    case "MEDIA":{
                        int suma = 0;
                        int media = 0;
                        int cantidad = 0;
                        for(String num : numString){
                            suma += Integer.parseInt(num);
                            cantidad += 1;
                        }
                        media = suma / cantidad;
                        writer.write(operacion + "#" + String.valueOf(media));
                        writer.newLine();writer.flush();
                        
                        break;
                    }
                    case "CONTAR":{
                        writer.write(operacion + "#" + String.valueOf(numString.length));
                        writer.newLine();writer.flush();
                        
                        break;
                    }
                    case "MAXIMO":{
                        int[] numeros = new int[numString.length];
                        
                        for(int i = 0; i < numString.length; i++){
                            numeros[i] = Integer.parseInt(numString[i]);
                        }
                        Arrays.sort(numeros);
                        int maximo = numeros[numeros.length - 1];
                        writer.write(operacion + "#" + String.valueOf(maximo));
                        writer.newLine();writer.flush();
                        
                        break;
                    }
                    case "MINIMO":{
                        int[] numeros = new int[numString.length];
                        
                        for(int i = 0; i < numString.length; i++){
                            numeros[i] = Integer.parseInt(numString[i]);
                        }
                        Arrays.sort(numeros);
                        int minimo = numeros[0];
                        writer.write(operacion + "#" + String.valueOf(minimo));
                        writer.newLine();writer.flush();
                        
                        break;
                    }
                    case "TODO":{
                        int suma = 0;
                        int media = 0;
                        int cantidad = 0;
                        for(String num : numString){
                            suma += Integer.parseInt(num);
                            cantidad += 1;
                        }
                        media = suma / cantidad;
                        
                        int[] numeros = new int[numString.length];
                        
                        for(int i = 0; i < numString.length; i++){
                            numeros[i] = Integer.parseInt(numString[i]);
                        }
                        Arrays.sort(numeros);
                        int maximo = numeros[numeros.length - 1];
                        int minimo = numeros[0];
                        
                        writer.write(operacion + "#" + String.valueOf(suma));
                        writer.newLine();writer.flush();
                        writer.write(operacion + "#" + String.valueOf(media));
                        writer.newLine();writer.flush();
                        writer.write(operacion + "#" + String.valueOf(numString.length));
                        writer.newLine();writer.flush();
                        writer.write(operacion + "#" + String.valueOf(maximo));
                        writer.newLine();writer.flush();
                        writer.write(operacion + "#" + String.valueOf(minimo));
                        writer.newLine();writer.flush();
                    }
                }
            }
            while(!recibido.equalsIgnoreCase("SALIR"));
            socket.close();
            
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
