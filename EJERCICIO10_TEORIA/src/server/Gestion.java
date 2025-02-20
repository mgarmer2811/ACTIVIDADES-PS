/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Usuario14
 */
public class Gestion {
    private Restaurante restaurante;
    private ArrayList<Comensal> comensales;
    private static int numPedido = 0;
    private HashMap<Integer, Comensal> pedidos;
    
    public Gestion(){
        comensales = new ArrayList<>();
        pedidos = new HashMap<>();
    }
    
    public void setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
        restaurante.start();
    }
    
    public void addComensal(Comensal comensal){
        this.comensales.add(comensal);
        comensal.start();
    }
    
    public int nuevoPedido(Comensal comensal, String productos) throws IOException{
        restaurante.nuevoPedido(numPedido,productos);
        pedidos.put(numPedido, comensal);
        return numPedido++;
    }
    
    public void actualizaPedido(int pedido, String estado) throws IOException{
        Comensal comensal = pedidos.get(pedido);
        comensal.sendMessage("ACTUALIZACION#" + estado);
    }
}
