package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Usuario;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 26/04/2021 v2.0
 */
public interface UsuarioDAO {

    public void save(Usuario u) throws PersistenceException;
    
    public List<Usuario> loadAll() throws PersistenceException;

    public Usuario load(String idUsuario) throws PersistenceException;

    public Usuario loadByName(String nombre) throws PersistenceException;

    public List<Usuario> loadByRol(String rol) throws PersistenceException;

    public void updateNumApplication(String idUsuario, int numApplications) throws PersistenceException;

    public void delete(String idUsuario) throws PersistenceException;

}
