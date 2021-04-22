package edu.eci.cvds.sampleprj.dao;


import java.util.List;

import edu.eci.cvds.samples.entities.Necesidad;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public interface NecesidadDAO {

    /**
     * 
     * @return
     * @throws PersistenceException
     */
    public List<Necesidad> loadAll() throws PersistenceException;

    /**
     * 
     * @param necesidad
     * @throws PersistenceException
     */
    public void save (Necesidad necesidad) throws PersistenceException;

    /**
     * 
     * @param idNecesidad
     * @param nombre
     * @throws PersistenceException
     */
    public void updateName(String idNecesidad, String nombre) throws PersistenceException;

    /**
     * 
     * @param idNecesidad
     * @param estado
     * @throws PersistenceException
     */
    public void updateState(String idNecesidad, String estado) throws PersistenceException;

}

