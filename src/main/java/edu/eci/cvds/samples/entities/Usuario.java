package edu.eci.cvds.samples.entities;

import java.io.Serializable;

import edu.eci.cvds.samples.entities.Rol;
/**
 * Clase usario para asi poder ...
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public class Usuario implements Serializable{
    private String idUsuario;
    private String nombre;
    private String telefono;
    private String email;
    private String clave;
    private Rol rol;

    /**
     * 
     * @param idUsuario
     * @param nombre
     * @param telefono
     * @param email
     * @param clave
     * @param rol
     */
    public Usuario(String idUsuario, String nombre, String telefono, String email, String clave, Rol rol){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
    }
    /**
     * 
     * @param idUsuario
     * @param nombre
     * @param telefono
     * @param email
     * @param clave
     * @param rol
     */
    public Usuario(String idUsuario, String nombre, String telefono, String email, String clave, String rol){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        System.out.println("Rol: " + rol);
        this.rol = Rol.valueOf(rol);
    }
    
    public void setIdUsuario(String newId) {
        idUsuario = newId;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(String newTelefono) {
        telefono = newTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setClave(String newClave) {
        clave = newClave;
    }

    public String getClave() {
        return clave;
    }

    public void setRol(Rol newRol) {
        rol = newRol;
    }

    public Rol getRol() {
        return rol;
    }

    @Override
    public String toString(){
        return "Usuario{" + "id=" + idUsuario + ", nombre=" + nombre + ", clave=" + clave + ",rol=" + rol + '}';
    }
}
