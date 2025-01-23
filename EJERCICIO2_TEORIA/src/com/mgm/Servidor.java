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
import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int puerto = 50050;
        int numeroRandom = new Random().nextInt(1,101);
        int mensajeNumerico = 0;
        String mensaje = "";
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor en funcionamiento");
            System.out.println("Esperando cliente");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado");
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            do{
                mensaje = br.readLine();
                mensajeNumerico = Integer.parseInt(mensaje);
                
                if(mensajeNumerico == numeroRandom){
                    bw.write("GANADOR");
                    bw.newLine();
                    bw.flush();
                }
                else if(mensajeNumerico > numeroRandom){
                    bw.write("El numero secreto es menor al que acabas de introducir");
                    bw.newLine();
                    bw.flush();
                }
                else{
                    bw.write("El numero secreto es mayor al que acabas de introducir");
                    bw.newLine();
                    bw.flush();
                }
            }
            while(mensajeNumerico != numeroRandom);
        }
        catch(Exception e){}
    }   
}
