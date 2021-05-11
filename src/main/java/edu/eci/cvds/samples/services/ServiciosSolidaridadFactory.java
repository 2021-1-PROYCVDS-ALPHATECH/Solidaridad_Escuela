package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;


import java.util.Optional;

import static com.google.inject.Guice.createInjector;
import edu.eci.cvds.samples.services.impl.ServiciosSolidaridadImpl;

/**
 * Clase fabrica para la aplicacion
 * @author Luis Amaya
 * @author Angie Medina
 * @author Sebastian Mina
 * @author Jose Perez
 * 
 * @version 19/04/2021 v1.0
 */
public class ServiciosSolidaridadFactory {
    private static ServiciosSolidaridadFactory instance = new ServiciosSolidaridadFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(CategoriaDAO.class).to(MyBATISCategoriaDAO.class);
                bind(NecesidadDAO.class).to(MyBATISNecesidadDAO.class);
                bind(OfertaDAO.class).to(MyBATISOfertaDAO.class);
                bind(SolicitudDAO.class).to(MyBATISSolicitudDAO.class);
                bind(RespuestaDAO.class).to(MyBATISRespuestaDAO.class);
                bind(ServiciosSolidaridad.class).to(ServiciosSolidaridadImpl.class);
            }
        });
    }

    private ServiciosSolidaridadFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosSolidaridad getServiciosSolidaridad(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosSolidaridad.class);
    }


    public ServiciosSolidaridad getServiciosSolidaridadTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosSolidaridad.class);
    }


    public static ServiciosSolidaridadFactory getInstance(){
        return instance;
    }

    public static void main(String[] args){
        try{
            /*System.out.println("-------------------------------- CONSULAR USUARIOS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarUsuarios());
            
            System.out.println("-------------------------------- CONSULAR SOLICITUDES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarSolicitudId("1"));*/

            System.out.println("-------------------------------- CONSULTAR RESPUESTAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarRespuestas());

            System.out.println("-------------------------------- CONSULTAR RESPUESTAS ID --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarRespuestaId("1"));

            System.out.println("-------------------------------- CONSULAR RESPUESTA SOLICITUD --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarRespuestasSolicitud("necesidad1"));
            
            
            System.out.println("-------------------------------- CONSULAR RESPUESTAS DE USUARIO --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarUsuario("2").getRespuestas());
            System.out.println(instance.getServiciosSolidaridad().consultarRespuestasUsuario("EstudTest2"));
            System.out.println(instance.getServiciosSolidaridad().consultarRespuestasUsuario("2"));


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

