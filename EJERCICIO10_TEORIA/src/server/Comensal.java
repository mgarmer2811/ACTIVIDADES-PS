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
public class Comensal extends Thread{
    private Socket socket;
    private Gestion gestion;
    private int idPedido;
    
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public Comensal(Socket socket, Gestion gestion) throws IOException{
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
    
    @Override
    public void run(){
        try{
            String line = reader.readLine();
            if(line.startsWith("NUEVO")){
                idPedido = gestion.nuevoPedido(this,line.split("#",2)[1]);
                sendMessage("CONFIRMACION#" + idPedido);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
