/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inoff.service;

import es.inoff.Images;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author ChristianPJ
 */
@Stateless
@Path("es.inoff.images")
public class ImagesFacadeREST extends AbstractFacade<Images> {
    @PersistenceContext(unitName = "InOffRestful-warPU")
    private EntityManager em;

    public ImagesFacadeREST() {
        super(Images.class);
    }

    @POST
    @Override
    @Path("{create}")
    @Consumes({"application/json"})
    public void create(Images entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit={idImage}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Images entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Images find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByIdWorkFK={idWorkFK}")
    @Produces({"application/json"})
    public List<Images> findByIdWorkFK(@PathParam("idWorkFK") Integer idWorkFK) {
        TypedQuery<Images> query = getEntityManager().createQuery("SELECT w FROM Images w WHERE w.idWorkFK = :idWorkFK AND w.activeImage = 1", Images.class);
        List<Images> images = query.setParameter("idWorkFK", idWorkFK).getResultList();
        return images;
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Images> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Images> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
