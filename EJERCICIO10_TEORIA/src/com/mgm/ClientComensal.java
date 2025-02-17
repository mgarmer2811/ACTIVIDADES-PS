/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.net.*;

/**
 *
 * @author Usuario14
 */
public class ClientComensal extends Thread{
    private static int numCliente = 0;
    
    public ClientComensal(){
        numCliente++;
    }
    
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50050;
        
        try(Socket socket = new Socket(host,puerto)){
            System.out.println("Cliente conectado");
            System.out.println("*****************");
            
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
