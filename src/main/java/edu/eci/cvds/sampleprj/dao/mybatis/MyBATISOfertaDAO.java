package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import java.util.List;

import edu.eci.cvds.sampleprj.dao.OfertaDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.OfertaMapper;
import edu.eci.cvds.samples.entities.Oferta;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */

public class MyBATISOfertaDAO implements OfertaDAO {  

    @Inject
    private OfertaMapper ofertaMapper;

    @Override
    public void save(Oferta oferta) throws PersistenceException {
        try {
            ofertaMapper.registrarOferta(oferta);
        } catch (Exception e) {
            throw new PersistenceException("Error al registrar una nueva necesidad del usuario: ", e);
        }
    }

    @Override
    public List<Oferta> loadAll() throws PersistenceException {
        try {
            return ofertaMapper.consultarOferta();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar las necesidades ",e);
        }
    }
}
