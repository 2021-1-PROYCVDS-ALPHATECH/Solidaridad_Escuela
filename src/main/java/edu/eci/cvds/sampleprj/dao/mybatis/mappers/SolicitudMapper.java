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

    public void insertarSolicitud(@Param("id") String id, 
                                    @Param("desc") String descripcion,
                                    @Param("estado") String estado,
                                    @Param("categoria") String categoria,
                                    @Param("idUsuario") String idUsuario);
                                    
    public List<Solicitud> consultarSolicitudes();

    public List<Solicitud> consultarSolicitudesUsuario(@Param("idUsuario") String idUsuario);

    public Solicitud consultarSolicitud(@Param("id") String id);
    
    public void actualizarSolicitud(@Param("id") String id,
                                    @Param("desc") String descripcion,
                                    @Param("estado") String estado);

    public void eliminarSolicitud(@Param("idSolicitud") String idSolicitud);

}
