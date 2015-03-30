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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Miguel
 */
@ManagedBean
public class RegistroBean {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    private String username;
    private String password;
    private String password2;
    private String email;
    private Part avatar;
    private boolean errorRegistro;
    
    public RegistroBean() {
    }
    
    public String registrarUsuario() {
        if (usuarioFacade.findByName(username) != null) {
            setErrorRegistro(true);
            return "registro";
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setTipo(Usuario.TIPO_NORMAL);
        try {
            usuario.setAvatar(IOUtils.toByteArray(avatar.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(RegistroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuarioFacade.create(usuario);
        
        usuarioBean.setUsuario(usuario);
        
        return "index?faces-redirect=true";
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword2(String password) {
        this.password2 = password;
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
    
    public boolean isErrorRegistro() {
        return errorRegistro;
    }

    public void setErrorRegistro(boolean errorRegistro) {
        this.errorRegistro = errorRegistro;
    }
    
}
