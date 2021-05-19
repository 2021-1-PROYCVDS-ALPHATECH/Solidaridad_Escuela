package edu.eci.cvds.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;

@ManagedBean(name = "UpdateBean")
@SessionScoped
public class UpdateBean extends BasePageBean{

    @Inject
    private ServiciosSolidaridad servicios;

    private Categoria categoria;
    private Usuario usuario;
    private Respuesta respuesta;
    private Necesidad necesidad;
    private Oferta oferta;
    
    
    public void eliminarCategoria(){
        try {
            servicios.eliminarCategoria(categoria.getId());
        } catch (Exception e) {
        }
    }

    public void actualizarCategoria(String id, String nombre, String descripcion, String estado){
        try {
            if (nombre.equals("")) nombre = null;
            if (estado.equals("")) estado = null;
            if (descripcion.equals("")) descripcion = null;
            servicios.actualizarCategoria(id, nombre, descripcion, estado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void actualizarOferta(String idOferta, String nombre, String descripcion, String estado){
        try {
            servicios.actualizarOferta(idOferta, nombre, descripcion, estado);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void actualizarNecesidad(String idNecesidad, String nombre, String descripcion, String estado){
        try {
            servicios.actualizarNecesidad(idNecesidad, nombre, descripcion, estado);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Necesidad getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(Necesidad necesidad) {
        this.necesidad = necesidad;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
}
