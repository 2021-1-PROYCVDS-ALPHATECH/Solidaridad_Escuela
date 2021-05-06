package edu.eci.cvds.samples.entities;


import java.sql.Date;

/**
 * Calse Necesidad en donde se van a guardar de maera correcta las diferentes necesidades que puedan
 * ener los estudiantes para poder ser expuestas en la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */

public class Necesidad extends Solicitud{
    private String urgencia;
    private String nombre;
    
    /**
     * 
     * @param idNecesidad
     * @param idUsuario
     * @param nombre
     * @param descipcion
     * @param urgencia
     * @param fechaCreacion
     * @param fechaModificacion
     * @param estado
     */

    public Necesidad(String idNecesidad, String nombre, String descripcion, String estado, String urgencia, Date fechaCreacion, Date fechaModificacion, Categoria categoria){
        super(idNecesidad, descripcion, estado, fechaCreacion, fechaModificacion, categoria);
        this.urgencia = urgencia;
        this.nombre = nombre;
    }

    public Necesidad(String idNecesidad, String nombre, String descripcion, String estado, String urgencia, Categoria categoria){
        super(idNecesidad, descripcion, estado, categoria);
        this.urgencia = urgencia;
        this.nombre = nombre;
    }

    public Necesidad(){}
    
    public void setNombre(String newNombre){
        nombre = newNombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getUrgencia() {
        return urgencia;
    }

    @Override
    public String toString(){
        return "Necesidad{"+"id= "+ idSolicitud + ", nombre= " + nombre + ", descripcion= " + descripcion +", urgencia= " + urgencia  +", fecha C= " + fechaCreacion + ", fecha M= " + fechaModificacion + ", estado= " + estado + ", nombreUsuario = " + nombreUsuario +", categoria =\n\t"+ categoria+", respuestas = \n\t" + respuestas+"}";
    }
}
