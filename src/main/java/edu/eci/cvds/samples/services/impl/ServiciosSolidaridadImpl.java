package edu.eci.cvds.samples.services.impl;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionSolidaridadEscuela;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;

public class ServiciosSolidaridadImpl implements ServiciosSolidaridad{

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private CategoriaDAO categoriaDAO;

    @Inject
    private NecesidadDAO necesidadDAO;

    @Transactional
    @Override
    public void registrarUsuario(Usuario u) throws ExcepcionSolidaridadEscuela {
        try{
            usuarioDAO.save(u);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al consultar los usuarios", e);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws ExcepcionSolidaridadEscuela {
        try{
            return usuarioDAO.loadAll();
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al consultar los usuarios", e);
        }
    }

    @Override
    public List<Categoria> consultarCategorias() throws ExcepcionSolidaridadEscuela {
        try{
            return categoriaDAO.loadAll();
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al consultar las categorias", e);
        }
    }

    @Transactional
    @Override
    public void registrarCategoria(String id, String nombre, String descripcion) throws ExcepcionSolidaridadEscuela {
        try{
            categoriaDAO.save(new Categoria(id, nombre, descripcion));
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al registrar la categoria: " + id + " " + nombre + " " + descripcion, e);
        }        
    }

    @Override
    public void actualizarNombreCategoria(String id, String nombre) throws ExcepcionSolidaridadEscuela {
        try{
            categoriaDAO.updateName(id, nombre);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al actualizar el nombre de la categoria con ID " + id, e);
        }
    }

    @Override
    public void actualizarDescripcionCategoria(String id, String descripcion) throws ExcepcionSolidaridadEscuela {
        try{
            categoriaDAO.updateDescription(id, descripcion);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al actualizar la descripcion de la categoria con ID " + id, e);
        }
    }

    @Override
    public void actualizarEstadoCategoria(String id, String estado) throws ExcepcionSolidaridadEscuela {
        try{
            categoriaDAO.updateState(id, estado);
        } catch (PersistenceException e){
            throw new ExcepcionSolidaridadEscuela ("Error al actualizar el estado de la categoria con ID " + id, e);
        }
        
    }

    @Override
    public void registrarNecesidades(String idNecesidad, String idUsuario, String nombre, String descripcion,
            String urgencia, String estado)
            throws ExcepcionSolidaridadEscuela {
        try {
            necesidadDAO.save(new Necesidad(idNecesidad, idUsuario, nombre, descripcion, urgencia, estado));
        } catch (Exception e) {
            throw new ExcepcionSolidaridadEscuela("Error al registrar la necesidad: "+ idNecesidad, e);
        }
        
    }

    @Override
    public void actualizarNombreNecesidad(String idNecesidad, String nombre) throws ExcepcionSolidaridadEscuela {
        try {
            necesidadDAO.updateName(idNecesidad, nombre);
        } catch (Exception e) {
            throw new ExcepcionSolidaridadEscuela("error al actualizar el nombre de la categoria con ID: "+ idNecesidad,e);
        }
        
    }

    @Override
    public void actualizarEstadoNecesidad(String idNecesidad, String estado) throws ExcepcionSolidaridadEscuela {
        try {
            necesidadDAO.updateState(idNecesidad, estado);
        } catch (Exception e) {
            throw new ExcepcionSolidaridadEscuela("Error al actualizar el estado de la categoria con ID: "+ idNecesidad, e);
        }
        
    }

    @Override
    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridadEscuela {
        try {
            return necesidadDAO.loadAll();
        } catch (Exception e) {
            throw new ExcepcionSolidaridadEscuela("Error al consultar todas las necesidades ", e);
        }
    }
}
