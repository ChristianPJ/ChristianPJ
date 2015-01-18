/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.domain;

import es.uma.inftel.blog.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miguel
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "BlogPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByName(String username) {
        boolean existe = em.createQuery("SELECT COUNT(u.id) FROM Usuario u WHERE u.username = :username", Long.class)
                .setParameter("username", username)
                .getSingleResult() > 0;
        
        if (!existe) {
            return null;
        }
        
        return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                .setParameter("username", username)
                .getSingleResult();
    }
    
    public List findByNameLike(String username) {

        return em.createQuery("SELECT u FROM Usuario u WHERE u.username LIKE :username")
                .setParameter("username", username + "%")
                .getResultList();
    }
    
    public boolean updateUser(String username, int usertype) {

        Usuario usuario = findByName(username);
        usuario.setTipo(usertype);

        em.merge(usuario);
        
        return true;
    }

    public boolean modifyUser(Usuario usuario) {
        em.merge(usuario);
        return true;
    }
    
    
}
