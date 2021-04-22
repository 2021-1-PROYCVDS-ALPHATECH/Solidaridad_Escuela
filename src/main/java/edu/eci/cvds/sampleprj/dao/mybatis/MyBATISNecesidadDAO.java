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
    public void save(Necesidad necesidad) throws PersistenceException {
        try {
            necesidadMapper.registrarNecesidades(necesidad);
        } catch (Exception e) {
            throw new PersistenceException("Error al registrar una nueva necesidad del usuario: ", e);
        }
    }

    @Override
    public void updateName(String idNecesidad, String nombre) throws PersistenceException {
        try {
            necesidadMapper.actualizarNombre(idNecesidad, nombre);
        } catch (Exception e) {
            throw new PersistenceException("Error al actualizar el nombre", e);
        }
        
    }

    @Override
    public void updateState(String idNecesidad, String estado) throws PersistenceException {
        try {
            necesidadMapper.actualizarEstado(idNecesidad, estado);
        } catch (Exception e) {
            throw new PersistenceException("Eror al actualizar el estado de la necesidad", e);
        }
        
    }

    @Override
    public List<Necesidad> loadAll() throws PersistenceException {
        try {
            return necesidadMapper.consultarNecesidades();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar las necesidades ",e);
        }
    }
}
