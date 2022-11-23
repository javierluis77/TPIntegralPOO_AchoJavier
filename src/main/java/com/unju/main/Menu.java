/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unju.main;

import controlador.EmpleadosJpaController;
import controlador.ProyectosJpaController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Empleados;
import modelo.Proyectos;

/**
 *
 * @author Lenovo
 * se utilizo el patron observer en la clase Empleados y proyectos
 */
public class Menu {

    public static EmpleadosJpaController emp = new EmpleadosJpaController();
    public static ProyectosJpaController pro = new ProyectosJpaController();
    public static Empleados empleado = new Empleados();
    public static Proyectos proyecto = new Proyectos();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {

        int opcion = 0;

        while (opcion != 3) {

            String lectura = JOptionPane.showInputDialog("****Menu Principal****"
                    + "\n 1- Empleados"
                    + "\n 2- Proyectos"
                    + "\n 3- Salir"
                    + "\n Elige una opcion:");

            try {
                opcion = Integer.parseInt(lectura);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una opcion del menu");

                menuPrincipal();

            }
            switch (opcion) {
                case 1:
                    menuEmpleados();
                    break;
                case 2:
                    menuProyectos();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debe ingresar una opcion del menu");

                    break;

            }
        }
    }

    public static void menuEmpleados() {

        int opcion = 0;
        //boolean banderaEmp = false;

        while (opcion != 8) {

            String lectura = JOptionPane.showInputDialog("****Menu Empleados****"
                    + "\n 1- Agregar empleado"
                    + "\n 2- Eliminar empleado"
                    + "\n 3- Modificar empleado"
                    + "\n 4- Listar empleado"
                    + "\n 5- Mostrar empleado de mayor edad"
                    + "\n 6- Listar empleados que superen a un determinado sueldo básico ingresado"
                    + "\n 7- Buscar empleado por DNI o por apellido"
                    + "\n 8- Volver al menú principal"
                    + "\n Elige una opcion:");

            try {
                opcion = Integer.parseInt(lectura);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una opcion del menu");
                menuEmpleados();

            }
            switch (opcion) {
                case 1:

                    try {
                        empleado.crearEmpleado();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error:" + ex);

                    }

//                    try {
//                         empleado.crearEmpleado();
//                    } catch (NumberFormatException ex) {
//                        
//                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor númericos en );
//
//                    } 
//                    catch () {
//
//                    } catch () {
//
//                    }
                    break;
                case 2:

                    try {
                        int cuit;

                        cuit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese CUIT del empleado que desea eliminar:"));
                        empleado.eliminarEmpleado(cuit);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor númerico,sin espacios en blanco");
                        menuEmpleados();

                    }

                    break;
                case 3:
                    try {
                        empleado.modificarEmpleado();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erroe:" + ex);

                    }

                    break;
                case 4:

                    empleado.mostrarEmpleados();

                    break;
                case 5:

                    empleado.mayorEdad();

                    break;
                case 6:

                    try {
                        float suelBasico = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un sueldo basico:"));
                        empleado.sueldoBasico(suelBasico);

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor númerico");

                    }

                    break;
                case 7:

                    empleado.buscarEmpleado();

                    break;
                case 8:
                    menuPrincipal();
                    break;
                default:

                    JOptionPane.showMessageDialog(null, "Debe ingresar una opción del menú");

                    break;

            }
        }
    }

