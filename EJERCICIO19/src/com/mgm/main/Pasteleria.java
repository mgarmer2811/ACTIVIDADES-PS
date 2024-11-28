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
public class Pasteleria {
    private final Lock lock = new ReentrantLock();
    private final Random random = new Random();
    private final Condition harinaCondition = lock.newCondition();
    private final Condition azucarCondition = lock.newCondition();
    private final Condition huevosCondition = lock.newCondition();
    private boolean harinaDisponible = false;
    private boolean azucarDisponible = false;
    private boolean huevosDisponible = false;
    
    public Pasteleria(){}
    
    public void pedirIngrediente(String ingrediente){
        lock.lock();
        try{
            Condition condition = null;
            boolean disponible = false;
            
            switch(ingrediente){
                case "harina":{
                    condition = harinaCondition;
                    harinaDisponible = false;
                    break;
                }
                case "azucar":{
                    condition = azucarCondition;
                    azucarDisponible = false;
                    break;
                }
                case "huevos":{
                    condition = huevosCondition;
                    huevosDisponible = false;
                    break;
                }
            }
            System.out.println("Repostero: Necesito " + ingrediente);
            condition.signal(); // Notificamos al proveedor correspondiente
            
            while(!esIngredienteDisponible(ingrediente)){
                condition.await();
            }
            System.out.println("Repostero: Recibi el ingrediente");
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error esperando la harina");
        }
        finally{
            lock.unlock();
        }
    }
    
    public void entregarIngrediente(String ingrediente){
        lock.lock();
        try{
            int tiempo = random.nextInt(2,5);
            Thread.sleep(tiempo * 1000);
            
            switch(ingrediente){
                case "harina":{
                    harinaDisponible = true;
                    harinaCondition.signal();
                    break;
                }
                case "azucar":{
                    azucarDisponible = true;
                    azucarCondition.signal();
                    break;
                }
                case "huevos":{
                    azucarDisponible = true;
                    azucarCondition.signal();
                    break;
                }
            }
            System.out.println("Proveedor: Ya he entregado " + ingrediente);
        }
        catch(InterruptedException ie){
            System.err.println("Se ha producido un error entregando el ingrediente");
        }
        finally{
            lock.unlock();
        }
    }
    
    private boolean esIngredienteDisponible(String ingrediente) {
        switch (ingrediente) {
            case "harina":
                return harinaDisponible;
            case "azúcar":
                return azucarDisponible;
            case "huevos":
                return huevosDisponible;
            default:
                return false;
        }
    }
}
