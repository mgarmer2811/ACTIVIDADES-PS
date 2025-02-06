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
import java.util.ArrayList;
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
    }
    
    @Override
    public void run(){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String recibido;
            boolean jugando = false;
            
            do{
                recibido = br.readLine();
                if(recibido.equalsIgnoreCase("COMENZAR")){
                    jugando = true;
                    String palabraSecreta = palabras[new Random().nextInt(11)];
                    
                    ArrayList<String> palabraCodificada = new ArrayList<>();
                    for(int i = 0; i < palabraSecreta.length(); i++){
                        palabraCodificada.add("_");
                    }
                    
                    bw.write("PALABRA_ELEGIDA");
                    bw.newLine();
                    bw.flush();
                    bw.write(String.join(" ",palabraCodificada));
                    bw.newLine();
                    bw.flush();
                    
                    boolean acertado = false;
                    int fallos = 0;
                    
                    do{
                        recibido = br.readLine();
                        boolean fallo = true;
                        if(recibido.length() == 1){
                            for(int i = 0; i < palabraSecreta.length(); i++){
                                if(Character.toString(palabraSecreta.charAt(i)).equalsIgnoreCase(recibido)){
                                    palabraCodificada.set(i, recibido);
                                    fallo = false;
                                }
                            }
                            if(fallo){
                                fallos++;
                                switch (fallos) {
                                    case 1: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 2: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|     |\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 3: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 4: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\\\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 5: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\\\n"
                                                + "|    /\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 6: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\\\n"
                                                + "|    / \\\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                }
                            }
                            else{
                                if(String.join("", palabraCodificada).equalsIgnoreCase(palabraSecreta)){
                                    acertado = true;
                                    continue;
                                    //////////////////////////////////////////////////////////
                                }
                                else{
                                    bw.write("ACIERTO " + fallos);
                                    bw.newLine();
                                    bw.flush();
                                    bw.write(String.join(" ", palabraCodificada));
                                    bw.newLine();
                                    bw.flush();
                                }
                            }
                        }
                        else{
                            if(!recibido.equalsIgnoreCase(palabraSecreta)){
                                fallos++;
                                switch (fallos) {
                                    case 1: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 2: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|     |\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 3: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 4: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\\\n"
                                                + "|\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 5: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\\\n"
                                                + "|    /\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                    case 6: {
                                        bw.write("FALLO" + fallos);
                                        bw.newLine();
                                        bw.flush();
                                        bw.write("------|\n"
                                                + "|     O\n"
                                                + "|    /|\\\n"
                                                + "|    / \\\n"
                                                + "|\n"
                                                + "=======");
                                        bw.newLine();
                                        bw.flush();
                                        bw.write(String.join(" ", palabraCodificada));
                                        bw.newLine();
                                        bw.flush();
                                        break;
                                    }
                                }
                            }
                            else{
                                acertado = true;
                                continue;
                            }
                        }
                    }
                    while((!acertado) && fallos < 6);
                    
                    if(acertado){
                        bw.write("COMPLETADO " + fallos);
                        bw.newLine();
                        bw.flush();
                        bw.write(String.join("",palabraCodificada));
                        bw.newLine();
                        bw.flush();
                    }
                    else{
                        bw.write("DERROTA " + fallos);
                        bw.newLine();
                        bw.flush();
                        bw.write(String.join("",palabraCodificada));
                        bw.newLine();
                        bw.flush();
                        recibido = br.readLine();
                        if(recibido.equalsIgnoreCase("SALIR")){
                            jugando = false;
                        }
                    }
                }
            }
            while(jugando);
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
