package Vista;

import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alfredo
 */
public interface VistaCrearPase {
    public static final String BotonGuardarPase = "BOTON_GUARDAR_PASE";
    public static final String BotonVolver = "BOTON_VOLVER"; 
    public String getPrueba();
    public String getCausa();
    public void cambiarLabel(String s);
    public void controlador(ActionListener ctr);
}
