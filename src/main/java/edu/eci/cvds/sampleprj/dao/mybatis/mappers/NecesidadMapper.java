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

    public List<Necesidad> consultarNecesidades();

    public void registrarNecesidades(@Param("necesidad") Necesidad necesidad);


    public void actualizarNombre(@Param("idNecesidad") String idNecesidad,
                                @Param("nombre") String nombre);

    public void actualizarEstado(@Param("idNecesidad") String idNecesidad, 
                                @Param("estado") String estado);
}
