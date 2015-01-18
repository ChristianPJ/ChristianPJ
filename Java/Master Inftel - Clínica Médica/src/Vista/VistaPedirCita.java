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
 * @author Samu
 */
public interface VistaPedirCita {
    
    public static final String BotonVerCitas = "BOTON_VER_CITAS";
    public static final String BotonAceptarCita = "BOTON_ACEPTAR_CITAS";
    public static final String ListaEspecialidades = "LISTA_ESPECIALIDADES";
    
    public int getMedico();
    public void vaciarMedicos();
    public void rellenarMedicos(String nombreMedico);
    public String getEspecialidad();
    public Date getFecha();
    public void borrarTabla();
    public int getSelectedRow();
    public void mensajeError(String message);
    public void rellenarEspecialidades(String especialidad);
    public void insertarFila(String hora, boolean disponibilidad);
    public String getHoraSeleccionada();
    public String getDisponibilidadSeleccionada();
    public void cerrarDialog();
    public void controlador(ActionListener ctr);
}
