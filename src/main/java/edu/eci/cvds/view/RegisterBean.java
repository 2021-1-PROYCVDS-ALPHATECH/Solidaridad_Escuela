package edu.eci.cvds.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.services.ServiciosSolidaridad;

@ManagedBean(name = "RegisterBean")
@SessionScoped
public class RegisterBean extends BasePageBean{
    @Inject

    protected ServiciosSolidaridad servicios;

    public void registrarCategoria(String id, String nombre, String descripcion, String estado, String comentario){
        try{
            servicios.registrarCategoria(id, nombre, descripcion, estado, comentario);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String estado, String categoria){
        try{
            servicios.registrarOferta(idOferta, idUsuario, nombre, descripcion, estado, categoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado, String categoria){
        try{
            servicios.registrarNecesidad(idNecesidad, idUsuario, nombre, descripcion, urgencia, estado, categoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void registrarUsuario(String idUsuario, String nombre, String telefono, String email, String clave, String rol){
        try {
            servicios.registrarUsuario(idUsuario, nombre, telefono, email, clave, rol);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void registrarRespuesta(String idRespuesta, String idUsuario, String nombre, String comentarios, String idSolicitud){
        try {
            servicios.registrarRespuesta(idRespuesta, idUsuario, nombre, comentarios, idSolicitud);
        } catch (Exception e){

        }
    }
}
