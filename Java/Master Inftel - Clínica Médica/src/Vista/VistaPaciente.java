/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author inftel15
 */
public interface VistaPaciente {
    
    public static final String BotonNuevaCita = "BOTON_NUEVA_CITA";
    public static final String BotonCerrarSesion = "BOTON_CERRAR_SESION";
    public static final String BotonBorrarCita = "BOTON_BORRAR_CITA";
    
    public void setInfoPaciente(String nombre, String apellidos);
    
    public void mostrarError(String error);
    
    public void ocultarBoton();
    
    public int getSelectedRow();
    
    public void mensajeError(String message);
    
    public void borrarTabla();
            
    public void insertarCita(String fecha, String hora, String especialidadMedico, String nombreMedico);
    
    public JFrame getPadre();
    
    public void controlador(ActionListener ctr);
}
