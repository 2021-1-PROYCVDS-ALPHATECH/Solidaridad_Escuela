package edu.eci.cvds.view;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

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
    private ServiciosSolidaridad servicios;

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

    public String consultarLabelsNecesidad() throws ExcepcionSolidaridad, PersistenceException{
        String labels = "";
        HashMap<String, Integer> estadisticas = servicios.consultarNecesidadesEstado();
        for(String key: estadisticas.keySet()){
            labels += key + ",";
        }
        labels = labels.substring(0, labels.length()-1);
        return labels;
    }

    public String consultarLabelsOfertas() throws ExcepcionSolidaridad, PersistenceException{
        String labels = "";
        HashMap<String, Integer> estadisticas = servicios.consultarOfertasEstado();
        for(String key: estadisticas.keySet()){
            labels += key + ",";
        }
        labels = labels.substring(0, labels.length()-1);
        return labels;
    }

    public String consultarLabelsCategorias() throws ExcepcionSolidaridad, PersistenceException{
        String labels = "";
        TreeMap<Integer, HashMap<String, int[]>> reporte = servicios.reporteCategorias();
        for(Integer key: reporte.keySet()){
            for(String nombreCategoria: reporte.get(key).keySet()){
                labels += nombreCategoria + ",";
            }
        }
        labels = labels.substring(0, labels.length()-1);
        return labels;
    }

    public String consultarValuesOfertas() throws ExcepcionSolidaridad, PersistenceException{
        String values = "";
        HashMap<String, Integer> estadisticas = servicios.consultarOfertasEstado();
        for(String key: estadisticas.keySet()){
            values += estadisticas.get(key) + ",";
        }
        values = values.substring(0, values.length()-1);
        return values;
    }

    public String consultarValuesCategorias() throws ExcepcionSolidaridad, PersistenceException{
        String values = "";
        TreeMap<Integer, HashMap<String, int[]>> reporte = servicios.reporteCategorias();
        for(Integer key: reporte.keySet()){
            for(int i=0; i<reporte.get(key).size(); i++){
                values += key + ",";
            }
        }
        values = values.substring(0, values.length()-1);
        return values;
    }

    public String consultarValuesNecesidad() throws ExcepcionSolidaridad, PersistenceException{
        String values = "";
        HashMap<String, Integer> estadisticas = servicios.consultarNecesidadesEstado();
        for(String key: estadisticas.keySet()){
            values += estadisticas.get(key) + ",";
        }
        values = values.substring(0, values.length()-1);
        return values;
    }

    public List consultarReporteCategorias() throws ExcepcionSolidaridad, PersistenceException{
        ArrayList<String[]> categorias = new ArrayList<String[]>();
        TreeMap<Integer, HashMap<String, int[]>> reporte = servicios.reporteCategorias();
        for(Integer key: servicios.reporteCategorias().keySet()){
            HashMap<String, int[]> map = reporte.get(key);
            for(String nombreCategoria: map.keySet()){
                String[] entry = new String[4];
                entry[0] = nombreCategoria; entry[1] = "" + map.get(nombreCategoria)[0];
                entry[3] = "" + key;        entry[2] = "" + map.get(nombreCategoria)[1];
                categorias.add(entry);
            }
        }
        return categorias;
    }

    public HashMap<String,String> categoriasASelectMenu(){
        HashMap<String,String> map = new HashMap<String,String>();
        try {
            for(Categoria categoria: servicios.consultarCategorias()){
                map.put(categoria.getNombre(),categoria.getId());
            }
        }catch (Exception e) {}
        return map;
    }
}
