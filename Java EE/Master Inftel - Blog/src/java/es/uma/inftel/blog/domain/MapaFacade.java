/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.domain;

import es.uma.inftel.blog.model.Mapa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maramec
 */
@Stateless
public class MapaFacade extends AbstractFacade<Mapa> {
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapaFacade() {
        super(Mapa.class);
    }
    
    public Mapa findMapaPost(Long id){
         
        Long l = em.createQuery("SELECT count(m.id) FROM Mapa m WHERE m.postId = ?1",Long.class).setParameter(1,id).getSingleResult();
         if(l!=0){
            return em.createQuery("SELECT m FROM Mapa m WHERE m.postId = ?1",Mapa.class).setParameter(1,id).getSingleResult();
         }
         return null;
    }
    
}
