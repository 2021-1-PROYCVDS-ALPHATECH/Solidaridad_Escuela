package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Usuario;

import org.apache.ibatis.annotations.Param;

public interface UsuarioMapper {

    public void registrarUsuario(@Param("usuario") Usuario u);
    
    public List<Usuario> consultarUsuarios();
}
