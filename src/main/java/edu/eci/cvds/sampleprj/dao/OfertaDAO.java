package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Oferta;
import java.util.List;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */

public interface OfertaDAO {

    /**
     * 
     * @return
     * @throws PersistenceException
     */
    public List<Oferta> loadAll() throws PersistenceException;

    public Oferta load(String id) throws PersistenceException;

    public Oferta loadByName(String nombre) throws PersistenceException;

    /**
     * 
     * @param oferta
     * @throws PersistenceException
     */
    public void save (String idOferta, String nombre) throws PersistenceException;

    public void delete(String idOferta) throws PersistenceException;
    
}
