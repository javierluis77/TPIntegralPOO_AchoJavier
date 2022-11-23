/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class EmpleadosTest {
    
    public EmpleadosTest() {
    }

    
    @Test
    public void testCalcularEdad() {
        System.out.println("calcularEdad");
        Date fechaNac = new Date(2000,1,1);
        Empleados instance = new Empleados();
        int expResult = 22;
        int result = instance.calcularEdad(fechaNac);
        assertEquals(expResult, result);
     
    }

    
}
