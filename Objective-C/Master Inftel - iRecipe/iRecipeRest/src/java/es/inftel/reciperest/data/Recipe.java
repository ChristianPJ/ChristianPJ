/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inftel.reciperest.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inftel22
 */
@Entity
@Table(name = "RECIPE")
@XmlRootElement
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Size(max = 200)
    @Column(name = "ELABORATION_TIME")
    private String elaborationTime;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "PHOTO")
    private byte[] photo;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Person person;
    /*@JoinColumn(name = "RECIPE_TYPE_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private RecipeType recipeTypeId;*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Collection<Ingredient> ingredientCollection;

    public Recipe() {
    }

    public Recipe(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElaborationTime() {
        return elaborationTime;
    }

    public void setElaborationTime(String elaborationTime) {
        this.elaborationTime = elaborationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /*public RecipeType getRecipeTypeId() {
        return recipeTypeId;
    }

    public void setRecipeTypeId(RecipeType recipeTypeId) {
        this.recipeTypeId = recipeTypeId;
    }*/

    @XmlTransient
    public Collection<Ingredient> getIngredientCollection() {
        return ingredientCollection;
    }

    public void setIngredientCollection(Collection<Ingredient> ingredientCollection) {
        this.ingredientCollection = ingredientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.inftel.data.Recipe[ id=" + id + " ]";
    }
    
}
