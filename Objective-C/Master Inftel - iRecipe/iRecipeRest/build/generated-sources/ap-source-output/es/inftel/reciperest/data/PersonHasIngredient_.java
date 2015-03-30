package es.inftel.reciperest.data;

import es.inftel.reciperest.data.Ingredient;
import es.inftel.reciperest.data.Person;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-16T23:00:27")
@StaticMetamodel(PersonHasIngredient.class)
public class PersonHasIngredient_ { 

    public static volatile SingularAttribute<PersonHasIngredient, Ingredient> ingredient;
    public static volatile SingularAttribute<PersonHasIngredient, Person> person;
    public static volatile SingularAttribute<PersonHasIngredient, BigDecimal> id;
    public static volatile SingularAttribute<PersonHasIngredient, Boolean> completed;

}