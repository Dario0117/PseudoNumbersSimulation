/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.util.List;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class Distribuciones {

    public static double generarPoisson(double num_aleatorio, double lambda) {
        return 0;
    }

    /*
        lambda = media de cada variable aleatoria
        num_aleatorio = numero aleatorio generado y validado
     */
    public static double generarExponencial(double num_aleatorio, double lambda) {
        double result = -(1 / lambda) * Math.log(num_aleatorio);
        return result;
    }

    /*
        lambda = el porcentaje de ocurrencia
        num_aleatorio = numero aleatorio generado y validado
     */
    public static double generarBernoulli(double num_aleatorio, double lambda) {
        if (num_aleatorio <= lambda) {
            return 1;
        }
        return 0;
    }

    public static double generarMultinomial(String variable, List<Integer> values) {
        switch(variable){
            case "pan":
                return panes(values.get(0), values.get(1), values.get(2), values.get(3));
            case "bebida":
                break;
            case "edad":
                break;
        }
        return 0;
    }

    private static double panes(int P300, int P600, int P1200, int P2000) {
        int n = P300 + P600 + P1200 + P2000;
        long factorial = factorial(n);
        long factorial2 = factorial(P300)*factorial(P600)*factorial(P1200)*factorial(P2000);
        double dist = factorial / factorial2;
        return dist;
    }

    private static long factorial(int numero) {
        long factorial = 1;
        while (numero != 0) {
            factorial = factorial * numero;
            numero--;
        }
        return factorial;
    }
}
