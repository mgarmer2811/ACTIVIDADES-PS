/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Planificador {
    
    public static void crearTareas(int numeroTareas) {
        for(int i = 1; i <= numeroTareas; i++){
            String tarea = "Tarea" + i;
            ListaTareas.anadirTarea(tarea);
            System.out.println("P: " + tarea + " añadida");
        }
    }
}
