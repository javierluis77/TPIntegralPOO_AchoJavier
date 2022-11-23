/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static com.unju.main.Menu.empleado;
import static com.unju.main.Menu.pro;
import static com.unju.main.Menu.proyecto;
import controlador.ProyectosJpaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Observable;
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
@Table(name = "proyectos", catalog = "bd_tp_integral_poo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findByCodigo", query = "SELECT p FROM Proyectos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proyectos.findByNomProyecto", query = "SELECT p FROM Proyectos p WHERE p.nomProyecto = :nomProyecto")
    , @NamedQuery(name = "Proyectos.findByFechaInicio", query = "SELECT p FROM Proyectos p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyectos.findByFechaFinalizacion", query = "SELECT p FROM Proyectos p WHERE p.fechaFinalizacion = :fechaFinalizacion")
    , @NamedQuery(name = "Proyectos.findByMonto", query = "SELECT p FROM Proyectos p WHERE p.monto = :monto")
    , @NamedQuery(name = "Poyectos.findByIntegrantes", query = "SELECT e FROM Proyectos e WHERE e.integrantes = :integrantes")})

//clase observada por la clase Empleados
public class Proyectos extends Observable implements Serializable {

    public static Scanner scanner = new Scanner(System.in);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nom_proyecto", nullable = false, length = 50)
    private String nomProyecto;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_finalizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private float monto;
    @Basic(optional = false)
    @Column(name = "integrantes", nullable = false, length = 50)
    private String integrantes;

    public Proyectos() {
    }

    public Proyectos(Integer codigo) {
        this.codigo = codigo;
    }

    public Proyectos(Integer codigo, String nomProyecto, Date fechaInicio, Date fechaFinalizacion, float monto, String integrantes) {
        this.codigo = codigo;
        this.nomProyecto = nomProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.monto = monto;
        this.integrantes = integrantes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getIntegrantes() {
        return integrantes;
    }

    // notifica a observador(Empleados) la que se hizo un cambio y se avisa a los  empleados
    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
        setChanged();
        notifyObservers();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectos[ codigo=" + codigo + " ]";
    }

