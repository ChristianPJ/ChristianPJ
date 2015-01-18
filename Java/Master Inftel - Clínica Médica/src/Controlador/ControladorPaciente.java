/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.DAO.CitaDAO;
import Modelo.DAO.MedicoDAO;
import Vista.PanelDialog;
import Vista.PanelLogin;
import Vista.PanelPedirCita;
import Vista.VistaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author inftel15
 */
public class ControladorPaciente implements ActionListener{
        
    private final VistaPaciente vista;
    private final Paciente paciente;
    private List<Cita> listaCitas;

    public ControladorPaciente(VistaPaciente vista, Paciente paciente) {
        this.vista = vista;
        this.paciente = paciente;
        vista.setInfoPaciente(paciente.getNombre(), paciente.getApellidos());
        try {
            rellenarTabla();
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ControladorPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaPaciente.BotonNuevaCita:
                    PanelPedirCita panelNuevaCita = new PanelPedirCita();
                    ControladorPedirCita controladorInfoPaciente = new ControladorPedirCita(panelNuevaCita, paciente);
                    panelNuevaCita.controlador(controladorInfoPaciente);
                    JFrame parentFrame = vista.getPadre();
                    PanelDialog dialog = new PanelDialog(parentFrame,true);
                    ControladorDialog.setDialogo(dialog);
                    ControladorDialog.cargarPanelDialogo(panelNuevaCita);
                    break;
                case VistaPaciente.BotonCerrarSesion:
                    PanelLogin panelLogin = new PanelLogin();
                    ControladorLogin controladorLogin = new ControladorLogin(panelLogin);
                    panelLogin.controlador(controladorLogin);
                    ControladorPrincipal.cambiarPanel(panelLogin);
                    break;
                case VistaPaciente.BotonBorrarCita:
                    int row = vista.getSelectedRow();
                    if (row == -1){
                        vista.mensajeError("No has seleccionado ninguna cita");
                    }
                    else{
                        Cita cita = listaCitas.get(vista.getSelectedRow());
                        CitaDAO citaDAO = new CitaDAO();
                        citaDAO.borrarCita(cita.getIdCita());
                        rellenarTabla();
                    }
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    public final void rellenarTabla() throws InstantiationException, IllegalAccessException, SQLException{
        
        vista.borrarTabla();
        boolean hayCitas = false;
        Date fechaModificada = null;
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fecha2 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat construirFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        listaCitas = new ArrayList<>();
        CitaDAO daoCita = new CitaDAO();
        Date fechaActual = new Date();
        String strFecha = fecha2.format(fechaActual) + " 00:00";
        try {
            fechaModificada = construirFecha.parse(strFecha);
        } catch (ParseException ex) {
            Logger.getLogger(ControladorPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        SortedSet<Cita> listaCitasPaciente = daoCita.getCitasPaciente(paciente.getIdPaciente());
        for (Cita cita : listaCitasPaciente) {
            Medico medico = MedicoDAO.getMedicoById(cita.getIdMedicoPK());
            if (cita.getFechaHora().compareTo(fechaModificada)>=0){
                listaCitas.add(cita);
                vista.insertarCita(fecha.format(cita.getFechaHora()), hora.format(cita.getFechaHora()), medico.getEspecialiad(), medico.getNombre());
                hayCitas = true;
            }
        }
        if (!hayCitas){
            vista.mostrarError("No hay citas pendientes");
            vista.ocultarBoton();
        }
    }    
}
