/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5039;
        
        try(Socket socket = new Socket(host,puerto)){
            System.out.println("Cliente conectado al servidor");
            System.out.println("*****************************");
            BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner entradaTeclado = new Scanner(System.in);
            
            String mensaje;
            do{
                System.out.println("Escribe el texto a convertir");
                mensaje = entradaTeclado.nextLine();
                escritor.write(mensaje);
                escritor.newLine();
                escritor.flush();
                
                if (!mensaje.equalsIgnoreCase("salir")) {
                    String respuesta = lector.readLine();
                    System.out.println("Respuesta del servidor: " + respuesta);
                }
            }
            while(!mensaje.equalsIgnoreCase("salir"));
        }
        catch(IOException ioe){
            System.out.println("Error en el cliente: " + ioe.getMessage());
        }
    }
}
