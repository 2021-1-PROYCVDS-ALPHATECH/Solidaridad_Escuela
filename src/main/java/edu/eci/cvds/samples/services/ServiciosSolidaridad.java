package edu.eci.cvds.samples.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;

/**
 * Interfaz para los servicios ofrecidos por la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 22/04/2021 v2.0
 */
public interface ServiciosSolidaridad {

    /**
     * Registra un nuevo Usuario
     * @param id Id del Nuevo Usuario
     * @param nombre Nombre del nuevo usuario
     * @param telefono Telefono del nuevo usuario
     * @param email Email del nuevo usuario
     * @param clave Clave del nuevo usuario
     * @param rol Rol del nuevo Usuario. Puede ser ADministrador, Estudiante, Profesor, Egresado o Administrativo
     * @param num Numero de Solicitudes que puede tener
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void registrarUsuario(String id, String nombre, String telefono, String email, String clave, String rol, int num) throws ExcepcionSolidaridad, PersistenceException;
    
    /**
     * Consulta todos los Usuarios existentes
     * @return Usuarios consultados
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Usuario> consultarUsuarios() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta un Usuario en especifico por su Id
     * @param idUsuario Id del Usuario a consultar
     * @return Usuario consultado
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Usuario consultarUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta un Usuario por su nombre
     * @param nombre Nombre por el cual se va a consultar al Usuario
     * @return Usuario consultado
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Usuario consultarUsuarioNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta los usuarios que pertenezcan a un mismo rol
     * @param rol Rol por el cual se van a consultar a los usuarios. Pueden ser: Administrador, Estudiante, Profesor, Egresado o Administrativo
     * @return Lista de Usuarios consultados
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Usuario> consultarUsuariosRol(String rol) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Actualiza el numerdo de Solicitudes que puede realizar un usuario 
     * @param idUsuario Id del usuario al que se le van a actualizar el numero de solicitudes
     * @param numSolicitudes Nuevo numero de solicitudes, no puede ser menor al numero que ya tenia anteriormente el Usuario
     * @throws ExcepcionSolidaridad
     */
    public abstract void actualizarNumSolicitudes(String idUsuario, int numSolicitudes) throws ExcepcionSolidaridad;

    /**
     * ELimina un Usuario por su ID
     * @param idUsuario ID del usuario a eliminar
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void eliminarUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Registra una nueva Categoria
     * @param id Id de la nueva Categoria
     * @param nombre Nombre de la nueva Categoria
     * @param descripcion Descripcion de la nueva Categoria
     * @param estado Estado de la nueva Categoria. Puede ser: Valida, Invalida
     * @param comentario Comentario de la nueva Categoria
     * @throws ExcepcionSolidaridad
     */
    public abstract void registrarCategoria(String id, String nombre, String descripcion, String estado, String comentario) throws ExcepcionSolidaridad;

