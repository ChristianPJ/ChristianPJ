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
@Table(name = "Notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n"),
    @NamedQuery(name = "Notes.findByIdNote", query = "SELECT n FROM Notes n WHERE n.idNote = :idNote"),
    @NamedQuery(name = "Notes.findByDateNote", query = "SELECT n FROM Notes n WHERE n.dateNote = :dateNote"),
    @NamedQuery(name = "Notes.findByTextNote", query = "SELECT n FROM Notes n WHERE n.textNote = :textNote"),
    @NamedQuery(name = "Notes.findByActiveNote", query = "SELECT n FROM Notes n WHERE n.activeNote = :activeNote"),
    @NamedQuery(name = "Notes.findByIdWorkFK", query = "SELECT n FROM Notes n WHERE n.idWorkFK = :idWorkFK"),
    @NamedQuery(name = "Notes.findByIdUserFK", query = "SELECT n FROM Notes n WHERE n.idUserFK = :idUserFK")})
public class Notes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNote")
    private Integer idNote;
    @Column(name = "dateNote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNote;
    @Size(max = 1024)
    @Column(name = "textNote")
    private String textNote;
    @Column(name = "activeNote")
    private Integer activeNote;
    @Column(name = "idWorkFK")
    private Integer idWorkFK;
    @Column(name = "idUserFK")
    private Integer idUserFK;

    public Notes() {
    }

    public Notes(Integer idNote) {
        this.idNote = idNote;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public Integer getActiveNote() {
        return activeNote;
    }

    public void setActiveNote(Integer activeNote) {
        this.activeNote = activeNote;
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
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.inoff.Notes[ idNote=" + idNote + " ]";
    }
    
}
