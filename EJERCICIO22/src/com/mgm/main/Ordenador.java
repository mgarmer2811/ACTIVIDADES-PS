/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Ordenador extends Thread{
    private String nombre;
    private int tiempo;
    private Impresora printer;
    
    public Ordenador(String nombre, int tiempo, Impresora printer) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.printer = printer;
    }
    
    public void print(){
        System.out.println(nombre + ": Ha enviado el documento");
        printer.print(nombre, tiempo);
    }
    
    @Override
    public void run(){
        print();
    }
}
