/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.entity.Comentario;
import sn.services.ComentarioServiceImp;

/**
 *
 * @author Andres
 */
@Component
@Scope("request")
public class CommentBean {

    @Autowired
    private SessionBean sessionBean;
    
    @Autowired
    private ComentarioServiceImp comentarioServiceImp;

    private String id;

    public CommentBean() {
    }

    public String copy() {
        Comentario comentario = comentarioServiceImp.findById(id);
        List<Comentario> storedComments = comentarioServiceImp.findByProfileAndContent(sessionBean.getUsuario().getEmail(), comentario.getEmailUsuario(), comentario.getTexto(), comentario.getImagen(), comentario.getVideo());
        if (storedComments == null || storedComments.isEmpty()) {
            comentario.setId(null);
            comentario.setPerfil(sessionBean.getUsuario().getEmail());
            comentario.setNombreGrupo(null);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            comentario.setFecha(dateFormat.format(date));
            comentarioServiceImp.create(comentario);
        }

        return "userProfile?faces-redirect=true";
    }

    public String delete() {
        Comentario comentario = comentarioServiceImp.findById(id);
        comentarioServiceImp.delete(comentario);
        return "userProfile?faces-redirect=true";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
