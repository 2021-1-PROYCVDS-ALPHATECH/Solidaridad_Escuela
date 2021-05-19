package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Categoria;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */
public interface CategoriaDAO {

    /**
     * Guarda una nueva categoria en la base de datos
     * @param ca Nueva categoria a guardar
     * @throws PersistenceException
     */
    public void save(Categoria ca) throws PersistenceException;
    
    /**
     * Consulta todas las categorias existentes en la base de datos
     * @return Lista de Categorias con todas las categorias existentes en la base de datos 
     * @throws PersistenceException
     */
    public List<Categoria> loadAll() throws PersistenceException;
    
    /**
     * Consulta una categoria en especifico, buscandola por su id
     * @param id Id de la categoria a consultar
     * @return Categoria consultada
     * @throws PersistenceException 
     */
    public Categoria load(String id) throws PersistenceException;

    /**
     * Consulta una categoria en especifico por su nombre
     * @param nombre Nombre de la categoria a consultar
     * @return Categoria Consultada
     * @throws PersistenceException 
     */
    public Categoria loadByName(String nombre) throws PersistenceException;


    /**
     * Actualiza los valores de una categoria
     * @param id Id de la categoria a la cual se le desean cambiar los valores
     * @param nombre Nuevo nombre de la categoria
     * @param descripcion Nueva descripcion de la categoria
     * @param estado Nuevo estado de la categoria. Puede ser: Valida, Invalida
     * @throws PersistenceException
     */
    public void update(String id, String nombre, String descripcion, String estado) throws PersistenceException;    

    /**
     * Elimina una categoria de la base de datos
     * @param idCategoria Id de la categoria que se desea eliminar
     * @throws PersistenceException
     */
    public void delete(String idCategoria) throws PersistenceException;
}
