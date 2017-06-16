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
public class Cliente {
    private int edad=0;
    private double tiempo_llegada, 
                   tiempo_espera,
                   tiempo_salida;
    private char sexo;
    private ArrayList<String> pan,
                              bebida;
    
    public Cliente(){
        
    }

    public Cliente(double hora_llegada, double tiempo_espera, 
                   double tiempo_atencion, char sexo, 
                   double pan, double bebida, double edad) {
        
        this.tiempo_llegada = hora_llegada;
        this.tiempo_espera = tiempo_espera;
        this.tiempo_salida = tiempo_atencion;
        this.sexo = sexo;
        this.pan = generarPanes(pan);
        this.bebida = generarBebidas(bebida);
        this.edad = generarEdad(edad);
    }
    
    private int generarEdad(double num){
        if(num <= 0.0144){
            return 1;
        }else if (num > 0.0144 && num <= 0.0692){
            return 2;
        }else if(num > 0.0692 && num <= 0.1499){
            return 4;
        }else if (num > 0.1499 && num <= 0.2536){
            return 5;
        }else{
            return 3;
        }
    }
    
    private ArrayList<String> generarPanes(double num){
        ArrayList<String> panes = new ArrayList<>();
        if(num <= 0.003309){
            panes.add("P300");
            panes.add("P1200");
            panes.add("P2000");
        }else if(num > 0.003309 && num <= 0.006721){
            panes.add("P300");
            panes.add("P2000");
        }else if(num > 0.006721 && num <= 0.009219){
            panes.add("P300");
            panes.add("P600");
            panes.add("P1200");
            panes.add("P2000");
        }else if(num > 0.009219 && num <= 0.010174){
            panes.add("P1200");
            panes.add("P2000");
        }else if(num > 0.010174 && num <= 0.014045){
            panes.add("P300");
            panes.add("P600");
            panes.add("P2000");
        }else if(num > 0.014045 && num <= 0.021262){
            panes.add("P600");
            panes.add("P1200");
            panes.add("P2000");
        }else if(num > 0.021262 && num <= 0.031){
            panes.add("P2000");
        }else if(num > 0.031 && num <= 0.035577){
            panes.add("P300");
            panes.add("P2000");
        }else if(num > 0.035577 && num <= 0.043189){
            panes.add("P600");
            panes.add("P2000");
        }else if(num > 0.043189 && num <= 0.074349){
            panes.add("P300");
            panes.add("P600");
            panes.add("P1200");
        }else if(num > 0.074349 && num <= 0.1084){
            panes.add("P300");
        }else if(num > 0.1084 && num <= 0.151023){
            panes.add("P300");
            panes.add("P600");
        }else if(num > 0.151023 && num <= 0.1641){
            panes.add("P1200");
        }else if(num > 0.1641 && num <= 0.228624){
            panes.add("P600");
            panes.add("P1200");
        }else if(num > 0.228624 && num <= 0.6966){
            panes.add("P600");
        }
        return panes;
    }
    
    private ArrayList<String> generarBebidas(double num){
        ArrayList<String> bebidas = new ArrayList<>();
        if(num <= 0.001696){
            bebidas.add("REFRESCO");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
            bebidas.add("AVENA");
        }else if(num > 0.001696 && num <= 0.001959){
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.001959 && num <= 0.002133){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
            bebidas.add("NATURAL");
        }else if(num > 0.002133 && num <= 0.003285){
            bebidas.add("REFRESCO");
            bebidas.add("NATURAL");
        }else if(num > 0.003285 && num <= 0.003942){
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.003942 && num <= 0.004265){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.004265 && num <= 0.00429){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
        }else if(num > 0.00429 && num <= 0.004957){
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
        }else if(num > 0.004957 && num <= 0.00906){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.00906 && num <= 0.01208){
            bebidas.add("AVENA");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.01208 && num <= 0.013956){
            bebidas.add("REFRESCO");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.013956 && num <= 0.015191){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
        }else if(num > 0.015191 && num <= 0.018225){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("AGUA U OTROS");
        }else if(num > 0.018225 && num <= 0.018608){
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.018608 && num <= 0.020255){
            bebidas.add("AVENA");
            bebidas.add("NATURAL");
        }else if(num > 0.020255 && num <= 0.021055){
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.021055 && num <= 0.022919){
            bebidas.add("AVENA");
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
        }else if(num > 0.022919 && num <= 0.0243){
            bebidas.add("AVENA");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.0243 && num <= 0.028073){
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.028073 && num <= 0.030559){
            bebidas.add("AVENA");
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
        }else if(num > 0.030559 && num <= 0.0351){
            bebidas.add("REFRESCO");
        }else if(num > 0.0351 && num <= 0.035304){
            bebidas.add("REFRESCO");
            bebidas.add("GASEOSA");
        }else if(num > 0.035304 && num <= 0.0468){
            bebidas.add("NATURAL");
        }else if(num > 0.0468 && num <= 0.047071){
            bebidas.add("GASEOSA");
            bebidas.add("NATURAL");
        }else if(num > 0.047071 && num <= 0.086041){
            bebidas.add("AVENA");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.086041 && num <= 0.12981){
            bebidas.add("AVENA");
            bebidas.add("GASEOSA");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.12981 && num <= 0.1988){
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.1988 && num <= 0.199953){
            bebidas.add("GASEOSA");
            bebidas.add("AGUA U OTRO");
        }else if(num > 0.199953 && num <= 0.2164){
            bebidas.add("AVENA");
        }else if(num > 0.2164 && num <= 0.217655){
            bebidas.add("AVENA");
            bebidas.add("GASEOSA");
        }else if(num > 0.217655 && num <= 0.5029){
            bebidas.add("GASEOSA");
        }
        return bebidas;
    }

    public double getTiempo_llegada() {
        return tiempo_llegada;
    }

    public void setTiempo_llegada(double tiempo_llegada) {
        this.tiempo_llegada = tiempo_llegada;
    }

    public double getTiempo_espera() {
        return tiempo_espera;
    }

    public void setTiempo_espera(double tiempo_espera) {
        this.tiempo_espera = tiempo_espera;
    }

    public double getTiempo_salida() {
        return tiempo_salida;
    }

    public void setTiempo_salida(double tiempo_salida) {
        this.tiempo_salida = tiempo_salida;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public ArrayList<String> getPan() {
        return pan;
    }

    public void setPan(ArrayList<String> pan) {
        this.pan = pan;
    }

    public ArrayList<String> getBebida() {
        return bebida;
    }

    public void setBebida(ArrayList<String> bebida) {
        this.bebida = bebida;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" + "edad=" + edad + ", hora_llegada=" + tiempo_llegada + ", hora_espera=" + tiempo_espera + ", hora_salida=" + tiempo_salida + ", sexo=" + sexo + ", pan=" + pan + ", bebida=" + bebida + '}';
    }
    
}