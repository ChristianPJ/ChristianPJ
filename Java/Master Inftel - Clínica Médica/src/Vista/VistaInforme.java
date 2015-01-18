/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author inftel18
 */
public interface VistaInforme {
    
    public static final String BotonCrearInforme = "BOTON_IR_A_CREARINFORME";
    public static final String BotonMostrarInforme = "BOTON_IR_A_MOSTRARINFORME";
    public static final String BotonVolverInforme = "BOTON_IR_A_OPCIONES";
    
    public void controlador(ActionListener ctr);

    public void meterInformeTabla(int idInforme, String especialiad, Date fecha);
    
    public void cambiarLabel(String s);
    
    public int getSelectedRow();
    
    
}
