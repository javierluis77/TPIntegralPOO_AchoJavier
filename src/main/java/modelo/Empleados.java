/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static com.unju.main.Menu.emp;
import static com.unju.main.Menu.menuEmpleados;
import static com.unju.main.Menu.pro;
import controlador.EmpleadosJpaController;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "empleados", catalog = "bd_tp_integral_poo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByNroLegajo", query = "SELECT e FROM Empleados e WHERE e.nroLegajo = :nroLegajo")
    , @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleados.findByCuit", query = "SELECT e FROM Empleados e WHERE e.cuit = :cuit")
    , @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleados.findBySueldoBasico", query = "SELECT e FROM Empleados e WHERE e.sueldoBasico = :sueldoBasico")})

//Este clase es el observador a la clase Proyectos
public class Empleados implements Observer, Serializable {

    public static Scanner scanner = new Scanner(System.in);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nro_legajo", nullable = false)
    private Integer nroLegajo;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cuit", nullable = false)
    private int cuit;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sueldo_basico", nullable = false)
    private float sueldoBasico;

    public Empleados() {
    }

    public Empleados(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public Empleados(Integer nroLegajo, String apellido, String nombre, int cuit, Date fechaNacimiento, float sueldoBasico) {
        this.nroLegajo = nroLegajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cuit = cuit;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoBasico = sueldoBasico;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuit() {
        return cuit;
    }

    public void setDni(int dni) {
        this.cuit = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroLegajo != null ? nroLegajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.nroLegajo == null && other.nroLegajo != null) || (this.nroLegajo != null && !this.nroLegajo.equals(other.nroLegajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ nroLegajo=" + nroLegajo + " ]";
    }

    public void crearEmpleado() {
        int nro_legajo;
        int cuit;
        int dia;
        int mes;
        int anio;
        float sueldo;
        String nombre;
        String apellido;
        String nombreResul;
        String apellidoResul;

        try {
            nro_legajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nº de Legajo:"));
            cuit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese CUIT:"));

            dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia:"));

            mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes:"));
            anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio:"));

            sueldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el sueldo basico"));

            if (emp.findEmpleados(nro_legajo) == null) {
                nombre = JOptionPane.showInputDialog("Ingrese Nombre:");
                apellido = JOptionPane.showInputDialog("Ingrese Apellido:");
//                nombreResul = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase().replace(" ", "");
//                apellidoResul = apellido.toUpperCase().charAt(0) + apellido.substring(1, apellido.length()).toLowerCase().replace(" ", "");

                if (nombre.matches(" ") || apellido.matches(" ")) {
                    JOptionPane.showMessageDialog(null, "los campos nombre y apellido no deben estar vacios ");

                } else {
                    if (nombre.matches("[A-Z].*") || apellido.matches("[A-Z].*") || nombre.matches("[a-z].*") || apellido.matches("[a-z].*")) {

                        Date fecha = new Date(anio, mes, dia);
                        Empleados nuevoEmpleado = new Empleados(nro_legajo, apellido, nombre, cuit, fecha, sueldo);
                        try {
                            emp.create(nuevoEmpleado);
                        } catch (Exception e) {
                            System.out.println("Error: " + e);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "los campos nombre y apellido deben contener solamente letras ");

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe empleado con este numero de legajo");

                menuEmpleados();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar solamente valores númericos en los campos:"
                    + "\n *Nro de legajo"
                    + "\n *Cuit"
                    + "\n *dia"
                    + "\n *mes"
                    + "\n *anio"
                    + "\n *sueldo");
            menuEmpleados();

        }

    }

    public void eliminarEmpleado(int cuit) {

        boolean igual = false;
        int numLegajo = -1;
        Empleados empleado = new Empleados();

        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            numLegajo = listaEmpleados.get(i).getNroLegajo();
            if (cuit == listaEmpleados.get(i).getCuit()) {
                igual = true;

            }
        }
        if (igual == true) {
            try {
                emp.destroy(numLegajo);
                JOptionPane.showMessageDialog(null, "Eliminado con exito");
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "error:"+e);

            }
        }
    }

    public int calcularEdad(Date fechaNac) {
        int dia = fechaNac.getDate();
        int mes = fechaNac.getMonth();
        int anio = fechaNac.getYear();
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);
        return periodo.getYears();
    }

    public void mostrarEmpleados() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        //JOptionPane.showMessageDialog(null, listaVe );

        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("+                                      Lista de Empleados                        +");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   CUIT    | Fecha de nacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");

        for (int i = 0; i < listaEmpleados.size(); i++) {
            int dia = listaEmpleados.get(i).getFechaNacimiento().getDate();
            int mes = listaEmpleados.get(i).getFechaNacimiento().getMonth();
            int anio = listaEmpleados.get(i).getFechaNacimiento().getYear();
            String fecha = dia + "-" + mes + "-" + anio;
            System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                    listaEmpleados.get(i).getNroLegajo(),
                    listaEmpleados.get(i).getApellido(),
                    listaEmpleados.get(i).getNombre(),
                    listaEmpleados.get(i).getCuit(),
                    fecha,
                    listaEmpleados.get(i).getSueldoBasico() + " |");
        }
        System.out.println("+--------------------------------------------------------------------------------+");

    }

    public void mayorEdad() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        Empleados empleado = new Empleados();
        int mayorEmp = 0;
        int edad = 0;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            edad = calcularEdad(listaEmpleados.get(i).getFechaNacimiento());
            if (mayorEmp < edad) {
                mayorEmp = edad;
                empleado = listaEmpleados.get(i);
            }
        }
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   CUIT    | Fecha de nacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        int dia = empleado.getFechaNacimiento().getDate();
        int mes = empleado.getFechaNacimiento().getMonth();
        int anio = empleado.getFechaNacimiento().getYear();
        String fecha = dia + "-" + mes + "-" + anio;
        System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                empleado.getNroLegajo(),
                empleado.getApellido(),
                empleado.getNombre(),
                empleado.getCuit(),
                fecha,
                empleado.getSueldoBasico() + " |");
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    public void sueldoBasico(float suelBasico) {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   CUIT    | Fecha de nacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (suelBasico < listaEmpleados.get(i).getSueldoBasico()) {
                int dia = listaEmpleados.get(i).getFechaNacimiento().getDate();
                int mes = listaEmpleados.get(i).getFechaNacimiento().getMonth();
                int anio = listaEmpleados.get(i).getFechaNacimiento().getYear();
                String fecha = dia + "-" + mes + "-" + anio;
                System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                        listaEmpleados.get(i).getNroLegajo(),
                        listaEmpleados.get(i).getApellido(),
                        listaEmpleados.get(i).getNombre(),
                        listaEmpleados.get(i).getCuit(),
                        fecha,
                        listaEmpleados.get(i).getSueldoBasico() + " |");
            }
        }
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    public void modificarEmpleado() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        Scanner scanner = new Scanner(System.in);
        Empleados empleado = new Empleados();
        System.out.println("Ingrese Nº_legajo del Empleado que desea modificar algun dato: ");
        int nro_legajo = scanner.nextInt();
        empleado = emp.findEmpleados(nro_legajo);
        int opcion = 0;
        System.out.println("+==================================+");
        System.out.println("+   1. Modificar Nombre            +");
        System.out.println("+   2. Modificar Apellido          +");
        System.out.println("+   3. Modificar DNI               +");
        System.out.println("+   4. Modificar fecha_nacimiento  +");
        System.out.println("+   Ingrese opcion                 +");
        System.out.println("+==================================+");
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            opcion = 0;
            System.out.println("Debe ingresar un numero");
        }
        switch (opcion) {
            case 1:
                System.out.println("Ingrese nuevo Nombre:");
                String nombre = scanner.next();
                empleado.setNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese nuevo Apellido:");
                String apellido = scanner.next();
                empleado.setApellido(apellido);
                break;
            case 3:
                System.out.println("Ingrese nuevo CUIT:");
                int DNI = scanner.nextInt();
                scanner.nextLine();
                empleado.setDni(DNI);
                break;
            case 4:
                System.out.println("Ingrese nueva Fecha de Nacimiento:");
                System.out.println("Dia: ");
                int dia = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Mes: ");
                int mes = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Año: ");
                int anio = scanner.nextInt();
                scanner.nextLine();
                Date fecha = new Date(anio, mes, dia);
                empleado.setFechaNacimiento(fecha);
            default:
                System.out.println("Opcion Incorrecta");
                break;
        }
        try {
            emp.edit(empleado);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void buscarEmpleado() {
        System.out.println("Ingrese CUIT del empleado que quiere Buscar:");
        int cuit = scanner.nextInt();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();

        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("+                                      Lista de Empleados                        +");
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   CUIT    | Fecha de nacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (cuit == listaEmpleados.get(i).getCuit()) {
                int dia = listaEmpleados.get(i).getFechaNacimiento().getDate();
                int mes = listaEmpleados.get(i).getFechaNacimiento().getMonth();
                int anio = listaEmpleados.get(i).getFechaNacimiento().getYear();
                String fecha = dia + "-" + mes + "-" + anio;
                System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s \n",
                        listaEmpleados.get(i).getNroLegajo(),
                        listaEmpleados.get(i).getApellido(),
                        listaEmpleados.get(i).getNombre(),
                        listaEmpleados.get(i).getCuit(),
                        fecha,
                        listaEmpleados.get(i).getSueldoBasico() + "     |");
            }
        }
        System.out.println("+--------------------------------------------------------------------------------+");
    }

    public void empleadosdeProyecto(List lista) {
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();

        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("|N° Legajo|    Apellido   |    Nombre      |   CUIT    | Fecha de nacimiento |  sueldo  |");
        System.out.println("+--------------------------------------------------------------------------------+");
        for (int i = 0; i < lista.size(); i++) {
            String pos = lista.get(i).toString();
            int poss = (Integer.valueOf(pos));
            for (int j = 0; j < listaEmpleados.size(); j++) {
                if (poss == listaEmpleados.get(j).getNroLegajo()) {
                    int dia = listaEmpleados.get(j).getFechaNacimiento().getDate();
                    int mes = listaEmpleados.get(j).getFechaNacimiento().getMonth();
                    int anio = listaEmpleados.get(j).getFechaNacimiento().getYear();
                    String fecha = dia + "-" + mes + "-" + anio;
                    System.out.printf("|   %-3s   | %-13s | %-14s | %-8s | %-13s | %-8s  \n",
                            listaEmpleados.get(j).getNroLegajo(),
                            listaEmpleados.get(j).getApellido(),
                            listaEmpleados.get(j).getNombre(),
                            listaEmpleados.get(j).getCuit(),
                            fecha,
                            listaEmpleados.get(j).getSueldoBasico() + " |");
                }
            }

        }
        System.out.println("+--------------------------------------------------------------------------------+");

    }

    //se utilizo en patron observer 
    @Override
    public void update(Observable o, Object o1) {
        System.out.println("Se comunica que el proyecto " + ((Proyectos) o).getNomProyecto() + " tiene un nuevo integrante");
        String cantIntegrantes[] = ((Proyectos) o).getIntegrantes().split("");
        List lista = new ArrayList();
        lista = Arrays.asList(cantIntegrantes);
        empleadosdeProyecto(lista);
    }
}