    public void crearProyecto() {
        int cod, diaIn, mesIn, anioIn, diaFin, mesFin, anioFin;
        float monto;
        String nombre_proyecto, Integrantes;

        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo del Proyecto: "));

        if (pro.findProyectos(cod) == null) {
            nombre_proyecto = JOptionPane.showInputDialog("Ingrese Nombre del proyecto: ");

            JOptionPane.showMessageDialog(null, "Ingrese Fecha_inicio del proyecto: ");

            diaIn = Integer.parseInt(JOptionPane.showInputDialog("Dia"));

            mesIn = Integer.parseInt(JOptionPane.showInputDialog("Mes:"));
            anioIn = Integer.parseInt(JOptionPane.showInputDialog("Año:"));

            Date fechaInicio = new Date(anioIn, mesIn, diaIn);

            JOptionPane.showMessageDialog(null, "Ingrese Fecha_Finalizacion del proyecto: ");
            diaFin = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
            mesFin = Integer.parseInt(JOptionPane.showInputDialog("Mes:"));
            anioFin = Integer.parseInt(JOptionPane.showInputDialog("Año:"));

            Date fechaFinalizacion = new Date(anioFin, mesFin, diaFin);
            monto = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Monto Presupuestado:"));

            Proyectos nuevoProyecto = new Proyectos(cod, nombre_proyecto, fechaInicio, fechaFinalizacion, monto, "");
            try {
                pro.create(nuevoProyecto);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un proyecto con este codigo");

        }
    }

    public void eliminarProyecto(int codigo) {

        try {
            pro.destroy(codigo);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void listarProyecto() {
        System.out.println("Ingrese codigo del proyecto :");
        int cod = scanner.nextInt();
        proyecto = pro.findProyectos(cod);
        if (proyecto != null) {
            String cantIntegrantes[] = proyecto.getIntegrantes().split("");
            List lista = new ArrayList();
            lista = Arrays.asList(cantIntegrantes);
            empleado.empleadosdeProyecto(lista);
        } else {
            System.out.println("No existe un proyecto con ese codigo");
        }
    }

    public void mostrarProyecto() {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+                                      Lista de Proyectos                          +");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|Codigo|      Nombre     | fecha inicio |  fecha finalizacion |  monto  | codigo integrantes |");
        System.out.println("+----------------------------------------------------------------------------------+");
        for (int i = 0; i < listaProyectos.size(); i++) {
            int dia = listaProyectos.get(i).getFechaInicio().getDate();
            int mes = listaProyectos.get(i).getFechaInicio().getMonth();
            int anio = listaProyectos.get(i).getFechaInicio().getYear();
            String fechaI = dia + "-" + mes + "-" + anio;
            dia = listaProyectos.get(i).getFechaFinalizacion().getDate();
            mes = listaProyectos.get(i).getFechaFinalizacion().getMonth();
            anio = listaProyectos.get(i).getFechaFinalizacion().getYear();
            String fechaF = dia + "-" + mes + "-" + anio;
            System.out.printf("| %-4s | %-15s | %-9s | %-16s | %-7s | %-15s  \n",
                    listaProyectos.get(i).getCodigo(),
                    listaProyectos.get(i).getNomProyecto(),
                    fechaI,
                    fechaF,
                    listaProyectos.get(i).getMonto(),
                    listaProyectos.get(i).getIntegrantes() + " |");
        }
        System.out.println("+----------------------------------------------------------------------------------+");

    }

    public String quitarIntegrantes(String integrantes, int legajo) {
        int num = -1;
        String result = "";
        String legajoCad = String.valueOf(legajo);
        String cantIntegrantes[] = integrantes.split("");
        List lista = new ArrayList();
        lista = Arrays.asList(cantIntegrantes);
        for (int i = 0; i < lista.size(); i++) {
            String pos = lista.get(i).toString();
            if (pos.equals(legajoCad)) {
            } else {
                result = result + pos;
            }
        }
        return result;
    }

    public boolean comprobarIntegrante(int legajo) {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        String legajoCad = String.valueOf(legajo);
        boolean encontrado = true;

        for (int i = 0; i < listaProyectos.size(); i++) {
            String cantIntegrantes[] = listaProyectos.get(i).getIntegrantes().split("");
            List lista = new ArrayList();
            lista = Arrays.asList(cantIntegrantes);
            for (int j = 0; j < lista.size(); j++) {
                String pos = lista.get(j).toString();
                if (pos.equals(legajoCad)) {
                    encontrado = false;
                }
            }
        }
        return encontrado;
    }

    public float calcularMontoTotal() {
        Proyectos proyecto = new Proyectos();
        float montoTotal = 0;
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        for (int i = 0; i < listaProyectos.size(); i++) {
            montoTotal = listaProyectos.get(i).getMonto() + montoTotal;
        }
        return montoTotal;
    }

    public float calcularMontoIndividual(int integrantes, float monto) {
        float montoIndividual = 0;
        montoIndividual = monto / integrantes;
        return montoIndividual;
    }

    public void comparaFecha(Date Inicio, Date Final) {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();

        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+                                      Lista de Proyectos                          +");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|Codigo|      Nombre     | Fecha inicio |  Fecha finalizacion |  Monto  | Codigo integrantes |");
        System.out.println("+----------------------------------------------------------------------------------+");
        for (int i = 0; i < listaProyectos.size(); i++) {
            if (Inicio.before(listaProyectos.get(i).getFechaInicio()) && Final.after(listaProyectos.get(i).getFechaFinalizacion())) {
                Proyectos proyecto = listaProyectos.get(i);
                mostrarporFecha(proyecto);
            }
        }
        System.out.println("+----------------------------------------------------------------------------------+");

    }

    public void mostrarporFecha(Proyectos proyecto) {
        int dia = proyecto.getFechaInicio().getDate();
        int mes = proyecto.getFechaInicio().getMonth();
        int anio = proyecto.getFechaInicio().getYear();
        String fechaI = dia + "-" + mes + "-" + anio;
        dia = proyecto.getFechaFinalizacion().getDate();
        mes = proyecto.getFechaFinalizacion().getMonth();
        anio = proyecto.getFechaFinalizacion().getYear();
        String fechaF = dia + "-" + mes + "-" + anio;
        System.out.printf("| %-4s | %-15s | %-9s | %-16s | %-7s | %-15s  \n",
                proyecto.getCodigo(),
                proyecto.getNomProyecto(),
                fechaI,
                fechaF,
                proyecto.getMonto(),
                proyecto.getIntegrantes() + " |");
    }
}
