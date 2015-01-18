/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author Alfredo
 */
public interface VistaCMostrarPase {
    public static final String BotonVolver = "BOTON_VOLVER";  
    public String getPrueba();
    public String getCausa();
    public void cambiarLabel(String s);
    public void controlador(ActionListener ctr);
    public void setInfo(String Prueba, String Causa);
}