    /**
     * Consulta todas las categorias existentes en la base de datos
     * @return Lista de Categorias con todas las categorias existentes en la base de datos 
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Categoria> consultarCategorias() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta una categoria en especifico, buscandola por su id
     * @param id Id de la categoria a consultar
     * @return Categoria consultada
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Categoria consultarCategoriaId(String id) throws ExcepcionSolidaridad, PersistenceException;
    
    /**
     * Consulta una categoria en especifico por su nombre
     * @param nombre Nombre de la categoria a consultar
     * @return Categoria Consultada
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Categoria consultarCategoriaNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Actualiza los valores de una categoria
     * @param id Id de la categoria a la cual se le desean cambiar los valores
     * @param nombre Nuevo nombre de la categoria
     * @param descripcion Nueva descripcion de la categoria
     * @param estado Nuevo estado de la categoria. Puede ser: Valida, Invalida
     * @throws ExcepcionSolidaridad
     */
    public abstract void actualizarCategoria(String id, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad;

    /**
     * Elimina una categoria de la base de datos
     * @param idCategoria Id de la categoria que se desea eliminar
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void eliminarCategoria(String idCategoria) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Registra una Solicitud en la base de datos
     * @param id Id de la nueva solicitud a registrar
     * @param descripcion Descripcion de la solicitud
     * @param estado Estado de la solicitud, puede ser Activa, En Proceso, Resuelta y Cerrada
     * @param categoria Categoria a la cual pertenece la solicitud
     * @param idUsuario Id del usuario que crea la solicitud
     * @throws ExcepcionSolidaridad
     */
    public abstract void registrarSolicitud(String id, String descripcion, String estado, String categoria, String idUsuario) throws ExcepcionSolidaridad;

    /**
     * Consulta todas las Solicitudes existentes en la base de datos
     * @return Lista de las Solicitudes que hay en la base de datos 
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Solicitud> consultarSolicitudes() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta las solicitudes realizadas por el usuario
     * @param idUsuario Id del usuario por el cual se van a consultar las Solicitudes
     * @return Lista de las Solicitudes consultadas 
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Solicitud> consultarSolicitudesUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException;
    
    /**
     * Consulta una Solicitud por su id
     * @param id Id de la solicitud a ser consultada
     * @return Solicitud consultada por su Id
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Solicitud consultarSolicitudId(String id) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Actualiza los campos de una solicitud
     * @param id Id de la solicitud que va a ser actualizada
     * @param descripcion Nueva descripcion de la solicitud
     * @param estado Nuevo estado de la solicitud, puede ser Activa, En Proceso, Resuelta y Cerrada
     * @throws ExcepcionSolidaridad
     */
    public abstract void actualizarSolicitud(String id, String descripcion, String estado) throws ExcepcionSolidaridad;

    /**
     * Consulta las solicitudes realizadas por el usuario
     * @param idUsuario Id del usuario por el cual se van a consultar las Solicitudes
     * @return Lista de las Solicitudes consultadas 
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void eliminarSolicitud(String idSolicitud) throws ExcepcionSolidaridad, PersistenceException;
    
    /**
     * Registra una nueva Necesidad
     * @param idNecesidad Id de la nueva Necesidad
     * @param idUsuario Id del Usuario que creo la Necesidad
     * @param nombre Nombre de la nueva Necesidad
     * @param descripcion Descripcion de la Necesidad
     * @param urgencia Urgencia de la Necesidad
     * @param estado Estado de la Necesidad. Puede ser Activa, En Proceso, Resuelta y Cerrada
     * @param categoria Categoria a la que pertenece la Necesidad
     * @throws ExcepcionSolidaridad
     */
    public abstract void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado, String categoria) throws ExcepcionSolidaridad;

    /**
     * Consulta todas las necesidades existentes en la base de datos
     * @return Lista de todas las necesidades que existen en la base de datos
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta las necesidades que creo un usuario en especifico
     * @param idUsuario Id del usuario que hizo las necesidades, para que estas puedan ser consultadas y listadas
     * @return Lista de las necesidades creadas por un usuario especifico
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Necesidad> consultarNecesidadesUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta todas las necesidades y devuelve un HashMap con el numero de necesidades que pertenecen a cada estado existente
     * @return HashMap con el numero de Necesidades que existen por cada estado existente
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract HashMap<String, Integer> consultarNecesidadesEstado() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta todas las necesidades que pertenezcan a una misma categoria
     * @param nombre Categoria por la cual se van a consultar las Necesidades
     * @return Lista de Necesidades consultadas
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Necesidad> consultarNecesidadesCategoria(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta una necesidad en especifico por su id
     * @param id Id de la necesidad que se va a consultar en la base de datos
     * @return Necesidad consultada por su id
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Necesidad consultarNecesidadId(String id) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta una necesidad en especifico por su nombre
     * @param nombre Nombre de la necesidad a consultar
     * @return Necesidad consultada
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Necesidad consultarNecesidadNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Actualiza algunos valores de una Necesidad
     * @param idNecesidad Id de la necesidad a la cual se le van a cambiar los valores
     * @param nombre Nuevo nombre de la Necesidad
     * @param descripcion Nueva descripcion de la Necesidad
     * @param estado Nuevo estado de la Necesidad. Puede ser: Abierta, En Proceso, Resuelta o Cerrada
     * @throws ExcepcionSolidaridad
     */
    public abstract void actualizarNecesidad(String idNecesidad, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad;

    /**
     * Elimina una necesidad de la base de datos
     * @param idNecesidad Id de la necesidad que se va a eliminar
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void eliminarNecesidad(String idNecesidad) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Registra una nueva Oferta
     * @param idOferta Id de la nueva Oferta
     * @param idUsuario Id del Usuario que crea esta Oferta
     * @param nombre Nombre de la nueva Oferta
     * @param descripcion Descripcion de la Nueva Oferta
     * @param estado Estado de la nueva Oferta. Pude ser: Activa, En Proceso, Resuelta o Cerrada
     * @param categoria Estado de la nueva Oferta. Puede ser: Valida o Invalida
     * @throws ExcepcionSolidaridad
     */
    public abstract void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String estado, String categoria)  throws ExcepcionSolidaridad;

