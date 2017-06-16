/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.util.ArrayList;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Cliente_anim {
    private final int edad=0;
    private final double hora_llegada, 
                         hora_atencion,
                         hora_salida;
    private final char sexo;
    private final ArrayList<String> pan,
                                    bebida;

    public Cliente_anim(double hora_llegada, double hora_atencion, 
                        double hora_salida, char sexo, ArrayList<String> pan, 
                        ArrayList<String> bebida) {
        
        this.hora_llegada = hora_llegada;
        this.hora_atencion = hora_atencion;
        this.hora_salida = hora_salida;
        this.sexo = sexo;
        this.pan = pan;
        this.bebida = bebida;
    }

    public int getEdad() {
        return edad;
    }

    public double getHora_llegada() {
        return hora_llegada;
    }

    public double getHora_atencion() {
        return hora_atencion;
    }

    public double getHora_salida() {
        return hora_salida;
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
    
    
}
