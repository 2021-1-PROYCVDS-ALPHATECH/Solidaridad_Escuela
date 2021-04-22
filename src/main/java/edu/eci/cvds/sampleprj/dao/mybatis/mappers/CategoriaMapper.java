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
 * @version 20/04/2021 v1.0
 */
public interface CategoriaMapper{

    public List<Categoria> consultarCategorias();

    public void insertarCategoria(@Param("cat") Categoria ca);

    public void actualizarNombre(@Param("id") String id,
                                @Param("nom") String nombre);
    
    public void actualizarDescripcion(@Param("id") String id,
                                    @Param("des") String descripcion);

    public void actualizarEstado(@Param("id") String id,
                                @Param("est") String estado);
    
}
