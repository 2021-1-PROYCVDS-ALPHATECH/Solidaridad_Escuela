package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Respuesta;

public interface RespuestaMapper {
    public void registrarRespuesta(@Param ("res") Respuesta r);   

    public List<Respuesta> consultarRespuestas();

    public List<Respuesta> consultarRespuestasUsuario();

    public void eliminarRespuesta(@Param("idRespuesta") String idRespuesta);
}
