package edu.eci.cvds.samples.entities;

import java.io.Serializable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase Solicitud en donde se van a guardar de maera correcta las diferentes necesidades que puedan
 * ener los estudiantes para poder ser expuestas en la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 28/04/2021 v3.0
 */

public class Solicitud implements Serializable{

    protected String  idSolicitud;
    protected String descripcion;
    protected String estado;
    protected Categoria categoria;
    protected Date fechaCreacion;
    protected Date fechaModificacion;
    protected ArrayList<Respuesta> respuestas;
    protected String nombreUsuario;


    public Solicitud(String idSolicitud, String descripcion, String estado, Date fechaCreacion, Date fechaModificacion, Categoria categoria, ArrayList<Respuesta> respuestas){
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.categoria = categoria;
        this.respuestas = respuestas;
    }

    public Solicitud(String idSolicitud, String descripcion, String estado, Date fechaCreacion, Date fechaModificacion, Categoria categoria){
        this.idSolicitud = idSolicitud;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.categoria = categoria;
        this.respuestas = new ArrayList<Respuesta>();
    }

    public Solicitud(String idSolicitud, String descipcion,String estado, Categoria categoria){
        LocalDate hoy = LocalDate.now();
        this.fechaCreacion = Date.valueOf(hoy);
        this.fechaModificacion = Date.valueOf(hoy);
        this.idSolicitud = idSolicitud;
        this.descripcion = descipcion;
        this.estado = estado;
        this.categoria = categoria;
        this.respuestas = new ArrayList<Respuesta>();
    }

    public Solicitud(){}

    public void setIdSolicitud(String newIdSolicitud) {
        idSolicitud = newIdSolicitud;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(String newEstado){
        estado = newEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCategoria(Categoria newCategoria){
        categoria = newCategoria;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setFechaCreacion(Date newFechaCreacion) {
        fechaCreacion = newFechaCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaModificacion(Date newFechaModificacion) {
        fechaModificacion = newFechaModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setRespuenta(ArrayList<Respuesta> newRespuestas){
        respuestas = newRespuestas;
    }

    public ArrayList<Respuesta> getRespuesta(){
        return respuestas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    @Override
    public String toString(){
        return "Solicitud{"+"id = "+ idSolicitud + ", descripcion = " + descripcion +", fecha C = " + fechaCreacion + ", fecha M = " + fechaModificacion + ", estado = " + estado + ", nombreUsuario = " + nombreUsuario + ", categoria = \n\t"+ categoria + ", respuestas = \n\t" + respuestas + "}";
    }
}
