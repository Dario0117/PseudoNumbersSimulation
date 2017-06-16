/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import GUI.Principal;
import javax.swing.UnsupportedLookAndFeelException;
import numbergenerator.NumberGenerator;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class main {
    
    public static int[] longitud_corrida ={
        112,121,114,116,121,113,119,121,117,116,
        116,119,114,120,114,118,112,121,115,121,
        116,113,116,122,120,121,117,120,115,120,
        115,115,116,114,121,112,115,122,116,115,
        121,118,118,122,122,118,122,121,113,116,
        120,116,115,117,122,114,117,121,114,116,
        113,121,122,118,119,112,120,118,118,120,
        122,118,117,114,120,122,119,122,120,120,
        119,120,115,113,122,119,121,115,115,119,
        112,114,121,117,118,121,114,114,118,115
    };
    
    public static String[] rango_edades = {
        "--",
        "0-10",
        "11-15",
        "16-25",
        "26-35",
        "36+"
    };
    
    public static Corrida[] corridas = new Corrida[100];
    
    public static int cabecera_aleatorios = 100;
    public static int cantidad_corridas = 50;
    
    public static final double promedio_llegada = 0.47;
    public static final double promedio_atencion = 2.87;
    public static final double promedio_salida = 3.92;
    public static final double probabilidad_hombre = 0.6513;
    
    
    public static void main(String[] args) {
        
        NumberGenerator.Generar(1, 7, 5, 99991, 1);
        for(int i=0;i<50;i++){
            corridas[i] = new Corrida(longitud_corrida[i]);
        }
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        new Principal().setVisible(true);
    }
    
}
