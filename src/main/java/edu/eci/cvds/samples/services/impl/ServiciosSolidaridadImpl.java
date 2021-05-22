package edu.eci.cvds.samples.services.impl;

import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

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

    private InputStream inputStream;

    @Transactional
    @Override
    public void registrarUsuario(String id, String nombre, String telefono, String email, String clave, String rol) throws ExcepcionSolidaridad, PersistenceException{
        usuarioDAO.save(new Usuario(id, nombre, telefono, email, new Sha256Hash(clave).toHex() + "", rol));
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionSolidaridad, PersistenceException {
        return usuarioDAO.loadAll();
    }

    @Override
    public Usuario consultarUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException {
        return usuarioDAO.load(idUsuario);
    }

    @Override
    public Usuario consultarUsuarioNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException{
        return usuarioDAO.loadByName(nombre);
    }

    @Override
    public List<Usuario> consultarUsuariosRol(String rol) throws ExcepcionSolidaridad, PersistenceException{
        return usuarioDAO.loadByRol(rol);
    }

    @Override
    public void eliminarUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException {
        usuarioDAO.delete(idUsuario);
    }

    @Transactional
    @Override
    public void registrarCategoria(String id, String nombre, String descripcion, String estado, String comentario) throws ExcepcionSolidaridad, PersistenceException {
        if (consultarCategoriaId(id) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ID);
        else if (consultarCategoriaNombre(nombre) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
        if (estado.equals("Invalida") && comentario == null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_CATEGORY);
        categoriaDAO.save(new Categoria(id, nombre, descripcion, estado, comentario));      
    }

    @Override
    public List<Categoria> consultarCategorias() throws ExcepcionSolidaridad, PersistenceException {
        return categoriaDAO.loadAll();
    }

    @Override
    public Categoria consultarCategoriaId(String id) throws ExcepcionSolidaridad, PersistenceException {
        return categoriaDAO.load(id);
    }

    @Override
    public Categoria consultarCategoriaNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException {
        return categoriaDAO.loadByName(nombre);
    }

    @Override
    public void actualizarCategoria(String id, String nombre, String descripcion, String estado, String comentario) throws ExcepcionSolidaridad, PersistenceException {
        Categoria categoria = consultarCategoriaId(id);
        if (categoria == null) {
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.NO_CATEGORY_REGISTRED);
        }
        
        String oldNombre = categoria.getNombre();
        String oldDescripcion = categoria.getDescripcion(); 
        String oldEstado = categoria.getEstado(); 
        String oldComentario = categoria.getComentario();
        if (oldNombre.equals(nombre) && oldDescripcion.equals(descripcion) &&  oldEstado.equals(estado) && (comentario == null || comentario.equals(oldComentario))) {
                throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_UPDATE);
        }
        if (nombre != null && consultarCategoriaNombre(nombre) != null){
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
        }
        if (nombre == null) nombre = oldNombre;
        if (descripcion == null) descripcion = oldDescripcion;
        if (estado == null) estado = oldEstado;
        if (estado.equals("Invalida") && comentario == null) comentario = oldComentario;
        categoriaDAO.update(id, nombre, descripcion, estado, comentario);
    }

    @Override
    public void eliminarCategoria(String idCategoria) throws ExcepcionSolidaridad, PersistenceException{
        categoriaDAO.delete(idCategoria);
    }

    @Transactional
    @Override
    public void registrarSolicitud(String id, String descripcion, String estado, String categoria, String idUsuario) throws ExcepcionSolidaridad, PersistenceException {
        if (consultarSolicitudId(id) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ID);
        if (Integer.parseInt(getNumeroSolicitudes()) < consultarSolicitudes().size()) throw new  ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_REGISTRED);
        Categoria categoriaSolicitud = consultarCategoriaId(categoria);
        if(categoriaSolicitud == null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.NO_CATEGORY_REGISTRED);
        else if (categoriaSolicitud.getEstado().equals("Invalida")) throw new ExcepcionSolidaridad(categoriaSolicitud.getComentario());
        solicitudDAO.save(id, descripcion, estado, categoria, idUsuario);
    }

    @Override
    public List<Solicitud> consultarSolicitudes() throws ExcepcionSolidaridad, PersistenceException {
        return solicitudDAO.loadAll();
    }

    @Override
    public List<Solicitud> consultarSolicitudesUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException {
        return solicitudDAO.loadByUser(idUsuario);
    }

    @Override
    public Solicitud consultarSolicitudId(String id) throws ExcepcionSolidaridad, PersistenceException {
        return solicitudDAO.load(id);
    }

    @Override
    public void actualizarSolicitud(String id, String descripcion, String estado) throws ExcepcionSolidaridad, PersistenceException{
        Solicitud solicitud = consultarSolicitudId(id);
        if (solicitud == null){
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.NO_APPLICATION_REGISTRED);
        }
        if (descripcion == null) descripcion = solicitud.getDescripcion();
        if (estado == null) estado = solicitud.getEstado();
        solicitudDAO.update(id, descripcion, estado);
    }

    @Override
    public void eliminarSolicitud(String idSolicitud) throws ExcepcionSolidaridad, PersistenceException {
        solicitudDAO.delete(idSolicitud);
    }
    
    @Transactional
    @Override
    public void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado, String categoria)
            throws ExcepcionSolidaridad, PersistenceException {
        if (consultarNecesidadNombre(nombre) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
        registrarSolicitud(idNecesidad, descripcion, estado, categoria, idUsuario);
        necesidadDAO.save(idNecesidad, nombre, urgencia);
    }

    @Override
    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad, PersistenceException {
        return necesidadDAO.loadAll();
    }

    @Override
    public List<Necesidad> consultarNecesidadesUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException {
        return necesidadDAO.loadByUser(idUsuario);
    }

    @Override
    public Necesidad consultarNecesidadId(String id) throws ExcepcionSolidaridad, PersistenceException {
        return necesidadDAO.load(id);
    }

    @Override
    public Necesidad consultarNecesidadNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException {
        return necesidadDAO.loadByName(nombre);
    }

    @Override
    public HashMap<String, Integer> consultarNecesidadesEstado() throws ExcepcionSolidaridad, PersistenceException {
        HashMap<String, Integer> estadisticas = new HashMap<>();
        for (Estado estado : Estado.values()){
            estadisticas.put(estado.getDescripcion(), necesidadDAO.loadByState(estado.getDescripcion()).size());
        }
        return estadisticas;
    }

    @Override
    public List<Necesidad> consultarNecesidadesCategoria(String categoria) throws ExcepcionSolidaridad, PersistenceException {
        return necesidadDAO.loadByCategory(categoria);
    }

    @Override
    public void actualizarNecesidad(String idNecesidad, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad, PersistenceException {
        Necesidad necesidad = consultarNecesidadId(idNecesidad);
        if (necesidad != null && nombre != null &&  !necesidad.getNombre().equals(nombre) && consultarNecesidadNombre(nombre) != null){
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
        }
        actualizarSolicitud(idNecesidad, descripcion, estado);
        if (nombre != null) necesidadDAO.update(idNecesidad, nombre);
    }    

    @Override
    public void eliminarNecesidad(String idNecesidad) throws ExcepcionSolidaridad, PersistenceException {
        necesidadDAO.delete(idNecesidad);
        solicitudDAO.delete(idNecesidad);
    }

    @Transactional
    @Override
    public void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String estado, String categoria) throws ExcepcionSolidaridad, PersistenceException{
        if (consultarOfertaNombre(nombre) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
        registrarSolicitud(idOferta, descripcion, estado, categoria, idUsuario);
        ofertaDAO.save(idOferta, nombre);
    }
    
    @Override
    public List<Oferta> consultarOfertas() throws ExcepcionSolidaridad, PersistenceException {
        return ofertaDAO.loadAll();
    }

    @Override
    public List<Oferta> consultarOfertasUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException {
        return ofertaDAO.loadByUser(idUsuario);
    }

    @Override
    public Oferta consultarOfertaId(String id) throws ExcepcionSolidaridad, PersistenceException {
        return ofertaDAO.load(id);
    }

    @Override
    public Oferta consultarOfertaNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException {
        return ofertaDAO.loadByName(nombre);
    }

    @Override
    public HashMap<String, Integer> consultarOfertasEstado() throws ExcepcionSolidaridad, PersistenceException {
        HashMap<String, Integer> estadisticas = new HashMap<>();
        for (Estado estado : Estado.values()){
            estadisticas.put(estado.getDescripcion(), ofertaDAO.loadByState(estado.getDescripcion()).size());
        }
        return estadisticas;
    }

    @Override
    public List<Oferta> consultarOfertasCategoria(String categoria) throws ExcepcionSolidaridad, PersistenceException {
        return ofertaDAO.loadByCategory(categoria);
    }

    @Override
    public void actualizarOferta(String idOferta, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad, PersistenceException {
        Oferta oferta = consultarOfertaId(idOferta);
        if (oferta != null && nombre != null && !oferta.getNombre().equals(nombre) && consultarOfertaNombre(nombre) != null){
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NAME);
        }
        actualizarSolicitud(idOferta, descripcion, estado);
        if (nombre != null) ofertaDAO.update(idOferta, nombre);
    }

    @Override
    public void eliminarOferta(String idOferta) throws ExcepcionSolidaridad, PersistenceException {
        ofertaDAO.delete(idOferta);
        solicitudDAO.delete(idOferta);
    }

    @Override
    public void registrarRespuesta(String idRespuesta, String idUsuario, String nombre, String comentarios, String idSolicitud) throws ExcepcionSolidaridad, PersistenceException {
        String estado = solicitudDAO.load(idSolicitud).getEstado();
        if (respuestaDAO.load(idRespuesta) != null) throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ID);
        if (!(estado.equals("Activa")) && !(estado.equalsIgnoreCase("en proceso"))) {
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_ANSWER);
        }
        respuestaDAO.save(new Respuesta(idRespuesta, nombre, comentarios), idUsuario, idSolicitud);
    }

    @Override
    public List<Respuesta> consultarRespuestas() throws ExcepcionSolidaridad, PersistenceException {
            return respuestaDAO.loadAll();
    }

    @Override
    public Respuesta consultarRespuestaId(String id) throws ExcepcionSolidaridad, PersistenceException {
            return respuestaDAO.load(id);
    }

    @Override
    public List<Respuesta> consultarRespuestasUsuario(String nombre) throws ExcepcionSolidaridad, PersistenceException {
            return respuestaDAO.loadByUser(nombre);
    }

    @Override
    public List<Respuesta> consultarRespuestasSolicitud(String nombre) throws ExcepcionSolidaridad, PersistenceException {
            return respuestaDAO.loadByApplication(nombre);
    }

    @Override
    public List<Respuesta> consultarRespuestasSolicitudesUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException{
        return respuestaDAO.loadByApplicationUser(idUsuario);
    }

    @Override
    public void eliminarRespuesta(String id) throws ExcepcionSolidaridad, PersistenceException {
        respuestaDAO.delete(id);
    }

    @Override
    public HashMap<String,Integer> consultarCantidadPorCategorias() throws ExcepcionSolidaridad, PersistenceException{
        HashMap<String, Integer> reporte = new HashMap<>();
        for (Categoria categoria : consultarCategorias()){
            String nombre = categoria.getNombre();
            int necesidades = consultarNecesidadesCategoria(nombre).size();
            int ofertas = consultarOfertasCategoria(nombre).size();
            reporte.put(nombre, necesidades + ofertas);
        }
        return reporte;
    }

    @Override
    public TreeMap<Integer, HashMap<String, int[]>> reporteCategorias() throws ExcepcionSolidaridad, PersistenceException {
        TreeMap<Integer, HashMap<String, int[]>> estadisticas =  new TreeMap<>();
        for (Categoria categoria : consultarCategorias()){
            String nombre = categoria.getNombre();
            int necesidades = consultarNecesidadesCategoria(nombre).size();
            int ofertas = consultarOfertasCategoria(nombre).size();
            HashMap<String, int[]> categorias = new HashMap<>();
            if (estadisticas.containsKey(necesidades + ofertas)){
                categorias = estadisticas.get(necesidades + ofertas);
            }
            int cantidades[] = {necesidades, ofertas};
            categorias.put(nombre, cantidades);
            estadisticas.put(necesidades + ofertas, categorias);
        }
        return estadisticas;
    }

    @Override
    public String getNumeroSolicitudes() {
        String result = "";
        try{
            Properties prop = new Properties();
            String propFile = "src/main/resources/config.properties";
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
            result = prop.getProperty("numSolicitudes");
        } catch (IOException  e){
            e.printStackTrace();
        } finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void actualizarNumeroSolicitudes(int nuevoNumero) throws ExcepcionSolidaridad, PersistenceException{
        if (nuevoNumero < consultarSolicitudes().size()){
            throw new ExcepcionSolidaridad(ExcepcionSolidaridad.INVALID_NUM_SOLICITUDES);
        }
        try{
            PropertiesConfiguration conf = new PropertiesConfiguration("src/main/resources/config.properties");
            conf.setProperty("numSolicitudes", nuevoNumero + "");
            conf.save();    
        } catch (ConfigurationException  e){
            e.printStackTrace();
        }
    }
}
