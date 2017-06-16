/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Esteban Dario Barboza Primera
 */
public class DistribucionesIT {
    
    public DistribucionesIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generarPoisson method, of class Distribuciones.
     */
    @Test
    public void testGenerarPoisson() {
//        System.out.println("generarPoisson");
//        double num_aleatorio = 0.0;
//        double lambda = 0.0;
//        double expResult = 0.0;
//        double result = Distribuciones.generarPoisson(num_aleatorio, lambda);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of generarExponencial method, of class Distribuciones.
     */
    @Test
    public void testGenerarExponencial() {
        System.out.println("generarExponencial");
        assertEquals(0.216212239, 
                Distribuciones.generarExponencial(0.142857142, 9), 
                0.0005
        );
    }

    /**
     * Test of generarBinomial method, of class Distribuciones.
     */
    @Test
    public void testGenerarBernoulli() {
        System.out.println("generarBernoulli");
        double prob = 0.6513;
        assertEquals(true, Distribuciones.generarBernoulli(0.05, prob));
        assertEquals(false, Distribuciones.generarBernoulli(0.66, prob));
        assertEquals(true, Distribuciones.generarBernoulli(0.6, prob));
        assertEquals(true, Distribuciones.generarBernoulli(0.35, prob));
        assertEquals(true, Distribuciones.generarBernoulli(0.15, prob));
    }

    /**
     * Test of generarMultinomial method, of class Distribuciones.
     */
    @Test
    public void testGenerarMultinomial() {
        System.out.println("generarMultinomial");
        int[][] values = {
            {0,0,0,0},
            {0,0,0,1},
            {0,0,1,0},
            {0,0,1,1},
            {0,1,0,0},
            {0,1,0,1},
            {0,1,1,0},
            {0,1,1,1},
            {1,0,0,0},
            {1,0,0,1},
            {1,0,1,0},
            {1,0,1,1},
            {1,1,0,0},
            {1,1,0,1},
            {1,1,1,0},
            {1,1,1,1},
        };
        
        int[][] values2 = {
            {0,0,0,0,0},
            {0,0,0,0,1},
            {0,0,0,1,0},
            {0,0,0,1,1},
            {0,0,1,0,0},
            {0,0,1,0,1},
            {0,0,1,1,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {0,1,0,0,1},
            {0,1,0,1,0},
            {0,1,0,1,1},
            {0,1,1,0,0},
            {0,1,1,0,1},
            {0,1,1,1,0},
            {0,1,1,1,1},
            {1,0,0,0,0},
            {1,0,0,0,1},
            {1,0,0,1,0},
            {1,0,0,1,1},
            {1,0,1,0,0},
            {1,0,1,0,1},
            {1,0,1,1,0},
            {1,0,1,1,1},
            {1,1,0,0,0},
            {1,1,0,0,1},
            {1,1,0,1,0},
            {1,1,0,1,1},
            {1,1,1,0,0},
            {1,1,1,0,1},
            {1,1,1,1,0},
            {1,1,1,1,1},
        };
        
        int[][] values3 = {
            {0,0,0,0,1},
            {0,0,0,1,0},
            {0,0,1,0,0},
            {0,1,0,0,0},
            {1,0,0,0,0},
        };
        
        System.out.println("---PANES---");
        for(int i=0;i<16;i++){
            String val = "";
            for(Integer n:values[i]) val += n+",";
            System.out.printf("%s	%f%n",val,Distribuciones.generarMultinomial("pan", values[i]));
        }
        System.out.println("---EDADES---");
        for(int i=0;i<5;i++){
            String val = "";
            for(Integer n:values3[i]) val += n+",";
            System.out.printf("%s	%f%n",val,Distribuciones.generarMultinomial("edad", values3[i]));
        }
        System.out.println("---BEBIDAS---");
        for(int i=0;i<32;i++){
            String val = "";
            for(Integer n:values2[i]) val += n+",";
            System.out.printf("%s	%f%n",val,Distribuciones.generarMultinomial("bebida", values2[i]));
        }
    }
}
