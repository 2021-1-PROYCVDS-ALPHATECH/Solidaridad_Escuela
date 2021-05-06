package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.RespuestaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RespuestaMapper;
import edu.eci.cvds.samples.entities.Respuesta;
import edu.eci.cvds.sampleprj.dao.PersistenceException;


/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 28/04/2021 v1.0
 */
public class MyBATISRespuestaDAO implements RespuestaDAO{

    @Inject
    private RespuestaMapper respuestaMapper;
    
    @Override
    public void save(Respuesta r, String idUsuario, String idSolicitud) throws PersistenceException {
        try{
            respuestaMapper.insertarRespuesta(r, idUsuario, idSolicitud);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar la respuesta", e);
        }
    }    

    @Override
    public List<Respuesta> loadAll() throws PersistenceException {
        try{
            return respuestaMapper.consultarRespuestas();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las respuestas", e);
        }
    }

    @Override
    public Respuesta load(String id) throws PersistenceException {
        try{
            return respuestaMapper.consultarRespuestaId(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las respuestas", e);
        }
    }

    @Override
    public List<Respuesta> loadByUser(String nombre) throws PersistenceException {
        try{
            return respuestaMapper.consultarRespuestasUsuario(nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las respuestas del usuario " + nombre , e);
        }
    }

    @Override
    public List<Respuesta> loadByApplication(String nombre) throws PersistenceException {
        try{
            return respuestaMapper.consultarRespuestasUsuario(nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las respuestas de la solicitud " + nombre , e);
        }
    }

    @Override
    public void delete(String id) throws PersistenceException {
        try{
            respuestaMapper.eliminarRespuesta(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al eliminar la respuesta con id: " + id , e);
        }
    }
}
