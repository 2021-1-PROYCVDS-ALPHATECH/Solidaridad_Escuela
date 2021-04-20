package edu.eci.cvds.sampleprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import com.google.inject.Inject;

import org.apache.ibatis.jdbc.SQL;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;



public class MyBATISUsuarioDAO implements UsuarioDAO{

    @Inject
    private UsuarioMapper usuarioMapper;
    
    @Override
    public List<Usuario> loadAll() throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuarios();
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            System.out.println("Error" + e.getMessage());
            throw new PersistenceException("Error al consultar usuarios " + e);
        }
    }
    
}
