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
public class Main extends Thread{

    public static void main(String[] args) {
        String numeros;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduzca numeros separados por espacio");
        numeros = scanner.nextLine();
        String[] nums = numeros.split(" ");
        
        for(String num : nums){
            new VerificaParidad(Integer.parseInt(num)).start();
        }
    }
}
