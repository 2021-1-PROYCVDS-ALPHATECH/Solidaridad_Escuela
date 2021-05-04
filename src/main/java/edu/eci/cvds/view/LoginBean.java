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
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.services.ExcepcionSolidaridad;
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
    private Usuario currentUser;
    private Usuario usuario;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void logIn(){
        subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user, new Sha256Hash(password).toHex());
        try {
            subject.login(token);
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

    public void actualizarCategoria(String id, String nombre, String descripcion, String estado) throws ExcepcionSolidaridad {
        if (nombre == "") nombre = null;
        if (estado == "") estado = null;
        if (descripcion == "") descripcion = null;
        servicios.actualizarCategoria(id, nombre, descripcion, estado);
    }

    public List<Oferta> consultarOfertas() throws ExcepcionSolidaridad{
        return servicios.consultarOfertas();
    }

    public void registrarOferta(String idOferta, String idUsuario, String nombre, String descripcion, String estado, String categoria){
        try{
            servicios.registrarOferta(idOferta, idUsuario, nombre, descripcion, estado, categoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Necesidad> consultarNecesidades() throws ExcepcionSolidaridad{
        return servicios.consultarNecesidades();
    }

    public void registrarNecesidad(String idNecesidad, String idUsuario, String nombre, String descripcion, String urgencia, String estado, String categoria){
        try{
            servicios.registrarNecesidad(idNecesidad, idUsuario, nombre, descripcion, urgencia, estado, categoria);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public List<Usuario> consultarUsuarios() throws ExcepcionSolidaridad{
        return servicios.consultarUsuariosRol("WHERE u.nombre = 'admin'");
    }

    public void registrarUsuario(String idUsuario, String nombre, String telefono, String email, String clave, String rol, int num){
        try {
            servicios.registrarUsuario(idUsuario, nombre, telefono, email, clave, rol, num);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarNumSolicitudes(String idUsuario, int numSolicitudes) throws ExcepcionSolidaridad{
        servicios.actualizarNumSolicitudes(idUsuario, numSolicitudes);
    }
    
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