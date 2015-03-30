package es.inftel.reciperest.data;

import es.inftel.reciperest.data.PersonHasIngredient;
import es.inftel.reciperest.data.Recipe;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T23:00:27")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> password;
    public static volatile CollectionAttribute<Person, PersonHasIngredient> personHasIngredientCollection;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, BigDecimal> id;
    public static volatile CollectionAttribute<Person, Recipe> recipeCollection;

}