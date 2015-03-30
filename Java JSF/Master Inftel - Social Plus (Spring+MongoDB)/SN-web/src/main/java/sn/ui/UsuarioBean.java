package sn.ui;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.entity.Usuario;
import sn.services.UsuarioServiceImp;
import sn.entity.Comentario;
import sn.services.ComentarioServiceImp;

@Component
@Scope("view")
public class UsuarioBean implements Serializable{
    
    @Autowired
    private UsuarioServiceImp usuarioServiceImpl;
    
    @Autowired
    private ComentarioServiceImp comentarioServiceImpl;
    
    @Autowired
    private SessionBean sessionBean;
    
    private Usuario usuario;
    private List<Comentario> listaComentarios;
    
    private String emailBusqueda;
    private String respuesta;
    
    public UsuarioBean() {  
    }
    
    @PostConstruct
    public void init(){
        if(sessionBean.getUsuario() == null) {
            return;
        }
        String email = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("email");
        if(email != null && !email.isEmpty()) {
            usuario = usuarioServiceImpl.findByEmail(email);
            listaComentarios = comentarioServiceImpl.findByEmailAndPrivate(usuario.getEmail(), false);
        } else {
            usuario = sessionBean.getUsuario();
            listaComentarios = comentarioServiceImpl.findAllByEmail(usuario.getEmail());
        }

        Collections.reverse(listaComentarios);
        if (this.listaComentarios.isEmpty()) {
            this.respuesta = "no tiene comentarios";
        } else {
            this.respuesta = "" + listaComentarios.size();
        }
    }
    
    public String find(){
        String salida;
        Usuario user = usuarioServiceImpl.findByEmail(emailBusqueda);
        if (user == null){
             salida="index?faces-redirect=true";
        }else{
            salida="userProfile?faces-redirect=true&email=" + emailBusqueda;
        }
        return salida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEmailBusqueda() {
        return emailBusqueda;
    }

    public void setEmailBusqueda(String emailBusqueda) {
        this.emailBusqueda = emailBusqueda;
    } 
}
