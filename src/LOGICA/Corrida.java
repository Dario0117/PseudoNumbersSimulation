/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.util.ArrayList;

/**
 *
 * @author Consejo Ing.Software
 */
public class Corrida {
    private int longitud;
    private ArrayList<Cliente> clientes;

    public Corrida(int longitud) {
        this.longitud = longitud;
        this.clientes = new ArrayList<>();
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
