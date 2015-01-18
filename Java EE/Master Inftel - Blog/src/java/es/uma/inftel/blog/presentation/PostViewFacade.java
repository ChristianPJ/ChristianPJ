/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.domain.ImagenFacade;
import es.uma.inftel.blog.domain.MapaFacade;
import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.model.Comentario;
import es.uma.inftel.blog.model.Mapa;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author miguel
 */
public class PostViewFacade extends BaseViewFacade<PostView> {
    
    private final PostFacade postFacade;
    private final ImagenFacade imagenFacade;
    private final MapaFacade mapaFacade;
    
    public PostViewFacade(PostFacade postFacade, ImagenFacade imagenFacade, MapaFacade mapaFacade) {
        super(postFacade);
        this.postFacade = postFacade;
        this.imagenFacade = imagenFacade;
        this.mapaFacade = mapaFacade;
    }
    
    public PostView createPostView(Long postId) {
        PostView postView = new PostView();
        
        initView(postView);
        
        postView.setPost(postFacade.find(postId));

        for (Comentario col : postView.getPost().getComentarioCollection()) {
            System.out.println(col.getTexto());  
        }

        postView.setImagenes(imagenFacade.findImagenesPost(postId));
        Post post = postView.getPost();
        Collection<Mapa> mapasPost = post.getMapaCollection();
        List listMapaPost = new ArrayList(mapasPost);
        if(!mapasPost.isEmpty()){
            postView.setMapa((Mapa)listMapaPost.get(0));
        }
        return postView;
    }
    
}
