/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;

import Modelo.DAO.RecetasDAO;
import Vista.PanelReceta;
import Vista.PanelRecetaCrear;

import Vista.VistaRecetaCrear;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loubna
 */
public class ControladorRecetaCrear implements ActionListener{

    private final VistaRecetaCrear vista;
    private final Cita cita;
    private Medico medico;
    private Paciente paciente;

    public ControladorRecetaCrear(VistaRecetaCrear vista, Cita cita, Paciente paciente, Medico medico) {
        this.vista = vista;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaRecetaCrear.BotonCrearRecetaBD: {
                      crearRecetaBd() ;
                    break;
                }
                  case VistaRecetaCrear.BotonVolverAtras:
                {
                        PanelReceta panelReceta = new PanelReceta();
                        ControladorReceta controladorReceta = new ControladorReceta(panelReceta,cita,paciente,medico);
                        panelReceta.controlador(controladorReceta);
                        ControladorDialog.cargarPanelDialogo(panelReceta);
                        break;
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void crearRecetaBd() throws SQLException, InstantiationException, IllegalAccessException {

        RecetasDAO receta = new RecetasDAO();
        Integer idpaciente = paciente.getIdPaciente();
        Integer Cita_idCita = cita.getIdCita();
        Integer idPersona = paciente.getIdPersona();
        
        List<String> datos = new ArrayList<>();
       
        datos = vista.recogerDatos();
        for (int i = 0; i <= datos.size(); i = i + 1) {
            if (datos.get(i) != null && datos.get(i+1) != null) {
             receta.crearReceta(datos.get(i),datos.get(i+1), Cita_idCita, idpaciente, idPersona);
            }
        }
    }
    }
