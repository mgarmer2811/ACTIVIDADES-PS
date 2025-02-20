/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario14
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 50050;
        ServerSocket server = new ServerSocket(puerto);
        Gestion gestion = new Gestion();
        BufferedReader reader;
        String tipo;
        
        while(true){
            Socket socket = server.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            tipo = reader.readLine();
            
            if(tipo.equalsIgnoreCase("RESTAURANTE")){
                gestion.setRestaurante(new Restaurante(socket,gestion));
            }
            else if(tipo.equalsIgnoreCase("COMENSAL")){
                gestion.addComensal(new Comensal(socket,gestion));
            }
        }
    }
}
