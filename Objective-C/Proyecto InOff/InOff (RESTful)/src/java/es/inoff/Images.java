/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inoff;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ChristianPJ
 */
@Entity
@Table(name = "Images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findByIdImage", query = "SELECT i FROM Images i WHERE i.idImage = :idImage"),
    @NamedQuery(name = "Images.findByUrlImage", query = "SELECT i FROM Images i WHERE i.urlImage = :urlImage"),
    @NamedQuery(name = "Images.findByDateImage", query = "SELECT i FROM Images i WHERE i.dateImage = :dateImage"),
    @NamedQuery(name = "Images.findByActiveImage", query = "SELECT i FROM Images i WHERE i.activeImage = :activeImage"),
    @NamedQuery(name = "Images.findByIdWorkFK", query = "SELECT i FROM Images i WHERE i.idWorkFK = :idWorkFK"),
    @NamedQuery(name = "Images.findByIdUserFK", query = "SELECT i FROM Images i WHERE i.idUserFK = :idUserFK")})
public class Images implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idImage")
    private Integer idImage;
    @Size(max = 255)
    @Column(name = "urlImage")
    private String urlImage;
    @Column(name = "dateImage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateImage;
    @Column(name = "activeImage")
    private Integer activeImage;
    @Column(name = "idWorkFK")
    private Integer idWorkFK;
    @Column(name = "idUserFK")
    private Integer idUserFK;

    public Images() {
    }

    public Images(Integer idImage) {
        this.idImage = idImage;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Date getDateImage() {
        return dateImage;
    }

    public void setDateImage(Date dateImage) {
        this.dateImage = dateImage;
    }

    public Integer getActiveImage() {
        return activeImage;
    }

    public void setActiveImage(Integer activeImage) {
        this.activeImage = activeImage;
    }

    public Integer getIdWorkFK() {
        return idWorkFK;
    }

    public void setIdWorkFK(Integer idWorkFK) {
        this.idWorkFK = idWorkFK;
    }

    public Integer getIdUserFK() {
        return idUserFK;
    }

    public void setIdUserFK(Integer idUserFK) {
        this.idUserFK = idUserFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.inoff.Images[ idImage=" + idImage + " ]";
    }
    
}
