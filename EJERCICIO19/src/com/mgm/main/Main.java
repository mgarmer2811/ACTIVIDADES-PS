package com.mgm.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Pasteleria pasteleria = new Pasteleria();
        Lock lock = new ReentrantLock();

        Condition harinaCondition = lock.newCondition();
        Condition azucarCondition = lock.newCondition();
        Condition huevosCondition = lock.newCondition();

        Proveedor proveedorHarina = new Proveedor("harina", pasteleria, lock, harinaCondition);
        Proveedor proveedorAzucar = new Proveedor("azucar", pasteleria, lock, azucarCondition);
        Proveedor proveedorHuevos = new Proveedor("huevos", pasteleria, lock, huevosCondition);

        proveedorHarina.setDaemon(true);
        proveedorAzucar.setDaemon(true);
        proveedorHuevos.setDaemon(true);
        
        proveedorHarina.start();
        proveedorAzucar.start();
        proveedorHuevos.start();
        
        Repostero repostero = new Repostero(pasteleria);
        repostero.start();
    }
}
