/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class ProyectosTest {

    public ProyectosTest() {
    }

    @Test
    public void testCalcularMontoIndividual() {
        System.out.println("calcularMontoIndividual");
        int integrantes = 3;
        float monto = 2000;
        Proyectos instance = new Proyectos();
        float expResult = 650;
        float result = instance.calcularMontoIndividual(integrantes, monto);
        assertEquals(expResult, result, 0.0);

    }

}
