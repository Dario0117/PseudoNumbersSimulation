/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import numbergenerator.NumberGenerator;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            De los números aleatorios, los primeros 100 van a ser para
            la cantidad de personas que llegan por corrida.
        */
        int corridas_inicio = 100;
        int tamaño_corridas = 110;
        
        NumberGenerator.Generar(1, 7, 5, 999983, 1);
        System.out.println(NumberGenerator.validarNumeros());
        for(int i=0;i<2;i++)
            System.out.println(NumberGenerator.getInternList().get(i));
        System.out.println("");
        System.out.println(Distribuciones.generarExponencial(8.9001514E-5, 12));
        
        
    }
    
}
