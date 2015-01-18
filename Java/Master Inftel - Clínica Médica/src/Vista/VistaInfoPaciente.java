/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author inftel15
 */
public interface VistaInfoPaciente {
    
    public static final String BotonIrAPases = "BOTON_IR_A_PASES";
    public static final String BotonIrAInformes = "BOTON_IR_A_INFORMES";
    public static final String BotonIrARecetas = "BOTON_IR_A_RECETAS";
    
    public void cargarInfoMedico(String nombre, String apellidos, String especialidad);
    
    public void cargarInfoPaciente(String nombre, String apellidos);
    
    public void controlador(ActionListener ctr);
    
}
