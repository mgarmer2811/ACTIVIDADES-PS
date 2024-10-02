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
        int a,b;
        a = 5;
        b = 2;
        
//        try{
//            System.out.println(a+"/"+b+"="+a/b);
//            b=0;
//            System.out.println(a+"/"+b+"="+a/b);
//            b=3;
//            System.out.println(a+"/"+b+"="+a/b);
//        }
//        catch(ArithmeticException ex){
//          System.err.println("No se puede dividir entre 0");
//        }
//        finally{
//            System.out.println("Esto se ejecuta por cojones");
//        }

        divide(a,b);
        b = 0;
        divide(a,b);
        b = 3;
        divide(a,b);
    }
    
    public static void divide(int num1, int num2){
        try{
            System.out.println("a / b = " + num1 / num2 );
        }
        catch(ArithmeticException ae){
            System.out.println("No se puede dividir entre 0");
        }
    }
    
}
