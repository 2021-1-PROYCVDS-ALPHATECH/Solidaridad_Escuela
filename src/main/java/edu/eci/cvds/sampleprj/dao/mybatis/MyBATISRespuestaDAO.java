package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import edu.eci.cvds.sampleprj.dao.RespuestaDAO;
import edu.eci.cvds.samples.entities.Respuesta;
import edu.eci.cvds.sampleprj.dao.PersistenceException;


public class MyBATISRespuestaDAO implements RespuestaDAO{
    
    public void save(Respuesta r) throws PersistenceException{

        // Auto complete
    }

    public List<Respuesta> loadAll() throws PersistenceException{
        return null;
    }

    public List<Respuesta> loadByUser(String idUsuario) throws PersistenceException{
        return null;
    }

    @Override
    public void delete(String id) throws PersistenceException {
        try {
            
        } catch (Exception e) {
            throw new PersistenceException("Error al eliminar la respuesta: " + id,e);
        }
        
    }
}
