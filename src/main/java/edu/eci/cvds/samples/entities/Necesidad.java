package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;

/**
 * Calse Necesidad en donde se van a guardar de maera correcta las diferentes necesidades que puedan
 * ener los estudiantes para poder ser expuestas en la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public class Necesidad implements Serializable{
    private String idNecesidad;
    private String idUsuario;
    private String nombre;
    private String descripcion;
    private String urgencia;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String estado;
    private Categoria categoria;

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
     * 
     */

    public Necesidad(){
    }
    
    public Necesidad(String idNecesidad, String idUsuario, String nombre, String descipcion, String urgencia, Date fechaCreacion, Date fechaModificacion, String estado, Categoria categoria){
        this.idNecesidad = idNecesidad;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descipcion;
        this.urgencia = urgencia; 
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.categoria = categoria;
    }

    public Necesidad(String idNecesidad, String idUsuario, String nombre, String descipcion, String urgencia,String estado, Categoria categoria){
        LocalDate hoy = LocalDate.now();
        this.fechaCreacion = Date.valueOf(hoy);
        this.fechaModificacion = Date.valueOf(hoy);
        this.idNecesidad = idNecesidad;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descipcion;
        this.urgencia = urgencia; 
        this.estado = estado;
        this.categoria = categoria;
    }

    public String getIdNecesidad(){
        return idNecesidad;
    }

    public void setIdNecesidad(String idNecesidad){
        this.idNecesidad = idNecesidad;
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

    public String getUrgencia(){
        return urgencia;
    }

    public void setUrgencia(String urgencia){
        this.urgencia = urgencia;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "Necesidad{"+"idNecesidad= "+ idNecesidad + ", idUsuario= " + idUsuario + ", nombre= " + nombre + ", descripcion= " + descripcion + ", urgencia= " + urgencia + ", fecha C= " + fechaCreacion + ", fecha M= " + fechaModificacion + ", estado= " + estado + ", categoria= " + categoria + "}";
    }
}