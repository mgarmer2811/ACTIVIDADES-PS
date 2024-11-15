/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.ArrayList;

/**
 *
 * @author Usuario14
 */
public class ListaTareas {
    private static ArrayList<String> tareas;
    
    public ListaTareas() {
        this.tareas = new ArrayList<>();
    }
    
    public static void anadirTarea(String tarea) {
        tareas.add(tarea);
    }
    
    public static String obtenerTarea(int posicion) {
        String tarea = tareas.getFirst();
        return tarea;
    }
}
