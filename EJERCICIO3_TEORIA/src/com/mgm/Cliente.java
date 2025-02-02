/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50050;
        
        try(Socket socket = new Socket(host,puerto)){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            String recibido;
            String enviado;
            boolean salir = false;
            
            do{
                System.out.println("Introduce la operacion a realizar con el formato {operando operacion operando} o escribe 'salir' para terminar");
                enviado = scanner.nextLine();
                
                if(!enviado.equalsIgnoreCase("salir")){
                    bw.write(enviado);
                    bw.newLine();
                    bw.flush();
                    
                    recibido = br.readLine();
                    System.out.println(recibido);
                }
                else{
                    salir = true;
                }
            }
            while(!salir);
            System.out.println("Has salido del programa");
        }
        catch(Exception e){
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
