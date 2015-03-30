/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museoserver.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author inftel20
 */
@Entity
@Table(name = "OBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o"),
    @NamedQuery(name = "Obra.findById", query = "SELECT o FROM Obra o WHERE o.id = :id"),
    @NamedQuery(name = "Obra.findByTitulo", query = "SELECT o FROM Obra o WHERE o.titulo = :titulo"),
    @NamedQuery(name = "Obra.findByAutor", query = "SELECT o FROM Obra o WHERE o.autor = :autor"),
    @NamedQuery(name = "Obra.findBySala", query = "SELECT o FROM Obra o WHERE o.sala = :sala"),
    @NamedQuery(name = "Obra.findByFoto", query = "SELECT o FROM Obra o WHERE o.foto = :foto"),
    @NamedQuery(name = "Obra.findByAudio", query = "SELECT o FROM Obra o WHERE o.audio = :audio"),
    @NamedQuery(name = "Obra.findByDescripcion", query = "SELECT o FROM Obra o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Obra.findByQr", query = "SELECT o FROM Obra o WHERE o.qr = :qr")})
public class Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "generadorSeqObra", sequenceName = "OBRA_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generadorSeqObra")
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 100)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 100)
    @Column(name = "AUTOR")
    private String autor;
    @Size(max = 100)
    @Column(name = "SALA")
    private String sala;
    @Size(max = 250)
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 250)
    @Column(name = "AUDIO")
    private String audio;
    @Size(max = 1024)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "QR")
    private String qr;

    public Obra() {
    }

    public Obra(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
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
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museoserver.entity.Obra[ id=" + id + " ]";
    }
    
}
