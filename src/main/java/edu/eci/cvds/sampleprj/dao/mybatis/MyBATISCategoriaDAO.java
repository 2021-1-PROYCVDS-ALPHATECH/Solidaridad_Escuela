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
    public List<Categoria> loadAll() throws PersistenceException {
        try{
            return categoriaMapper.consultarCategorias();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println("Error " + e.getMessage());
            throw new PersistenceException("Error al consultar las categorias", e);
        }
    }
    
    @Override
    public void save(Categoria ca) throws PersistenceException {
        try{
            categoriaMapper.insertarCategoria(ca);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar la categoria" + ca.toString(), e);
        }   
    }

    @Override
    public void updateName(String id, String name) throws PersistenceException {
        try{
            categoriaMapper.actualizarNombre(id, name);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar el nombre de la categoria con id = " + id, e);
        }  
    }

    @Override
    public void updateDescription(String id, String description) throws PersistenceException {
        try{
            categoriaMapper.actualizarDescripcion(id, description);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar la descripcion de la categoria con id = " + id, e);
        }  
    }

    @Override
    public void updateState(String id, String state) throws PersistenceException {
        try{
            categoriaMapper.actualizarEstado(id, state);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al actualizar el estado de la categoria con id = " + id, e);
        }  
        
    }

    
    
}