    /**
     * Consulta todas las ofertas existentes en la base de datos
     * @return Lista de todas las ofertas quee xisten en la base de datos
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Oferta> consultarOfertas() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta todas las ofertas existentes en la base ded atos realizadas por un usuario en especifico
     * @param idUsuario Id del usuario que relalizo las ofertas
     * @return Lista de ofertas que haya realizado un usuario en especifico
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Oferta> consultarOfertasUsuario(String idUsuario) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta una oferta en especifico por su Id
     * @param id Id de la oferta a consultar
     * @return Oferta consultada por su Id
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Oferta consultarOfertaId(String id) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta una oferta en especifico por su nombre
     * @param nombre Nombre de la oferta a consultar
     * @return Oferta consultada por su nombre
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Oferta consultarOfertaNombre(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta todas las Ofertas y devuelve un HashMap con el numero de necesidades que pertenecen a cada estado existente
     * @return HashMap con el numero de Ofertas que existen por cada estado existente
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract HashMap<String, Integer> consultarOfertasEstado() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta todas las ofertas que pertenezcan a una misma categoria
     * @param categoria Categoria por la cual se van a consultar las ofertas
     * @return Lista de Ofertas consultadas
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Oferta> consultarOfertasCategoria(String categoria) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Actualiza algunos valores de una Oferta
     * @param idOferta Id de la Oferta a la cual se le van a actualizar los datos
     * @param nombre Nuevo nombre de la Oferta a actualizar
     * @param descripcion Nueva descripcion de la Oferta
     * @param estado Nuevo estado de la Oferta. Puede ser: Activa, En Proceso, Resuelta o Cerrada
     * @throws ExcepcionSolidaridad
     */
    public abstract void actualizarOferta(String idOferta, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad;

    /**
     * Elimina una oferta de la base de datos
     * @param idOferta Id de la oferta a eliminar
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void eliminarOferta(String idOferta) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Registra una nueva Respuesta
     * @param idRespuesta Id de la nueva Respuesta
     * @param idUsuario Id del Usuario que crea la nueva Respuesta
     * @param nombre Nombre de la nueva Respuesta
     * @param comentarios Comentarios de la nueva Respuesta
     * @param idSolicitud Id de la Solicitud a la cual se esta dando Respuesta
     * @throws ExcepcionSolidaridad
     */
    public abstract void registrarRespuesta(String idRespuesta, String idUsuario, String nombre, String comentarios, String idSolicitud) throws ExcepcionSolidaridad;

    /**
     * Consulta todas las respuestas dadas, dentro de la base de datos
     * @return Lista de respuestas consultadas
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Respuesta> consultarRespuestas() throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta una respuesta por su id
     * @param id Id de la respuesta que se quiere consultar
     * @return Respuesta consultada
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract Respuesta consultarRespuestaId(String id) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta las respuestas realizadas por un usuario en especifico
     * @param nombre Nombre del usuario que realizo las respuestas
     * @return Lista de respuestas dadas por le usuario especificado
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Respuesta> consultarRespuestasUsuario(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Consulta las respuestas que se dieron a una solicitud en especifico
     * @param nombre Nombre de la solicitud a la que se le dieron respuestas
     * @return Lista de respuestas dadas a la solicitud dada
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract List<Respuesta> consultarRespuestasSolicitud(String nombre) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Elimina una respuesta en especifico de la base de datos
     * @param id Id de la respuesta a eliminar
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract void eliminarRespuesta(String id) throws ExcepcionSolidaridad, PersistenceException;

    /**
     * Genera un reporte con todas las categorias
     * @return TreeMap compuesto de un entero y de un HashMap de las Categorias y el numero de Solicitudes y Respuestas que pertenecen a cada Categoria
     * @throws ExcepcionSolidaridad
     * @throws PersistenceException
     */
    public abstract TreeMap<Integer, HashMap<String, int[]>> reporteCategorias() throws ExcepcionSolidaridad, PersistenceException;
}
