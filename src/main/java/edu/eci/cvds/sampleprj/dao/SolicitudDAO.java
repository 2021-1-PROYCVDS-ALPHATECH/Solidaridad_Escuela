package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Solicitud;



/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v1.0
 */
public interface SolicitudDAO {

    public void save(String id, String descripcion, String estado, String categoria, String idUsuario) throws PersistenceException;

    public List<Solicitud> loadAll() throws PersistenceException;
    
    public Solicitud load(String id) throws PersistenceException;

    public void update(String id) throws PersistenceException;

    public void delete(String idSolicitud) throws PersistenceException;
}
