package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;

public class Oferta implements Serializable {
    private String idOferta;
    private String idUsuario;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String estado;

    public Oferta(){
    }
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

    public Oferta(String idOferta, String idUsuario, String nombre, String descipcion, Date fechaCreacion, Date fechaModificacion, String estado){
        this.idOferta = idOferta;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descipcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
    }

    public Oferta(String idOferta, String idUsuario, String nombre, String descipcion,String estado){
        LocalDate hoy = LocalDate.now();
        this.fechaCreacion = Date.valueOf(hoy);
        this.fechaModificacion = Date.valueOf(hoy);
        this.idOferta = idOferta;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descipcion;
        this.estado = estado;
    }

    public String getIdOferta(){
        return idOferta;
    }

    public void setIdOferta(String idOferta){
        this.idOferta = idOferta;
    }

    public String getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario){
        this.idUsuario = idUsuario;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion(){
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion){
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    @Override
    public String toString(){
        return "Oferta{"+"idOferta= "+ idOferta + ", idUsuario= " + idUsuario + ", nombre= " + nombre + ", descripcion= " + descripcion + ", fecha C= " + fechaCreacion + ", fecha M= " + fechaModificacion + ", estado= " + estado + "}";
    }
}
