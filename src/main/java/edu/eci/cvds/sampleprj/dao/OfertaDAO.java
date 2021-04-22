package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Oferta;
import java.util.List;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */

public interface OfertaDAO {

    /**
     * 
     * @return
     * @throws PersistenceException
     */
    public List<Oferta> loadAll() throws PersistenceException;

    /**
     * 
     * @param oferta
     * @throws PersistenceException
     */
    public void save (Oferta oferta) throws PersistenceException;
    
}
