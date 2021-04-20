package edu.eci.cvds.samples.services;

import java.util.List;

import edu.eci.cvds.samples.entities.*;

/**
 * Interfaz para los servicios ofrecidos por la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public interface ServiciosSolidaridad {
    
    public abstract List<Usuario> consultarUsuarios() throws ExcepcionSolidaridadEscuela;

    public abstract List<Categoria> consultarCategorias() throws ExcepcionSolidaridadEscuela;

    public abstract void registrarCategoria(String id, String nombre, String descripcion) throws ExcepcionSolidaridadEscuela;

    public abstract void actualizarNombreCategoria(String id, String nombre) throws ExcepcionSolidaridadEscuela;

    public abstract void actualizarDescripcionCategoria(String id, String descripcion) throws ExcepcionSolidaridadEscuela;

    public abstract void actualizarEstadoCategoria(String id, String estado) throws ExcepcionSolidaridadEscuela;

}
