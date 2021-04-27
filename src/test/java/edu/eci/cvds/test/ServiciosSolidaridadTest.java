package edu.eci.cvds.test;

import java.sql.Date;
import java.time.LocalDate;

import com.google.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridadFactory;

public class ServiciosSolidaridadTest {

    @Inject
    private SqlSession SqlSession;

    ServiciosSolidaridad serviciosSolidaridad;

    public ServiciosSolidaridadTest(){
        serviciosSolidaridad = ServiciosSolidaridadFactory.getInstance().getServiciosSolidaridadTesting();
    }
    
    @Before
    public void setUp(){

    }

    /**
     * Se comprueba que se registre un usuario de manera exitosa
     */
    @Test
    public void deberiaRegistrarUsuario(){
        try{
            serviciosSolidaridad.registrarUsuario("10", "Bess Woods","(345) 394-5688" , "ikagim@oleat.tf", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "Estudiante", 2);
            if(serviciosSolidaridad.consultarUsuario("10") == null){
                fail("No se encontro el usuario.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se prueba que se pueda consultar correctamente un usuario por su nombre (que debe ser unico)
     */
    @Test
    public void deberiaConsultarPorNombre(){
        try{
            serviciosSolidaridad.registrarUsuario("11", "Christina Wood","(349) 349-3399" , "daet@dujo.ba", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "Estudiante", 2);
            if(serviciosSolidaridad.consultarUsuarioNombre("Christina Wood") == null){
                fail("No se encontro el usuario.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
        }
    }

    @Test
    public void deberiaConsultarPorRol(){
        try{
            String rol = "Estudiante";
            serviciosSolidaridad.registrarUsuario("12", "Travis Cunningham","(476) 912-7578" , "ogwuz@judi.cu", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", rol, 2);
            if(serviciosSolidaridad.consultarUsuariosRol(rol) == null || serviciosSolidaridad.consultarUsuariosRol(rol).size() < 1){
                fail("No se encontraron usuarios.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se comprueba que se actualice el numero de solicitudes permitidas del usuario de manera correcta
     */
    @Test
    public void deberiaActualizarNumSolicitudesUsuario(){
        try{
            serviciosSolidaridad.registrarUsuario("13", "Tom Barton","(911) 456-4054" , "ehiuj@cavmis.ad", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "Estudiante", 2);
            int numSolicitudes = 5;
            serviciosSolidaridad.actualizarNumSolicitudes("13", numSolicitudes);
            assertEquals(numSolicitudes, serviciosSolidaridad.consultarUsuario("13").getNumSolicitudes());
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
        }
    }

    /**
     * Se prueba que no se actualice el numero de solicitudes del usuario si este numero es menor
     * a las solucitudes que ya realizo
     */
    @Test
    public void noDeberiaActualizarNumSolicitudesUsuario(){
        try{
            serviciosSolidaridad.actualizarNumSolicitudes("2", 1);
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.INVALID_NUM_SOLICITUDES, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #2 Registrar Categoria
     * Se comprueba que se registre la categoria de manera exitosa
     */
    @Test
    public void deberiaRegistrarCategoria(){
        try{
            serviciosSolidaridad.registrarCategoria("11", "cat11", "cat11Desc");
            if (serviciosSolidaridad.consultarCategoriaId("11") == null) {
                fail("No se encontro la categoria.");
            }
        } catch (ExcepcionSolidaridad e){
            fail("Lanzo excepcion: " + e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #2 Registrar Categoria
     * Se prueba que no sea posible registrar una categoria con id ya existente
     */
    @Test
    public void noDeberiaRegistrarCategoriaIdExistente(){
        try{
            serviciosSolidaridad.registrarCategoria("1", "cat1", "cat1Desc");
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad e){
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
            serviciosSolidaridad.registrarCategoria("11", "Categoria1", "cat11Desc");
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.INVALID_NAME, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #3 Actualizar Categoria
     * Se prueba que al actualizar una categoria se actualice la fecha de modificacion a la actual
     */
    @Test
    public void deberiaActualizarLaFechaCategoria(){
        try{
            serviciosSolidaridad.actualizarCategoria("2", "Categoria22", "DescripcionC22", "Activa");
            if (!(serviciosSolidaridad.consultarCategoriaId("2").getFechaModificacion().equals(Date.valueOf(LocalDate.now())))){
                fail("No se actualizo la fecha de la categoria.");
            }
        } catch(ExcepcionSolidaridad e){
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
            String nombre = "Categoria33", descripcion = "DescripcionC33", estado = "Inactiva";
            serviciosSolidaridad.actualizarCategoria("3", nombre, descripcion, estado);
            Categoria categoria =  serviciosSolidaridad.consultarCategoriaId("3");
            if (!(categoria.getNombre().equals(nombre))) fail("Nombre no actualizado.");
            else if (!(categoria.getDescripcion().equals(descripcion))) fail("Descripcion no actualizada.");
            else if(!(categoria.getEstado().equals(estado)))  fail("Estado no actualizado.");
        } catch(ExcepcionSolidaridad e){
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
            serviciosSolidaridad.actualizarCategoria("12", "Categoria12", "DescripcionC12", "Activa");
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.NO_CATEGORY_REGISTRED, e.getMessage());
        }
    }

    @Test
    public void noDeberiAlctualizarCategoriaDatosIguales(){
        try{
            serviciosSolidaridad.actualizarCategoria("1", "Categoria1", "DescripcionC1", "Activa");
            fail("No lanzo excepcion.");
        } catch(ExcepcionSolidaridad e){
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
            serviciosSolidaridad.registrarNecesidad("10", "2", "Necesidad10", "DescripconN10", "Alta", "Activa", "1");
            if (serviciosSolidaridad.consultarSolicitudId("10") == null){
                fail("No se inserto la necesidad en solicicitudes.");
            }
            else if (serviciosSolidaridad.consultarNecesidadNombre("Necesidad10") == null){
                fail("No se inserto la necesidad.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
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
        } catch(ExcepcionSolidaridad e){
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
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.INVALID_ID, e.getMessage());
        }
    }
    
    /**
     * Prueba Historia de usuario #4 Registrar Necesidad
     * Se prueba que no sea posible registrar una necesidad si el usuario ya llego al tope de su cantidad de solicitudes
     */
    @Test
    public void noDeberiaRegistrarNecesidadNumSolicitudes(){
        try{
            serviciosSolidaridad.registrarNecesidad("12", "4", "Necesidad1", "DescripconN1", "Alta", "Activa", "1");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.INVALID_REGISTRED, e.getMessage());
        }
    }

    /**
     * Prueba Historia de usuario #7 Actualizar Necesidad
     * 
     */
    /*
    @Test
    public void deberiaActualizarNecesidad(){
        try{
            serviciosSolidaridad.registrarNecesidad("12", "2", "Necesidad1", "DescripconN1", "Alta", "Activa", "1");
            serviciosSolidaridad.actualizarEstadoNecesidad("12");
            if (serviciosSolidaridad.consultarNecesidadId("12").getEstado() != "Cerrada"){
                fail("No se actualizo la necesidad.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
        }
    }*/


    /**
     * Prueba Historia de usuario #5 Registrar Oferta
     * Se comprueba que se registre la oferta de manera exitosa
     */
    @Test
    public void deberiaRegistrarOferta(){
        try{
            serviciosSolidaridad.registrarOferta("20", "2", "Oferta20", "DescripconO20", "Activa", "1");
            if (serviciosSolidaridad.consultarSolicitudId("20") == null){
                fail("No se inserto la oferta en solicicitudes.");
            }
            else if (serviciosSolidaridad.consultarOfertaNombre("Oferta20") == null){
                fail("No se inserto la oferta.");
            }
        } catch(ExcepcionSolidaridad e){
            fail("Lanzo excepcion.");
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
        } catch(ExcepcionSolidaridad e){
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
            serviciosSolidaridad.registrarOferta("21", "3", "Solicitud3", "DescripconO21", "Activa", "1");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.INVALID_ID, e.getMessage());
        }
    }


    /**
     * Prueba Historia de usuario #5 Registrar Oferta
     * Se prueba que no sea posible registrar una necesidad si el usuario ya llego al tope de su cantidad de solicitudes
     */
    @Test
    public void noDeberiaRegistrarOfertaNumSolicitudes(){
        try{
            serviciosSolidaridad.registrarOferta("22", "4", "Oferta22", "DescripconO22", "Activa", "1");
            fail("No lanzo excepcion");
        } catch(ExcepcionSolidaridad e){
            assertEquals(ExcepcionSolidaridad.INVALID_REGISTRED, e.getMessage());
        }
    }

    @After
    public void dropData(){
        try {
            serviciosSolidaridad.eliminarNecesidad("10");
            serviciosSolidaridad.eliminarNecesidad("11");
            serviciosSolidaridad.eliminarOferta("20");
            serviciosSolidaridad.eliminarCategoria("11");
            serviciosSolidaridad.eliminarUsuario("10");
            serviciosSolidaridad.eliminarUsuario("11");
            serviciosSolidaridad.eliminarUsuario("12");
            serviciosSolidaridad.eliminarUsuario("13");
            serviciosSolidaridad.actualizarCategoria("3", "Categoria3", "DescripcionC3", "Activa");
            serviciosSolidaridad.actualizarCategoria("2", "Categoria2", "DescripcionC2", "Inactiva");
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
    }
}
