package com.mgm;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50050;

        try (Socket socket = new Socket(host, puerto)) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            String recibido;
            String enviado;

            while (true) {
                recibido = br.readLine();
                if (recibido == null) {
                    break;
                }
                System.out.println(recibido);

                if (recibido.equalsIgnoreCase("Introduce 's' para volver a jugar o 'n' para salir")) {
                    enviado = scanner.nextLine();
                    bw.write(enviado);
                    bw.newLine();
                    bw.flush();

                    if (!enviado.equalsIgnoreCase("s")) {
                        break;
                    }
                }
                else if (!recibido.equalsIgnoreCase("¡Muy bien! Has acertado la palabra")){
                    System.out.println("Introduce una letra o palabra");
                    enviado = scanner.nextLine();
                    bw.write(enviado);
                    bw.newLine();
                    bw.flush();
                }
            }

        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
