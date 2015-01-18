/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

import java.util.Date;

/**
 *
 * @author Blackproxy
 */
public class Medico extends Persona{
    
    private int idMedico;
    private String especialiad;
    private Date horarioInicio;
    private Date horarioFin;

    public Medico(int idMedico,String especialiad, Date horarioInicio, Date horarioFin, int idPersona, String nombre, String apellidos, String nif, String direccion, Date fechaNacimiento, int telefono, String email, String contrasena, int perfil) {
        super(idPersona,nombre, apellidos, nif, direccion, fechaNacimiento, telefono, email, contrasena, perfil);
        this.idMedico = idMedico;
        this.especialiad = especialiad;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public String getEspecialiad() {
        return especialiad;
    }

    public void setEspecialiad(String especialiad) {
        this.especialiad = especialiad;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(Date horarioFin) {
        this.horarioFin = horarioFin;
    }
    
}
