/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.domain;

import es.uma.inftel.blog.model.Post;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> {
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    public List findPostBusqueda(String cadena, int firstResult, int maxResults){
        Query query = em.createQuery("SELECT p FROM Post p WHERE p.titulo LIKE :cadena")
                .setParameter("cadena", "%" + cadena + "%");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        
        return query.getResultList();
    }
    
    public long countPostBusqueda(String cadena){
        return em.createQuery("SELECT COUNT(p.id) FROM Post p WHERE p.titulo LIKE :cadena", Long.class)
                .setParameter("cadena", "%" + cadena + "%").getSingleResult();
    }
    
    public List<Post> findAllPostsOrderedByCreationDateDesc() {
        return em.createQuery("SELECT p FROM Post p ORDER BY p.fechaCreacion DESC", Post.class).getResultList();
    }
    
    public List<Post> findRangeOfPostsOrderedByCreationDateDesc(int firstResult, int maxResults) {
        Query query = em.createQuery("SELECT p FROM Post p ORDER BY p.fechaCreacion DESC");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }
    
}
