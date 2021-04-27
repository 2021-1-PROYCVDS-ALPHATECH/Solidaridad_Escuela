package edu.eci.cvds.samples.services.impl;

import java.util.List;
import org.apache.shiro.crypto.hash.Sha256Hash;

import com.google.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;

public class ServiciosSolidaridadImpl implements ServiciosSolidaridad{

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private CategoriaDAO categoriaDAO;

    @Inject
    private NecesidadDAO necesidadDAO;

    @Inject
    private OfertaDAO ofertaDAO;

    @Inject
    private SolicitudDAO solicitudDAO;

    @Transactional
    @Override
    public void registrarUsuario(String id, String nombre, String telefono, String email, String clave, String rol, int num) throws ExcepcionSolidaridad{
        try{
            usuarioDAO.save(new Usuario(id, nombre, telefono, email, new Sha256Hash(clave).toHex() + "", rol, num));
        } catch(PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al registrar el usuario " + id, e);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionSolidaridad {
        try{
            return usuarioDAO.loadAll();
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar los usuarios", e);
        }
    }

    @Override
    public Usuario consultarUsuario(String idUsuario) throws ExcepcionSolidaridad {
        try{
            return usuarioDAO.load(idUsuario);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar el usuario " + idUsuario, e);
        }
    }

    @Override
    public Usuario consultarUsuarioNombre(String nombre) throws ExcepcionSolidaridad{
        try{
            return usuarioDAO.loadByName(nombre);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar el usuario con nombre " + nombre, e);
        }
    }

    @Override
    public List<Usuario> consultarUsuariosRol(String rol) throws ExcepcionSolidaridad{
        try{
            return usuarioDAO.loadByRol(rol);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar los usuarios con rol " + rol, e);
        }
    }

    @Override
    public void actualizarNumSolicitudes(String idUsuario, int numSolicitudes) throws ExcepcionSolidaridad {
        try{
            Usuario usuario = consultarUsuario(idUsuario);
            if (usuario.getSolicitudes().size() > numSolicitudes){
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NUM_SOLICITUDES);
            }
            usuarioDAO.updateNumApplication(idUsuario, numSolicitudes);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar los usuarios", e);
        }
    }

    @Transactional
    @Override
    public void registrarCategoria(String id, String nombre, String descripcion) throws ExcepcionSolidaridad {
        try{
            if (consultarCategoriaId(id) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ID);
            else if (consultarCategoriaNombre(nombre) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
            categoriaDAO.save(new Categoria(id, nombre, descripcion));
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al registrar la categoria: " + id, e);
        }        
    }

    @Override
    public List<Categoria> consultarCategorias() throws ExcepcionSolidaridad {
        try{
            return categoriaDAO.loadAll();
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar las categorias", e);
        }
    }

    @Override
    public Categoria consultarCategoriaId(String id) throws ExcepcionSolidaridad {
        try{
            return categoriaDAO.load(id);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar la categoria: " + id, e);
        }
    }

    @Override
    public Categoria consultarCategoriaNombre(String nombre) throws ExcepcionSolidaridad {
        try{
            return categoriaDAO.loadByName(nombre);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al consultar la categoria con nombre: " + nombre, e);
        }
    }

    @Override
    public void actualizarCategoria(String id, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad {
        try{
            Categoria categoria = consultarCategoriaId(id);
            if (categoria == null) {
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.NO_CATEGORY_REGISTRED);
            }
            String oldNombre = categoria.getNombre();
            String oldDescripcion = categoria.getDescripcion(); 
            String oldEstado = categoria.getEstado(); 
            if (oldNombre.equals(nombre) && oldDescripcion.equals(descripcion) &&  oldEstado.equals(estado)){
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_UPDATE);
            }
            if (nombre == null) nombre = oldNombre;
            if (descripcion == null) descripcion = oldDescripcion;
            if (estado == null) estado = oldEstado;
            categoriaDAO.update(id, nombre, descripcion, estado);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al actualizar la categoria: " + id, e);
        }
    }

