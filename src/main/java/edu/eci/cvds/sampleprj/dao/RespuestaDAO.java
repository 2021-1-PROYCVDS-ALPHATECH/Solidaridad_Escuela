package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Respuesta;


/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 26/04/2021 v1.0
 */
public interface RespuestaDAO {

    /**
     * Guarda una nueva respuesta a la base de datos
     * @param r Nueva respuesta a guardar
     * @param idUsuario Id del usuario que da dicha respuesta
     * @param idSolicitud Id de la solicitud a la cual va dirigida la respuesta
     * @throws PersistenceException
     */
    public void save(Respuesta r, String idUsuario, String idSolicitud) throws PersistenceException;

    /**
     * Consulta todas las respuestas dadas, dentro de la base de datos
     * @return Lista de respuestas consultadas
     * @throws PersistenceException
     */
    public List<Respuesta> loadAll() throws PersistenceException;

    /**
     * Consulta una respuesta por su id
     * @param id Id de la respuesta que se quiere consultar
     * @return Respuesta consultada
     * @throws PersistenceException
     */
    public Respuesta load(String id) throws PersistenceException;

    /**
     * Consulta las respuestas realizadas por un usuario en especifico
     * @param nombre Nombre del usuario que realizo las respuestas
     * @return Lista de respuestas dadas por le usuario especificado
     * @throws PersistenceException
     */
    public List<Respuesta> loadByUser(String nombre) throws PersistenceException;

    /**
     * Consulta las respuestas que se dieron a una solicitud en especifico
     * @param nombre Nombre de la solicitud a la que se le dieron respuestas
     * @return Lista de respuestas dadas a la solicitud dada
     * @throws PersistenceException
     */
    public List<Respuesta> loadByApplication(String nombre) throws PersistenceException;

    /**
     * Elimina una respuesta en especifico de la base de datos
     * @param id Id de la respuesta a eliminar
     * @throws PersistenceException
     */
    public void delete(String id) throws PersistenceException;

}
