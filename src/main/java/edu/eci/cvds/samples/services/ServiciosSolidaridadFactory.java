package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;


import edu.eci.cvds.samples.services.impl.ServiciosSolidaridadImpl;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

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
            //System.out.println("-------------------------------- CONSULAR CATEGORIAS --------------------------------");
            /*System.out.println(instance.getServiciosSolidaridad().consultarCategorias().toString());
            System.out.println("-------------------------------- CONSULAR SOLICITUDES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarSolicitudes().toString());
            System.out.println("-------------------------------- CONSULAR NECESIDADES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarNecesidades().toString());
            System.out.println("-------------------------------- CONSULAR OFERTAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarOferta().toString());
            System.out.println("-------------------------------- CONSULAR USUARIOS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarUsuarios().toString());
            

            
            System.out.println("-------------------------------- INSERTAR USUARIOS --------------------------------");
            instance.getServiciosSolidaridad().registrarUsuario("3", "EstudTest3", "0000000002", "es@mail.com", "10e35e8e93e91e58b54af372922fe86028c587c7e32fa3f50c4a106eaa05e668", "Estudiante", 10);

            
            System.out.println("-------------------------------- INSERTAR CATEGORIAS  --------------------------------");
            instance.getServiciosSolidaridad().registrarCategoria("4", "insercion23", "inserciond");
            
            System.out.println("-------------------------------- INSERTAR NECESIDADES --------------------------------");
            Categoria cat = new Categoria("1", "categoria1", "cat1");
            instance.getServiciosSolidaridad().registrarNecesidad("1234","1", "nombretest1", "desctest", "Alta", "Activa", cat);
            
            System.out.println("-------------------------------- CONSULAR SOLICITUDES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarSolicitudes().toString());
            System.out.println("-------------------------------- CONSULAR NECESIDADES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarNecesidades().toString());

            System.out.println("-------------------------------- INSERTAR OFERTAS --------------------------------");
            instance.getServiciosSolidaridad().registrarOferta("124", "1", "ofertatest", "of", "Activa", cat);
            System.out.println("-------------------------------- CONSULAR SOLICITUDES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarSolicitudes().toString());
            System.out.println("-------------------------------- CONSULTAR OFERTAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarOferta().toString());*/

            /*System.out.println("-------------------------------- INSERTAR CATEGORIAS  --------------------------------");
            instance.getServiciosSolidaridad().registrarCategoria("20", "insercion234", "inserciond");*/

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
