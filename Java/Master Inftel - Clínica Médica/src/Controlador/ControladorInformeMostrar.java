/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Informe;
import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Vista.PanelInforme;
import Vista.VistaInformeMostrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;

/**
 *
 * @author inftel18
 */
public final class ControladorInformeMostrar implements ActionListener{
    
    private final VistaInformeMostrar vinformem;
    private final Medico medico;
    private final Paciente paciente;
    private final Cita cita;
    private final Informe informe;

    public ControladorInformeMostrar(VistaInformeMostrar vinformem, Medico medico, Paciente paciente, Cita cita, Informe informe) {
        
        this.vinformem = vinformem;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
        this.informe = informe;
        vinformem.cambiarLabel(paciente.getApellidos()+ ", " +paciente.getNombre());
        rellenarCampos(informe.getDiagnostico(), informe.getTratamiento(), informe.getDatosExp(),informe.getFoto());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaInformeMostrar.BotonInformeVolver:
                {
                    PanelInforme panelInforme = new PanelInforme();
                    ControladorInforme controladorInforme = new ControladorInforme(panelInforme,medico,paciente,cita);//falta insertar medico y paciente
                    panelInforme.controlador(controladorInforme);
                    ControladorDialog.cargarPanelDialogo(panelInforme);
                    break;
                }
            }
        } catch (SQLException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void rellenarCampos(String dia, String trat, String dat, Blob file){
        vinformem.setInfo(dia,trat,dat,file);
    }
    
}
