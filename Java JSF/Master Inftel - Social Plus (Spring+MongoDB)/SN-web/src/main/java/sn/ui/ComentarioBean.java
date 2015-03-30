package sn.ui;

import java.io.Serializable;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.entity.Comentario;
import sn.services.ComentarioServiceImp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Component
@Scope("request")
public class ComentarioBean implements Serializable{

    @Autowired
    ComentarioServiceImp comentarioServiceImpl;
    
    @Autowired
    SessionBean sessionBean;
    
    private String titulo;
    private String imagen;
    private String texto;
    private String video;
    private Boolean privado;
    private String nombreGrupo;
    private List<Comentario> listaComentariosGrupo;
    
    private Comentario comentario;

    public ComentarioBean() {
    }
    
    @PostConstruct
    public void init(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        nombreGrupo = externalContext.getRequestParameterMap().get("grupo");
        
        if(nombreGrupo==null){
            nombreGrupo="";
        }
        listaComentariosGrupo = comentarioServiceImpl.findByGroup(nombreGrupo);
        Collections.reverse(listaComentariosGrupo);
    }
    
    public String insertarComentario() {

        comentario = new Comentario();
        comentario.setPerfil(sessionBean.getUsuario().getEmail());
        comentario.setNombre(sessionBean.getUsuario().getNombre());
        comentario.setApellido(sessionBean.getUsuario().getApellido());
        comentario.setEmailUsuario(sessionBean.getUsuario().getEmail());
        comentario.setImagenUsuario(sessionBean.getUsuario().getFoto());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        comentario.setFecha(dateFormat.format(date));
        comentario.setTitulo(this.titulo);
        comentario.setImagen(this.imagen);
        comentario.setTexto(this.texto);
        comentario.setVideo(this.video);

        if (this.nombreGrupo.length() == 0) {
            comentario.setPrivado(this.privado);
        } else {
            comentario.setPrivado(true);
        }
        
        comentario.setNombreGrupo(nombreGrupo);
        comentarioServiceImpl.create(comentario);

        if (nombreGrupo != null && !nombreGrupo.isEmpty()) {
            return "group?faces-redirect=true&grupo=" + nombreGrupo;
        }
        return "index?faces-redirect=true";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }    
  
    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<Comentario> getListaComentariosGrupo() {
        return listaComentariosGrupo;
    }

    public void setListaComentariosGrupo(List<Comentario> listaComentariosGrupo) {
        this.listaComentariosGrupo = listaComentariosGrupo;
    }
}
