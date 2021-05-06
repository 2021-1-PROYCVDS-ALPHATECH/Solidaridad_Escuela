package edu.eci.cvds.sampleprj.dao;


import java.util.List;

import edu.eci.cvds.samples.entities.Necesidad;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */
public interface NecesidadDAO {

    public void save(String idNecesidad, String nombre, String urgencia) throws PersistenceException;

    public List<Necesidad> loadAll() throws PersistenceException;

    public Necesidad load(String id) throws PersistenceException;

    public Necesidad loadByName(String nombre) throws PersistenceException;

    public List<Necesidad> loadByState(String estado) throws PersistenceException;

    public void update(String id, String nombre) throws PersistenceException;
    
    public void delete(String idNecesidad) throws PersistenceException;

    public List<Necesidad> loadByUser(String idUsuario) throws PersistenceException;

}

