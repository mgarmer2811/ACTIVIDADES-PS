/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int puerto = 50050;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            
            System.out.println("Esperando cliente");
            while(true){
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado");
                new ClientHandler(socketCliente).start();
            }
            
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
