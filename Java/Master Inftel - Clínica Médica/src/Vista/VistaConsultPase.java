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
public interface VistaConsultPase {
    public static final String BotonCrearPase = "BOTON_IR_A_CREARPASE";
    public static final String BotonVolver = "BOTON_VOLVER";
    public static final String BotonMostrar = "BOTON_MOSTRAR";
    public void controlador(ActionListener ctr);
    public void meterPasetabla(String prueba, String causa);
    public void cambiarLabel(String s);
    public int getSelectedRow();
}
