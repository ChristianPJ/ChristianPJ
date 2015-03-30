/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inftel.reciperest.data.service;

import es.inftel.reciperest.data.Person;
import java.math.BigDecimal;
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
 * @author inftel22
 */
@Stateless
@Path("es.inftel.data.person")
public class PersonFacadeREST extends AbstractFacade<Person> {
    @PersistenceContext(unitName = "RecipeRestPU")
    private EntityManager em;

    public PersonFacadeREST() {
        super(Person.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public Person create(Person entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") BigDecimal id, Person entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Person find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }
    
    @GET
    @Path("name={name}")
    @Produces({"application/json"})
    public Person find(@PathParam("name") String name) {
        TypedQuery<Person> query = getEntityManager().createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class);
        List<Person> persons = query.setParameter("name", name).getResultList();
        Person person = null;
        if(!persons.isEmpty()){
            person = persons.get(0);
        } else {
            Person entity = new Person();
            entity.setName(name);
            person = create(entity);
        }
        return person;
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Person> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Person> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
