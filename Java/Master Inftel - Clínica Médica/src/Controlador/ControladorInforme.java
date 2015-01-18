/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Informe;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.DAO.InformeDAO;
import static Modelo.DAO.MedicoDAO.getMedicoById;
import Vista.PanelInfoPaciente;
import Vista.PanelInformeCrear;
import Vista.PanelInformeMostrar;
import Vista.VistaInforme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author inftel18
 */
public final class ControladorInforme implements ActionListener{
    
    private final VistaInforme vinforme;
    private final Medico medico;
    private final Paciente paciente;
    private final Cita cita;
    int idInformeSeleccionado;
    private final List<Informe> listaInformes;
    

    public ControladorInforme(VistaInforme informe, Medico medico, Paciente paciente, Cita cita) throws SQLException, InstantiationException, IllegalAccessException {
        this.vinforme = informe;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
        InformeDAO i = new InformeDAO();
        listaInformes=i.leerInformes(paciente.getIdPaciente());
        cargarTabla();
        vinforme.cambiarLabel(paciente.getApellidos()+ ", " +paciente.getNombre());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaInforme.BotonCrearInforme:
                {

                        PanelInformeCrear panelInformeCrear = new PanelInformeCrear();
                        ControladorInformeCrear controladorInformeCrear = new ControladorInformeCrear(panelInformeCrear,medico,paciente,cita);//falta insertar medico y paciente
                        panelInformeCrear.controlador(controladorInformeCrear);
                        ControladorDialog.cargarPanelDialogo(panelInformeCrear);

                        break;
                }
                case VistaInforme.BotonMostrarInforme:
                {
                    
                        idInformeSeleccionado = listaInformes.get(vinforme.getSelectedRow()).getIdInforme();
                        Informe inf = listaInformes.get(vinforme.getSelectedRow());
                        PanelInformeMostrar panelInformeMostrar = new PanelInformeMostrar();
                        ControladorInformeMostrar controladorInformeMostrar = new ControladorInformeMostrar(panelInformeMostrar,medico,paciente,cita,inf);
                        panelInformeMostrar.controlador(controladorInformeMostrar);
                        ControladorDialog.cargarPanelDialogo(panelInformeMostrar);
                        break;
                }
                case VistaInforme.BotonVolverInforme:
                {
                        PanelInfoPaciente panelInfoPaciente = new PanelInfoPaciente();
                        ControladorInfoPaciente controladorInfoPaciente = new ControladorInfoPaciente(panelInfoPaciente,medico,paciente,cita);
                        panelInfoPaciente.controlador(controladorInfoPaciente);
                        ControladorDialog.cargarPanelDialogo(panelInfoPaciente);
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void cargarTabla() throws SQLException, InstantiationException, IllegalAccessException {
        
        Integer idpac = paciente.getIdPaciente();
        
        InformeDAO i = new InformeDAO();
        
       

        List<Informe> listaInformes = i.leerInformes(idpac);
        for (Informe informe : listaInformes) {
            Medico med = getMedicoById(informe.getIdMedico());
            vinforme.meterInformeTabla(informe.getIdInforme(),med.getEspecialiad(),informe.getFecha());
        }
        
    }
    
}
