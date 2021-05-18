package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samples.entities.Categoria;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public class MyBATISCategoriaDAO implements CategoriaDAO{

    @Inject
    private CategoriaMapper categoriaMapper;

    @Override
    public void save(Categoria ca) throws PersistenceException {
        try{
            categoriaMapper.insertarCategoria(ca);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println(e.getMessage());
            throw new PersistenceException("Error al registrar la categoria" + ca.toString(), e);
        }   
    }

    @Override
    public List<Categoria> loadAll() throws PersistenceException {
        try{
            return categoriaMapper.consultarCategorias();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar las categorias", e);
        }
    }

    @Override
    public Categoria load(String id) throws PersistenceException {
        try{
            return categoriaMapper.consultarCategoria(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar la categoria: " + id, e);
        }
    }

    @Override
    public Categoria loadByName(String nombre) throws PersistenceException {
        try{
            return categoriaMapper.consultarCategoriaNombre(nombre);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar la categoria con nombre: " + nombre, e);
        }
    }

    @Override
    public void update(String id, String nombre, String descripcion, String estado) throws PersistenceException {
        try{
            categoriaMapper.actualizarCategoria(id, nombre, descripcion, estado);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar la categoria: " + id, e);
        }   
    }

    @Override
    public void delete(String idCategoria) throws PersistenceException {
        try {
            categoriaMapper.eliminarCategoria(idCategoria);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al eliminar la categoria: " + idCategoria, e);
        }
    }
}
