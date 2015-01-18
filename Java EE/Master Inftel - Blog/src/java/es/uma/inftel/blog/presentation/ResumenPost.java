/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Post;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author miguel
 */
public class ResumenPost implements Serializable {
    
    private Long id;
    private String titulo;
    private Date fechaCreacion;
    private List<String> parrafos;
    private String username;
    private Collection<Etiqueta> listEtiqueta;
    
    public ResumenPost() {
    }
    
    public ResumenPost(Post post, int maxLengthParrafo) {
        this.id = post.getId();
        this.titulo = post.getTitulo();
        this.fechaCreacion = post.getFechaCreacion();
        this.listEtiqueta = post.getEtiquetaCollection();
        
        if (maxLengthParrafo > 0) {
            String texto = post.getTexto();
            if(texto!=null){
                boolean cortado = texto.length() > maxLengthParrafo;
                String[] tokens = texto.substring(0, Math.min(texto.length(), maxLengthParrafo)).split("\\n");
                if (cortado) {
                    String ultimoToken = tokens[tokens.length - 1];
                    int index = ultimoToken.lastIndexOf(" ");
                        if (index > 0) {
                            tokens[tokens.length - 1] = ultimoToken.substring(0, index) + " ...";
                        } else{
                            tokens[tokens.length - 1] = ultimoToken.substring(0, Math.min(ultimoToken.length(), maxLengthParrafo)) + " ...";
                        }
                }
                this.parrafos = Arrays.asList(tokens);
            }
        } else {
            this.parrafos = new ArrayList<>();
        }
        
        this.username = post.getUsuarioId().getUsername();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<String> getParrafos() {
        return parrafos;
    }

    public Collection<Etiqueta> getListEtiqueta() {
        return listEtiqueta;
    }

    public void setListEtiqueta(Collection<Etiqueta> listEtiqueta) {
        this.listEtiqueta = listEtiqueta;
    }

    public void setParrafos(List<String> parrafos) {
        this.parrafos = parrafos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
