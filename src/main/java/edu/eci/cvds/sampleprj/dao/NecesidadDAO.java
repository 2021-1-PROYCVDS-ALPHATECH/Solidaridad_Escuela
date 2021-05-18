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

    /**
     * Guarda una nueva necesidad en la base de datos
     * @param idNecesidad Id de la nueva necesidad a guardar
     * @param nombre Nombre de la nueva necesidad
     * @param urgencia Urgencia de la nueva necesidad
     * @throws PersistenceException
     */
    public void save(String idNecesidad, String nombre, String urgencia) throws PersistenceException;

    /**
     * Consulta todas las necesidades existentes en la base de datos
     * @return Lista de todas las necesidades que existen en la base de datos
     * @throws PersistenceException
     */
    public List<Necesidad> loadAll() throws PersistenceException;

    /**
     * Consulta una necesidad en especifico por su id
     * @param id Id de la necesidad que se va a consultar en la base de datos
     * @return Necesidad consultada por su id
     * @throws PersistenceException
     */
    public Necesidad load(String id) throws PersistenceException;

    /**
     * Consulta una necesidad en especifico por su nombre
     * @param nombre Nombre de la necesidad a consultar
     * @return
     * @throws PersistenceException
     */
    public Necesidad loadByName(String nombre) throws PersistenceException;

    /**
     * Consulta las necesidades que esten en el mismo estado
     * @param estado Estado por el cual se van a listar las necesidades
     * @return Lista de necesidades que tienen el mismo estado que se ingreso
     * @throws PersistenceException
     */
    public List<Necesidad> loadByState(String estado) throws PersistenceException;

    /**
     * Actualiza algunos valores de una necesidad en especifico
     * @param id Id de la necesidad a la cual se le van a cambiar los valores
     * @param nombre Nuevo nombre de la necesidad, el cual va a ser actualizado
     * @throws PersistenceException
     */
    public void update(String id, String nombre) throws PersistenceException;
    
    /**
     * Elimina una necesidad de la base de datos
     * @param idNecesidad Id de la necesidad que se va a eliminar
     * @throws PersistenceException
     */
    public void delete(String idNecesidad) throws PersistenceException;

    /**
     * Consulta las necesidades que creo un usuario en especifico
     * @param idUsuario Id del usuario que hizo las necesidades, para que estas puedan ser consultadas y listadas
     * @return Lista de las necesidades creadas por un usuario especifico
     * @throws PersistenceException
     */
    public List<Necesidad> loadByUser(String idUsuario) throws PersistenceException;

}

