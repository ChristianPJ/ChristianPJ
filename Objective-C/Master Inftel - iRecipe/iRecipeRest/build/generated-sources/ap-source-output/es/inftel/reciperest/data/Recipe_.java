package es.inftel.reciperest.data;

import es.inftel.reciperest.data.Ingredient;
import es.inftel.reciperest.data.Person;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T23:00:27")
@StaticMetamodel(Recipe.class)
public class Recipe_ { 

    public static volatile SingularAttribute<Recipe, Person> person;
    public static volatile SingularAttribute<Recipe, String> name;
    public static volatile SingularAttribute<Recipe, String> description;
    public static volatile SingularAttribute<Recipe, byte[]> photo;
    public static volatile CollectionAttribute<Recipe, Ingredient> ingredientCollection;
    public static volatile SingularAttribute<Recipe, BigDecimal> id;
    public static volatile SingularAttribute<Recipe, String> elaborationTime;
    public static volatile SingularAttribute<Recipe, Date> creationDate;

}