/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

/**
 *
 * @author Miguel
 */
public class RegistroView extends BaseView {
    
    private boolean errorRegistro;

    public boolean isErrorRegistro() {
        return errorRegistro;
    }

    public void setErrorRegistro(boolean errorRegistro) {
        this.errorRegistro = errorRegistro;
    }
    
}
