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

    public void insertarCategoria(@Param("cat") Categoria ca);
    
    public List<Categoria> consultarCategorias();

    public Categoria consultarCategoria(@Param("id") String id);

    public Categoria consultarCategoriaNombre(@Param("nombre") String nombre);

    public void actualizarCategoria(@Param("id") String id,
                            @Param("nom") String nombre,
                            @Param("desc") String descripcion, 
                            @Param("est") String estado);

    public void eliminarCategoria(@Param("idCategoria") String idCategoria);
}
