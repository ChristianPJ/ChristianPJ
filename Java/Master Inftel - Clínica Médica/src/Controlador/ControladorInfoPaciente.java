/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Vista.PanelConsultPase;
import Vista.PanelInforme;
import Vista.PanelReceta;
import Vista.VistaInfoPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author inftel15
 */
public class ControladorInfoPaciente implements ActionListener{
    
    private final VistaInfoPaciente vista;
    private final Medico medico;
    private final Paciente paciente;
    private final Cita cita;

    public ControladorInfoPaciente(VistaInfoPaciente vista, Medico medico, Paciente paciente, Cita cita) {
        this.vista = vista;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
        vista.cargarInfoMedico(medico.getNombre(), medico.getApellidos(), medico.getEspecialiad());
        vista.cargarInfoPaciente(paciente.getNombre(), paciente.getApellidos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaInfoPaciente.BotonIrAPases:
                    {
                        // INTRODUCIR LO QUE HACE EL BOTON AL PULSARLO
                        // recoger los datos de la interfaz con vista.getUsuaruio y vista.getPassword
                        // ver a que persona pertenece con una consulta o si no pertenece a nadie mostrar error
                        // guardamos el id de la persona encontrada y su perfil
                        // hacer un switch del perfilUsuaruio y segun su perfil hacer:
                        PanelConsultPase panelConsulPase = new PanelConsultPase();
                        ControladorConsultPase controladorConsultaPase = new ControladorConsultPase(panelConsulPase, medico, paciente, cita);
                        panelConsulPase.controlador(controladorConsultaPase);
                        
                        ControladorDialog.cargarPanelDialogo(panelConsulPase);
                        // cargamos un admin(persona) where idPersona = id que guardamos
                        // creamos un panel VistaAdmin pasandole la persona
                        // cargamos un medico where Persona_idPersona = id que guardamos
                        // creamos un panel VistaMedico pasandole el medico
                        // cargamos un paciente where Persona_idPersona = id que guardamos
                        break;
                    }
                case VistaInfoPaciente.BotonIrAInformes:
                {
                    // INTRODUCIR LO QUE HACE EL BOTON AL PULSARLO
                    // recoger los datos de la interfaz con vista.getUsuaruio y vista.getPassword
                    // ver a que persona pertenece con una consulta o si no pertenece a nadie mostrar error
                    // guardamos el id de la persona encontrada y su perfil
                    // hacer un switch del perfilUsuaruio y segun su perfil hacer:
                    PanelInforme panelMedico = new PanelInforme();
                    ControladorInforme controladorInforme = new ControladorInforme(panelMedico,medico, paciente, cita);
                    panelMedico.controlador(controladorInforme);
                    ControladorDialog.cargarPanelDialogo(panelMedico);
                    // cargamos un admin(persona) where idPersona = id que guardamos
                    // creamos un panel VistaAdmin pasandole la persona
                    // cargamos un medico where Persona_idPersona = id que guardamos
                    // creamos un panel VistaMedico pasandole el medico
                    // cargamos un paciente where Persona_idPersona = id que guardamos
                        break;
                    }
                case VistaInfoPaciente.BotonIrARecetas:
                    {
                        // INTRODUCIR LO QUE HACE EL BOTON AL PULSARLO
                        // recoger los datos de la interfaz con vista.getUsuaruio y vista.getPassword
                        // ver a que persona pertenece con una consulta o si no pertenece a nadie mostrar error
                        // guardamos el id de la persona encontrada y su perfil
                        // hacer un switch del perfilUsuaruio y segun su perfil hace
                        PanelReceta panelReceta = new PanelReceta();
                        ControladorReceta controladorReceta = new ControladorReceta(panelReceta, cita, paciente, medico);
                        panelReceta.controlador(controladorReceta);
                        
                        ControladorDialog.cargarPanelDialogo(panelReceta);
                        // cargamos un admin(persona) where idPersona = id que guardamos
                        // creamos un panel VistaAdmin pasandole la persona
                        // cargamos un medico where Persona_idPersona = id que guardamos
                        // creamos un panel VistaMedico pasandole el medico
                        // cargamos un paciente where Persona_idPersona = id que guardamos
                        break;
                    }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
}
