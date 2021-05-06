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

    public void registrarNecesidad(@Param("id") String idNecesidad,
                                    @Param("nombre") String nombre,
                                    @Param("urg") String urgencia);


    public List<Necesidad> consultarNecesidades();

    public List<Necesidad> consultarNecesidadesUsuario(@Param("idUsuario") String idUsuario);

    public List<Necesidad> consultarNecesidadesEstado(@Param("estado") String estado);

    public Necesidad consultarNecesidad(@Param("id") String idNecesidad);

    public Necesidad consultarNecesidadNombre(@Param("nombre") String nombre);

    public void actualizarNecesidad(@Param("id") String idNecesidad,
                                    @Param("nombre") String nombre);

    public void eliminarNecesidad(@Param("idNecesidad") String idNecesidad);
}
