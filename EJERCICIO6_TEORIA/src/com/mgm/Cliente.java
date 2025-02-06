/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
 * @author Usuario14
 */
public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50050;
        
        try(Socket socket = new Socket(host,puerto)){
            System.out.println("Cliente conectado al servidor");
            System.out.println("*****************************");
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            String enviado;
            String recibido;
            String lineas;
            
            enviado = scanner.nextLine();
            bw.write(enviado);
            bw.newLine();
            bw.flush();
            
            recibido = br.readLine();
            if(recibido.equalsIgnoreCase("PALABRA_ELEGIDA")){
                boolean jugando = true;
                
                recibido = br.readLine();
                System.out.println(recibido);
                
                do{
                    enviado = scanner.nextLine();
                    bw.write(enviado);
                    bw.newLine();
                    bw.flush();
                    
                    recibido = "";
                    lineas = "";
                    
                    while((recibido = br.readLine()) != null){
                        lineas += recibido + "\n";
                    }
                    System.out.println(lineas);
                    if(lineas.contains("COMPLETADO") || lineas.contains("DERROTA")){
                        System.out.println("Quieres volver a jugar? Si='Si'  No='SALIR'");
                        enviado = scanner.nextLine();
                        
                        if(enviado.equalsIgnoreCase("SALIR")){
                            bw.write(enviado);
                            bw.newLine();
                            bw.flush();
                            jugando = false;
                        }
                    }
                }
                while(jugando);
            }
            else{
                System.out.println("Entrada no valida, escribe 'Comenzar' para empezar!!");
            }
            System.out.println("Has salido del juego!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
