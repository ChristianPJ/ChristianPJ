/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Imagen;
import es.uma.inftel.blog.model.Mapa;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author miguel
 */
public class PostView extends PaginatedView {
    
    private Post post;
    private List<String> parrafosPost;
    private List<Imagen> imagenes;
    private Mapa mapa;
    private String etiquetas;
    
    public PostView() {
        this.parrafosPost = new ArrayList<>();
    }

    public Post getPost() {
        return post;
    }
    
    public void setPost(Post post) {
        this.post = post;
        this.parrafosPost = Arrays.asList(post.getTexto().split("\\n"));
    }

    public List<String> getParrafosPost() {
        return parrafosPost;
    }

    public void setParrafosPost(List<String> parrafosPost) {
        this.parrafosPost = parrafosPost;
    }
    
    public void setEtiquetas(String etiquetas){
       this.etiquetas = etiquetas;
    }
    
    public String getEtiquetas(){
        Collection<Etiqueta> cEtiqueta = post.getEtiquetaCollection();
        if(cEtiqueta == null){
            return null;
        }
        if(!cEtiqueta.isEmpty()){
            String et="";
            for (Etiqueta etiqueta : cEtiqueta){
                et = et+ " "+ etiqueta.getNombre();
            } 
            return et;
        }
        return null;
    }
    
    public List<Imagen> getImagenes(){
        return imagenes;
    }

    public void setImagenes(List listImagenes){
        imagenes = listImagenes;
    }
    
    public Mapa getMapa (){
        return mapa;
    }
    
    public void setMapa(Mapa mapa){
        this.mapa = mapa;
    }
    
}
