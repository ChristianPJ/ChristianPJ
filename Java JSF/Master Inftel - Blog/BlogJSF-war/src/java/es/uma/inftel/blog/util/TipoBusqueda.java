/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.util;

/**
 *
 * @author miguel
 */
public enum TipoBusqueda {
    ETIQUETA(1),
    CADENA_TITULO(2),
    USUARIO(3);
    
    private int id;
    
    private TipoBusqueda(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
