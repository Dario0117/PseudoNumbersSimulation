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
        // TODO code application logic here
        //                      x, a, c, m, tipo
        NumberGenerator.Generar(1, 7, 5, 999983, 1);
        System.out.println(NumberGenerator.validarNumeros());
//        for(Float numb: NumberGenerator.getInternList())
//            System.out.println(numb);
    }
    
}
