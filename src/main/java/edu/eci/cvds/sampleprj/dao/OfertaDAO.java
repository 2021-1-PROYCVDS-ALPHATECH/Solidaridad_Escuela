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
     * Guarda una nueva oferta en la base de datos
     * @param idOferta Id de la nueva oferta a guardar
     * @param nombre Nombre de la nueva oferta
     * @throws PersistenceException
     */
    public void save (String idOferta, String nombre) throws PersistenceException;

    /**
     * Consulta todas las ofertas existentes en la base de datos
     * @return Lista de todas las ofertas quee xisten en la base de datos
     * @throws PersistenceException
     */
    public List<Oferta> loadAll() throws PersistenceException;

    /**
     * Consulta todas las ofertas existentes en la base ded atos realizadas por un usuario en especifico
     * @param idUsuario Id del usuario que relalizo las ofertas
     * @return Lista de ofertas que haya realizado un usuario en especifico
     * @throws PersistenceException
     */
    public List<Oferta> loadByUser(String idUsuario) throws PersistenceException;

    /**
     * Consulta todas las ofertas que tengan el mismo estado
     * @param estado Estado por el cual se van a listar las ofertas
     * @return Lista de ofertas que comparten un mismo estado
     * @throws PersistenceException
     */
    public List<Oferta> loadByState(String estado) throws PersistenceException;

    /**
     * Consulta todas las ofertas que pertenezcan a una misma categoria
     * @param categoria Categoria por la cual se van a consultar las ofertas
     * @return Lista de Ofertas consultadas
     * @throws PersistenceException
     */
    public List<Oferta> loadByCategory(String categoria) throws PersistenceException;

    /**
     * Consulta una oferta por su Id
     * @param id Id de la oferta a consultar
     * @return Oferta consultada
     * @throws PersistenceException
     */
    public Oferta load(String id) throws PersistenceException;

    /**
     * Consulta una oferta en especifico por su nombre
     * @param nombre Nombre de la oferta a consultar
     * @return Oferta consultada por su nombre
     * @throws PersistenceException
     */
    public Oferta loadByName(String nombre) throws PersistenceException;

    /**
     * Actualiza algunos valores de una oferta
     * @param id Id de la oferta a la cual se le van a actualizar los datos
     * @param nombre Nuevo nombre de la oferta a actualizar
     * @throws PersistenceException
     */
    public void update(String id, String nombre) throws PersistenceException;

    /**
     * Elimina una oferta de la base de datos
     * @param idOferta Id de la oferta a eliminar
     * @throws PersistenceException
     */
    public void delete(String idOferta) throws PersistenceException;
    
}
