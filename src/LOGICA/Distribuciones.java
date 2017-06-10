/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Distribuciones {

    /*
        lambda = media de cada variable aleatoria
        num_aleatorio = numero aleatorio generado y validado
     */
    public static double generarPoisson(double num_aleatorio, double lambda) {
        return 0;
    }

    public static double generarExponencial(double num_aleatorio, double lambda) {
        double result = -(1 / lambda) * Math.log(num_aleatorio);
        return result;
    }

    public static double generarBernoulli(double num_aleatorio, double lambda) {
        if (num_aleatorio <= lambda) {
            return 1;
        }
        return 0;
    }

    public static double generarMultinomial() {
        return 0;
    }
}
