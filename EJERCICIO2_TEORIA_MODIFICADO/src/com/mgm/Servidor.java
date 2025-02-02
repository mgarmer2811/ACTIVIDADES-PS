package com.mgm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int puerto = 50050;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor en funcionamiento");
            System.out.println("Esperando clientes");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado");
                new ClienteHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}