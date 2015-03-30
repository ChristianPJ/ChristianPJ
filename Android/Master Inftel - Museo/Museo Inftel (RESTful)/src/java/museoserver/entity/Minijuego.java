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
@Table(name = "MINIJUEGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Minijuego.findAll", query = "SELECT m FROM Minijuego m"),
    @NamedQuery(name = "Minijuego.findById", query = "SELECT m FROM Minijuego m WHERE m.id = :id"),
    @NamedQuery(name = "Minijuego.findByPregunta", query = "SELECT m FROM Minijuego m WHERE m.pregunta = :pregunta"),
    @NamedQuery(name = "Minijuego.findByRespuesta1", query = "SELECT m FROM Minijuego m WHERE m.respuesta1 = :respuesta1"),
    @NamedQuery(name = "Minijuego.findByRespuesta2", query = "SELECT m FROM Minijuego m WHERE m.respuesta2 = :respuesta2"),
    @NamedQuery(name = "Minijuego.findByRepuesta3", query = "SELECT m FROM Minijuego m WHERE m.repuesta3 = :repuesta3")})
public class Minijuego implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "generadorSeqMinijuego", sequenceName = "MINIJUEGO_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generadorSeqMinijuego")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Size(max = 500)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @Size(max = 500)
    @Column(name = "RESPUESTA1")
    private String respuesta1;
    @Size(max = 500)
    @Column(name = "RESPUESTA2")
    private String respuesta2;
    @Size(max = 500)
    @Column(name = "REPUESTA3")
    private String repuesta3;

    public Minijuego() {
    }

    public Minijuego(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRepuesta3() {
        return repuesta3;
    }

    public void setRepuesta3(String repuesta3) {
        this.repuesta3 = repuesta3;
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
        if (!(object instanceof Minijuego)) {
            return false;
        }
        Minijuego other = (Minijuego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "museoserver.entity.Minijuego[ id=" + id + " ]";
    }
    
}
