/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Usuario14
 */
public class LeeFichero {
    public static void main(String[] args) {
        String fileName = "";
        String line = "";
        Scanner scanner = new Scanner(System.in);
        
        fileName = scanner.nextLine();
        
        try{
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(Exception e){
            System.exit(1);
        }
    }
}
