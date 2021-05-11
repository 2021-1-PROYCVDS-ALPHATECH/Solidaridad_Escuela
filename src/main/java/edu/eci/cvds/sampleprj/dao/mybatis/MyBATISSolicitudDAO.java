package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;


import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.SolicitudDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.SolicitudMapper;
import edu.eci.cvds.samples.entities.Solicitud;



/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public class MyBATISSolicitudDAO implements SolicitudDAO{

    @Inject
    private SolicitudMapper solicitudMapper;

    public void save(String id, String descripcion, String estado, String categoria, String idUsuario) throws PersistenceException{
        try{
            solicitudMapper.insertarSolicitud(id, descripcion, estado, categoria, idUsuario);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar la solicitud", e);
        }
    }

    @Override
    public List<Solicitud> loadAll() throws PersistenceException {
        try{
            return solicitudMapper.consultarSolicitudes();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las solicitudes", e);
        }
    }

    @Override
    public Solicitud load(String id) throws PersistenceException {
        try{
            return solicitudMapper.consultarSolicitud(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar la solicitud " + id, e);
        }
    }

    @Override
    public void update(String id, String descripcion, String estado) throws PersistenceException {
        try{
            solicitudMapper.actualizarSolicitud(id, descripcion, estado);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar la solicitud " + id, e);
        }
    }

    @Override
    public void delete(String idSolicitud) throws PersistenceException {
        try {
            solicitudMapper.eliminarSolicitud(idSolicitud);
        } catch (Exception e) {
            throw new PersistenceException("Error al eliminar la solicitud con id: " + idSolicitud,e);
        }
        
    }

    @Override
    public List<Solicitud> loadByUser(String idUsuario) throws PersistenceException {
        try{
            return solicitudMapper.consultarSolicitudesUsuario(idUsuario);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar las solicitudes del usuario con id: " + idUsuario, e);
        }
    }
}
