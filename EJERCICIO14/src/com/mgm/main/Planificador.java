/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Planificador extends Thread{
    private ListaTareas listaTareas;
    private int nTareas;

    public Planificador(ListaTareas listaTareas, int nTareas) {
        super();
        this.listaTareas = listaTareas;
        this.nTareas = nTareas;
    }
    
    @Override
    public void run(){
        for(int i=0; i < nTareas; i++){
            String tarea = "Tarea " + i;
            listaTareas.anadirTarea(tarea);
            System.out.println("P: " + tarea + " añadida");
        }
    }
}
