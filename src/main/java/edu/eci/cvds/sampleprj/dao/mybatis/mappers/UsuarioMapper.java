package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Usuario;

import org.apache.ibatis.annotations.Param;

/**
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 20/04/2021 v1.0
 */
public interface UsuarioMapper {

    public void registrarUsuario(@Param("usuario") Usuario u);
    
    public List<Usuario> consultarUsuarios();
}
