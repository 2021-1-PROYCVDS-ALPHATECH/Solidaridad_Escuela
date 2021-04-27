package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Respuesta;


/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 26/04/2021 v1.0
 */
public interface RespuestaDAO {

    public void save(Respuesta r) throws PersistenceException;

    public List<Respuesta> loadAll() throws PersistenceException;

    public List<Respuesta> loadByUser(String idUsuario) throws PersistenceException;

    public void delete(String id) throws PersistenceException;

}
