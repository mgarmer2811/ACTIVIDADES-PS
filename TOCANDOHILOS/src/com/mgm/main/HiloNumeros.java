/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class HiloNumeros extends Thread{
    private boolean corriendo = true;
    private String nombre;
    private int condicion;
    
    public HiloNumeros(String nombre, int condicion) {
        super(nombre);
        this.nombre = nombre;
        this.condicion = condicion;
    }
    
    public void detener() {
        corriendo = false;
    }
    
    @Override
    public void run() {
        int i = 1;
        while(i <= 90){
            System.out.println(nombre + ": " + i);
            if((!corriendo) && ((i % condicion) == 0)){
                break;
            }
            i++;
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){}
        }
    }
}
