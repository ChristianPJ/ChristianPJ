/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Cita;
import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.DAO.PaseServicioDAO;
import Vista.PanelConsultPase;
import Vista.VistaCrearPase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Alfredo
 */
public class ControladorCrearPase implements ActionListener {

    private VistaCrearPase vista;
    private Paciente paciente;
    private Medico medico;
    private Cita cita;

    public ControladorCrearPase(VistaCrearPase vista, Medico medico, Paciente paciente, Cita cita) {
        this.vista = vista;
        this.paciente = paciente;
        this.medico = medico;
        this.cita=cita;
        vista.cambiarLabel(paciente.getApellidos() + ", " + paciente.getNombre());

    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case VistaCrearPase.BotonGuardarPase: {
                    int idPersona=paciente.getIdPersona();
                    int idCita=cita.getIdCita();
                    int idPaciente=paciente.getIdPaciente();
                    String prueba = vista.getPrueba();
                    String causa = vista.getCausa();
                    PaseServicioDAO pase = new PaseServicioDAO();
                    
                    try {
                        pase.crearPase(prueba, causa, idCita, idPaciente, idPersona);
                        generaPDF(prueba, causa, idCita, idPaciente, idPersona);
                    } catch (FileNotFoundException | DocumentException ex) {
                        System.out.println(ex.getMessage());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                case VistaCrearPase.BotonVolver: {

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
     public void generaPDF(String Prueba, String Causa, Integer idCita, Integer idPaciente, Integer idPersona) throws FileNotFoundException, DocumentException, IOException {
    
        Calendar cal = Calendar.getInstance();
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
        String timename = new SimpleDateFormat("yyyyMMddHHmm").format(cal.getTime()); 
        
        File file = new File("PaseServicio" + timename + ".pdf");
        FileOutputStream fileout = new FileOutputStream(file);	
        Document document = new Document();
        PdfWriter writer;
        writer = PdfWriter.getInstance(document, fileout);
        
        Font fuente = new Font();
        Font fuente2= new Font();
        Font fuente3= new Font();
        
        // fuente.setColor(BaseColor.BLUE);
        fuente.setStyle(Font.UNDERLINE |Font.BOLDITALIC);
        fuente2.setStyle(Font.BOLD);
        fuente2.setSize(12);
        fuente3.setSize(20);
        fuente3.setStyle(Font.BOLD);
        
        document.open();
        document.add(new Paragraph("\n \n \n \n \n"));
        document.add(new Paragraph("Clinica Médica INFTEL",fuente3));
        
        String imageUrl = "src/Imagen/logo.png";
      //  String imagen="src\Imagen\logo.png"; 
        Image image = Image.getInstance(imageUrl);  
        image.setAbsolutePosition(300, 750);
        image.scalePercent(80f);
        document.add(image);       
        
        document.add(new Paragraph(" "));        
        document.add(new Paragraph("---------------------"));        
        
        document.add(new Paragraph("DATOS DEL PACIENTE",fuente));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Apellidos y Nombre : "+paciente.getApellidos() + ", " + paciente.getNombre()));
        document.add(new Paragraph("NIF : " + paciente.getNif()));
        document.add(new Paragraph("NSS : " + paciente.getNumSS()));
        document.add(new Paragraph("Direccion : " + paciente.getDireccion()));
        document.add(new Paragraph("Telefono : " + paciente.getTelefono()));
        document.add(new Paragraph("Email : " + paciente.getEmail()));
        document.add(new Paragraph("ID Paciente : " + idPaciente));
        
        document.add(new Paragraph(" "));        
        document.add(new Paragraph("---------------------"));        
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("DATOS ",fuente));        
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("Prueba : ", fuente2));
        document.add(new Paragraph(Prueba));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("Causa : ", fuente2));
        document.add(new Paragraph(Causa));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        
        
        absText(writer,time, 450, 50);
        
        document.close();
        File myfile = new File("PaseServicio" + timename + ".pdf");
        Desktop.getDesktop().open(myfile);
    }
    
    private static void absText(PdfWriter writer, String text, int x, int y) throws DocumentException, IOException {
        
        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb.saveState();
        cb.beginText();
        cb.moveText(x, y);
        cb.setFontAndSize(bf, 12);
        cb.showText(text);
        cb.endText();
        cb.restoreState();

  }
    
    
}
