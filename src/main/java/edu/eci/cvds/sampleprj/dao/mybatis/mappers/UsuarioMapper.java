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

    /**
     * Registra un nuevo usuario
     * @param u Nuevo usuario a ser registrado
     */
    public void registrarUsuario(@Param("usuario") Usuario u);
    
    /**
     * Consulta todos los usuarios 
     * @return Lista con todos los Usuarios
     */
    public List<Usuario> consultarUsuarios();

    /**
     * Consulta un usuario en especifico por su Id
     * @param id Id del usuario a ser consultado
     * @return Usuario consultado
     */
    public Usuario consultarUsuario(@Param("id") String id);

    /**
     * Consulta un usuario en especifico a travez de su nombre
     * @param nombre Nombre del usuario a ser consultado
     * @return Usuario consultado
     */
    public Usuario consultarUsuarioNombre(@Param("nombre") String nombre);

    /**
     * Consulta los usuarios que pertenezcan a un mismo rol
     * @param rol Rol por el cual se van a consultar a los usuarios. Pueden ser: Administrador, Estudiante, Profesor, Egresado o Administrativo
     * @return Lista de Usuarios consultados
     * @return
     */
    public List<Usuario> consultarUsuariosRol(@Param("rol") String rol);

    /**
     * Actualiza el numerdo de Solicitudes que puede realizar un usuario 
     * @param idUsuario Id del usuario al que se le van a actualizar el numero de solicitudes
     * @param numSolicitudes Nuevo numero de solicitudes, no puede ser menor al numero que ya tenia anteriormente el Usuario
     */
    public void actualizarNumSolicitudes(@Param("id") String idUsuario,
                                        @Param("num") int numSolicitudes);

    /**
     * ELimina un Usuario por su ID
     * @param idUsuario ID del usuario a eliminar
     */
    public void eliminarUsuario(@Param("idUsuario") String idUsuario);
}
