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
    private ArrayList<String> tareas;

    public ListaTareas() {
        this.tareas = new ArrayList<>();
    }

    public synchronized void anadirTarea(String tarea) {
        tareas.add(tarea);
        notify();
    }

    public synchronized String obtenerTarea() throws InterruptedException {
        if (tareas.isEmpty()) {
            Thread.sleep(1);
            wait();

        }
        return tareas.removeFirst();
    }
}
