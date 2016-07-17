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
@Table(name = "Works")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Works.findAll", query = "SELECT w FROM Works w ORDER BY w.nameWork"),
    @NamedQuery(name = "Works.findByIdWork", query = "SELECT w FROM Works w WHERE w.idWork = :idWork"),
    @NamedQuery(name = "Works.findByIconWork", query = "SELECT w FROM Works w WHERE w.iconWork = :iconWork"),
    @NamedQuery(name = "Works.findByNameWork", query = "SELECT w FROM Works w WHERE w.nameWork = :nameWork"),
    @NamedQuery(name = "Works.findByDateWork", query = "SELECT w FROM Works w WHERE w.dateWork = :dateWork"),
    @NamedQuery(name = "Works.findByActiveWork", query = "SELECT w FROM Works w WHERE w.activeWork = :activeWork"),
    @NamedQuery(name = "Works.findByIdUserFK", query = "SELECT w FROM Works w WHERE w.idUserFK = :idUserFK")})
public class Works implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWork")
    private Integer idWork;
    @Column(name = "iconWork")
    private Integer iconWork;
    @Size(max = 255)
    @Column(name = "nameWork")
    private String nameWork;
    @Column(name = "dateWork")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateWork;
    @Column(name = "activeWork")
    private Integer activeWork;
    @Column(name = "idUserFK")
    private Integer idUserFK;

    public Works() {
    }

    public Works(Integer idWork) {
        this.idWork = idWork;
    }

    public Integer getIdWork() {
        return idWork;
    }

    public void setIdWork(Integer idWork) {
        this.idWork = idWork;
    }

    public Integer getIconWork() {
        return iconWork;
    }

    public void setIconWork(Integer iconWork) {
        this.iconWork = iconWork;
    }

    public String getNameWork() {
        return nameWork;
    }

    public void setNameWork(String nameWork) {
        this.nameWork = nameWork;
    }

    public Date getDateWork() {
        return dateWork;
    }

    public void setDateWork(Date dateWork) {
        this.dateWork = dateWork;
    }

    public Integer getActiveWork() {
        return activeWork;
    }

    public void setActiveWork(Integer activeWork) {
        this.activeWork = activeWork;
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
        hash += (idWork != null ? idWork.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Works)) {
            return false;
        }
        Works other = (Works) object;
        if ((this.idWork == null && other.idWork != null) || (this.idWork != null && !this.idWork.equals(other.idWork))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.inoff.Works[ idWork=" + idWork + " ]";
    }
    
}
