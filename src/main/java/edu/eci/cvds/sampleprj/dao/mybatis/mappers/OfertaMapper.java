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

    public void registrarOferta(@Param ("oferta") Oferta o);

    public List<Oferta> consultarOferta();
    
}
