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
 * @version 22/04/2021 v2.0
 */
public interface ServiciosSolidaridad {

    public abstract void registrarUsuario(String id, String nombre, String telefono, String email, String clave, String rol, int num) throws ExcepcionSolidaridad;
    
    public abstract List<Usuario> consultarUsuarios() throws ExcepcionSolidaridad;

    public abstract Usuario consultarUsuario(String idUsuario) throws ExcepcionSolidaridad;

    public abstract Usuario consultarUsuarioNombre(String nombre) throws ExcepcionSolidaridad;

    public abstract List<Usuario> consultarUsuariosRol(String rol) throws ExcepcionSolidaridad;

    public abstract void actualizarNumSolicitudes(String idUsuario, int numSolicitudes) throws ExcepcionSolidaridad;

    public abstract void eliminarUsuario(String idUsuario) throws ExcepcionSolidaridad;

    public abstract void registrarCategoria(String id, String nombre, String descripcion) throws ExcepcionSolidaridad;

    public abstract List<Categoria> consultarCategorias() throws ExcepcionSolidaridad;

    public abstract Categoria consultarCategoriaId(String id) throws ExcepcionSolidaridad;
    
    public abstract Categoria consultarCategoriaNombre(String nombre) throws ExcepcionSolidaridad;

    public abstract void actualizarCategoria(String id, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad;

    public abstract void eliminarCategoria(String idCategoria) throws ExcepcionSolidaridad;

    public abstract void registrarSolicitud(String id, String descripcion, String estado, String categoria, String idUsuario) throws ExcepcionSolidaridad;

    public abstract List<Solicitud> consultarSolicitudes() throws ExcepcionSolidaridad;
    
    public abstract Solicitud consultarSolicitudId(String id) throws ExcepcionSolidaridad;

    public abstract void actualizarSolicitud(String id) throws ExcepcionSolidaridad;

    public abstract void eliminarSolicitud(String idSolicitud) throws ExcepcionSolidaridad;
    
    public abstract void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado, String categoria) throws ExcepcionSolidaridad;

    public abstract List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad;

    public abstract Necesidad consultarNecesidadId(String id) throws ExcepcionSolidaridad;

    public abstract Necesidad consultarNecesidadNombre(String nombre) throws ExcepcionSolidaridad;

    public abstract void actualizarEstadoNecesidad(String idNecesidad) throws ExcepcionSolidaridad;

    public abstract void eliminarNecesidad(String idNecesidad) throws ExcepcionSolidaridad;

    public abstract void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String estado, String categoria)  throws ExcepcionSolidaridad;

    public abstract List<Oferta> consultarOfertas() throws ExcepcionSolidaridad;

    public abstract Oferta consultarOfertaId(String id) throws ExcepcionSolidaridad;

    public abstract Oferta consultarOfertaNombre(String nombre) throws ExcepcionSolidaridad;

    public abstract void actualizarEstadoOferta(String idOferta) throws ExcepcionSolidaridad;

    public abstract void eliminarOferta(String idOferta) throws ExcepcionSolidaridad;

    public abstract void registrarRespuesta(String idRespuesta, String idUsuario, String nombre, String comentarios, String idSolicitud) throws ExcepcionSolidaridad;

    public abstract List<Respuesta> consultarRespuestas() throws ExcepcionSolidaridad;

    public abstract Respuesta consultarRespuestaId(String id) throws ExcepcionSolidaridad;

    public abstract List<Respuesta> consultarRespuestasUsuario(String nombre) throws ExcepcionSolidaridad;

    public abstract List<Respuesta> consultarRespuestasSolicitud(String nombre) throws ExcepcionSolidaridad;

    public abstract void eliminarRespuesta(String id) throws ExcepcionSolidaridad;

}
