/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario14
 */
public class Copisteria {
    private final Lock lock = new ReentrantLock();
    
    public Copisteria(){}
    
    public void print(String nombreOrdenador, int tiempoImpresion){
        lock.lock();
        try{
            try{
                System.out.println(nombreOrdenador + ": ha comenzado a imprimir");
                Thread.sleep(tiempoImpresion * 1000);
                System.out.println(nombreOrdenador + ": ha terminado de imprimir");
            }
            catch(InterruptedException iei){
                System.err.println("Se ha producido un error mientras se imprimia");
            }
        }
        finally{
            lock.unlock();
        }
    }
}
    
    /*
    
    {private final Condition impresoraDisponible = lock.newCondition();
    private int impresorasDisponibles}
    public void print(String nombreOrdenador, int tiempoImpresion){
        lock.lock();
        try{
            while (impresorasDisponibles < 1) {
                System.out.println("Esperando impresora");
                impresoraDisponible.await();
            }
            impresorasDisponibles -= 1; // Dejos las impresoras disponibles a 0
            try{
                System.out.println(nombreOrdenador + ": ha comenzado a imprimir");
                Thread.sleep(tiempoImpresion * 1000);
                System.out.println(nombreOrdenador + ": ha terminado de imprimir");
            }
            catch(InterruptedException iei){
                System.err.println("Se ha producido un error mientras se imprimia");
            }
            impresorasDisponibles += 1;
            impresoraDisponible.signalAll();
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error esperando por la impresora");
        }
        finally{
            lock.unlock();
        }
    }
    */