    @Transactional
    @Override
    public void registrarSolicitud(String id, String descripcion, String estado, String categoria, String idUsuario) throws ExcepcionSolidaridad {
        try {
            if (consultarSolicitudId(id) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ID);
            else if(consultarUsuario(idUsuario).solicitudesRestantes() == 0) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_REGISTRED);
            solicitudDAO.save(id, descripcion, estado, categoria, idUsuario);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            throw new ExcepcionSolidaridad("Error al insertar solicitud: " + id, e);
        }
    }

    @Override
    public List<Solicitud> consultarSolicitudes() throws ExcepcionSolidaridad {
        try {
            return solicitudDAO.loadAll();
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar todas las solicitudes", e);
        }
    }

    @Override
    public Solicitud consultarSolicitudId(String id) throws ExcepcionSolidaridad {
        try {
            return solicitudDAO.load(id);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar la solicitud " + id, e);
        }
    }

    @Override
    public void actualizarSolicitud(String id) throws ExcepcionSolidaridad{
        try {
            solicitudDAO.update(id);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al actualizar la solicitud " + id, e);
        }
    }
    
    @Transactional
    @Override
    public void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado, String categoria)
            throws ExcepcionSolidaridad {
        try {
            if (consultarNecesidadNombre(nombre) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
            registrarSolicitud(idNecesidad, descripcion, estado, categoria, idUsuario);
            necesidadDAO.save(idNecesidad, nombre, urgencia);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al registrar la necesidad: "+ idNecesidad, e);
        }
    }

    @Override
    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad {
        try {
            return necesidadDAO.loadAll();
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar todas las necesidades ", e);
        }
    }

    @Override
    public Necesidad consultarNecesidadId(String id) throws ExcepcionSolidaridad {
        try {
            return necesidadDAO.load(id);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar la necesidad " + id, e);
        }
    }

    @Override
    public Necesidad consultarNecesidadNombre(String nombre) throws ExcepcionSolidaridad {
        try {
            return necesidadDAO.loadByName(nombre);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar la necesidad con nombre " + nombre, e);
        }
    }

    @Override
    public void actualizarEstadoNecesidad(String idNecesidad) throws ExcepcionSolidaridad {
        try {
            actualizarSolicitud(idNecesidad);
        } catch (ExcepcionSolidaridad e) {
            throw new ExcepcionSolidaridad("Error al actualizar el estado de la categoria con ID: "+ idNecesidad, e);
        }
    }    

    @Transactional
    @Override
    public void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String estado, String categoria) throws ExcepcionSolidaridad {
        try{
            if (consultarOfertaNombre(nombre) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
            registrarSolicitud(idOferta, descripcion, estado, categoria, idUsuario);
            ofertaDAO.save(idOferta, nombre);
        } catch (PersistenceException e){
            e.printStackTrace();
            throw new ExcepcionSolidaridad ("Error al insertar la oferta", e);
        }
    }
    
    @Override
    public List<Oferta> consultarOfertas() throws ExcepcionSolidaridad {
        try {
            return ofertaDAO.loadAll();
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar todas las ofertas ", e);
        }
    }

    @Override
    public Oferta consultarOfertaId(String id) throws ExcepcionSolidaridad {
        try {
            return ofertaDAO.load(id);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar la oferta " + id, e);
        }
    }

    @Override
    public Oferta consultarOfertaNombre(String nombre) throws ExcepcionSolidaridad {
        try {
            return ofertaDAO.loadByName(nombre);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar la oferta con nombre " + nombre, e);
        }
    }

    @Override
    public void actualizarEstadoOferta(String idOferta) throws ExcepcionSolidaridad {
        try {
            actualizarSolicitud(idOferta);
        } catch (ExcepcionSolidaridad e) {
            throw new ExcepcionSolidaridad("Error al actualizar el estado de la oferta con ID: "+ idOferta, e);
        }
    }

    @Override
    public void eliminarOferta(String idOferta) throws ExcepcionSolidaridad {
        try {
            ofertaDAO.delete(idOferta);
        } catch (Exception e) {
            throw new ExcepcionSolidaridad("Error al eliminar la oferta con ID: " + idOferta, e);
        }
        
    }

    @Override
    public void eliminarUsuario(String idUsuario) throws ExcepcionSolidaridad {
        try {
            usuarioDAO.delete(idUsuario);
        } catch (Exception e) {
            throw new ExcepcionSolidaridad("Error al eliminar el usuario con ID: " + idUsuario, e);
        }
        
    }

    @Override
    public void eliminarNecesidad(String idNecesidad) throws ExcepcionSolidaridad {
        try {
            necesidadDAO.delete(idNecesidad);
        } catch (Exception e) {
            throw new ExcepcionSolidaridad("Error al eliminar la necesidad con ID: " + idNecesidad, e);
        }
        
    }

    @Override
    public void eliminarSolicitud(String idSolicitud) throws ExcepcionSolidaridad {
        try {
            solicitudDAO.delete(idSolicitud);
        } catch (Exception e) {
            throw new ExcepcionSolidaridad("Error al eliminar la solicitud con ID: " + idSolicitud, e);
        }
        
    }

    @Override
    public void eliminarCategoria(String idCategoria) throws ExcepcionSolidaridad{
        try {
            categoriaDAO.delete(idCategoria);
        } catch (Exception e) {
            throw new ExcepcionSolidaridad("Error al eliminar la categoria con ID: " + idCategoria, e);
        }
    }

}
