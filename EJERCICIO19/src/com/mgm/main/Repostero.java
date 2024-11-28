package com.mgm.main;

import java.util.Random;

public class Repostero extends Thread {
    private final Pasteleria pasteleria;
    private final String[] ingredientes = {"harina", "azucar", "huevos"};
    private final Random random = new Random();

    public Repostero(Pasteleria pasteleria) {
        this.pasteleria = pasteleria;
    }

    @Override
    public void run() {
        while (true) {
            int ixIngrediente1 = random.nextInt(3);
            int ixIngrediente2;
            do {
                ixIngrediente2 = random.nextInt(3);
            } while (ixIngrediente1 == ixIngrediente2);
            
            String ingredienteFaltante = ingredientes[3 - ixIngrediente1 - ixIngrediente2];
            System.out.println("Repostero: Me falta " + ingredienteFaltante);
            pasteleria.pedirIngrediente(ingredienteFaltante);
            System.out.println("Repostero: Preparando el bizcocho...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Error mientras se preparaba el bizcocho");
            }
            System.out.println("Repostero: ¡Bizcocho terminado!");
        }
    }
}
