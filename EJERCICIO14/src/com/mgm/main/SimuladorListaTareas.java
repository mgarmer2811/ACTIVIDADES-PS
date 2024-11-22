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
public class SimuladorListaTareas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nº de tareas para crear");
        int nTareas = sc.nextInt();
        
        ListaTareas listaTareas = new ListaTareas();
        Planificador planificador = new Planificador(listaTareas, nTareas);
        Desarrollador desarrollador = new Desarrollador(listaTareas, nTareas);
        
        planificador.start();
        desarrollador.start();
        try{
            desarrollador.join();
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error esperando");
        }
        
         System.out.println("Ya no quedan tareas por leer");
    }
    
}
