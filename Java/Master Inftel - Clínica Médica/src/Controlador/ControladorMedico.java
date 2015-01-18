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
import Modelo.DAO.PacienteDAO;
import Vista.PanelDialog;
import Vista.PanelInfoPaciente;
import Vista.PanelLogin;
import Vista.VistaMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import javax.swing.JFrame;

/**
 * Controlador para la pantalla principal del Médico
 */
public class ControladorMedico implements ActionListener {

    private VistaMedico vista;
    private Medico medico;
    private List<Paciente> listaPacientes;
    private List<Cita> listaCitas;
    int idPacienteSeleccionado;
    
    public ControladorMedico(VistaMedico vista, Medico medico) throws SQLException {
        this.vista = vista;
        this.medico = medico;
        try {
            vista.cargarInfoMedico(medico.getNombre(), medico.getApellidos(), medico.getEspecialiad());
            rellenarTabla();
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            if (cmd.equals(VistaMedico.BotonIrACita)) {
                idPacienteSeleccionado = listaPacientes.get(vista.getSelectedRow()).getIdPaciente();
                Cita cita = listaCitas.get(vista.getSelectedRow());
                Paciente paci = PacienteDAO.getPacienteById(idPacienteSeleccionado);
                PanelInfoPaciente panelInfoPaciente = new PanelInfoPaciente();
                ControladorInfoPaciente controladorInfoPaciente = new ControladorInfoPaciente(panelInfoPaciente, medico, paci, cita);
                panelInfoPaciente.controlador(controladorInfoPaciente);
                
                JFrame parentFrame = vista.getPadre();
                PanelDialog dialog = new PanelDialog(parentFrame,true);
                dialog.setLocationRelativeTo(null);
                ControladorDialog.setDialogo(dialog);
                ControladorDialog.cargarPanelDialogo(panelInfoPaciente);
            }
            if (cmd.equals(VistaMedico.BotonCerrarSesion)) {
                PanelLogin panelLogin = new PanelLogin();
                ControladorLogin controladorLogin = new ControladorLogin(panelLogin);
                panelLogin.controlador(controladorLogin);
                
                ControladorPrincipal.cambiarPanel(panelLogin);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public final void rellenarTabla() throws InstantiationException, IllegalAccessException, SQLException {
        
        listaPacientes = new ArrayList<>();
        listaCitas = new ArrayList<>();
        DateFormat dateFormatHora = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        CitaDAO daoCita = new CitaDAO();
        SortedSet<Cita> listaCitasDia = daoCita.getCitasDelDia(date, medico.getIdMedico());
        //System.out.println(listaCitasDia);
        if (listaCitasDia.isEmpty()){
            vista.mostrarError("No hay citas para hoy");
            vista.ocultarBoton();
        }
        else{
            for (Cita cita : listaCitasDia) {
                Paciente paci = PacienteDAO.getPacienteById(cita.getIdPacientePK());
                listaPacientes.add(paci);
                listaCitas.add(cita);
                vista.insertarCita(dateFormatHora.format(cita.getFechaHora()), paci.getNombre() + " " + paci.getApellidos());
            }
        }
        
    }

}
