/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int puerto = 50050;
        ClientRestaurante restaurante;
        
        BufferedReader br;
        
        try(ServerSocket server = new ServerSocket(puerto)){
            System.out.println("Servidor en funcionamiento");
            while(true){
                Socket socket = server.accept();
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                String recibido = br.readLine();
                if (recibido.equalsIgnoreCase("RESTAURANTE")){
                    
                }
                else{
                    new ClientComensal();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
