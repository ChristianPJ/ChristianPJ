/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inftel.reciperest.data.service;

import es.inftel.reciperest.data.Ingredient;
import es.inftel.reciperest.data.PersonHasIngredient;
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
@Path("es.inftel.data.personhasingredient")
public class PersonHasIngredientFacadeREST extends AbstractFacade<PersonHasIngredient> {
    @PersistenceContext(unitName = "RecipeRestPU")
    private EntityManager em;

    public PersonHasIngredientFacadeREST() {
        super(PersonHasIngredient.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public PersonHasIngredient create(PersonHasIngredient entity) {
       TypedQuery<PersonHasIngredient> query = getEntityManager().createQuery("SELECT p FROM PersonHasIngredient p WHERE p.ingredient.id = :ingredientId AND p.person.id = :personId", PersonHasIngredient.class);
        List<PersonHasIngredient> persons = query
                .setParameter("ingredientId", entity.getIngredient().getId())
                .setParameter("personId", entity.getPerson().getId())
                .getResultList();
        PersonHasIngredient person = null;
        if(!persons.isEmpty()){
            person = persons.get(0);
            person.setCompleted(entity.getCompleted());
            getEntityManager().merge(person);
        } else {
            getEntityManager().persist(entity);
            person = entity;
        }
        return person;
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") BigDecimal id, PersonHasIngredient entity) {
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
    public PersonHasIngredient find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }
    
    @GET
    @Path("recipe={idRecipe}&&person={idPerson}")
    @Produces({"application/json"})
    public List<PersonHasIngredient> findPersonIngredients(@PathParam("idRecipe") BigDecimal idRecipe, @PathParam("idPerson") BigDecimal idPerson) {
        TypedQuery<PersonHasIngredient> query = getEntityManager().createQuery("SELECT p FROM PersonHasIngredient p WHERE p.ingredient.recipe.id = :idRecipe AND p.person.id = :idPerson", PersonHasIngredient.class);
        List<PersonHasIngredient> ingredients = query.setParameter("idRecipe", idRecipe).setParameter("idPerson", idPerson).getResultList();
        return ingredients;
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<PersonHasIngredient> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<PersonHasIngredient> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
