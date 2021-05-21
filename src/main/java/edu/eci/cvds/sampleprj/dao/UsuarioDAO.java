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

    /**
     * Registra un nuevo usuario
     * @param u Nuevo usuario a ser insertado en la base de datos
     * @throws PersistenceException
     */
    public void save(Usuario u) throws PersistenceException;
    
    /**
     * Consulta todos los usuarios existentes
     * @return Lista con todos los usuarios
     * @throws PersistenceException
     */
    public List<Usuario> loadAll() throws PersistenceException;

    /**
     * Consulta un usuario en especifico a travez de su ID
     * @param idUsuario ID del usuario para ser consultado
     * @return Usuario consultado
     * @throws PersistenceException
     */
    public Usuario load(String idUsuario) throws PersistenceException;

    /**
     * Consulta un usuario en especifico a travez de su nombre
     * @param nombre Nombre del usuario a ser consultado
     * @return Usuario consultado
     * @throws PersistenceException
     */
    public Usuario loadByName(String nombre) throws PersistenceException;

    /**
     * Consulta los usuarios que pertenezcan a un mismo rol
     * @param rol Rol por el cual se van a consultar a los usuarios. Pueden ser: Administrador, Estudiante, Profesor, Egresado o Administrativo
     * @return Lista de Usuarios consultados
     * @throws PersistenceException
     */
    public List<Usuario> loadByRol(String rol) throws PersistenceException;

    /**
     * ELimina un Usuario por su ID
     * @param idUsuario ID del usuario a eliminar
     * @throws PersistenceException
     */
    public void delete(String idUsuario) throws PersistenceException;

}
