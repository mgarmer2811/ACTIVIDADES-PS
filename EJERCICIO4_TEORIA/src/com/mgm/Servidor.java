package com.mgm;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 50050;

        String[] palabras = {"casa", "sol", "luz", "agua", "vida", "paz", "amor", "árbol", "cielo", "flor"};

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado");
            System.out.println("*****************");
            System.out.println("Esperando cliente...");

            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            
            while (true) {
                String palabraSecreta = palabras[new Random().nextInt(palabras.length)];
                String[] palabraSecretaArr = palabraSecreta.split("");
                List<String> letrasGuiones = new ArrayList<>();
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    letrasGuiones.add("_");
                }

                System.out.println("Jugando con la palabra: " + palabraSecreta);

                int letrasAcierto = 0;
                while (letrasAcierto < palabraSecreta.length()) {
                    bw.write("Palabra: " + String.join(" ", letrasGuiones) + "\nIntroduce una letra o palabra completa: ");
                    bw.newLine();
                    bw.flush();

                    String recibido = br.readLine();

                    if (recibido.equalsIgnoreCase(palabraSecreta)) {
                        letrasGuiones.clear();
                        for (String letra : palabraSecretaArr) {
                            letrasGuiones.add(letra);
                        }
                        letrasAcierto = palabraSecreta.length();
                        break;
                    }

                    if (recibido.length() == 1) {
                        char letra = recibido.charAt(0);
                        for (int i = 0; i < palabraSecretaArr.length; i++) {
                            if (palabraSecretaArr[i].equalsIgnoreCase(String.valueOf(letra))) {
                                letrasGuiones.set(i, palabraSecretaArr[i]);
                                letrasAcierto++;
                            }
                        }
                    }
                }

                bw.write("¡Muy bien! Has acertado la palabra");
                bw.newLine();
                bw.flush();

                bw.write("Introduce 's' para volver a jugar o 'n' para salir");
                bw.newLine();
                bw.flush();

                String continuar = br.readLine();
                if (continuar == null || !continuar.equalsIgnoreCase("s")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
