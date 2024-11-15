/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Comedero {
    private static int comidaConsumida;
    
    public Comedero() {
        comidaConsumida = 0;
    }
    
    public static synchronized void consumirComida() {
        comidaConsumida++;
    }
    
    public int getComidaConsumida() {
        return comidaConsumida;
    }
}
