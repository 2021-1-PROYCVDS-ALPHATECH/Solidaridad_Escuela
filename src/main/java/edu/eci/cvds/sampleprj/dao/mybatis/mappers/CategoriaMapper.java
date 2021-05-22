package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Categoria;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */
public interface CategoriaMapper{

    /**
     * Guarda una nueva categoria en la base de datos
     * @param ca Nueva categoria a guardar
     */
    public void insertarCategoria(@Param("cat") Categoria ca);
    
    /**
     * Consulta todas las categorias existentes en la base de datos
     * @return Lista de Categorias con todas las categorias existentes en la base de datos 
     */
    public List<Categoria> consultarCategorias();

    /**
     * Consulta una categoria en especifico, buscandola por su id
     * @param id Id de la categoria a consultar
     * @return Categoria consultada
     */
    public Categoria consultarCategoria(@Param("id") String id);

    /**
     * Consulta una categoria en especifico por su nombre
     * @param nombre Nombre de la categoria a consultar
     * @return Categoria Consultada
     */
    public Categoria consultarCategoriaNombre(@Param("nombre") String nombre);

    /**
     * Actualiza los valores de una categoria
     * @param id Id de la categoria a la cual se le desean cambiar los valores
     * @param nombre Nuevo nombre de la categoria
     * @param descripcion Nueva descripcion de la categoria
     * @param estado Nuevo estado de la categoria. Puede ser: Valida, Invalida
     */
    public void actualizarCategoria(@Param("id") String id,
                            @Param("nom") String nombre,
                            @Param("desc") String descripcion, 
                            @Param("est") String estado,
                            @Param("com") String comentario);

    /**
     * Elimina una categoria de la base de datos
     * @param idCategoria Id de la categoria que se desea eliminar
     */
    public void eliminarCategoria(@Param("idCategoria") String idCategoria);
}
