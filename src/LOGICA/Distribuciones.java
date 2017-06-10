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

    public static double generarMultinomial(String variable, int[] values) {
        switch(variable){
            case "pan":
                return panes(values[0], values[1], values[2], values[3]);
            case "bebida":
                break;
            case "edad":
                break;
        }
        return 0;
    }

    private static double panes(int P300, int P600, int P1200, int P2000) {
        double[] pro = {0.1,0.5,0.3,0.1};
        int n = P300 + P600 + P1200 + P2000;
//        System.out.println("N: "+n);
        long factorial = factorial(n);
//        System.out.println("Factorial: "+factorial);
        long factorial2 = factorial(P300)*factorial(P600)*factorial(P1200)*factorial(P2000);
//        System.out.println("Sumatoria de factoriales: "+factorial2);
        double producto = Math.pow(pro[0], P300)*Math.pow(pro[1], P600)*Math.pow(pro[2], P1200)*Math.pow(pro[3], P2000);
//        System.out.println("Producto: "+producto);
        double dist = (double)factorial / (double)factorial2;
//        System.out.println("Dist: "+dist);
        return dist*producto;
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
