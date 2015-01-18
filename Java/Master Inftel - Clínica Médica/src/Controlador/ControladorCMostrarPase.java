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
import Modelo.DAO.PaseServicioDAO;
import Vista.PanelCMostrarPase;
import Vista.PanelConsultPase;
import Vista.PanelCrearPase;
import Vista.VistaCMostrarPase;
import Vista.VistaConsultPase;
import Vista.VistaCrearPase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alfredo
 */
public class ControladorCMostrarPase implements ActionListener {

    private VistaCMostrarPase vista;
    private Paciente paciente;
    private Medico medico;
    private Cita cita;
    private PaseServicio paseservicio;

    public ControladorCMostrarPase(VistaCMostrarPase vista, Medico medico, Paciente paciente, Cita cita, PaseServicio paseservicio ) {
        this.vista = vista;
        this.paciente = paciente;
        this.medico = medico;
        this.cita=cita;
        this.paseservicio=paseservicio;
        vista.cambiarLabel(paciente.getApellidos() + ", " + paciente.getNombre());
        rellenarCampos(paseservicio.getPrueba(), paseservicio.getCausa());

    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                
                case VistaCMostrarPase.BotonVolver: {
                    
                    PanelConsultPase panelConsulPase = new PanelConsultPase();
                    ControladorConsultPase controladorConsultaPase = new ControladorConsultPase(panelConsulPase, medico, paciente, cita);
                    panelConsulPase.controlador(controladorConsultaPase);

                    ControladorDialog.cargarPanelDialogo(panelConsulPase);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void rellenarCampos(String prueba, String causa){
        vista.setInfo(prueba,causa);
    }
    
  }
    
    
