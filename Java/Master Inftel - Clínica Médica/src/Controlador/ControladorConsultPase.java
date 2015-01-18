/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.Clases.PaseServicio;
import Modelo.DAO.InformeDAO;
import Modelo.DAO.PacienteDAO;

import Modelo.DAO.PaseServicioDAO;
import Vista.PanelCMostrarPase;
import Vista.PanelCrearPase;
import Vista.PanelInfoPaciente;
import Vista.VistaConsultPase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alfredo
 */
public class ControladorConsultPase implements ActionListener {

    private VistaConsultPase vista;
    private Paciente paciente;
    private List<PaseServicio> ListaPaseServicio;
    private Medico medico;
    private Cita cita;
    int idPaseSeleccionado;

    public ControladorConsultPase(VistaConsultPase vista, Medico medico, Paciente paciente, Cita cita) throws SQLException, InstantiationException, IllegalAccessException {
        this.vista = vista;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
        PaseServicioDAO i = new PaseServicioDAO();
        ListaPaseServicio=i.leerPases(paciente.getIdPaciente());
        try {

            rellenarTabla();
            vista.cambiarLabel(paciente.getApellidos() + ", " + paciente.getNombre());
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaConsultPase.BotonCrearPase: {

                    PanelCrearPase panelPaseCrear = new PanelCrearPase();
                    ControladorCrearPase controladorCrearPase = new ControladorCrearPase(panelPaseCrear, medico, paciente, cita);
                    panelPaseCrear.controlador(controladorCrearPase);
                    ControladorDialog.cargarPanelDialogo(panelPaseCrear);

                    break;
                }

                case VistaConsultPase.BotonVolver: {

                    PanelInfoPaciente panelInfo = new PanelInfoPaciente();
                    ControladorInfoPaciente controladorInfo = new ControladorInfoPaciente(panelInfo, medico, paciente, cita);
                    panelInfo.controlador(controladorInfo);
                    ControladorDialog.cargarPanelDialogo(panelInfo);

                    break;
                }
                case VistaConsultPase.BotonMostrar: {

                    idPaseSeleccionado = ListaPaseServicio.get(vista.getSelectedRow()).getIdPaseServicio();
                    
                    PaseServicio paseserv = ListaPaseServicio.get(vista.getSelectedRow());
                   // System.out.println(paseserv);
                    PanelCMostrarPase panelCMostrarPase = new PanelCMostrarPase();
                    ControladorCMostrarPase controladorCMostrarPase = new ControladorCMostrarPase(panelCMostrarPase, medico, paciente, cita, paseserv);

                    panelCMostrarPase.controlador(controladorCMostrarPase);
                    ControladorDialog.cargarPanelDialogo(panelCMostrarPase);

                    break;
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public final void rellenarTabla() throws InstantiationException, IllegalAccessException, SQLException {
        PaseServicioDAO daoPase = new PaseServicioDAO();
        Integer idpac = paciente.getIdPaciente();

        List<PaseServicio> listaPaseDia = daoPase.leerPases(idpac);

        for (PaseServicio pase : listaPaseDia) {

            vista.meterPasetabla(pase.getPrueba(), pase.getCausa());
            //System.out.println(pase.getIdPaseServicio()+ pase.getPrueba()+ pase.getCausa());

        }

    }

}
