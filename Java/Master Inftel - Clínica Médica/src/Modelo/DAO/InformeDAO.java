/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Informe;
import Modelo.Clases.Paciente;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import consultamedica.Conexion;
import java.awt.Desktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


/**
 *
 * @author Usuario
 */
public class InformeDAO {
    
    Connection con= null;
    
    public static final String SQL_INFORMES =
        "SELECT idInforme,Diagnostico,Tratamiento,`Datos de exploración`,Paciente_idPaciente,Paciente_Persona_idPersona, idMedico, Foto, Fecha " +
        "FROM informe I " +
        "WHERE I.Paciente_idPaciente = ? ";
        // "ORDER BY I.FECHA DESC; ";*/
    
    public static final String SQL_NUEVO_INFORME =
        "INSERT INTO informe " +
        " (`Diagnostico`,`Tratamiento`,`Datos de exploración`,`Paciente_idPaciente`,`Paciente_Persona_idPersona`, `idMedico`, `Foto`, `Fecha`) " +
        " VALUES " +
        "( ? , ? , ? , ? , ?, ?, ?, ?);";    
   
    public InformeDAO (){
        
    }    
    
    public List<Informe> leerInformes(Integer idPaciente) throws SQLException, InstantiationException, IllegalAccessException{
        
        con=Conexion.conectar(); 
        
        List<Informe> listaInformes = new ArrayList<>();
        PreparedStatement ps =null;
        ResultSet rs = null;

        try{
            
            ps = con.prepareStatement(SQL_INFORMES);
            ps.setInt(1, idPaciente);
            rs = ps.executeQuery();
            while (rs.next()) {
                Informe informe = new Informe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getBlob(8), rs.getDate(9));
                listaInformes.add(informe);
            }
            
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            if (ps !=null){
               ps.close(); 
            } 
            if (rs!=null){
               rs.close(); 
            }           
        }
        
        return listaInformes;
    }
    
    public void crearInforme(String Diagnostico, String Tratamiento, String Datos, Integer idPaciente, Integer idPersona, Integer idMedico, File file) throws SQLException, InstantiationException, IllegalAccessException, IOException{

        con=Conexion.conectar();
        FileInputStream fis = null;
        
        if(file!= null){
            fis = new FileInputStream(file);
        }
        
        long ts = System.currentTimeMillis();
        DateFormat dt = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        Date localTime = new Date(ts);
        dt.format(localTime);

        try (PreparedStatement ps = con.prepareStatement(SQL_NUEVO_INFORME)) {
            ps.setString(1, Diagnostico);
            ps.setString(2, Tratamiento);
            ps.setString(3, Datos);
            ps.setInt(4, idPaciente);
            ps.setInt(5, idPersona);
            ps.setInt(6, idMedico);
            ps.setBlob(7, fis); 
            ps.setDate(8, new java.sql.Date(localTime.getTime())); 
            ps.executeUpdate();

        }
    }
    
    public String generaPDF(String Diagnostico, String Tratamiento, String Datos, Integer idPaciente, Integer idPersona, Paciente paciente) throws FileNotFoundException, DocumentException, IOException {
    
        Calendar cal = Calendar.getInstance();
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
        String timename = new SimpleDateFormat("yyyyMMddHHmm").format(cal.getTime()); 
        
        File file = new File("informe" + timename + ".pdf");
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
        document.add(new Paragraph("Clínica Médica INFTEL",fuente3));
        
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
        
        document.add(new Paragraph("DATOS CLÍNICOS",fuente));        
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("Diagnóstico : ",fuente2));
        document.add(new Paragraph(Diagnostico));
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("Tratamiento : ",fuente2));
        document.add(new Paragraph(Tratamiento));
        document.add(new Paragraph(" "));
        
        document.add(new Paragraph("Datos : ",fuente2));
        document.add(new Paragraph(Datos));
        document.add(new Paragraph(" "));
        
        absText(writer,time, 450, 50);
        
        document.close();
        
        File myFile = new File("informe" + timename + ".pdf");
        Desktop.getDesktop().open(myFile);
        
        return myFile.toString();

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
    
    public void enviarEmail(String email,String pdf){
        // Recipient's email ID needs to be mentioned.
        String to = email;
        // Sender's email ID needs to be mentioned
        String from = "clinicainftel@gmail.com";
        // Get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "25");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");  
        properties.setProperty("mail.smtp.port", "465");  
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtps.quitwait", "false");
        
        System.out.println(properties.toString());
        
        final String username = "clinicainftel@gmail.com";
        final String password = "inftelinftel";
        
        Session session = Session.getInstance(properties,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
            new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Informe Clínica Inftel");
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Fill the message
            messageBodyPart.setText("Informe Clínica Inftel");
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = pdf;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            message.setContent(multipart );
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        
        } catch (MessagingException mex) {
        }
    }
}
