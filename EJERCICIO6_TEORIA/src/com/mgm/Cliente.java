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
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 50050;

        try (Socket socket = new Socket(host, puerto)) {
            System.out.println("Cliente conectado al servidor");
            System.out.println("*****************************");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            String enviado;
            String recibido;
            String codigo;
            String palabraCodificada;
            int numFallos;
            boolean seguimosJugando = true;
            
            do {
                bw.write("COMENZAR");
                bw.newLine();
                bw.flush();

                recibido = br.readLine();
                if (recibido.equalsIgnoreCase("PALABRA_ELEGIDA")) {
                    boolean jugando = true;

                    recibido = br.readLine();
                    System.out.println(recibido);

                    do {
                        enviado = scanner.nextLine();
                        bw.write(enviado);
                        bw.newLine();
                        bw.flush();

                        recibido = "";
                        palabraCodificada = "";
                        codigo = "";
                        numFallos = 0;

                        recibido = br.readLine();
                        String[] partes = recibido.split(" ");
                        codigo = partes[0];
                        numFallos = Integer.parseInt(partes[1]);

                        if (codigo.equalsIgnoreCase("COMPLETADO") || codigo.equalsIgnoreCase("DERROTA")) {
                            if(codigo.equalsIgnoreCase("DERROTA")){
                                System.out.println("------|\n"
                                        + "|     O\n"
                                        + "|    /|\\\n"
                                        + "|    / \\\n"
                                        + "|\n"
                                        + "=======");
                            }
                            System.out.println(codigo.equalsIgnoreCase("COMPLETADO") ? "HAS GANADO!!" : "HAS PERDIDO!!");
                            recibido = br.readLine();
                            System.out.println(recibido);
                            System.out.println("Quieres volver a jugar? Si='Si'  No='SALIR'");
                            enviado = scanner.nextLine();
                            jugando = false;
                            
                            if (!enviado.equalsIgnoreCase("SI")) {
                                bw.write("SALIR");
                                bw.newLine();
                                bw.flush();
                                seguimosJugando = false;
                            }
                        } else if (codigo.equalsIgnoreCase("FALLO")) {
                            System.out.println(recibido);
                            switch (numFallos) {
                                case 1: {
                                    System.out.println("------|\n"
                                            + "|     O\n"
                                            + "|\n"
                                            + "|\n"
                                            + "|\n"
                                            + "=======");
                                    break;
                                }
                                case 2: {
                                    System.out.println("------|\n"
                                            + "|     O\n"
                                            + "|     |\n"
                                            + "|\n"
                                            + "|\n"
                                            + "=======");
                                    break;
                                }
                                case 3: {
                                    System.out.println("------|\n"
                                            + "|     O\n"
                                            + "|    /|\n"
                                            + "|\n"
                                            + "|\n"
                                            + "=======");
                                    break;
                                }
                                case 4: {
                                    System.out.println("------|\n"
                                            + "|     O\n"
                                            + "|    /|\\\n"
                                            + "|\n"
                                            + "|\n"
                                            + "=======");
                                    break;
                                }
                                case 5: {
                                    System.out.println("------|\n"
                                            + "|     O\n"
                                            + "|    /|\\\n"
                                            + "|    /\n"
                                            + "|\n"
                                            + "=======");
                                    break;
                                }
                            }
                            recibido = br.readLine();
                            System.out.println(recibido);
                        } else if (codigo.equalsIgnoreCase("ACIERTO")) {
                            System.out.println(recibido);
                            recibido = br.readLine();
                            System.out.println(recibido);
                        }
                    } while (jugando);
                } else {
                    System.err.println("Se ha producido un error");
                }
            } while (seguimosJugando);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
