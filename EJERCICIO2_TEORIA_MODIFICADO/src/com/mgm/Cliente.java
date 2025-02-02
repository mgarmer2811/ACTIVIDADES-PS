package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50050;
        String mensaje = "";
        String respuesta = "";

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Cliente conectado al servidor");
            System.out.println("*****************************");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Prueba un número:");
                mensaje = scanner.nextLine();
                bw.write(mensaje);
                bw.newLine();
                bw.flush();
                respuesta = br.readLine();

                if (respuesta.equalsIgnoreCase("GANADOR")) {
                    System.out.println("HAS GANADO!");
                } else {
                    System.out.println(respuesta);
                }
            } while (!respuesta.equalsIgnoreCase("GANADOR"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}