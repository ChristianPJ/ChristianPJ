/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

/**
 *
 * @author Samu
 */
public class Etiqueta {
    
    private int idEtiqueta;
    private String nombre;
    private int idDirectorio;

    public Etiqueta(int idEtiqueta, String nombre, int idDirectorio) {
        this.idEtiqueta = idEtiqueta;
        this.nombre = nombre;
        this.idDirectorio = idDirectorio;
    }

    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDirectorio() {
        return idDirectorio;
    }

    public void setIdDirectorio(int idDirectorio) {
        this.idDirectorio = idDirectorio;
    }

   
}
