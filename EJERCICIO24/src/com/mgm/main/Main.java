/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class Main {
    private static final int MAXIMO_AFORO = 10;
    
    public static void main(String[] args) {
        Piscina piscina = new Piscina(MAXIMO_AFORO);
        Persona[] personas = new Persona[15];
        Random random = new Random();
        
        for(int i = 0; i < 15; i++){
            String name = "Persona " + (i + 1);
            int numBanios = random.nextInt(1,4);
            int tiempoBanio = random.nextInt(5,11);
            Persona persona = new Persona(name,numBanios,tiempoBanio,piscina);
            personas[i] = persona;
            persona.start();
        }
        
        for(int i = 0; i < 15; i++){
            try{
                personas[i].join();
            }
            catch(Exception e){}
        }
        System.out.println("SE HA TERMINADO EL DIA DE PISCINA");
    }
    
}
