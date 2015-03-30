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
public class Info {
    
    private String valor;
    private int idFoto;
    private int idEqtiqueta;
    private int idDirectorio;

    public Info(String valor, int idFoto, int idEqtiqueta, int idDirectorio) {
        this.valor = valor;
        this.idFoto = idFoto;
        this.idEqtiqueta = idEqtiqueta;
        this.idDirectorio = idDirectorio;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getIdEqtiqueta() {
        return idEqtiqueta;
    }

    public void setIdEqtiqueta(int idEqtiqueta) {
        this.idEqtiqueta = idEqtiqueta;
    }

    public int getIdDirectorio() {
        return idDirectorio;
    }

    public void setIdDirectorio(int idDirectorio) {
        this.idDirectorio = idDirectorio;
    }
    
    
}
