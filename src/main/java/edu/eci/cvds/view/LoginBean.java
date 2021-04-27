package edu.eci.cvds.view;

import com.google.inject.Inject;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage; 

import org.apache.shiro.subject.Subject;

import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
import edu.eci.cvds.samples.services.ServiciosSolidaridad;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean extends BasePageBean{
    @Inject
    private ServiciosSolidaridad servicios;
    private String user;
    private String password;
    private Subject subject;

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

    public List<Categoria> consultarCategorias() throws ExcepcionSolidaridad{
        return servicios.consultarCategorias();
    }

    public void registrarCategoria(String id, String nombre, String descripcion){
        try{
            servicios.registrarCategoria(id, nombre, descripcion);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public List<Oferta> consultarOfertas() throws ExcepcionSolidaridad{
        return servicios.consultarOfertas();
    }

    /*public void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String fechaCreacion, String fechaModificacion, String estado){
        try{
            Oferta oferta = new Oferta(idOferta, nombre, descripcion, Date.valueOf(fechaCreacion), Date.valueOf(fechaModificacion), estado);
            servicios.registrarOferta(oferta);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }*/

    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad{
        return servicios.consultarNecesidades();
    }

    /*
    public void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado){
        try{
            servicios.registrarNecesidades(idNecesidad, idUsuario, nombre, descripcion, urgencia, estado);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }*/

    public void logOut(){
        subject.logout();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
        }
        catch(Exception e) {
            System.out.println(e.getMessage()+" "+e.getCause());
        }
    }
}