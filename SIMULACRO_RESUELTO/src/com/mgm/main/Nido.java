/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm.main;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario14
 */
public class Nido {
    private int numGusanos;
    private Lock lock;
    private Condition suficientesGusanos;
    private Condition reponerGusanos;
    
    public Nido(int numGusanos){
        this.numGusanos = numGusanos;
        this.lock = new ReentrantLock(true);
        this.suficientesGusanos = lock.newCondition();
        this.reponerGusanos = lock.newCondition();
    }
    
    public void comerUnGusano(int idPajarillo){
        try{
            lock.lock();
            while(numGusanos <= 0){
                reponerGusanos.signal();
                System.out.println("El pajarillo " + idPajarillo + " ha llamado al padre");
                suficientesGusanos.await();
            }
            numGusanos--;
            System.out.println("Pajarillo " + idPajarillo + " ha comido un gusano. Cantidad restante: " + numGusanos);
            lock.unlock(); // asi mientras uno come el resto puede empezar a comer tmb
            Thread.sleep(new Random().nextInt(1000,2001));
        }
        catch(InterruptedException ie){
            System.err.println(ie.getMessage());
        }
    }
    
    public void esperandoPajarillo(){
        lock.lock();
        try{
            System.out.println("El pajaro padre esta esperando a los pajarillos");
            reponerGusanos.await();
        }
        catch(InterruptedException ie){
            System.err.println(ie.getMessage());
        }
        finally{
            lock.unlock();
        }
    }
    
    public void ponerGusanos(int nuevosGusanos){
        lock.lock();
        try{
            System.out.println("El pajaro padre ha ido a buscar gusanos");
            numGusanos += nuevosGusanos;
            Thread.sleep(new Random().nextInt(2000,4001));
            System.out.println("El pajaro padre ha traido " + nuevosGusanos);
            suficientesGusanos.signalAll();
        }
        catch(InterruptedException ie){
            System.err.println(ie.getMessage());
        }
        finally{
            lock.unlock();
        }
    }
}
