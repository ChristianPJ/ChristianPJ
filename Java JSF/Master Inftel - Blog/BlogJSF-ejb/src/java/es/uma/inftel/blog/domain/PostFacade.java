/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.domain;

import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
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
    
    public Post findPostById(Long id){
        Long l = em.createQuery("SELECT count(p.id) FROM Post p WHERE p.id = ?1",Long.class).setParameter(1,id).getSingleResult();
        if(l!=0){
            return em.createQuery("SELECT p FROM Post p WHERE p.id = ?1",Post.class).setParameter(1,id).getSingleResult();
        }
        return null;
    }
    
    public List findPostBusqueda(String cadena, int firstResult, int maxResults){
        Long l = countPostBusqueda(cadena);
        if(l!=0){
            Query query = em.createQuery("SELECT p FROM Post p WHERE lower(p.titulo) LIKE :cadena")
                    .setParameter("cadena", "%" + cadena.toLowerCase() + "%");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            return query.getResultList();
        }
        return new ArrayList();
    }
    
    public Post findPostTitulo(String titulo){
       Long l = em.createQuery("SELECT count(e.id) FROM Post e WHERE e.titulo LIKE ?1",Long.class).setParameter(1,titulo).getSingleResult();
        if(l!=0){
           return em.createQuery("SELECT e FROM Post e WHERE e.titulo LIKE ?1",Post.class).setParameter(1,titulo).getSingleResult();
       }
            return null;
    }
    
    public long countPostBusqueda(String cadena){
        return em.createQuery("SELECT COUNT(p.id) FROM Post p WHERE lower(p.titulo) LIKE lower(:cadena)", Long.class)
                .setParameter("cadena", "%" + cadena.toLowerCase() + "%").getSingleResult();
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
