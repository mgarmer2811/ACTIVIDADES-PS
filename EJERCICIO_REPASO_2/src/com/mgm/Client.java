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
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Client {
    public static void main(String[] args) {
        int puerto = 50050;
        String direccion = "localhost";

        try (Socket socket = new Socket(direccion, puerto)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            String enviado = "";
            String recibido = "";
            do{
               enviado = scanner.nextLine().toUpperCase();
               writer.write(enviado);
               writer.newLine();writer.flush();
               
               if(enviado.isBlank()){
                   continue;
               }
               
               if(enviado.contains("DADOS")){
                   recibido = reader.readLine();
                   String[] resultadoDados = recibido.split("#")[1].split(" ");
                   System.out.println(Arrays.toString(resultadoDados));
               }
               else{
                   recibido = reader.readLine().split("#")[1];
                   System.out.println(recibido);
               }
               
            }while(!enviado.isBlank());
            
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
