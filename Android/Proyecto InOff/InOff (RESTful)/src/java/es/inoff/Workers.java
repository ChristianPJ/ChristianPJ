/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.inoff;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ChristianPJ
 */
@Entity
@Table(name = "Workers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workers.findAll", query = "SELECT w FROM Workers w"),
    @NamedQuery(name = "Workers.findByIdWorker", query = "SELECT w FROM Workers w WHERE w.idWorker = :idWorker"),
    @NamedQuery(name = "Workers.findByNameWorker", query = "SELECT w FROM Workers w WHERE w.nameWorker = :nameWorker"),
    @NamedQuery(name = "Workers.findByActiveWorker", query = "SELECT w FROM Workers w WHERE w.activeWorker = :activeWorker"),
    @NamedQuery(name = "Workers.findByIdWorkFK", query = "SELECT w FROM Workers w WHERE w.idWorkFK = :idWorkFK"),
    @NamedQuery(name = "Workers.findByIdUserFK", query = "SELECT w FROM Workers w WHERE w.idUserFK = :idUserFK")})
public class Workers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWorker")
    private Integer idWorker;
    @Size(max = 255)
    @Column(name = "nameWorker")
    private String nameWorker;
    @Column(name = "activeWorker")
    private Integer activeWorker;
    @Column(name = "idWorkFK")
    private Integer idWorkFK;
    @Column(name = "idUserFK")
    private Integer idUserFK;
    @Column(name = "hoursWorker")
    private Integer hoursWorker;

    public Workers() {
    }

    public Workers(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public Integer getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public String getNameWorker() {
        return nameWorker;
    }

    public void setNameWorker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    public Integer getActiveWorker() {
        return activeWorker;
    }

    public void setActiveWorker(Integer activeWorker) {
        this.activeWorker = activeWorker;
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
    
    public Integer getHoursWorker() {
        return hoursWorker;
    }

    public void setHoursWorker(Integer hoursWorker) {
        this.hoursWorker = hoursWorker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWorker != null ? idWorker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workers)) {
            return false;
        }
        Workers other = (Workers) object;
        if ((this.idWorker == null && other.idWorker != null) || (this.idWorker != null && !this.idWorker.equals(other.idWorker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.inoff.Workers[ idWorker=" + idWorker + " ]";
    }
    
}
