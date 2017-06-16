/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Cliente_anim {
    private final int edad;
    private final int minuto_llegada, 
                    minuto_atencion,
                    minuto_salida;
    private int status = 0;
    private Color color = Color.RED;
    private final char sexo;
    private final ArrayList<String> pan,
                                    bebida;

    public Cliente_anim(int hora_llegada, int hora_atencion, 
                        int hora_salida, char sexo, int edad, ArrayList<String> pan, 
                        ArrayList<String> bebida) {
        
        this.minuto_llegada = hora_llegada;
        this.minuto_atencion = hora_atencion;
        this.minuto_salida = hora_salida;
        this.sexo = sexo;
        this.pan = pan;
        this.bebida = bebida;
        this.edad = edad;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public int getMinuto_llegada() {
        return minuto_llegada;
    }

    public int getMinuto_atencion() {
        return minuto_atencion;
    }

    public double getMinuto_salida() {
        return minuto_salida;
    }

    public char getSexo() {
        return sexo;
    }

    public ArrayList<String> getPan() {
        return pan;
    }

    public ArrayList<String> getBebida() {
        return bebida;
    }

    @Override
    public String toString() {
        return "Cliente_anim{" + "edad=" + edad + ", minuto_llegada=" + minuto_llegada + ", minuto_atencion=" + minuto_atencion + ", minuto_salida=" + minuto_salida + ", sexo=" + sexo + ", pan=" + pan + ", bebida=" + bebida + '}';
    }
    
}
