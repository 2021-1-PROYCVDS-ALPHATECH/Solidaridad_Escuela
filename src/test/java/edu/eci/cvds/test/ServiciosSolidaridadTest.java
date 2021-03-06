package edu.eci.cvds.test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Estado;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridadFactory;

public class ServiciosSolidaridadTest {

    private ServiciosSolidaridad serviciosSolidaridad;

    public ServiciosSolidaridadTest(){
        serviciosSolidaridad = ServiciosSolidaridadFactory.getInstance().getServiciosSolidaridadTesting();
    }

    /**
     * Se prueba que se tengan datos de usuario guardados previamente
     */
    @Test
    public void deberiaTenerDatosUsuarios(){
        try{
            if (serviciosSolidaridad.consultarUsuarios() == null) fail("No se encontraron datos de usuarios.");
        }catch(Exception e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se prueba que se tengan datos de categoiras guardados previamente
     */
    @Test
    public void deberiaTenerDatosCategorias(){
        try{
            if (serviciosSolidaridad.consultarCategorias() == null) fail("No se encontraron datos de categorias.");
        }catch(Exception e){
            System.out.println(e.getMessage());
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se prueba que se tengan datos de solicitudes guardados previamente
     */
    @Test
    public void deberiaTenerDatosSolicitudes(){
        try{
            if (serviciosSolidaridad.consultarSolicitudes() == null) fail("No se encontraron datos de solicitudes.");
        }catch(Exception e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se prueba que se tengan datos de necesidades guardados previamente
     */
    @Test
    public void deberiaTenerDatosNecesidades(){
        try{
            if (serviciosSolidaridad.consultarNecesidades() == null) fail("No se encontraron datos de necesidades.");
        }catch(Exception e){
            fail("Lanzo excepcion.");
        }
    }


    /**
     * Se prueba que se tengan datos de ofertas guardados previamente
     */
    @Test
    public void deberiaTenerDatosOfertas(){
        try{
            if (serviciosSolidaridad.consultarOfertas() == null) fail("No se encontraron datos de ofertas.");
        }catch(Exception e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se prueba que se tengan datos de respuestas guardados previamente
     */
    @Test
    public void deberiaTenerDatosRespuestas(){
        try{
            if (serviciosSolidaridad.consultarRespuestas() == null) fail("No se encontraron datos de respuestas.");
        }catch(Exception e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se comprueba que se registre un usuario de manera exitosa
     */
    @Test
    public void deberiaRegistrarUsuario(){
        try{
            serviciosSolidaridad.registrarUsuario("10", "Bess Woods","(345) 394-5688" , "ikagim@oleat.tf", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "Estudiante");
            if(serviciosSolidaridad.consultarUsuario("10") == null){
                fail("No se encontro el usuario.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion." + e.getMessage());
        }
    }

    /**
     * Se comprueba que se no se registre un usuario
     */
    @Test
    public void noDeberiaRegistrarUsuario(){
        try{
            serviciosSolidaridad.registrarUsuario("1", "Steve Davidson","(938) 559-6778" , "iru@pawumvap.hm", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "Estudiante");
            fail("Lanzo excepcion.");
        } catch(Exception e){
        }
    }

    /**
     * Se prueba que se pueda consultar correctamente un usuario por su nombre (que debe ser unico)
     */
    @Test
    public void deberiaConsultarPorNombre(){
        try{
            serviciosSolidaridad.registrarUsuario("11", "Christina Wood","(349) 349-3399" , "daet@dujo.ba", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "Estudiante");
            if(serviciosSolidaridad.consultarUsuarioNombre("Christina Wood") == null){
                fail("No se encontro el usuario.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion." + e.getMessage());
        }
    }

    @Test
    public void deberiaConsultarPorRol(){
        try{
            String rol = "Estudiante";
            serviciosSolidaridad.registrarUsuario("12", "Travis Cunningham","(476) 912-7578" , "ogwuz@judi.cu", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", rol);
            if(serviciosSolidaridad.consultarUsuariosRol(rol) == null || serviciosSolidaridad.consultarUsuariosRol(rol).size() < 1){
                fail("No se encontraron usuarios.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion."+ e.getMessage());
        }
    }

    @Test
    public void deberiaConsultarSolicitudesUsuario(){
        try{
            if (serviciosSolidaridad.consultarSolicitudesUsuario("2") == null) fail("No hay solicitudes del usuario.");
        } catch(Exception e){
            fail("Lanzo ecepcion.");
        }
    }

    /**
     * Prueba Historia de usuario #2 Registrar Categoria
     * Se comprueba que se registre la categoria de manera exitosa
     */
    @Test
    public void deberiaRegistrarCategoria(){
        try{
            serviciosSolidaridad.registrarCategoria("11", "cat11", "cat11Desc", "Valida", null);
            if (serviciosSolidaridad.consultarCategoriaId("11") == null) {
                fail("No se encontro la categoria.");
            }
        } catch (Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaRegistrarCategoriaInvalida(){
        try{
            serviciosSolidaridad.registrarCategoria("21", "Cat21", "Cat21Desc", "Invalida", "No se maneja dinero");
        } catch (ExcepcionSolidaridad | PersistenceException e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Prueba Historia de usuario #2 Registrar Categoria
     * Se prueba que no sea posible registrar una categoria con id ya existente
     */
    @Test
    public void noDeberiaRegistrarCategoriaIdExistente(){
        try{
            serviciosSolidaridad.registrarCategoria("1", "cat1", "cat1Desc", "Valida", null);
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_ID, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #2 Registrar Categoria
     * Se prueba que no sea posible registrar una categoria con un nombre ya existente
     */
    @Test
    public void noDeberiaRegistrarCategoriaNombreExistente(){
        try{
            serviciosSolidaridad.registrarCategoria("11", "Categoria1", "cat11Desc", "Valida", null);
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_NAME, e.getMessage());
        }
    }

    @Test
    public void noDeberiRegistrarCategoriaInvalidaSinComentario(){
        try{
            serviciosSolidaridad.registrarCategoria("20", "Cat20", "Cat20Desc", "Invalida", null);
            fail("No lanzo excepcion.");
        } catch (ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_CATEGORY, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #3 Actualizar Categoria
     * Se prueba que al actualizar una categoria se actualice la fecha de modificacion a la actual
     */
    @Test
    public void deberiaActualizarLaFechaCategoria(){
        try{
            serviciosSolidaridad.actualizarCategoria("2", "Categoria22", "DescripcionC22", "Valida", null);
            if (!(serviciosSolidaridad.consultarCategoriaId("2").getFechaModificacion().equals(Date.valueOf(LocalDate.now())))){
                fail("No se actualizo la fecha de la categoria.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void noDeberiaRegistrarSolicitudNoCategoria(){
        try{
            serviciosSolidaridad.registrarSolicitud("100", "Sol100Desc", "Activa", "200", "2");
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.NO_CATEGORY_REGISTRED, e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarSolicitudConDescripcionNull(){
        try {
            serviciosSolidaridad.actualizarSolicitud("2", null, "Activa");
        } catch (Exception e) {
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarSolicitudConEstadoNull(){
        try {
            serviciosSolidaridad.actualizarSolicitud("2", "DescripcionS22", null);
        } catch (Exception e) {
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }


    @Test
    public void deberiaActualizarSolicitudConEstadoNullDescripcionNull(){
        try {
            serviciosSolidaridad.actualizarSolicitud("2", null, null);
        } catch (Exception e) {
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #3 Actualizar Categoria
     * Se comprueba que la informacion de los atributos sean actualizados correctamente
     */
    @Test
    public void deberiaActualizarInformacionCategoria(){
        try{
            String nombre = "Categoria33";
            String descripcion = "DescripcionC33";
            String estado = "Invalida";
            String comentario = "No se maneja este tipo";
            serviciosSolidaridad.actualizarCategoria("3", nombre, descripcion, estado, comentario);
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("3");
            if (!(categoria.getNombre().equals(nombre))) fail("Nombre no actualizado.");
            else if (!(categoria.getDescripcion().equals(descripcion))) fail("Descripcion no actualizada.");
            else if(!(categoria.getEstado().equals(estado)))  fail("Estado no actualizado.");
            else if(!(categoria.getComentario().equals(comentario))) fail("Comentario no actualizado.");
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarInformacionCategoriaNombreNull(){
        try{
            String nombre = null;
            String descripcion = "DescripcionC33";
            String estado = "Invalida";
            String comentario = "No se maneja este tipo";
            serviciosSolidaridad.actualizarCategoria("3", nombre, descripcion, estado, comentario);
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("3");
            if ((categoria.getNombre().equals(nombre))) fail("Nombre no actualizado.");
            else if (!(categoria.getDescripcion().equals(descripcion))) fail("Descripcion no actualizada.");
            else if(!(categoria.getEstado().equals(estado)))  fail("Estado no actualizado.");
            else if(!(categoria.getComentario().equals(comentario))) fail("Comentario no actualizado.");
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarInformacionCategoriaDescripcionNull(){
        try{
            serviciosSolidaridad.actualizarCategoria("3", "Categoria3333", null, "Invalida", "No se maneja este tipo");
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("3");
            if (!(categoria.getNombre().equals("Categoria3333"))) fail("Nombre no actualizado.");
            else if ((categoria.getDescripcion() == null)) fail("Descripcion actualizada.");
            else if(!(categoria.getEstado().equals("Invalida")))  fail("Estado no actualizado.");
            else if(!(categoria.getComentario().equals("No se maneja este tipo"))) fail("Comentario no actualizado.");
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarInformacionCategoriaEstadoNull(){
        try{
            String nombre = "Categoria55";
            String descripcion = "DescripcionC55";
            String estado = null;
            serviciosSolidaridad.actualizarCategoria("5", nombre, descripcion, estado, null);
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("5");
            if (!(categoria.getNombre().equals(nombre))) fail("Nombre no actualizado.");
            else if (!(categoria.getDescripcion().equals(descripcion))) fail("Descripcion no actualizada.");
            else if((categoria.getEstado().equals(estado)))  fail("Estado actualizado.");
            else if(categoria.getComentario() != null) fail("Comentario actualizado");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarInformacionCategoriaComentario(){
        try{
            String nombre = null;
            String descripcion = null;
            String estado = "Invalida";
            String comentario = "No se maneja este tipo.";
            serviciosSolidaridad.actualizarCategoria("3", nombre, descripcion, estado, comentario);
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("3");
            if ((categoria.getNombre().equals(nombre))) fail("Nombre actualizado.");
            else if ((categoria.getDescripcion().equals(descripcion))) fail("Descripcion actualizada.");
            else if(!(categoria.getEstado().equals(estado)))  fail("Estado no actualizado.");
            else if(!(comentario.equals(categoria.getComentario()))) fail("Comentario no actualizado");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarInformacionCategoriaComentarioNull(){
        try{
            String nombre = "Categoria66";
            String descripcion = "DescripcionC66";
            String estado = "Invalida";
            String comentario = null;
            serviciosSolidaridad.actualizarCategoria("3", nombre, descripcion, estado, comentario);
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("3");
            if (!(categoria.getNombre().equals(nombre))) fail("Nombre no actualizado.");
            else if (!(categoria.getDescripcion().equals(descripcion))) fail("Descripcion no actualizada.");
            else if(!(categoria.getEstado().equals(estado)))  fail("Estado actualizado.");
            else if(categoria.getComentario() == null) fail("Comentario no actualizado");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #3 Actualizar Categoria
     * Se prueba que no sea posible actualizar una categoria cuyo id no exista
     */
    @Test
    public void noDeberiaActualizarCategoriaNoId(){
        try{
            serviciosSolidaridad.actualizarCategoria("12", "Categoria12", "DescripcionC12", "Valida", null);
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.NO_CATEGORY_REGISTRED, e.getMessage());
        }
    }

    @Test
    public void noDeberiAlctualizarCategoriaDatosIguales(){
        try{
            serviciosSolidaridad.actualizarCategoria("1", "Categoria1", "DescripcionC1", "Valida", null);
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_UPDATE, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #4 Registrar Necesidad
     * Se comprueba que se registre la necesidad de manera exitosa
     */
    @Test
    public void deberiaRegistrarNecesidad(){
        try{
            int cantNecesidadesUsuarios =  serviciosSolidaridad.consultarNecesidadesUsuario("2").size();
            int cantNecesidadesCategorias = serviciosSolidaridad.consultarNecesidadesCategoria("Categoria1").size();
            serviciosSolidaridad.registrarNecesidad("10", "2", "Necesidad10", "DescripconN10", "Alta", "Activa", "1");
            if (serviciosSolidaridad.consultarSolicitudId("10") == null){
                fail("No se inserto la necesidad en solicicitudes.");
            }
            else if (serviciosSolidaridad.consultarNecesidadNombre("Necesidad10") == null){
                fail("No se inserto la necesidad.");
            }
            else if (cantNecesidadesUsuarios + 1 != serviciosSolidaridad.consultarNecesidadesUsuario("2").size()){
                fail("No se inserto la necesidad al usuario.");
            }
            else if (cantNecesidadesCategorias + 1 != serviciosSolidaridad.consultarNecesidadesCategoria("Categoria1").size()){
                fail("No se inserto la necesidad con la categoria dicha.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion." + e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #4 Registrar Necesidad
     * Se prueba que no sea posible registrar una necesidad con id ya existente
     */
    @Test
    public void noDeberiaRegistrarNecesidadIdExistente(){
        try{
            serviciosSolidaridad.registrarNecesidad("1", "3", "Necesidad1", "DescripconN1", "Alta", "Activa", "1");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_ID, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #4 Registrar Necesidad
     * Se prueba que no sea posible registrar una necesidad con un nombre ya existente
     */
    
    @Test
    public void noDeberiaRegistrarNecesidadNombreExistente(){
        try{
            serviciosSolidaridad.registrarNecesidad("11", "3" ,"Solicitud1", "DescripcionSN10", "Alta", "Activa", "2");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_NAME, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #5 Registrar Oferta
     * Se comprueba que se registre la oferta de manera exitosa
     */
    @Test
    public void deberiaRegistrarOferta(){
        try{
            int cantOfertasUsuarios =  serviciosSolidaridad.consultarOfertasUsuario("2").size();
            int cantNecesidadesCategorias = serviciosSolidaridad.consultarOfertasCategoria("Categoria1").size();
            serviciosSolidaridad.registrarOferta("20", "2", "Oferta20", "DescripconO20", "Activa", "1");
            if (serviciosSolidaridad.consultarSolicitudId("20") == null){
                fail("No se inserto la oferta en solicicitudes.");
            }
            else if (serviciosSolidaridad.consultarOfertaNombre("Oferta20") == null){
                fail("No se inserto la oferta.");
            }
            else if (cantOfertasUsuarios + 1 != serviciosSolidaridad.consultarOfertasUsuario("2").size()){
                fail("No se inserto la oferta al usuario.");
            }
            else if (cantNecesidadesCategorias + 1 != serviciosSolidaridad.consultarOfertasCategoria("Categoria1").size()){
                fail("No se inserto la oferta con la categoria dicha.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion."+e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #5 Registrar Oferta
     * Se prueba que no sea posible registrar una oferta con id ya existente
     */
    @Test
    public void noDeberiaRegistrarOfertaIdExistente(){
        try{
            serviciosSolidaridad.registrarOferta("3", "2", "Oferta21", "DescripconO21", "Activa", "1");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_ID, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #5 Registrar Oferta
     * Se prueba que no sea posible registrar una oferta con un nombre ya existente
     */
    @Test
    public void noDeberiaRegistrarOfertaNombreExistente(){
        try{
            serviciosSolidaridad.registrarOferta("22", "3", "Solicitud23", "DescripconO23", "Activa", "1");
            serviciosSolidaridad.registrarOferta("21", "3", "Solicitud23", "DescripconO21", "Activa", "1");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_NAME, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #6 Registrar Respuestas
     * Se comprueba que se registre la categoria de manera exitosa
     */
    @Test
    public void deberiaRegistrarRespuestaSolicitudActiva(){
        try{
            int cantRespuestasUsuario = serviciosSolidaridad.consultarRespuestasUsuario("Allen Wright").size();
            int cantRespuestasSolicitud = serviciosSolidaridad.consultarRespuestasSolicitud("Solicitud2").size();
            serviciosSolidaridad.registrarRespuesta("11", "3", "Respuesta11", "RespuestaCom11", "2");
            if (serviciosSolidaridad.consultarRespuestaId("11") == null) {
                fail("No se encontro la respuesta.");
            }
            else if (cantRespuestasUsuario >= serviciosSolidaridad.consultarRespuestasUsuario("Allen Wright").size()){
                fail("No se inserto respuesta al usuario");
            }
            else if (cantRespuestasSolicitud >= serviciosSolidaridad.consultarRespuestasSolicitud("Solicitud2").size()){
                fail("No se inserto respuesa ");
            }
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

        /**
     * Prueba Historia de usuario #6 Registrar Respuestas
     * Se comprueba que se registre la categoria de manera exitosa
     */
    @Test
    public void deberiaRegistrarRespuesta(){
        try{
            int cantRespuestasUsuario = serviciosSolidaridad.consultarRespuestasUsuario("Allen Wright").size();
            int cantRespuestasSolicitud = serviciosSolidaridad.consultarRespuestasSolicitud("Solicitud300").size();
            serviciosSolidaridad.registrarRespuesta("12", "3", "Respuesta12", "RespuestaCom12", "300");
            if (serviciosSolidaridad.consultarRespuestaId("12") == null) {
                fail("No se encontro la respuesta.");
            }
            else if (cantRespuestasUsuario + 1 != serviciosSolidaridad.consultarRespuestasUsuario("Allen Wright").size()){
                fail("No se inserto respuesta al usuario");
            }
            else if (cantRespuestasSolicitud + 1 != serviciosSolidaridad.consultarRespuestasSolicitud("Solicitud2").size()){
                fail("No se inserto respuesa ");
            }
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #6 Registrar Respuestas
     * Se prueba que no sea posible registrar una respuesta con id ya existente
     */
    @Test
    public void noDeberiaRegistrarRespuestaIdExistente(){
        try{
            serviciosSolidaridad.registrarRespuesta("1", "3", "Respuesta11", "RespuestaCom11", "2");
            fail("Lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_ID, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #6 Registrar Respuestas
     * Se prueba que no sea posible registrar una respuesta cuando la solicitud indicada no
     * esta Activa o en proceso
     */
    @Test
    public void noDeberiaRegistrarRespuestaEstadoSolicitudCerrada(){
        try{
            serviciosSolidaridad.registrarRespuesta("10", "3", "Respuesta11", "RespuestaCom11", "6");
            fail("Lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_ANSWER, e.getMessage());
        }
    }

    @Test
    public void noDeberiaRegistrarRespuestaEstadoSolicitudResuelta(){
        try{
            serviciosSolidaridad.registrarRespuesta("20", "3", "Respuesta111", "RespuestaCom111", "301");
            fail("Lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_ANSWER, e.getMessage());
        }
    }


    @Test
    public void noDeberiaEliminarRespuesta(){
        try{
            serviciosSolidaridad.registrarRespuesta("100", "2", "Respuesta100", "RespuestaCom100", "2");
            serviciosSolidaridad.eliminarRespuesta("100");
            if (serviciosSolidaridad.consultarRespuestaId("100") != null) fail("No se elimino la respuesta.");
        } catch(Exception e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Prueba Historia de Usuario #7 Actualizar Necesidad
     * Se prueba que al actualizar una necesidad se actualice la fecha de modificacion a la actual
     */
    @Test
    public void deberiaActualizarLaFechaNecesidad(){
        try{
            serviciosSolidaridad.actualizarNecesidad("7", "Solicitud77", "DescripcionSN77", "Cerrada");
            if (!(serviciosSolidaridad.consultarNecesidadId("7").getFechaModificacion().equals(Date.valueOf(LocalDate.now())))){
                fail("No se actualizo la fecha de la necesidad.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarNecesidadNombreNull(){
        try{
            Necesidad beforeNecesidad = serviciosSolidaridad.consultarNecesidadId("9");
            serviciosSolidaridad.actualizarNecesidad("9", null, "Solicitud91", "Activa");
            Necesidad afterNecesidad = serviciosSolidaridad.consultarNecesidadId("9");
            if (!beforeNecesidad.getNombre().equals(afterNecesidad.getNombre())){
                fail("Cambio el nombre de la necesidad.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion: " + e.getMessage());
        } catch (PersistenceException e) {
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void noDeberiaActualizarNecesidad(){
        try{
            serviciosSolidaridad.actualizarNecesidad("1", "Solicitud2", "DescripcionS101", "Cerrada");
            fail("No lanzo excepcion.");
        }catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_NAME, e.getMessage());
        }
    }

    @Test
    public void deberiaEliminarSolicitud(){
        try{
            serviciosSolidaridad.registrarSolicitud("100", "DescripcionS100", "Activa", "1", "2");
            serviciosSolidaridad.eliminarSolicitud("100");
            if (serviciosSolidaridad.consultarSolicitudId("100") != null) fail("No elimino la solicitud.");
        }catch(Exception e){
            fail("Lanzo excepcion " + e.getMessage());
        }
    }

    
    @Test
    public void noDeberiaActualizarSolicitud(){
        try{
            serviciosSolidaridad.actualizarNecesidad("100", "Solicitud100", "DescripcionSN100", "Cerrada");
            fail("No lanzo excepcion.");
        } catch(Exception e){
            assertEquals(ExcepcionSolidaridad.NO_APPLICATION_REGISTRED, e.getMessage());
        }     
    }

    /**
     * Prueba Historia de Usuario #8 Actualizar Oferta
     * Se prueba que al actualizar una oferta se actualice la fecha de modificacion a la actual
     */
    @Test
    public void deberiaActualizarLaFechaOferta(){
        try{
            serviciosSolidaridad.actualizarOferta("8", "Solicitud88", "DescripcionSN88", "Cerrada");
            if (!(serviciosSolidaridad.consultarOfertaId("8").getFechaModificacion().equals(Date.valueOf(LocalDate.now())))){
                fail("No se actualizo la fecha de la oferta.");
            }
        } catch(Exception e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void deberiaActualizarOfertaNombreNull(){
        try{
            Oferta beforeOferta = serviciosSolidaridad.consultarOfertaId("8");
            serviciosSolidaridad.actualizarOferta("8", null, "Solicitud81", "Activa");
            Oferta afterOferta = serviciosSolidaridad.consultarOfertaId("8");
            if (!beforeOferta.getNombre().equals(afterOferta.getNombre())){
                fail("Cambio el nombre de la necesidad.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion: " + e.getMessage());
        } catch (PersistenceException e) {
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    @Test
    public void noDeberiaActualizarOferta(){
        try{
            serviciosSolidaridad.actualizarOferta("3", "Solicitud5", "DescripcionSO301", "Cerrada");
            fail("No lanzo excepcion.");
        }catch(ExcepcionSolidaridad | PersistenceException e){
            assertEquals(ExcepcionSolidaridad.INVALID_NAME, e.getMessage());
        }
    }

    @Test
    public void deberiaEliminarCategoria(){
        try {
            serviciosSolidaridad.registrarCategoria("120", "cat120", "cat120Desc", "Valida", null);
            serviciosSolidaridad.eliminarCategoria("120");
            if(serviciosSolidaridad.consultarCategoriaId("120") != null) fail("No elimino la categoria");
        } catch (Exception e) {
            fail("Lanzo excepcion: "+ e.getMessage());
        }
    }

    @Test
    public void noDeberiaRegistrarSolicitudCategoriaInvalida(){
        String idCategoria = "4";
        try{
            serviciosSolidaridad.registrarSolicitud("200", "descripcion", "Activa", idCategoria, "2");
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad | PersistenceException e){
            try {
                assertEquals(serviciosSolidaridad.consultarCategoriaId(idCategoria).getComentario(), e.getMessage());
            } catch (ExcepcionSolidaridad | PersistenceException e1) {
                fail("La excepcion no es correcta.");
            }
        }
    }

    @Test
    public void deberiaConsultarNecesidadesPorTodosLosEstados(){
        try{
            HashMap<String, Integer> estadisticas = serviciosSolidaridad.consultarNecesidadesEstado();
            Estado[] estado = Estado.values();
            Set<String> estadosEstadisticas = estadisticas.keySet();
            int cont = 0;
            for (int i = 0; i < estado.length; i++){
                if (!estadosEstadisticas.contains(estado[i].getDescripcion())) break;
                else{cont++;}
            }
            if (cont != estado.length) fail("No se tienen todas los estados");
        } catch (ExcepcionSolidaridad | PersistenceException e1) {
            fail("Lanzo excepcion.");
        }
    }

    @Test
    public void deberiaConsultarOfertasPorTodosLosEstados(){
        try{
            HashMap<String, Integer> estadisticas = serviciosSolidaridad.consultarOfertasEstado();
            Estado[] estado = Estado.values();
            Set<String> estadosEstadisticas = estadisticas.keySet();
            int cont = 0;
            for (int i = 0; i < estado.length; i++){
                if (!estadosEstadisticas.contains(estado[i].getDescripcion())) break;
                else{cont++;}
            }
            if (cont != estado.length) fail("No se tienen todas los estados");
        } catch (ExcepcionSolidaridad | PersistenceException e1) {
            fail("Lanzo excepcion.");
        }
    }

    @Test
    public void deberiaActualizarNumSolicitudes(){
        int numSolicitudes = 1000;
        try{
            String before = serviciosSolidaridad.getNumeroSolicitudes();
            serviciosSolidaridad.actualizarNumeroSolicitudes(numSolicitudes);
            String after = serviciosSolidaridad.getNumeroSolicitudes();
            serviciosSolidaridad.actualizarNumeroSolicitudes(Integer.parseInt(before));
            assertEquals(1000 + "", after);
        }catch (ExcepcionSolidaridad | PersistenceException e1) {
            fail("Lanzo excepcion.");
        }
    }

    @Test
    public void noDeberiaActualizarNumSolicitudes(){
        int numSolicitudes = 0;
        try{
            serviciosSolidaridad.actualizarNumeroSolicitudes(numSolicitudes);
            fail("No lanzo excepcion.");
        }catch (ExcepcionSolidaridad | PersistenceException e1) {
            assertEquals(ExcepcionSolidaridad.INVALID_NUM_SOLICITUDES, e1.getMessage());
        }
    }

    @Test
    public void deberiaTenerExactamenteNSolicitudes(){
        try{
            int numSolicitudes = serviciosSolidaridad.consultarSolicitudes().size();
            int cont = 0;
            for (int cant : serviciosSolidaridad.consultarCantidadPorCategorias().values()) cont += cant;
            assertEquals(numSolicitudes, cont);
        }catch (ExcepcionSolidaridad | PersistenceException e1) {
            fail("Lanzo excepcion.");
        }
    }

    @Test
    public void deberiaTenerExactamenteNSolicitudes2(){
        try{
            int numSolicitudes = serviciosSolidaridad.consultarSolicitudes().size();
            int cont = 0;
            for (int cant : serviciosSolidaridad.reporteCategorias().keySet())cont += cant;
            assertEquals(numSolicitudes, cont);
        }catch (ExcepcionSolidaridad | PersistenceException e1) {
            fail("Lanzo excepcion.");
        }
    }

    @After
    public void dropData(){
        try {
            serviciosSolidaridad.eliminarNecesidad("10");
            serviciosSolidaridad.eliminarOferta("20");
            serviciosSolidaridad.eliminarOferta("21");
            serviciosSolidaridad.eliminarOferta("23");
            serviciosSolidaridad.eliminarOferta("22");
            serviciosSolidaridad.eliminarCategoria("11");
            serviciosSolidaridad.eliminarUsuario("10");
            serviciosSolidaridad.eliminarUsuario("11");
            serviciosSolidaridad.eliminarUsuario("12");
            serviciosSolidaridad.eliminarUsuario("13");
            serviciosSolidaridad.actualizarCategoria("3", "Categoria3", "DescripcionC3", "Valida", null);
            serviciosSolidaridad.actualizarCategoria("2", "Categoria2", "DescripcionC2", "Invalida", "No ");
            serviciosSolidaridad.eliminarRespuesta("11");
            serviciosSolidaridad.eliminarRespuesta("12");
        } catch (Exception e) {
        }
    }
}
