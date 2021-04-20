package edu.eci.cvds.samples.services.impl;

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
}
