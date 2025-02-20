/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario14
 */
public class Comensal {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost",50050);
            BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));

            Scanner teclado = new Scanner(System.in);
            String pedido = teclado.nextLine();
            writer.write(pedido);
            
            for(int i = 0; i < 3; i++){
                System.out.println(reader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
