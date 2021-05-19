package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Necesidad;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public interface NecesidadMapper {

    /**
     * Guarda una nueva necesidad en la base de datos
     * @param idNecesidad Id de la nueva necesidad a guardar
     * @param nombre Nombre de la nueva necesidad
     * @param urgencia Urgencia de la nueva necesidad
     */
    public void registrarNecesidad(@Param("id") String idNecesidad,
                                    @Param("nombre") String nombre,
                                    @Param("urg") String urgencia);

    /**
     * Consulta todas las necesidades existentes en la base de datos
     * @return Lista de todas las necesidades que existen en la base de datos
     */
    public List<Necesidad> consultarNecesidades();

    /**
     * Consulta una necesidad en especifico por su id
     * @param idUsuario Id de la necesidad que se va a consultar en la base de datos
     * @return Necesidad consultada por su id
     */
    public List<Necesidad> consultarNecesidadesUsuario(@Param("idUsuario") String idUsuario);

    /**
     * Consulta las necesidades que esten en el mismo estado
     * @param estado Estado por el cual se van a listar las necesidades. Este puede ser: Activa, En Proceso, Resuelta, Cerrada
     * @return Lista de necesidades que tienen el mismo estado que se ingreso
     */
    public List<Necesidad> consultarNecesidadesEstado(@Param("estado") String estado);

    /**
     * Consulta todas las necesidades que pertenezcan a una misma categoria
     * @param categoria Categoria por la cual se van a consultar las Necesidades
     * @return Lista de Necesidades consultadas
     */
    public List<Necesidad> consultarNecesidadesCategoria(@Param("categoria") String categoria);

    /**
     * Consulta una necesidad en especifico por su id
     * @param id Id de la necesidad que se va a consultar en la base de datos
     * @return Necesidad consultada por su id
     * @return
     */
    public Necesidad consultarNecesidad(@Param("id") String idNecesidad);

    /**
     * Consulta una necesidad en especifico por su nombre
     * @param nombre Nombre de la necesidad a consultar
     * @return Necesidad consultada
     */
    public Necesidad consultarNecesidadNombre(@Param("nombre") String nombre);

    /**
     * Actualiza algunos valores de una necesidad en especifico
     * @param idNecesidad Id de la necesidad a la cual se le van a cambiar los valores
     * @param nombre Nuevo nombre de la necesidad, el cual va a ser actualizado
     */
    public void actualizarNecesidad(@Param("id") String idNecesidad,
                                    @Param("nombre") String nombre);

    /**
     * Elimina una necesidad de la base de datos
     * @param idNecesidad Id de la necesidad que se va a eliminar
     */
    public void eliminarNecesidad(@Param("idNecesidad") String idNecesidad);
}
