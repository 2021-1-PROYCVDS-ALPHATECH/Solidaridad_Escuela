package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import java.util.List;

import edu.eci.cvds.sampleprj.dao.NecesidadDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.NecesidadMapper;
import edu.eci.cvds.samples.entities.Necesidad;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public class MyBATISNecesidadDAO implements NecesidadDAO{
    @Inject
    private NecesidadMapper necesidadMapper;

    @Override
    public void save(String idNecesidad, String nombre, String urgencia) throws PersistenceException {
        try {
            necesidadMapper.registrarNecesidad(idNecesidad, nombre, urgencia);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al registrar la necesidad " + idNecesidad, e);
        }
    }
    
    @Override
    public List<Necesidad> loadAll() throws PersistenceException {
        try {
            return necesidadMapper.consultarNecesidades();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar las necesidades ",e);
        }
    }

    public List<Necesidad> loadByUser(String idUsuario) throws PersistenceException{
        try {
            return necesidadMapper.consultarNecesidadesUsuario(idUsuario);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar las necesidades ",e);
        }
    }

    @Override
    public List<Necesidad> loadByState(String estado) throws PersistenceException {
        try {
            return necesidadMapper.consultarNecesidadesEstado(estado);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar las necesidades con estado " + estado, e);
        }
    }

    @Override
    public Necesidad load(String id) throws PersistenceException {
        try {
            return necesidadMapper.consultarNecesidad(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar la necesidad " + id,e);
        }
    }

    @Override
    public Necesidad loadByName(String nombre) throws PersistenceException {
        try {
            return necesidadMapper.consultarNecesidadNombre(nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar la necesidad con nombre " + nombre, e);
        }
    }

    @Override
    public List<Necesidad> loadByCategory(String categoria) throws PersistenceException {
        try {
            return necesidadMapper.consultarNecesidadesCategoria(categoria);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar las necesidades con categoria " + categoria, e);
        }
    }

    @Override
    public void update(String idNecesidad, String nombre) throws PersistenceException {
        try {
            necesidadMapper.actualizarNecesidad(idNecesidad, nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al actualizar la necesidad con id " + idNecesidad, e);
        }
    }

    @Override
    public void delete(String idNecesidad) throws PersistenceException {
        try {
            necesidadMapper.eliminarNecesidad(idNecesidad);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al eliminar la necesidad: " + idNecesidad, e);
        }
    }
}
