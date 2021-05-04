package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Categoria;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */
public interface CategoriaDAO {

    /**
     * 
     * @param ca
     * @throws PersistenceException
     */
    public void save(Categoria ca) throws PersistenceException;

    public List<Categoria> loadAll() throws PersistenceException;

    public Categoria load(String id) throws PersistenceException;

    public Categoria loadByName(String nombre) throws PersistenceException;


    /**
     * 
     * @param id
     * @param nombre
     * @param descripcion
     * @param estado
     * @throws PersistenceException
     */
    public void update(String id, String nombre, String descripcion, String estado) throws PersistenceException;    

    public void delete(String idCategoria) throws PersistenceException;
}
