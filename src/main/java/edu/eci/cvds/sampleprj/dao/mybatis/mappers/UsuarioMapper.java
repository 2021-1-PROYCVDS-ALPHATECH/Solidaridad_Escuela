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

    public Usuario consultarUsuario(@Param("id") String id);

    public Usuario consultarUsuarioNombre(@Param("nombre") String nombre);

    public List<Usuario> consultarUsuariosRol(@Param("rol") String rol);

    public void actualizarNumSolicitudes(@Param("id") String id,
                                        @Param("num") int numSolicitudes);

    public void eliminarUsuario(@Param("idUsuario") String idUsuario);
}
