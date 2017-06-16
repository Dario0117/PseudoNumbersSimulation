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
    public static double generarExponencial(double num_aleatorio, double lambda) {
        double result = -(1 / lambda) * Math.log(num_aleatorio);
        return result;
    }

    /*
        lambda = el porcentaje de ocurrencia
        num_aleatorio = numero aleatorio generado y validado
     */
    public static boolean generarBernoulli(double num_aleatorio, double lambda) {
        if (num_aleatorio <= lambda) {
            return true;
        }
        return false;
    }

    public static double generarMultinomial(String variable, int[] values) {
        switch(variable){
            case "pan":
                return panes(values[0], values[1], values[2], values[3]);
            case "bebida":
                return bebidas(values[0], values[1], values[2], values[3], values[4]);
            case "edad":
                return edades(values[0], values[1], values[2], values[3], values[4]);
        }
        return 0;
    }

    private static double panes(int P300, int P600, int P1200, int P2000) {
        double[] pro = {0.1084,0.6966,0.1641,0.0310};
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
    
    private static double bebidas(int avena, int refresco, int gaseosa, int natural, int agua_y_otro) {
        double[] pro = {0.2164,0.0351,0.5029,0.0468,0.1988};
        int n = avena + refresco + gaseosa + natural + agua_y_otro;
//        System.out.println("N: "+n);
        long factorial = factorial(n);
//        System.out.println("Factorial: "+factorial);
        long factorial2 = factorial(avena)*factorial(refresco)*factorial(gaseosa)*factorial(natural)*factorial(agua_y_otro);
//        System.out.println("Sumatoria de factoriales: "+factorial2);
        double producto = Math.pow(pro[0], avena)*Math.pow(pro[1], refresco)*Math.pow(pro[2], gaseosa)*Math.pow(pro[3], natural)*Math.pow(pro[4], agua_y_otro);
//        System.out.println("Producto: "+producto);
        double dist = (double)factorial / (double)factorial2;
//        System.out.println("Dist: "+dist);
        return dist*producto;
    }
    
    private static double edades(int r1, int r2, int r3, int r4, int r5) {
        double[] pro = {0.0144,0.0692,0.5130,0.1499,0.2536};
        int n = r1 + r2 + r3 + r4 + r5;
//        System.out.println("N: "+n);
        long factorial = factorial(n);
//        System.out.println("Factorial: "+factorial);
        long factorial2 = factorial(r1)*factorial(r2)*factorial(r3)*factorial(r4)*factorial(r5);
//        System.out.println("Sumatoria de factoriales: "+factorial2);
        double producto = Math.pow(pro[0], r1)*Math.pow(pro[1], r2)*Math.pow(pro[2], r3)*Math.pow(pro[3], r4)*Math.pow(pro[4], r5);
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
