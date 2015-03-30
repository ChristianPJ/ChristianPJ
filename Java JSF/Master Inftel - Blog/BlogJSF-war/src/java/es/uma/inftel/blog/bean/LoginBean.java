/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Miguel
 */
@ManagedBean
public class LoginBean {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    
    private String username;
    private String password;
    private boolean errorLogin;
    
    public LoginBean() {
    }
    
    public String identificarUsuario() {
        Usuario usuario = usuarioFacade.findByName(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            setErrorLogin(false);
            usuarioBean.setUsuario(usuario);
            return "index?faces-redirect=true";
        }
        setErrorLogin(true);
        return "login";
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
    
    public boolean isErrorLogin() {
        return errorLogin;
    }

    public void setErrorLogin(boolean errorLogin) {
        this.errorLogin = errorLogin;
    }
    
}
