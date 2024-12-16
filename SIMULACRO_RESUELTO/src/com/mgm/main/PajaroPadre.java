/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;

/**
 *
 * @author Usuario14
 */
public class PajaroPadre extends Thread{
    private Nido nido;
    
    public PajaroPadre(Nido nido){
        super();
        this.nido = nido;
    }
    
    @Override
    public void run(){
        while(true){
            nido.esperandoPajarillo();
            nido.ponerGusanos(new Random().nextInt(4,8));
        }
    }
}
