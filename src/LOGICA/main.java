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
        NumberGenerator.Generar(1, 7, 5, 999983, 1);
        System.out.println(NumberGenerator.validarNumeros());
//        for(Float numb: NumberGenerator.getInternList())
//            System.out.println(numb);
    }
    
}
