/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.HashSet;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread.State state;
        RatonStates fievel = new RatonStates("Fievel",6000);
        HashSet<Thread.State> states = new HashSet<>();
        states.add(fievel.getState());
        fievel.start();
        
        while((state = fievel.getState()) != Thread.State.TERMINATED){
            states.add(state);
        }
        states.add(fievel.getState());
        System.out.println("Estados del hilo del raton Fievel:");
        for(Thread.State stateAux : states){
            System.out.println(stateAux);
        }
    }
}
