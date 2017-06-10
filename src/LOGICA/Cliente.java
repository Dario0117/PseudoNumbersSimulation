/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.awt.Color;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Cliente {
    private int hora_llegada, 
                hora_espera,
                hora_salida,
                x=500,
                y=40,
                status=0;
    private Color color;
    private char sexo;
    private boolean pan,
                    bebida;
    
    public Cliente(){
        
    }

    public Cliente(int hora_llegada, int tiempo_espera, 
                        int tiempo_atencion, char sexo, 
                        boolean pan, boolean bebida) {
        this.hora_llegada = hora_llegada;
        this.hora_espera = tiempo_espera;
        this.hora_salida = tiempo_atencion;
        this.color = Color.RED;
        this.sexo = sexo;
        this.pan = pan;
        this.bebida = bebida;
    }

    public int getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(int hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public int getHora_espera() {
        return hora_espera;
    }

    public void setHora_espera(int hora_espera) {
        this.hora_espera = hora_espera;
    }

    public int getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(int hora_salida) {
        this.hora_salida = hora_salida;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean hasPan() {
        return pan;
    }

    public void setPan(boolean pan) {
        this.pan = pan;
    }

    public boolean hasBebida() {
        return bebida;
    }

    public void setBebida(boolean bebida) {
        this.bebida = bebida;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
