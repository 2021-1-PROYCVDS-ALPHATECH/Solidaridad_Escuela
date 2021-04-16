package edu.eci.cvds.view;

import com.google.inject.Inject;

import java.util.List;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext; 
import javax.faces.application.FacesMessage; 

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.jdbc.JdbcRealm;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean{
    @Inject
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
            testLog(token);
            subject.login(token);
            System.out.println("yep");
            if (subject.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/admin.xhtml");
			}
            else if (subject.hasRole("Administrativo")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrativo.xhtml");
			}
            else if (subject.hasRole("Egresado")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/egresado.xhtml");
			}
            else if (subject.hasRole("Profesor")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/profesor.xhtml");
			}
            else if (subject.hasRole("Estudiante")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/estudiante.xhtml");
			}
        } catch(Exception e) {
            System.out.println(e.getMessage()+" "+e.getCause());
        }
    }
}