/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class ClientHandler extends Thread{
    private Socket socket;
    
    public ClientHandler(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String recibido= "";
            Random random = new Random();
            
            do{
                recibido = reader.readLine();
                if(recibido == null){
                    continue;
                }
                
                if(recibido.contains("DADOS")){
                    String[] partes = recibido.split("#",3);
                    int numDados = Integer.parseInt(partes[1]);
                    int numCaras = Integer.parseInt(partes[2]);
                    
                    int[] resultados = new int[numDados];
                    for(int i = 0; i < resultados.length; i++){
                        resultados[i] = random.nextInt(1,numCaras + 1);
                    }
                    writer.write("RESULTADO#" + Arrays.toString(resultados));
                    writer.newLine();writer.flush();
                }
                else{
                    int numCaras = Integer.parseInt(recibido.split("#")[1]);
                    int resultado = random.nextInt(1,numCaras + 1);
                    writer.write("RESULTADO#" + String.valueOf(resultado));
                    writer.newLine();writer.flush();
                }
            }while(recibido != null);
            
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
