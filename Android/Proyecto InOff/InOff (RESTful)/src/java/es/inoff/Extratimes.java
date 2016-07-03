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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ChristianPJ
 */
@Entity
@Table(name = "Extratimes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extratimes.findAll", query = "SELECT e FROM Extratimes e"),
    @NamedQuery(name = "Extratimes.findByIdExtratime", query = "SELECT e FROM Extratimes e WHERE e.idExtratime = :idExtratime"),
    @NamedQuery(name = "Extratimes.findByDateExtratime", query = "SELECT e FROM Extratimes e WHERE e.dateExtratime = :dateExtratime"),
    @NamedQuery(name = "Extratimes.findByNumExtratime", query = "SELECT e FROM Extratimes e WHERE e.numExtratime = :numExtratime"),
    @NamedQuery(name = "Extratimes.findByIdWorkerFK", query = "SELECT e FROM Extratimes e WHERE e.idWorkerFK = :idWorkerFK")})
public class Extratimes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idExtratime")
    private Integer idExtratime;
    @Column(name = "dateExtratime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExtratime;
    @Column(name = "numExtratime")
    private Integer numExtratime;
    @Column(name = "idWorkerFK")
    private Integer idWorkerFK;

    public Extratimes() {
    }

    public Extratimes(Integer idExtratime) {
        this.idExtratime = idExtratime;
    }

    public Integer getIdExtratime() {
        return idExtratime;
    }

    public void setIdExtratime(Integer idExtratime) {
        this.idExtratime = idExtratime;
    }

    public Date getDateExtratime() {
        return dateExtratime;
    }

    public void setDateExtratime(Date dateExtratime) {
        this.dateExtratime = dateExtratime;
    }

    public Integer getNumExtratime() {
        return numExtratime;
    }

    public void setNumExtratime(Integer numExtratime) {
        this.numExtratime = numExtratime;
    }

    public Integer getIdWorkerFK() {
        return idWorkerFK;
    }

    public void setIdWorkerFK(Integer idWorkerFK) {
        this.idWorkerFK = idWorkerFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExtratime != null ? idExtratime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extratimes)) {
            return false;
        }
        Extratimes other = (Extratimes) object;
        if ((this.idExtratime == null && other.idExtratime != null) || (this.idExtratime != null && !this.idExtratime.equals(other.idExtratime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.inoff.Extratimes[ idExtratime=" + idExtratime + " ]";
    }
    
}
