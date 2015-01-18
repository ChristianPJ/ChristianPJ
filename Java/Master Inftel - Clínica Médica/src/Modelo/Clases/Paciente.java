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
public class Paciente extends Persona{
    private int idPaciente;
    private int numSS;
    private String opQuirurgicas;
    private String alergias;
    private String tratamientos;

    public Paciente(int idPaciente, int numSS, String opQuirurgicas, String alergias, String tratamientos, int idPersona, 
            String nombre, String apellidos, String nif, String direccion, Date fechaNacimiento, int telefono, String email, String contrasena, int perfil) {
        super(idPersona,nombre, apellidos, nif, direccion, fechaNacimiento, telefono, email, contrasena, perfil);
        this.idPaciente=idPaciente;
        this.numSS = numSS;
        this.opQuirurgicas = opQuirurgicas;
        this.alergias = alergias;
        this.tratamientos = tratamientos;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int getNumSS() {
        return numSS;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    public String getOpQuirurgicas() {
        return opQuirurgicas;
    }

    public void setOpQuirurgicas(String opQuirurgicas) {
        this.opQuirurgicas = opQuirurgicas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    
}
