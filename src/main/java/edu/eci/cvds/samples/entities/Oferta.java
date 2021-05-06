package edu.eci.cvds.samples.entities;

import java.sql.Date;

/**
 * Clase Oferta
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */

public class Oferta extends Solicitud {

    private String nombre;

    /**
     * 
     * @param idOferta
     * @param idUsuario
     * @param nombre
     * @param descipcion
     * @param fechaCreacion
     * @param fechaModificacion
     * @param estado
     */

    public Oferta(String idOferta, String nombre, String descripcion ,String estado, Date fechaCreacion, Date fechaModificacion, Categoria categoria){
        super(idOferta, descripcion, estado, fechaCreacion, fechaModificacion, categoria);
        this.nombre = nombre;
    }

    public Oferta(String idOferta, String nombre, String descripcion,String estado, Categoria categoria){
        super(idOferta, descripcion, estado, categoria);
        this.nombre = nombre;
    }

    public Oferta(){}

    public void setNombre(String newNombre){
        nombre = newNombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String toString(){
        return "Oferta{"+"id= "+ idSolicitud + ", nombre= " + nombre + ", descripcion= " + descripcion +", fecha C= " + fechaCreacion + ", fecha M= " + fechaModificacion + ", estado= " + estado + ", nombreUsuario = " + nombreUsuario +", categoria =\n\t"+ categoria+", respuestas = \n\t" + respuestas+"}";
    }
}
