package edu.eci.cvds.samples.entities;


import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Clase categoria para asi poder clasificar de forma correcta las diferentes ofertas
 * y necesidades que seran expuestas en la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public class Categoria implements Serializable{
    private String idCategoria;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String estado;

    public Categoria(String id, String nombre, String descripcion, Date fechaCreacion, Date fechaModificacion, String estado) {
        this.idCategoria = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
    }

    public Categoria(String id, String nombre, String descripcion){
        this.idCategoria = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        LocalDate hoy = LocalDate.now();
        this.fechaCreacion = Date.valueOf(hoy);
        this.fechaModificacion = Date.valueOf(hoy);;
        this.estado = "Activa";
    }

    public void setId(String newId){
        idCategoria = newId;
    }

    public String getId(){
        return idCategoria;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setDescripcion(String newDescripcion){
        descripcion = newDescripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Date getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaModificacion(Date newFechaModificacion){
        fechaModificacion = newFechaModificacion;;
    }

    public Date getFechaModificacion(){
        return fechaModificacion;
    }

    public void setEstado(String newEstado){
        estado = newEstado;
    }

    public String getEstado(){
        return estado;
    }

    @Override
    public String toString(){
        return "Categoria{" + "id=" + idCategoria + ", nombre=" + nombre +", descripcion=" + descripcion +", fecha C=" + fechaCreacion + ", fecha M=" + fechaModificacion+", estado= "+estado+'}';
    }
}
