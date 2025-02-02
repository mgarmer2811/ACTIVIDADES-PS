package com.mgm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class ClienteHandler extends Thread {
    private Socket socket;
    private int numeroRandom;

    public ClienteHandler(Socket socket) {
        this.socket = socket;
        this.numeroRandom = new Random().nextInt(1, 101);
    }

    @Override
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje;
            int mensajeNumerico;

            do {
                mensaje = br.readLine();
                mensajeNumerico = Integer.parseInt(mensaje);

                if (mensajeNumerico == numeroRandom) {
                    bw.write("GANADOR");
                    bw.newLine();
                    bw.flush();
                } else if (mensajeNumerico > numeroRandom) {
                    bw.write("El número secreto es menor al que acabas de introducir");
                    bw.newLine();
                    bw.flush();
                } else {
                    bw.write("El número secreto es mayor al que acabas de introducir");
                    bw.newLine();
                    bw.flush();
                }
            } while (mensajeNumerico != numeroRandom);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}