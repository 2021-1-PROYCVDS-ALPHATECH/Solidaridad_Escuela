package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.NecesidadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISUsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISCategoriaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISNecesidadDAO;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;
import edu.eci.cvds.samples.services.impl.ServiciosSolidaridadImpl;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISOfertaDAO;
import edu.eci.cvds.sampleprj.dao.OfertaDAO;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {     
	    Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(CategoriaDAO.class).to(MyBATISCategoriaDAO.class);
                bind(NecesidadDAO.class).to(MyBATISNecesidadDAO.class);
                bind(OfertaDAO.class).to(MyBATISOfertaDAO.class);
                bind(ServiciosSolidaridad.class).to(ServiciosSolidaridadImpl.class);
            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}