/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Blackproxy
 */
public class Cita implements Comparable<Cita>{
    private int idCita;
    private Date fechaHora;
    private int idPacientePK;
    private int idMedicoPK;

    public Cita(int idCita,Date fechaHora, int idPacientePK, int idMedicoPK) {
        this.idCita=idCita;
        this.fechaHora = fechaHora;
        this.idPacientePK = idPacientePK;
        this.idMedicoPK = idMedicoPK;
    }

    public int getIdCita() {
        return idCita;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdPacientePK() {
        return idPacientePK;
    }

    public void setIdPacientePK(int idPacientePK) {
        this.idPacientePK = idPacientePK;
    }

    public int getIdMedicoPK() {
        return idMedicoPK;
    }

    public void setIdMedicoPK(int idMedicoPK) {
        this.idMedicoPK = idMedicoPK;
    }

    @Override
    public int compareTo(Cita o) {
        return getFechaHora().compareTo(o.getFechaHora());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.fechaHora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cita other = (Cita) obj;
        return Objects.equals(this.fechaHora, other.fechaHora);
    }   
}
