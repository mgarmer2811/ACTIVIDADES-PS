/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSegundos,intervaloAlarma;
        System.out.println("Introduzca cuantos segundos va a durar el temporizador");
        numSegundos = scanner.nextInt();
        System.out.println("Introduzca cada cuento quiere que suene la alarma");
        intervaloAlarma = scanner.nextInt();
        
        Reloj reloj = new Reloj(numSegundos);
        Alarma alarma = new Alarma(numSegundos,intervaloAlarma);
        alarma.setDaemon(true);
        reloj.start();
        alarma.start();
    }
    
}
