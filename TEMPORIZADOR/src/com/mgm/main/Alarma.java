/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Alarma extends Thread{
    private int numSegundos;
    private int intervalo;
    
    public Alarma(int numSegundos, int intervalo) {
        super();
        this.numSegundos = numSegundos;
        this.intervalo = intervalo;
    }
    
    @Override
    public void run() {
        numSegundos = intervalo;
        while(true){
            try{
                Thread.sleep(intervalo * 1000);
                System.out.println("Alarma! Han pasado " + numSegundos + " segundos");
                numSegundos += intervalo;
            }
            catch(InterruptedException e){}
        }
    }
}
