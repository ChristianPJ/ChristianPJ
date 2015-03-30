/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Usuario;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author miguel
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    @EJB
    private UsuarioFacade usuarioFacade;

    private Usuario usuario;
    
    public UsuarioBean() {
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DefaultStreamedContent getStreamedAvatar() {
        InputStream inputStream = new ByteArrayInputStream(usuario.getAvatar());
        return new DefaultStreamedContent(inputStream, "image/png");
    }
    
    public DefaultStreamedContent getStreamedAvatarIdUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        String idUsuarioParam = context.getExternalContext().getRequestParameterMap().get("idUsuario");
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        Long idUsuario = Long.valueOf(idUsuarioParam);
        byte[] foto = usuarioFacade.find(idUsuario).getAvatar();
        InputStream inputStream = new ByteArrayInputStream(foto);
        return new DefaultStreamedContent(inputStream, "image/png");
    }
    
}
