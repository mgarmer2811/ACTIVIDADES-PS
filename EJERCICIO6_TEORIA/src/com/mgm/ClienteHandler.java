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
import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class ClienteHandler extends Thread{
    private Socket socket;
    private String palabraRandom;
    private final String[] palabras = {"gato", "sol", "mesa", "luz", "rojo", "flor", "casa", "perro", "nube", "agua"};
    
    public ClienteHandler(Socket socket){
        this.socket = socket;
        this.palabraRandom = palabras[new Random().nextInt(11)];
    }
    
    @Override
    public void run(){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje;
            int mensajeNumerico;
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
