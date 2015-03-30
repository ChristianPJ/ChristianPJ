/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Alfredo
 */
@ManagedBean
public class PerfilBean {

     @EJB
    private UsuarioFacade usuarioFacade;
    
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    private String password;
    private String password2;
    private String email;
    private Part avatar;
    
    public PerfilBean() {
    }
        
    public String modificarUsuario() {
        Usuario usuario = usuarioBean.getUsuario();
        if(password.equals("")){
            password = usuarioBean.getUsuario().getPassword();
        }
        if(email.equals("")){
            email = usuarioBean.getUsuario().getEmail();
        }
       
        usuario.setPassword(password);
        usuario.setEmail(email);
        if(avatar!=null){
         try {
            usuario.setAvatar(IOUtils.toByteArray(avatar.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        usuarioFacade.modifyUser(usuario);
        return "perfil?faces-redirect=true";
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Part getAvatar() {
        return avatar;
    }

    public void setAvatar(Part avatar) {
        this.avatar = avatar;
    }
    /**
     * Creates a new instance of PerfilViewBean
     */
   
}
