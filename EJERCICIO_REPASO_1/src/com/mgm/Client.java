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
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Client {
    public static void main(String[] args) {
        int puerto = 50050;
        String direccion = "localhost";
        
        try(Socket socket = new Socket(direccion,puerto)){
            String enviado = "";
            String recibido = "";
            
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            do{
                enviado = scanner.nextLine();
                writer.write(enviado);
                writer.newLine();writer.flush();
                
                if(enviado.equalsIgnoreCase("SALIR")){
                    continue;
                }
                
                if(enviado.equalsIgnoreCase("TODO")){
                    recibido = "";
                    for(int i = 0; i < 5; i++){
                        recibido += reader.readLine() + "\n";
                    }
                    System.out.println(recibido);
                }
                else{
                    recibido = reader.readLine();
                    System.out.println(recibido);
                }
            }
            while(!enviado.equalsIgnoreCase("SALIR"));
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
