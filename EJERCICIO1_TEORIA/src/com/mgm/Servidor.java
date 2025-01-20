/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
        
/**
 *
 * @author Usuario14
 */
public class Servidor {
    public static void main(String[] args) {
        int puerto = 5039;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado. Esperando cliente...");
            System.out.println("***************************************");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado!");
            System.out.println("");
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String mensaje;
            String mensajeMayus;
            do {
                mensaje = entrada.readLine();
                mensajeMayus = mensaje.toUpperCase();
                salida.write(mensajeMayus);
                salida.newLine();
                salida.flush();
                System.out.println("Cliente: " + mensaje);
                System.out.println("Enviado: " + mensajeMayus);
            } while (!mensaje.equalsIgnoreCase("salir"));

            System.out.println("Cliente desconectado");
        }
        catch(IOException ioe){
            System.out.println("Error en el servidor: " + ioe.getMessage());
        }
    }
}
