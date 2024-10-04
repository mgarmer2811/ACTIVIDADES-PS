/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mgm.main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class FiltroParImpar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String option;
        ArrayList <Integer> numbers = new ArrayList<>();
        ArrayList <Integer> aux = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        if((args.length == 0) || (args.length > 1)){
            System.out.println("");
            System.out.println("No se ha recibido ningun parametro, por favor escoja un parametro la proxima vez");
            System.exit(1);
        }else if((!args[0].equalsIgnoreCase("p")) && (!args[0].equalsIgnoreCase("i"))){
            System.out.println("");
            System.out.println("El parametro introducido no esta admitido en el programa, por favor escoja un parametro valido la proxima vez");
            System.exit(2);
        }
        else{
            option = args[0];
            boolean finished = false;
            System.out.println("");
            System.out.println("Introduzca numeros y pulse enter (introduzca 0 para terminar la introduccion de datos)");
            
            while(!finished){
                int number = scanner.nextInt();
                if(number == 0){
                    finished = true;
                }
                else{
                    numbers.add(number);
                }
            }
            
            switch(option){
                case "p":
                {
                   filterOddEven(numbers, aux, 1);
                   break;
                }
                case "i":
                {
                    filterOddEven(numbers, aux, 2);
                    break;
                }
            }
        }
    }
    
    public static void filterOddEven(ArrayList<Integer> numbers,ArrayList<Integer> aux,int option) {
        switch(option){
            case 1:
            {
                for(Integer number : numbers){
                    if((number % 2) == 0){
                        aux.add(number);
                    }
                }
                System.out.println("");
                System.out.println(aux.toString());
                break;
            }
            case 2:
            {
                for(Integer number : numbers){
                    if((number % 2) != 0){
                        aux.add(number);
                    }
                }
                System.out.println("");
                System.out.println(aux.toString());
                break;
            }
            default:
            {
                System.err.println("Ha habido un error en el procesado de los numeros (Error en parametro de llamada a la funcion)");
            }
        }
    }
    
}
