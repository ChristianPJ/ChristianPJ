/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

import java.util.Date;

/**
 *
 * @author Samu
 */
public class Foto {
    
    private int idFoto;
    private String nombreFoto;
    private String extension;
    private int tamanio;
    private int idCarpeta;
    private Date fecha;

    public Foto(int idFoto, String nombreFoto, String extension, int tamanio, int idCarpeta, Date fecha) {
        this.idFoto = idFoto;
        this.nombreFoto = nombreFoto;
        this.extension = extension;
        this.tamanio = tamanio;
        this.idCarpeta = idCarpeta;
        this.fecha = fecha;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getIdCarpeta() {
        return idCarpeta;
    }

    public void setIdCarpeta(int idCarpeta) {
        this.idCarpeta = idCarpeta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
