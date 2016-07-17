/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inoff.service;

import es.inoff.Works;
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
@Path("es.inoff.works")
public class WorksFacadeREST extends AbstractFacade<Works> {
    @PersistenceContext(unitName = "InOffRestful-warPU")
    private EntityManager em;

    public WorksFacadeREST() {
        super(Works.class);
    }

    @POST
    @Override
    @Path("{create}")
    @Consumes({"application/json"})
    public void create(Works entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit={idWork}")
    @Consumes({"application/json"})
    public void edit(@PathParam("idWork") Integer idWork, Works entity) {
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
    public Works find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByActiveWork={activeWork}")
    @Produces({"application/json"})
    public List<Works> findByActiveWork(@PathParam("activeWork") Integer activeWork) {
        TypedQuery<Works> query = getEntityManager().createQuery("SELECT w FROM Works w WHERE w.activeWork = :activeWork ORDER BY w.nameWork", Works.class);
        List<Works> works = query.setParameter("activeWork", activeWork).getResultList();
        return works;
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Works> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Works> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
