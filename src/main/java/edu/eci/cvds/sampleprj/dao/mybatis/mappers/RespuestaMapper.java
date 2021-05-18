package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Respuesta;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 28/04/2021 v1.0
 */
public interface RespuestaMapper {
    
    /**
     * Guarda una nueva respuesta a la base de datos
     * @param r Nueva respuesta a guardar
     * @param idUsuario Id del usuario que da dicha respuesta
     * @param idSolicitud Id de la solicitud a la cual va dirigida la respuesta
     */
    public void insertarRespuesta(@Param ("res") Respuesta r,
                                    @Param("idUs") String idUsuario,
                                    @Param("idSol") String idSolicitud);   

    /**
     * Consulta todas las respuestas dadas, dentro de la base de datos
     * @return Lista de respuestas consultadas
     */
    public List<Respuesta> consultarRespuestas();
    
    /**
     * Consulta una respuesta por su id
     * @param idRespuesta Id de la respuesta que se quiere consultar
     * @return Respuesta consultada
     */
    public Respuesta consultarRespuestaId(@Param("id") String idRespuesta);

    /**
     * Consulta las respuestas realizadas por un usuario en especifico
     * @param nombre Nombre del usuario que realizo las respuestas
     * @return Lista de respuestas dadas por le usuario especificado
     */
    public List<Respuesta> consultarRespuestasUsuario(@Param ("nombre") String nombre);

    /**
     * Consulta las respuestas que se dieron a una solicitud en especifico
     * @param nombre Nombre de la solicitud a la que se le dieron respuestas
     * @return Lista de respuestas dadas a la solicitud dada
     */
    public List<Respuesta> consultarRespuestasSolicitud(@Param ("solicitud") String nombre);

    /**
     * Elimina una respuesta en especifico de la base de datos
     * @param idRespuesta Id de la respuesta a eliminar
     */
    public void eliminarRespuesta(@Param("idRespuesta") String idRespuesta);
}
