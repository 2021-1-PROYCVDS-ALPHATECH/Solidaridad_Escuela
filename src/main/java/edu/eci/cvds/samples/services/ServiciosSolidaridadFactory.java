package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Oferta;
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
                bind(OfertaDAO.class).to(MyBATISOfertaDAO.class);
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
            System.out.println(instance.getServiciosSolidaridad().consultarUsuarios().toString());
            /*System.out.println("-------------------------------- INSERTAR USUARIOS --------------------------------");
            instance.getServiciosSolidaridad().registrarUsuario(new Usuario("3", "estudiante1", "0000000000", "estu123@gmail.com", "10e35", Rol.Estudiante));
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
            System.out.println(instance.getServiciosSolidaridad().consultarCategorias().toString());   */

            //System.out.println("-------------------------------- INSERTAR NECESIDADES --------------------------------");
            //instance.getServiciosSolidaridad().registrarNecesidades("3", "2", "estudiante", "necesidad2", "necesidad", "Activa", new Categoria("2", "test", "test"));
            System.out.println("-------------------------------- CONSULTAR NECESIDADES --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarNecesidades().toString());

            /*System.out.println("-------------------------------- INSERTAR OFERTAS --------------------------------");
            instance.getServiciosSolidaridad().registrarOferta(new Oferta("1","1","estudiante","oferta1","estado"));
            System.out.println("-------------------------------- CONSULTAR OFERTAS --------------------------------");
            System.out.println(instance.getServiciosSolidaridad().consultarOferta().toString());*/

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
