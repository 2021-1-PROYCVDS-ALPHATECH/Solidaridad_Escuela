package edu.eci.cvds.view;

import com.google.inject.Inject;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage; 

import org.apache.shiro.subject.Subject;

import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ExcepcionSolidaridadEscuela;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

import java.sql.Date;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean extends BasePageBean{
    @Inject
    private ServiciosSolidaridad servicios;
    private String user;
    private String password;
    private Subject subject;
    private Categoria categoria;

    public LoginBean(){
        user = "";
        password = "";
    }
    
    public void setUser(String user){
        this.user = user;
    }

    public String getUser(){
        return user;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void logIn(){
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user, new Sha256Hash(password).toHex());
        try {
            subject.login(token);
            if (subject.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/admin.xhtml");
			}
            else if (subject.hasRole("Administrativo")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/administrativo.xhtml");
			}
            else if (subject.hasRole("Egresado")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/egresado.xhtml");
			}
            else if (subject.hasRole("Profesor")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/profesor.xhtml");
			}
            else if (subject.hasRole("Estudiante")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/estudiante.xhtml");
			}
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage("log:Usuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Juaz juaz ", "Usuario o contraseña incorrectos"));
        }
    }

    public List<Categoria> consultarCategorias() throws ExcepcionSolidaridadEscuela{
        return servicios.consultarCategorias();
    }

    public void registrarCategoria(String id, String nombre, String descripcion){
        try{
            servicios.registrarCategoria(id, nombre, descripcion);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public List<Oferta> consultarOfertas() throws ExcepcionSolidaridadEscuela{
        return servicios.consultarOferta();
    }

    public void registrarOferta(String idOferta, String idUsuario, String nombre, String descipcion, String fechaCreacion, String fechaModificacion, String estado){
        try{
            Oferta oferta = new Oferta(idOferta, idUsuario, nombre, descipcion, Date.valueOf(fechaCreacion), Date.valueOf(fechaModificacion), estado);
            servicios.registrarOferta(oferta);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridadEscuela{
        return servicios.consultarNecesidades();
    }

    public void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado){
        try{
            //servicios.registrarNecesidades(idNecesidad, idUsuario, nombre, descripcion, urgencia, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void modificarNecesidad(String nombre, String descripcion, String estado){
        try{
            String id = categoria.getId();
            if(!nombre.trim().equals("")){
                servicios.actualizarNombreCategoria(id, nombre);
            }
            if(!descripcion.trim().equals("")){
                servicios.actualizarDescripcionCategoria(id, descripcion);
            }
            if(!estado.trim().equals("")){
                servicios.actualizarEstadoCategoria(id, estado);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void logOut(){
        System.out.println("Log Out");
        subject.logout();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
        }
        catch(Exception e) {
            System.out.println(e.getMessage()+" "+e.getCause());
        }
    }
}