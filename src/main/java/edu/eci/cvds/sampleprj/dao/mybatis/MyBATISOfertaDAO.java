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
    public void save(String idOferta, String nombre) throws PersistenceException {
        try {
            ofertaMapper.registrarOferta(idOferta, nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException("Error al registrar la oferta " + idOferta, e);
        }
    }

    @Override
    public List<Oferta> loadAll() throws PersistenceException {
        try {
            return ofertaMapper.consultarOfertas();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al consultar las ofertas ", e);
        }
    }

    @Override
    public Oferta load(String id) throws PersistenceException {
        try {
            return ofertaMapper.consultarOferta(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar la oferta " + id, e);
        }
    }

    @Override
    public Oferta loadByName(String nombre) throws PersistenceException {
        try {
            return ofertaMapper.consultarOfertaNombre(nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar la oferta con nombre" + nombre, e);
        }
    }

    @Override
    public void update(String idOferta, String nombre) throws PersistenceException {
        try {
            ofertaMapper.actualizarOferta(idOferta, nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al actualizar la oferta con id: " + idOferta, e);
        }
    }

    @Override
    public void delete(String idOferta) throws PersistenceException {
        try {
            ofertaMapper.eliminarOferta(idOferta);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al eliminar la oferta con id: " + idOferta, e);
        }
    }
}
