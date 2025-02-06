/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Usuario14
 */
public class Servidor {
    public static void main(String[] args) {
        int puerto = 50050;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor en funcionamiento");
            System.out.println("Esperando clientes");
            new ClienteHandler(socket).start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
