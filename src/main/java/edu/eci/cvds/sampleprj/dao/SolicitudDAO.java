package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Solicitud;



/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v1.0
 */
public interface SolicitudDAO {

    /**
     * Registra una Solicitud en la base de datos
     * @param id Id de la nueva solicitud a registrar
     * @param descripcion Descripcion de la solicitud
     * @param estado Estado de la solicitud, puede ser Activa, En Proceso, Resuelta y Cerrada
     * @param categoria Categoria a la cual pertenece la solicitud
     * @param idUsuario Id del usuario que crea la solicitud
     * @throws PersistenceException
     */
    public void save(String id, String descripcion, String estado, String categoria, String idUsuario) throws PersistenceException;

    /**
     * Consulta todas las Solicitudes existentes en la base de datos
     * @return Lista de las Solicitudes que hay en la base de datos 
     * @throws PersistenceException
     */
    public List<Solicitud> loadAll() throws PersistenceException;
    
    /**
     * Consulta una Solicitud por su id
     * @param id Id de la solicitud a ser consultada
     * @return Solicitud consultada por su Id
     * @throws PersistenceException
     */
    public Solicitud load(String id) throws PersistenceException;

    /**
     * Actualiza los campos de una solicitud
     * @param id Id de la solicitud que va a ser actualizada
     * @param descripcion Nueva descripcion de la solicitud
     * @param estado Nuevo estado de la solicitud, puede ser Activa, En Proceso, Resuelta y Cerrada
     * @throws PersistenceException
     */
    public void update(String id, String descripcion, String estado) throws PersistenceException;

    /**
     * Elimina una solicitud 
     * @param idSolicitud Id de la solicitud a eliminar
     * @throws PersistenceException
     */
    public void delete(String idSolicitud) throws PersistenceException;

    /**
     * Consulta las solicitudes realizadas por el usuario
     * @param idUsuario Id del usuario por el cual se van a consultar las Solicitudes
     * @return Lista de las Solicitudes consultadas 
     * @throws PersistenceException
     */
    public List<Solicitud> loadByUser(String idUsuario) throws PersistenceException;
}
