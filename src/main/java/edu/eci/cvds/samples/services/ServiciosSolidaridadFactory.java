package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
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
            System.out.println("-------------------------------- CONSULAR USUARIOS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarUsuarios().toString());
            System.out.println("-------------------------------- INSERTAR USUARIOS --------------------------------");
            instance.getServiciosSolidaridad().registrarUsuario(new Usuario("2", "estudiante", "0000000000", "estu@gmail.com", "10e35e8e93e91e58b54af372922fe86028c587c7e32fa3f50c4a106eaa05e668", Rol.Estudiante));
            System.out.println("-------------------------------- CONSULAR USUARIOS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarUsuarios().toString());

            System.out.println("\n-------------------------------- CONSULAR CATEGORIAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarCategorias().toString());
            System.out.println("-------------------------------- INSERTAR CATEGORIAS  --------------------------------");
            //instance.getServiciosSolidaridad().registrarCategoria("3", "insercion", "inserciond");
            System.out.println("-------------------------------- CONSULAR CATEGORIAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarCategorias().toString());
            System.out.println("-------------------------------- ACTUALIZAR NOMBRE CATEGORIAS --------------------------------");
            instance.getServiciosSolidaridad().actualizarNombreCategoria("1", "actnom");
            System.out.println("-------------------------------- ACTUALIZAR DESCRIPCION CATEGORIAS --------------------------------");
            instance.getServiciosSolidaridad().actualizarDescripcionCategoria("1", "actdes");
            System.out.println("-------------------------------- ACTUALIZAR ESTADO CATEGORIAS --------------------------------");
            instance.getServiciosSolidaridad().actualizarEstadoCategoria("1", "Inactiva");
            System.out.println("-------------------------------- CONSULAR CATEGORIAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarCategorias().toString());   

            System.out.println("-------------------------------- INSERTAR NECESIDADES --------------------------------");
            instance.getServiciosSolidaridad().registrarNecesidades("1", "2", "estudiante", "necesidad1", "necesidad", "estado");
            System.out.println("-------------------------------- CONSULTAR NECESIDADES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarNecesidades().toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
