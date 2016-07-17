/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inoff.service;

import es.inoff.Workers;
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
import javax.ws.rs.QueryParam;

/**
 *
 * @author ChristianPJ
 */
@Stateless
@Path("es.inoff.workers")
public class WorkersFacadeREST extends AbstractFacade<Workers> {
    @PersistenceContext(unitName = "InOffRestful-warPU")
    private EntityManager em;

    public WorkersFacadeREST() {
        super(Workers.class);
    }

    @POST
    @Override
    @Path("{create}")
    @Consumes({"application/json"})
    public void create(Workers entity) {
        super.create(entity);
    }

    @PUT
    @Path("edit={idWorker}")
    @Consumes({"application/json"})
    public void edit(@PathParam("idWorker") Integer id, Workers entity) {
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
    public Workers find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByActiveWorker={activeWorker}")
    @Produces({"application/json"})
    public List<Workers> findByActiveWorker(@PathParam("activeWorker") Integer activeWorker) {
        TypedQuery<Workers> query = getEntityManager().createQuery("SELECT w FROM Workers w WHERE w.activeWorker = :activeWorker", Workers.class);
        List<Workers> workers = query.setParameter("activeWorker", activeWorker).getResultList();
        return workers;
    }
    
    @GET
    @Path("findByIdWorkFK={idWorkFK}")
    @Produces({"application/json"})
    public List<Workers> findByIdWorkFK(@PathParam("idWorkFK") Integer idWorkFK) {
        TypedQuery<Workers> query = getEntityManager().createQuery("SELECT w FROM Workers w WHERE w.idWorkFK = :idWorkFK AND w.activeWorker = 1 ORDER BY w.nameWorker", Workers.class);
        List<Workers> workers = query.setParameter("idWorkFK", idWorkFK).getResultList();
        return workers;
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Workers> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Workers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
