/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inoff.service;

import es.inoff.Extratimes;
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
@Path("es.inoff.extratimes")
public class ExtratimesFacadeREST extends AbstractFacade<Extratimes> {
    @PersistenceContext(unitName = "InOffRestful-warPU")
    private EntityManager em;

    public ExtratimesFacadeREST() {
        super(Extratimes.class);
    }

    @POST
    @Override
    @Path("{create}")
    @Consumes({"application/json"})
    public void create(Extratimes entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit={idWorker}")
    @Consumes({"application/json"})
    public void edit(@PathParam("idWorker") Integer idWorker, Extratimes entity) {
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
    public Extratimes find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByIdWorkerFK={idWorkerFK}")
    @Produces({"application/json"})
    public List<Extratimes> findByIdWorkerFK(@PathParam("idWorkerFK") Integer idWorkerFK) {
        TypedQuery<Extratimes> query = getEntityManager().createQuery
        ("SELECT w FROM Extratimes w WHERE w.idWorkerFK = :idWorkerFK AND w.numExtratime > 0 ORDER BY w.dateExtratime DESC", Extratimes.class);
        List<Extratimes> extratimes = query.setParameter("idWorkerFK", idWorkerFK).getResultList();
        return extratimes;
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Extratimes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Extratimes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
