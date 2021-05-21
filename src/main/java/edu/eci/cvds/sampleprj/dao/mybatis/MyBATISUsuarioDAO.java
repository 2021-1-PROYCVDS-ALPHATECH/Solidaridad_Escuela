package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;


import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;


/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 26/04/2021 v2.0
 */
public class MyBATISUsuarioDAO implements UsuarioDAO{

    @Inject
    private UsuarioMapper usuarioMapper;
    
    @Override
    public void save(Usuario u) throws PersistenceException{
        try{
            usuarioMapper.registrarUsuario(u);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar usuario " + u.toString(), e);
        }
    }

    @Override
    public List<Usuario> loadAll() throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuarios();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar usuarios " + e);
        }
    }

    @Override
    public Usuario load(String idUsuario) throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuario(idUsuario);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el usuario " + idUsuario + e);
        }
    }

    @Override
    public Usuario loadByName(String nombre) throws PersistenceException{
        try{
            return usuarioMapper.consultarUsuarioNombre(nombre);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el usuario con nombre " + nombre + e);
        }
    }

    @Override
    public List<Usuario> loadByRol(String rol) throws PersistenceException{
        try{
            return usuarioMapper.consultarUsuariosRol(rol);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar usuarios con rol " + rol + e);
        }
    }

    @Override
    public void delete(String idUsuario) throws PersistenceException {
        try {
            usuarioMapper.eliminarUsuario(idUsuario);
        } catch (Exception e) {
            throw new PersistenceException("Error al eliminar usuario con id: "+ idUsuario, e);
        }
        
    }
}
