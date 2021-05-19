package edu.eci.cvds.view;

import com.google.inject.Inject;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage; 

import org.apache.shiro.subject.Subject;

import edu.eci.cvds.samples.entities.Usuario;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

import edu.eci.cvds.samples.services.ServiciosSolidaridad;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean extends BasePageBean{
    //@Inject
    //private ServiciosSolidaridad servicios;

    private String user;
    private String password;
    private Subject subject;
    private Usuario currentUser;
    
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

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Usuario currentUser) {
        this.currentUser = currentUser;
    }

    public void logIn(){
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user, new Sha256Hash(password).toHex());
        try {
            subject.login(token);
            //currentUser = servicios.consultarUsuarioNombre(user);
            if (subject.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/Admin/admin.xhtml");
			}
            else if (subject.hasRole("Administrativo")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/Administrativo/administrativo.xhtml");
			}
            else if (subject.hasRole("Egresado")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/Egresado/egresado.xhtml");
			}
            else if (subject.hasRole("Profesor")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/Profesor/profesor.xhtml");
			}
            else if (subject.hasRole("Estudiante")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Roles/Estudiante/estudiante.xhtml");
			}
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage("log:Usuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Juaz juaz ", "Usuario o contraseña incorrectos"));
        }
    }

    public void logOut(){
        try{
            subject.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
        }
        catch(Exception e) {
            System.out.println(e.getMessage()+" "+e.getCause());
        }
    }
}