package edu.eci.cvds.view;

import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.entities.Respuesta;
import edu.eci.cvds.samples.entities.Usuario;

import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

@ManagedBean(name = "ConsultBean")
@SessionScoped
public class ConsultBean extends BasePageBean{
    @Inject

    protected ServiciosSolidaridad servicios;

    public List<Categoria> consultarCategorias() throws ExcepcionSolidaridad, PersistenceException{
        return servicios.consultarCategorias();
    }

    public List<Oferta> consultarOfertas() throws ExcepcionSolidaridad, PersistenceException{
        return servicios.consultarOfertas();
    }

    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad, PersistenceException{
        return servicios.consultarNecesidades();
    }

    public List<Usuario> consultarUsuarios() throws ExcepcionSolidaridad, PersistenceException{
        return servicios.consultarUsuarios();
    }

    public List<Necesidad> consultarNecesidadesEstudiante(String idUsuario) throws ExcepcionSolidaridad, PersistenceException{
        return servicios.consultarNecesidadesUsuario(idUsuario);
    }

    public List<Respuesta> consultarRespuestas() throws ExcepcionSolidaridad, PersistenceException{
        return servicios.consultarRespuestas();
    }
    
    public String ConsultarEstadosNecesidad() throws ExcepcionSolidaridad, PersistenceException{
        String values = "";
        HashMap<String, Integer> estadisticas = servicios.consultarNecesidadesEstado();
        for(String key: estadisticas.keySet()){
            values += estadisticas.get(key) + ",";
        }
        values = values.substring(0, values.length()-1);
        return values;
    }

    public String ConsultarLabelsNecesidad() throws ExcepcionSolidaridad, PersistenceException{
        String labels = "";
        HashMap<String, Integer> estadisticas = servicios.consultarNecesidadesEstado();
        for(String key: estadisticas.keySet()){
            labels += key + ",";
        }
        labels = labels.substring(0, labels.length()-1);
        return labels;
    }

    public String ConsultarLabelsOfertas() throws ExcepcionSolidaridad, PersistenceException{
        String labels = "";
        HashMap<String, Integer> estadisticas = servicios.consultarOfertasEstado();
        for(String key: estadisticas.keySet()){
            labels += key + ",";
        }
        labels = labels.substring(0, labels.length()-1);
        return labels;
    }

    public String ConsultarEstadosOfertas() throws ExcepcionSolidaridad, PersistenceException{
        String values = "";
        HashMap<String, Integer> estadisticas = servicios.consultarOfertasEstado();
        for(String key: estadisticas.keySet()){
            values += estadisticas.get(key) + ",";
        }
        values = values.substring(0, values.length()-1);
        return values;
    }
}
