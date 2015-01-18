/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Blackproxy
 */
public class Informe {
    
    private final int idInforme;
    private String diagnostico;
    private String tratamiento;
    private String datosExp;
    private int idPacientePK;
    private int idPersonaPK;
    private int idMedico;
    private Blob foto;
    private Date fecha;

    public Informe(int idInforme, String diagnostico, String tratamiento, String datosExp, int idPaciente, int idPersona, int idMedico, Blob foto, Date fecha) {
        this.idInforme= idInforme;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.datosExp = datosExp;
        this.idPacientePK = idPaciente;
        this.idPersonaPK = idPersona;
        this.idMedico = idMedico;
        this.foto = foto;
        this.fecha = fecha;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDatosExp() {
        return datosExp;
    }

    public void setDatosExp(String datosExp) {
        this.datosExp = datosExp;
    }

    public int getIdPacientePK() {
        return idPacientePK;
    }

    public void setIdPacientePK(int idPaciente) {
        this.idPacientePK = idPaciente;
    }
    
     public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
