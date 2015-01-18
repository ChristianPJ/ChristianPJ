/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.Clases.Receta;
import Modelo.DAO.RecetasDAO;
import Vista.PanelInfoPaciente;
import Vista.PanelRecetaCrear;
import Vista.VistaReceta;
import static Vista.VistaReceta.GenerarPDF;
import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loubna
 */
public class ControladorReceta implements ActionListener {

    private VistaReceta vista;
    private final Cita cita;
    private final Medico medico;
    private final Paciente paciente;

    public ControladorReceta(VistaReceta Receta, Cita cita, Paciente paciente, Medico medico) throws SQLException, InstantiationException, IllegalAccessException {
        this.vista = Receta;
        this.medico = medico;
        this.paciente = paciente;
        this.cita = cita;
        cargarRecetas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaReceta.BotonCrearReceta: {

                    PanelRecetaCrear panelRecetaCrear = new PanelRecetaCrear();
                    ControladorRecetaCrear controladorRecetaCrear = new ControladorRecetaCrear(panelRecetaCrear, cita, paciente, medico);
                    panelRecetaCrear.controlador(controladorRecetaCrear);
                    ControladorDialog.cargarPanelDialogo(panelRecetaCrear);

                    break;
                }
                case VistaReceta.BotonMostrarReceta: {
                        
                    verReceta();
                    break;
                }
                case VistaReceta.GenerarPDF: {
                       
                    impremirPDF();
                    break;
                }
                case VistaReceta.BotonVolverAtras: {
                   PanelInfoPaciente panelInfo = new PanelInfoPaciente();
                    ControladorInfoPaciente controladorInfo = new ControladorInfoPaciente(panelInfo, medico, paciente, cita);
                    panelInfo.controlador(controladorInfo);
                    ControladorDialog.cargarPanelDialogo(panelInfo);
                    break;
                }

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //cargar las recetas en la tabla

    public final void cargarRecetas() throws SQLException, InstantiationException, IllegalAccessException {
        RecetasDAO receta = new RecetasDAO();
        List<Receta> ListaRecetas = new ArrayList<>();

        ListaRecetas = receta.getRecetasByPacientes(paciente.getIdPaciente());
           
        if (ListaRecetas != null) {
            for (Receta ListaReceta1 : ListaRecetas) {
                vista.insertarFila(ListaReceta1.getIndicaciones(), ListaReceta1.getMedicamento());

            }
        }
    }

    // mostrar la receta seleccionada   

    public void verReceta() {

        String mensaje1 = vista.getIdIMedicamentoOfSelectedRow();
        String mensaje2 = vista.getIdIndecacionesOfSelectedRow();

        if ((mensaje1 != null) && (mensaje2 != null)) {
            vista.mostrarMensaje1(mensaje1);
            vista.mostrarMensaje2(mensaje2);
        } else {
            JOptionPane.showMessageDialog(null, "Receta no seleccionada");
        }

    }

    public void impremirPDF() throws DocumentException, IOException {
        RecetasDAO receta = new RecetasDAO();
        List<String> recta_array = new ArrayList<>();
        recta_array = vista.ImpremirCampo();

        receta.generaPDF(recta_array.get(0), recta_array.get(1), paciente, paciente.getIdPaciente());

    }

}
