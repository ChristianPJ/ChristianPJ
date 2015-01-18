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
import Modelo.DAO.PacienteDAO;
import Vista.PanelPaciente;
import Vista.VistaPedirCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samu
 */
public class ControladorPedirCita implements ActionListener {

    private final VistaPedirCita vista;
    private List<String> especialidades;
    private List<Medico> medicos;
    private Medico medicoGuardado;
    private Date fechaGuardada;
    private Paciente paciente;

    public ControladorPedirCita(VistaPedirCita vista, Paciente paciente) {
        this.vista = vista;
        this.paciente = paciente;
        try {
            cargarEspecialidades();
            cargarMedicos(vista.getEspecialidad());
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControladorPedirCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        try {
            if (cmd.equals(VistaPedirCita.BotonVerCitas)) {

                vista.borrarTabla();
                Date fecha = vista.getFecha();
                Calendar fechaActual = Calendar.getInstance();
                fechaActual.add(Calendar.DATE, -1);
                Date fechaAyer = fechaActual.getTime();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:SS");
                Medico medico = medicos.get(vista.getMedico());
                Date horaInicio = medico.getHorarioInicio();
                Date horaFin = medico.getHorarioFin();
                CitaDAO citaDAO = new CitaDAO();
                List<String> horasOcupadas = new ArrayList<>();
                DateFormat dateFormatHora = new SimpleDateFormat("HH:mm");
                if (fecha == null) {
                    vista.mensajeError("El campo fecha está vacío");
                } else if (fecha.compareTo(fechaAyer) < 0) {
                    vista.mensajeError("La fecha elegida ya ha expirado");
                } else {
                    SortedSet<Cita> citas = citaDAO.getCitasDelDia(fecha, medico.getIdMedico());
                    for (Cita cita : citas) {
                        horasOcupadas.add(dateFormatHora.format(cita.getFechaHora()));
                    }
                    while (horaInicio.compareTo(horaFin) <= 0) {
                        if (horasOcupadas.contains(dateFormatHora.format(horaInicio))) {
                            vista.insertarFila(dateFormatHora.format(horaInicio), false);
                        } else {
                            vista.insertarFila(dateFormatHora.format(horaInicio), true);
                        }
                        horaInicio = new Date(horaInicio.getTime() + 30 * 60000);
                    }
                }
                medicoGuardado = medico;
                fechaGuardada = fecha;
            }
            if (cmd.equals(VistaPedirCita.ListaEspecialidades)) {
                cargarMedicos(vista.getEspecialidad());
            }
            if (cmd.equals(VistaPedirCita.BotonAceptarCita)) {
                int row = vista.getSelectedRow();
                if (row == -1) {
                    vista.mensajeError("No has seleccionado ninguna cita");
                } else {
                    Date date = null;
                    DateFormat getFecha = new SimpleDateFormat("yyyy-MM-dd");
                    DateFormat construirFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    //System.out.println(getFecha.format(fechaGuardada) + " ");
                    //System.out.println(vista.getHoraSeleccionada());
                    String build = getFecha.format(fechaGuardada) + " " + vista.getHoraSeleccionada();
                    //System.out.println(build);
                    try {
                        date = construirFecha.parse(build);
                    } catch (ParseException ex) {
                        Logger.getLogger(ControladorPedirCita.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(build);
                    //System.out.println(date + " " + paciente.getIdPaciente() + " " + paciente.getIdPersona() + " " + medicoGuardado.getIdMedico() + " " + medicoGuardado.getIdPersona());
                    if (vista.getDisponibilidadSeleccionada().equals("Ocupado")) {
                        vista.mensajeError("La cita está ocupada");
                    } else {
                        CitaDAO citaDAO = new CitaDAO();
                        citaDAO.insertCita(date, paciente.getIdPaciente(), paciente.getIdPersona(), medicoGuardado.getIdMedico(), medicoGuardado.getIdPersona());
                        vista.cerrarDialog();
                        PanelPaciente panelPaciente = new PanelPaciente();
                        ControladorPaciente controladorPaciente = new ControladorPaciente(panelPaciente, paciente);
                        panelPaciente.controlador(controladorPaciente);
                        ControladorPrincipal.cambiarPanel(panelPaciente);
                    }

                }
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            //vista.error(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public final void cargarEspecialidades() throws InstantiationException, IllegalAccessException {
        especialidades = MedicoDAO.getEspecialidades();
        for (String espe : especialidades) {
            vista.rellenarEspecialidades(espe);
        }
    }

    public final void cargarMedicos(String especialidad) throws InstantiationException, IllegalAccessException {
        vista.vaciarMedicos();
        medicos = MedicoDAO.getMedicosByEspecialidad(especialidad);
        for (Medico med : medicos) {
            vista.rellenarMedicos(med.getNombre() + " " + med.getApellidos());
        }
    }
}
