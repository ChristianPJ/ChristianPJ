/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.Clases.Cita;
import Modelo.DAO.InformeDAO;
import Vista.PanelInforme;
import Vista.VistaInformeCrear;
import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inftel18
 */
public class ControladorInformeCrear implements ActionListener{
        
    private final VistaInformeCrear vinformec;
    private final Medico medico;
    private final Paciente paciente;
    private final Cita cita;
    private String pdf;
    
    public ControladorInformeCrear(VistaInformeCrear informec,Medico medico, Paciente paciente, Cita cita) {
        
        this.vinformec = informec;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
        vinformec.cambiarLabel(paciente.getApellidos()+ ", " +paciente.getNombre());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaInformeCrear.BotonInformeVolver:
                {
                    PanelInforme panelInforme = new PanelInforme();
                    ControladorInforme controladorInforme = new ControladorInforme(panelInforme,medico,paciente,cita);//falta insertar medico y paciente
                    panelInforme.controlador(controladorInforme);
                    ControladorDialog.cargarPanelDialogo(panelInforme);
                        
                    break;
                } 
                case VistaInformeCrear.BotonInformeCrear:
                {

                    InformeDAO i = new InformeDAO();

                    try {

                        i.crearInforme(vinformec.infDiagnostico(), vinformec.infTratamiento() , vinformec.infDatos(), paciente.getIdPaciente(), paciente.getIdPersona(), medico.getIdMedico(), vinformec.getAdjunto());
                        
                        if(vinformec.checkPDF())
                            pdf = i.generaPDF(vinformec.infDiagnostico(), vinformec.infTratamiento() , vinformec.infDatos(), paciente.getIdPaciente(), paciente.getIdPersona(), paciente);
                        
                        if(vinformec.checkEmail()){
                            i.enviarEmail(paciente.getEmail(), pdf);
                        }
                        
                        vinformec.mError("Informe creado.");

                    } catch (IOException | DocumentException ex) {
                    Logger.getLogger(ControladorInformeCrear.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                }
            } 
        }   catch (SQLException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
