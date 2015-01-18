/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.domain;

import es.uma.inftel.blog.model.Imagen;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maramec
 */
@Stateless
public class ImagenFacade extends AbstractFacade<Imagen> {
    @EJB
    private PostFacade postFacade;
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImagenFacade() {
        super(Imagen.class);
    }
    
    public List findImagenesPost(Long id){
        Post post = postFacade.find(id);
        Collection<Imagen> imagenesPost = post.getImagenCollection();
        List listImagenesPost = new ArrayList(imagenesPost);
        return listImagenesPost;
    }
}
