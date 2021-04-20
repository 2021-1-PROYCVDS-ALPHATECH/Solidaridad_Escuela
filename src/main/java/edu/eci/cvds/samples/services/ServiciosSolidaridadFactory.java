package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;

import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISUsuarioDAO;

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
        } catch (Exception e){
            System.out.println("F");
        }
        
    }

}
