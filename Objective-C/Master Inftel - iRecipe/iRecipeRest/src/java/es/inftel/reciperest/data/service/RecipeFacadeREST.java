/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inftel.reciperest.data.service;

import es.inftel.reciperest.data.Ingredient;
import es.inftel.reciperest.data.Recipe;
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
@Path("es.inftel.data.recipe")
public class RecipeFacadeREST extends AbstractFacade<Recipe> {
    @PersistenceContext(unitName = "RecipeRestPU")
    private EntityManager em;

    public RecipeFacadeREST() {
        super(Recipe.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Recipe create(Recipe entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") BigDecimal id, Recipe entity) {
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
    public Recipe find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Recipe> findAll() {
        TypedQuery<Recipe> query = getEntityManager().createQuery("SELECT r FROM Recipe r ORDER BY r.name", Recipe.class);
        List<Recipe> recipes = query.getResultList();
        return recipes;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Recipe> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