    public static void menuProyectos() {
        int opcion = 0;

        while (opcion != 10) {
            String lectura = JOptionPane.showInputDialog("****Menu Proyectos****"
                    + "\n 1- Agregar proyecto"
                    + "\n 2- Eliminar proyecto"
                    + "\n 3- Listar proyectos"
                    + "\n 4- Agregar empleado a un proyecto"
                    + "\n 5- Quitar empleado de un proyecto"
                    + "\n 6- Listar datos de un proyecto"
                    + "\n 7- Calcular el total de montos destinados a proyectos"
                    + "\n 8- Calcular el monto que recibe cada participante de un proyecto"
                    + "\n 9- Listar proyectos por rangos de fechas"
                    + "\n 10- Volver al menú principal"
                    + "\n Elige una opcion:");

            try {
                opcion = Integer.parseInt(lectura);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una opcion del menu");
                menuProyectos();
            }
            switch (opcion) {
                case 1:
                    try {
                        proyecto.crearProyecto();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error:" + ex);

                    }

                    break;
                case 2:

                    try {
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese CUIT:"));

                        proyecto.eliminarProyecto(codigo);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor númerico");
                        menuProyectos();
                    }

                    break;
                case 3:

                    proyecto.mostrarProyecto();

                    break;
                case 4:
                    //Agrega un empleado a un proyecto

                    try {
                        int cod;
                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del proyecto para agregar un empleado:"));
                        proyecto = pro.findProyectos(cod);
                        if (proyecto != null) {
                            int legajo = Integer.parseInt(JOptionPane.showInputDialog("ingrese Nro de Legajo del empleado:"));

                            if (emp.findEmpleados(legajo) != null) {
                                if (proyecto.comprobarIntegrante(legajo)) {
                                    proyecto.addObserver(emp.findEmpleados(legajo));
                                    try {
                                        String integrante = proyecto.getIntegrantes() + "" + legajo;
                                        proyecto.setIntegrantes(integrante);
                                        pro.edit(proyecto);
                                    } catch (Exception ex) {
                                        System.out.println("Error: " + ex.getMessage());
                                    }
                                } else {

                                    JOptionPane.showMessageDialog(null, "El empleado ya pertenece a un proyecto");

                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "No existe un empleado con ese Nro de legajo");

                            }
                        } else {

                            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese codigo");

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor númerico");

                    }

                    break;

                case 5:

                    try {
                        int cod;
                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo del proyecto para quitar empleado:"));
                        proyecto = pro.findProyectos(cod);
                        if (proyecto != null) {
                            int legajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nro de legajo del empleado: "));

                            if (emp.findEmpleados(legajo) != null) {
                                proyecto.deleteObserver(emp.findEmpleados(legajo));
                                try {
                                    String integrante = proyecto.getIntegrantes();
                                    String quitado = proyecto.quitarIntegrantes(integrante, legajo);
                                    proyecto.setIntegrantes(quitado);
                                    pro.edit(proyecto);
                                } catch (Exception ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No existe un empleado con ese Nro de legajo");

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese codigo");

                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar una valor númerico");

                    }

                    break;
                case 6:
                    try {
                        proyecto.listarProyecto();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error:" + e);

                    }

                case 7:
                    JOptionPane.showMessageDialog(null, "El monto total para los proyectos es de: " + proyecto.calcularMontoTotal());

                    break;
                case 8:

                    try {
                        int cod;

                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo del proyecto:"));

                        proyecto = pro.findProyectos(cod);
                        if (proyecto != null) {
                            String cantIntegrantes[] = proyecto.getIntegrantes().split("");
                            List lista = new ArrayList();
                            lista = Arrays.asList(cantIntegrantes);
                            if (lista.get(0) != "") {
                                float montoindividual = proyecto.calcularMontoIndividual(lista.size(), proyecto.getMonto());
                                JOptionPane.showMessageDialog(null, "El monto por empleado del proyecto " + proyecto.getNomProyecto() + " es de " + montoindividual);

                            } else {
                                JOptionPane.showMessageDialog(null, "El proyecto no tiene integrantes");

                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese codigo");

                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico");

                    }

                    break;
                case 9:

                    try {
                        JOptionPane.showMessageDialog(null, "Ingrese la fecha de inicio");
                        int dia;
                        int mes;
                        int anio;

                        dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia:"));

                        mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes:"));
                        anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio:"));

                        Date fechaInicio = new Date(dia, mes, anio);
                        JOptionPane.showMessageDialog(null, "fechaInicio: " + fechaInicio);

                        JOptionPane.showMessageDialog(null, "Ingrese la fecha de finalización");

                        dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia:"));

                        mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes:"));
                        anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio:"));

                        Date fechaFinal = new Date(dia, mes, anio);
                        JOptionPane.showMessageDialog(null, "fechaInicio: " + fechaFinal);

                        proyecto.comparaFecha(fechaInicio, fechaFinal);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar valores númericos");

                    }

                    break;
                case 10:
                    menuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Debe ingresar una opción del menú");

                    break;

            }
        }
    }

}
