/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.domain;

import es.uma.inftel.blog.model.Etiqueta;
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
 * @author miguel
 */
@Stateless
public class EtiquetaFacade extends AbstractFacade<Etiqueta> {
    @EJB
    private PostFacade postFacade;
    
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtiquetaFacade() {
        super(Etiqueta.class);
    } 

    public Etiqueta findEtiquetaNombre(String nombre){
        Long l = em.createQuery("SELECT count(e.id) FROM Etiqueta e WHERE e.nombre LIKE ?1",Long.class).setParameter(1,nombre).getSingleResult();
        if(l!=0){
            return em.createQuery("SELECT e FROM Etiqueta e WHERE e.nombre LIKE ?1",Etiqueta.class).setParameter(1,nombre).getSingleResult();
        }
        return null;
    }

    public List findTrendingEtiquetas(){

        return em.createQuery("SELECT e FROM Etiqueta e ORDER BY SIZE (e.postCollection) DESC").getResultList();   
    }   
    
    public List findEtiquetasPost(Long id){
        Post post = postFacade.find(id);
        Collection<Etiqueta> etiquetasPost = post.getEtiquetaCollection();
        List listEtiquetasPost = new ArrayList(etiquetasPost);
        return listEtiquetasPost;
    }
}
