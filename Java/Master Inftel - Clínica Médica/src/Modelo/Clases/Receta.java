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
public class Receta {
    private int idReceta;
    private String indicaciones;
    private String medicamento;
    private int idCitaPK;

    public Receta(int idReceta,String indicaciones, String medicamento, int idCitaPK) {
        this.idReceta = idReceta;
        this.indicaciones = indicaciones;
        this.medicamento = medicamento;
        this.idCitaPK = idCitaPK;
    }

    public Receta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdReceta() {
        return idReceta;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getIdCitaPK() {
        return idCitaPK;
    }

    public void setIdCitaPK(int idCitaPK) {
        this.idCitaPK = idCitaPK;
    }
    
}
