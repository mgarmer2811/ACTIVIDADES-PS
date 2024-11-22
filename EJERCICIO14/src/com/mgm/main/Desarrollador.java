/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Desarrollador extends Thread{
    private ListaTareas listaTareas;
    private int nTareas;

    public Desarrollador(ListaTareas listaTareas, int nTareas) {
        super();
        this.listaTareas = listaTareas;
        this.nTareas = nTareas;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < nTareas; i++) {
                String tarea = listaTareas.obtenerTarea();
                System.out.println("D: " + tarea + " recibida");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
