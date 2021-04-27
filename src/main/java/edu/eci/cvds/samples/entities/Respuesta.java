package edu.eci.cvds.samples.entities;

import java.io.Serializable;

import java.sql.Date;
import java.time.LocalDate;


/**
 * Clase Respuesta 
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 26/04/2021 v1.0
 */
public class Respuesta implements Serializable{
    private String idRespuesta;
    private String nombre;
    private String comentarios;
    private Date fechaCreacion;

    public Respuesta(String idRespuesta, String nombre, String comentarios, Date fechaCreacion){
        this.idRespuesta = idRespuesta;
        this.nombre = nombre;
        this.comentarios = comentarios;
        this.fechaCreacion = fechaCreacion;
    }

    public Respuesta(String idRespuesta, String nombre, String comentarios){
        this.idRespuesta = idRespuesta;
        this.nombre = nombre;
        this.comentarios = comentarios;
        fechaCreacion = Date.valueOf(LocalDate.now());
    }

    public Respuesta(){}

    public void setIdRespuesta(String newIdRespuesta){
        idRespuesta = newIdRespuesta;
    }

    public String getIdRespuesta(){
        return idRespuesta;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setComentarios(String newComentarios){
        comentarios = newComentarios;
    }

    public String getComentarios(){
        return comentarios;
    }

    public void setFechaCreacion(Date newFechaCreacion){
        fechaCreacion = newFechaCreacion;
    }

    public Date getFechaCreacion(){
        return fechaCreacion;
    }

    @Override
    public String toString(){
        return "Respuesta{"+"id= "+ idRespuesta + ", nombre= " + nombre + ",comentarios=" + comentarios + ", fecha C= " + fechaCreacion +"}";
    }
}
