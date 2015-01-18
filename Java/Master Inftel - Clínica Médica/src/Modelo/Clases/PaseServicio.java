/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

/**
 *
 * @author Blackproxy
 */
public class PaseServicio {
    private int idPaseServicio;
    private String prueba;
    private String causa;
    private int idCita;

    public PaseServicio(int idPaseServicio,String prueba, String causa, int idCita) {
        this.idPaseServicio=idPaseServicio;
        this.prueba = prueba;
        this.causa = causa;
        this.idCita = idCita;
    }

    public int getIdPaseServicio() {
        return idPaseServicio;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public void setIdPaseServicio(int idPaseServicio) {
        this.idPaseServicio = idPaseServicio;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    
}
