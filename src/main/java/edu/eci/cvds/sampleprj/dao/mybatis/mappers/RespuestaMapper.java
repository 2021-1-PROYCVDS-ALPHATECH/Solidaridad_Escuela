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
    
    public void insertarRespuesta(@Param ("res") Respuesta r,
                                    @Param("idUs") String idUsuario,
                                    @Param("idSol") String idSolicitud);   

    public List<Respuesta> consultarRespuestas();

    public Respuesta consultarRespuestaId(@Param("id") String idRespuesta);

    public List<Respuesta> consultarRespuestasUsuario(@Param ("nombre") String nombre);

    public List<Respuesta> consultarRespuestasSolicitud(@Param ("nombre") String nombre);

    public void eliminarRespuesta(@Param("idRespuesta") String idRespuesta);
}
