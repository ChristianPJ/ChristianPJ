package es.inftel.reciperest.data;

import es.inftel.reciperest.data.PersonHasIngredient;
import es.inftel.reciperest.data.Recipe;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T23:00:27")
@StaticMetamodel(Ingredient.class)
public class Ingredient_ { 

    public static volatile SingularAttribute<Ingredient, String> quantity;
    public static volatile CollectionAttribute<Ingredient, PersonHasIngredient> personHasIngredientCollection;
    public static volatile SingularAttribute<Ingredient, String> name;
    public static volatile SingularAttribute<Ingredient, Recipe> recipe;
    public static volatile SingularAttribute<Ingredient, BigDecimal> id;

}