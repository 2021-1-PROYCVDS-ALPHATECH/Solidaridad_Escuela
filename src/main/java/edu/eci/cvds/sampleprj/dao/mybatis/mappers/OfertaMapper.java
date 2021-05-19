package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Oferta;
import java.util.List;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */

public interface OfertaMapper {

    /**
     * Registra una nueva oferta
     * @param idOferta Id de la oferta a ser registrada
     * @param nombre Nombre de la oferta a registrar
     */
    public void registrarOferta(@Param ("id") String idOferta, 
                                @Param("nombre") String nombre);

    /**
     * Consulta todas las ofertas existentes
     * @return Lista de las Ofertas consultadas
     */
    public List<Oferta> consultarOfertas();

    /**
     * Consulta todas las ofertas realizadas por un usuario
     * @param idUsuario ID del Usuarioo que realizo las ofertas
     * @return Lista de las Ofertas consultadas
     */
    public List<Oferta> consultarOfertasUsuario(@Param("idUsuario") String idUsuario);

    /**
     * Consulta todas las ofertas que tengan el mismo estado en comun
     * @param estado Estado por el cual se va a consultar las Ofertas. Puede ser: Activa, En Proceso, Resuelta, Cerrada
     * @return Lista de Ofertas que tienen el mismo estado
     */
    public List<Oferta> consultarOfertasEstado(@Param("estado") String estado);

    /**
     * Consulta todas las Ofertas que pertenecen a una misma categoria
     * @param categoria Categoria por la que se van a consultar las Ofertas. Puede ser: Valida, Invalida
     * @return Lista de Ofertas que pertenecen a la misma categoria
     */
    public List<Oferta> consultarOfertasCategoria(@Param("categoria") String categoria);

    /**
     * Consulta una oferta por su ID
     * @param id Id de la oferta a consultar
     * @return Oferta consultada por su ID
     */
    public Oferta consultarOferta(@Param("id") String id);

    /**
     * Consulta una oferta por su nombre
     * @param nombre Nombre por el cual se va a consultar una oferta
     * @return Oferta consultada por su nombre
     */
    public Oferta consultarOfertaNombre(@Param("nombre") String nombre);
    
    /**
     * Actualiza una oferta con un nuevo nombre
     * @param idOferta Id de la oferta a actualizar
     * @param nombre Nuevo nombre de la Oferta
     */
    public void actualizarOferta(@Param("id") String idOferta,
                                @Param("nombre") String nombre);
    
    /**
     * Elimina una oferta por su ID
     * @param idOferta Id de la oferta a ser eliminada
     */
    public void eliminarOferta(@Param("idOferta") String idOferta);
}
