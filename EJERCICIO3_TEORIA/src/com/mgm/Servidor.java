/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

/**
 *
 * @author Usuario
 */
public class Servidor {
    public static void main(String[] args) {
        int puerto = 50050;
        
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor iniciado");
            System.out.println("*****************");
            System.out.println("Esperando cliente...");
            
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            String recibido = "";
            boolean salir = false;
            
            do{
                recibido = br.readLine();
                if(!recibido.equalsIgnoreCase("salir")){
                    String[] partes = recibido.strip().split(" ");
                    String operando1 = partes[0];
                    String operacion = partes[1];
                    String operando2 = partes[2];
                    
                    switch(operacion){
                        
                        case "+":{
                            float suma = Float.parseFloat(operando1) + Float.parseFloat(operando2);
                            bw.write("El resultado de la suma es: " + suma);
                            bw.newLine();
                            bw.flush();
                            break;
                        }
                        case "-":{
                            float resta = Float.parseFloat(operando1) - Float.parseFloat(operando2);
                            bw.write("El resultado de la resta es: " + resta);
                            bw.newLine();
                            bw.flush();
                            break;
                        }
                        case "*":{
                            float multiplicacion = Float.parseFloat(operando1) * Float.parseFloat(operando2);
                            bw.write("El resultado de la multiplicacion es: " + multiplicacion);
                            bw.newLine();
                            bw.flush();
                            break;
                        }
                        case "/":{
                            if(Float.parseFloat(operando2) == 0){
                                bw.write("No se puede dividir entre 0 campeon");
                                bw.newLine();
                                bw.flush();
                            }
                            else{
                                float division = Float.parseFloat(operando1) / Float.parseFloat(operando2);
                                bw.write("El resultado de la division es: " + division);
                                bw.newLine();
                                bw.flush();
                            }
                            break;
                        }
                        default:{
                            bw.write("Operacion no valida");
                            bw.newLine();
                            bw.flush();
                        }
                    }
                }
                else{
                    salir = true;
                }
                
            }while(!salir);
            System.out.println("El cliente ha salido del programa");
        }
        catch(Exception e){
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
