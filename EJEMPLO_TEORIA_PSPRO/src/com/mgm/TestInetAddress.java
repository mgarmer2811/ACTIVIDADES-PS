/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mgm;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Usuario14
 */
public class TestInetAddress {
    private static void metodos(InetAddress dir){
        System.out.println("\t Metodo getByName(): " + dir);
        try{
            InetAddress dir2 = InetAddress.getLocalHost();
            System.out.println("\t Metodo getLocalHost(): " + dir2);
        }
        catch(UnknownHostException e){
            e.printStackTrace();
        }
        
        System.out.println("\t Metodo getHostName(): " + dir.getHostName());
        System.out.println("\t Metodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\t Metodo toString(): " + dir.toString());
        System.out.println("\t Metodo getCannonicalHostName(): " + dir.getCanonicalHostName());
        
        try{
            System.out.println("\t Direcciones Ip para: " + dir.getHostName());
            InetAddress[] direccionesIp = InetAddress.getAllByName(dir.getHostName());
            for(InetAddress dirIp : direccionesIp){
                System.out.println("\t\t" + dirIp.toString());
            }
        }
        catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        InetAddress dir = null;
        try{
            System.out.println("Salida para localhost");
            dir = InetAddress.getByName("localhost");
            metodos(dir);
            System.out.println("-------------------------");
            System.out.println("Salida para la url");
            dir = InetAddress.getByName("www.google.es");
            metodos(dir);
        }
        catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
}
