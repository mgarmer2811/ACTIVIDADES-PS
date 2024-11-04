/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

/**
 *
 * @author Usuario14
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RatonVarComp fievel = new RatonVarComp("Fievel",3000);
        RatonVarComp jerry = new RatonVarComp("Jerry",3000);
        RatonVarComp pinky = new RatonVarComp("Pinky",3000);
        RatonVarComp mickey = new RatonVarComp("Mickey",3000);
        
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
        
        try{
            fievel.join();
            jerry.join();
            pinky.join();
            mickey.join();
        }
        catch(InterruptedException ie){
            System.err.println("Ha ocurrido un error esperando a alguno de los hilos");
        }
        System.out.println("Comida consumida: " + RatonVarComp.getComidaConsumida());
    }
}
