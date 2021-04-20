package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Categoria;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public interface CategoriaDAO {
 
    public List<Categoria> loadAll() throws PersistenceException;

    public void save (Categoria ca) throws PersistenceException;

    public void updateName (String id, String name) throws PersistenceException;

    public void updateDescription (String id, String description) throws PersistenceException;

    public void updateState (String id, String state) throws PersistenceException;

    
}
