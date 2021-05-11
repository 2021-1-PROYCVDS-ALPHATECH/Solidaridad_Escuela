package edu.eci.cvds.samples.services.impl;

import java.util.List;
import java.util.HashMap;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.bouncycastle.jcajce.provider.digest.RIPEMD128.HashMac;

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

    @Inject
    private RespuestaDAO respuestaDAO;


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

    @Override
    public void eliminarUsuario(String idUsuario) throws ExcepcionSolidaridad {
        try {
            usuarioDAO.delete(idUsuario);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al eliminar el usuario con ID: " + idUsuario, e);
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
            if (nombre != null && consultarCategoriaNombre(nombre) != null){
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
            }
            if (nombre == null) nombre = oldNombre;
            if (descripcion == null) descripcion = oldDescripcion;
            if (estado == null) estado = oldEstado;
            categoriaDAO.update(id, nombre, descripcion, estado);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad ("Error al actualizar la categoria: " + id, e);
        }
    }

    @Override
    public void eliminarCategoria(String idCategoria) throws ExcepcionSolidaridad{
        try {
            categoriaDAO.delete(idCategoria);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al eliminar la categoria con ID: " + idCategoria, e);
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
    public List<Solicitud> consultarSolicitudesUsuario(String idUsuario) throws ExcepcionSolidaridad {
        try {
            return solicitudDAO.loadByUser(idUsuario);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar las solicitudes del usuario con id " + idUsuario, e);
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
    public void actualizarSolicitud(String id, String descripcion, String estado) throws ExcepcionSolidaridad{
        try {
            Solicitud solicitud = consultarSolicitudId(id);
            if (solicitud == null){
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.NO_APPLICATION_REGISTRED);
            }
            if (descripcion == null) descripcion = solicitud.getDescripcion();
            if (estado == null) estado = solicitud.getEstado();
            solicitudDAO.update(id, descripcion, estado);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al actualizar la solicitud " + id, e);
        }
    }

    @Override
    public void eliminarSolicitud(String idSolicitud) throws ExcepcionSolidaridad {
        try {
            solicitudDAO.delete(idSolicitud);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al eliminar la solicitud con id: " + idSolicitud, e);
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
    public List<Necesidad> consultarNecesidadesUsuario(String idUsuario) throws ExcepcionSolidaridad {
        try {
            return necesidadDAO.loadByUser(idUsuario);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar las necesidades del usuario con id " + idUsuario, e);
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
    public HashMap<String, Integer> consultarNecesidadesEstado() throws ExcepcionSolidaridad {
        try{
            HashMap<String, Integer> estadisticas = new HashMap<>();
            for (Estado estado : Estado.values()){
                estadisticas.put(estado.getDescripcion(), necesidadDAO.loadByState(estado.getDescripcion()).size());
            }
            return estadisticas;
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al consultar las necesidades por estado", e);
        }
    }

    @Override
    public void actualizarNecesidad(String idNecesidad, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad {
        try {
            Necesidad necesidad = consultarNecesidadId(idNecesidad);
            if (necesidad != null && nombre != null &&  !necesidad.getNombre().equals(nombre) && consultarNecesidadNombre(nombre) != null){
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
            }
            actualizarSolicitud(idNecesidad, descripcion, estado);
            if (nombre != null) necesidadDAO.update(idNecesidad, nombre);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al actualizar el estado de la necesidad con ID: "+ idNecesidad, e);
        }
    }    

    @Override
    public void eliminarNecesidad(String idNecesidad) throws ExcepcionSolidaridad {
        try {
            necesidadDAO.delete(idNecesidad);
            solicitudDAO.delete(idNecesidad);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al eliminar la necesidad con ID: " + idNecesidad, e);
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
    public List<Oferta> consultarOfertasUsuario(String idUsuario) throws ExcepcionSolidaridad {
        try {
            return ofertaDAO.loadByUser(idUsuario);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al consultar todas las ofertas ", e);
        }
    }

    @Override
    public HashMap<String, Integer> consultarOfertasEstado() throws ExcepcionSolidaridad {
        try{
            HashMap<String, Integer> estadisticas = new HashMap<>();
            for (Estado estado : Estado.values()){
                estadisticas.put(estado.getDescripcion(), ofertaDAO.loadByState(estado.getDescripcion()).size());
            }
            return estadisticas;
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al consultar las ofertas por estado", e);
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
    public void actualizarOferta(String idOferta, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad {
        try {
            Oferta oferta = consultarOfertaId(idOferta);
            if (oferta != null && nombre != null && !oferta.getNombre().equals(nombre) && consultarOfertaNombre(nombre) != null){
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
            }
            actualizarSolicitud(idOferta, descripcion, estado);
            if (nombre != null) ofertaDAO.update(idOferta, nombre);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al actualizar el estado de la oferta con id: "+ idOferta, e);
        }
    }

    @Override
    public void eliminarOferta(String idOferta) throws ExcepcionSolidaridad {
        try {
            ofertaDAO.delete(idOferta);
            solicitudDAO.delete(idOferta);
        } catch (PersistenceException e) {
            throw new ExcepcionSolidaridad("Error al eliminar la oferta con ID: " + idOferta, e);
        }
    }

    @Override
    public void registrarRespuesta(String idRespuesta, String idUsuario, String nombre, String comentarios, String idSolicitud) throws ExcepcionSolidaridad {
        try{
            String estado = solicitudDAO.load(idSolicitud).getEstado();
            if (respuestaDAO.load(idRespuesta) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ID);
            if (!(estado.equals("Activa")) && !(estado.equalsIgnoreCase("en proceso"))) {
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ANSWER);
            }
            respuestaDAO.save(new Respuesta(idRespuesta, nombre, comentarios), idUsuario, idSolicitud);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al registrar respuesta con id: " + idRespuesta, e);
        }
    }

    @Override
    public List<Respuesta> consultarRespuestas() throws ExcepcionSolidaridad {
        try{
            return respuestaDAO.loadAll();
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al consultar todas las respuestas", e);
        }
    }

    @Override
    public Respuesta consultarRespuestaId(String id) throws ExcepcionSolidaridad {
        try{
            return respuestaDAO.load(id);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al consultar la respuesta con id: " + id, e);
        }
    }

    @Override
    public List<Respuesta> consultarRespuestasUsuario(String nombre) throws ExcepcionSolidaridad {
        try{
            return respuestaDAO.loadByUser(nombre);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al consultar las respuestas del usuario  " + nombre, e);
        }
    }

    @Override
    public List<Respuesta> consultarRespuestasSolicitud(String nombre) throws ExcepcionSolidaridad {
        try{
            return respuestaDAO.loadByApplication(nombre);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al consultar las respuestas de la solicitud " + nombre, e);
        }
    }

    @Override
    public void eliminarRespuesta(String id) throws ExcepcionSolidaridad {
        try{
            respuestaDAO.delete(id);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridad("Error al eliminar la respuesta con id  " + id, e);
        }
        
    }

    
}
