package edu.eci.cvds.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Usuario;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public interface UsuarioDAO {

    public void save(Usuario u) throws PersistenceException;
    
    public List<Usuario> loadAll() throws PersistenceException;

}
