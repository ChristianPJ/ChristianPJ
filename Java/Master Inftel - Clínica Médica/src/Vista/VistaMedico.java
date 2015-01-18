/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Interfaz para la pantalla principal de un Médico
 */

public interface VistaMedico {
    
    public static final String BotonIrACita = "BOTON_IR_A_CITA";
    public static final String BotonCerrarSesion = "BOTON_CERRAR_SESION";
    
    // public void insertarCita(String hora, String nombrePaciente, Integer idPaciente)
    /*
    * Inserta una cita en la tabla
    */
    public void insertarCita(String hora, String idPaciente);
    
    /*
    * Consigue el paciente seleccionado de la tabla
    */
    public int getSelectedRow();
    
    public void cargarInfoMedico(String nombre, String apellidos, String especialidad);
    
    public void mostrarError(String error);
    
    public void ocultarBoton();
    
    public JFrame getPadre();
    
    public void controlador(ActionListener ctr);
}
