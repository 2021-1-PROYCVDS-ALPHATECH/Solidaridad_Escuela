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

    public void save (String idOferta, String nombre) throws PersistenceException;

    public List<Oferta> loadAll() throws PersistenceException;

    public List<Oferta> loadByUser(String idUsuario) throws PersistenceException;

    public List<Oferta> loadByState(String estado) throws PersistenceException;

    public List<Oferta> loadByCategory(String categoria) throws PersistenceException;

    public Oferta load(String id) throws PersistenceException;

    public Oferta loadByName(String nombre) throws PersistenceException;

    public void update(String id, String nombre) throws PersistenceException;

    public void delete(String idOferta) throws PersistenceException;
    
}
