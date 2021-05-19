package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Solicitud;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public interface SolicitudMapper{

    /**
     * Registra una Solicitud en la base de datos
     * @param id Id de la nueva solicitud a registrar
     * @param descripcion Descripcion de la solicitud
     * @param estado Estado de la solicitud, puede ser Activa, En Proceso, Resuelta y Cerrada
     * @param categoria Categoria a la cual pertenece la solicitud
     * @param idUsuario Id del usuario que crea la solicitud
     */
    public void insertarSolicitud(@Param("id") String id, 
                                    @Param("desc") String descripcion,
                                    @Param("estado") String estado,
                                    @Param("categoria") String categoria,
                                    @Param("idUsuario") String idUsuario);
                                    
    /**
     * Consulta todas las Solicitudes existentes en la base de datos
     * @return Lista de las Solicitudes que hay en la base de datos 
     */
    public List<Solicitud> consultarSolicitudes();

    /**
     * Consulta las solicitudes realizadas por el usuario
     * @param idUsuario Id del usuario por el cual se van a consultar las Solicitudes
     * @return Lista de las Solicitudes consultadas 
     */
    public List<Solicitud> consultarSolicitudesUsuario(@Param("idUsuario") String idUsuario);

    /**
     * Consulta uns Solicitud por su id
     * @param id Id de la solicitud a ser consultada
     * @return Solicitud consultada por su Id
     */
    public Solicitud consultarSolicitud(@Param("id") String id);
    
    /**
     * Actualiza los campos de una solicitud
     * @param id Id de la solicitud que va a ser actualizada
     * @param descripcion Nueva descripcion de la solicitud
     * @param estado Nuevo estado de la solicitud, puede ser Activa, En Proceso, Resuelta y Cerrada
     */
    public void actualizarSolicitud(@Param("id") String id,
                                    @Param("desc") String descripcion,
                                    @Param("estado") String estado);

    /**
     * Elimina una solicitud 
     * @param idSolicitud Id de la solicitud a eliminar
     */
    public void eliminarSolicitud(@Param("idSolicitud") String idSolicitud);

}
