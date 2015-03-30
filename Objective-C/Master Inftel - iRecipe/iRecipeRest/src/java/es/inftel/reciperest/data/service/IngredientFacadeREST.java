/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inftel.reciperest.data.service;

import es.inftel.reciperest.data.Ingredient;
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
@Path("es.inftel.data.ingredient")
public class IngredientFacadeREST extends AbstractFacade<Ingredient> {
    @PersistenceContext(unitName = "RecipeRestPU")
    private EntityManager em;

    public IngredientFacadeREST() {
        super(Ingredient.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Ingredient create(Ingredient entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") BigDecimal id, Ingredient entity) {
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
    public Ingredient find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Path("recipe={id}")
    @Produces({"application/json"})
    public List<Ingredient> findRecipeIngredients(@PathParam("id") BigDecimal id) {
        TypedQuery<Ingredient> query = getEntityManager().createQuery("SELECT i FROM Ingredient i WHERE i.recipe.id = :id", Ingredient.class);
        List<Ingredient> ingredients = query.setParameter("id", id).getResultList();
        return ingredients;
    }
    
    @GET
    @Override
    @Produces({"application/json"})
    public List<Ingredient> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Ingredient> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
