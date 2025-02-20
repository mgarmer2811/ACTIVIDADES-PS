/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Usuario14
 */
public class Restaurante extends Thread{
    private Socket socket;
    private Gestion gestion;
    
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public Restaurante(Socket socket,Gestion gestion) throws IOException{
        this.socket = socket;
        this.gestion = gestion;
        
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    
    public void sendMessage(String message) throws IOException{
        writer.write(message);
        writer.newLine();
        writer.flush();
    }
    
    public void nuevoPedido(int numPedido, String productos) throws IOException{
        sendMessage("NUEVO#" + numPedido + "#" + productos);
    }
    
    @Override
    public void run(){
        while(true){
            try{
                String line = reader.readLine();
                String[] parts = line.split("#");
                gestion.actualizaPedido(Integer.parseInt(parts[1]),parts[0]);
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
