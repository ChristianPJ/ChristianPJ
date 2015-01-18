/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelo.Clases.Receta;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import consultamedica.Conexion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author loubna
 */
public class RecetasDAO {

    /**
     * Sentencia SQL para obtener las recetas de un paciente
     */
    private static final String SQL_SELECT_RECETAS_PACIENTE
            = "select * from receta where Cita_Paciente_idPaciente=?;";
    /**
     * Sentencia SQL para recuperar la receta cuyo campo idreceta se le pasa
     * como parámetro.
     */
    public static final String SQL_RECETA_POR_USUARIO
            = "select * from receta where "
            + "idReceta = ?";

    public static final String SQL_NUEVA_RECETA
            = "INSERT INTO receta "
            + " (`Indicaciones`,`Medicamento`,`Cita_idCita`,`Cita_Paciente_idPaciente`,`Cita_Paciente_Persona_idPersona`) "
            + " VALUES "
            + "( ? , ? , ? , ? , ?);";

    public RecetasDAO() {
    }

    public List<Receta> getRecetasByPacientes(int id_paciente) throws SQLException, InstantiationException, IllegalAccessException {
        Receta receta = null;
        Connection conn = Conexion.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList ListaRecetas = new ArrayList<>();

        try {
            if (conn != null) {
                stmt = (PreparedStatement) conn.prepareStatement(SQL_SELECT_RECETAS_PACIENTE);
                stmt.setInt(1, id_paciente);
                rs = stmt.executeQuery();
                int i = 0;
                //Creamos la lista con todos los objetos las recetas
                while (rs.next()) {

                    receta = new Receta(rs.getInt("idReceta"), rs.getString("Indicaciones"), rs.getString("Medicamento"), rs.getInt("Cita_idCita"));

                    ListaRecetas.add(receta);
                    Receta rec = (Receta) ListaRecetas.get(i);

                   
                    i++;

                }

            }
            if (ListaRecetas.size() > 0) {
                
                return ListaRecetas;
            } else {
                
                return null;
            }

        } finally {
            rs.close();

        }

    }

  //  private void cerrar(ResultSet rs) {
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
    public void crearReceta(String Indicaciones, String Medicamento, Integer Cita_idCita, Integer idPaciente, Integer idPersona) throws SQLException, InstantiationException, IllegalAccessException {

        Connection con = Conexion.conectar();
        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement(SQL_NUEVA_RECETA);
            ps.setString(1, Indicaciones);
            ps.setString(2, Medicamento);
            ps.setInt(3, Cita_idCita);
            ps.setInt(4, idPaciente);
            ps.setInt(5, idPersona);

            ps.executeUpdate();

        } finally {
            ps.close();
        }
    }

    public void generaPDF(String Indicaciones, String Medicamentos,Paciente paciente, Integer idPaciente) throws FileNotFoundException, DocumentException, IOException {

        Calendar cal = Calendar.getInstance();
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(cal.getTime());
        String timename = new SimpleDateFormat("yyyyMMddHHmm").format(cal.getTime());

        File file = new File("Receta" + timename + ".pdf");
        FileOutputStream fileout = new FileOutputStream(file);
        Document document = new Document();
        PdfWriter writer;
        writer = PdfWriter.getInstance(document, fileout);

        Font fuente = new Font();
        Font fuente2 = new Font();
        

        // fuente.setColor(BaseColor.BLUE);
        fuente.setStyle(Font.BOLD | Font.UNDERLINE);
        fuente2.setStyle(Font.BOLD);
        fuente2.setSize(20);

        document.open();
        document.add(new Paragraph("\n \n \n \n \n"));
        document.add(new Paragraph("Clinica Médica INFTEL", fuente2));

        String imageUrl = "src/Imagen/logo.png";

      
        Image image = Image.getInstance(imageUrl);  
        image.setAbsolutePosition(300, 750);
        image.scalePercent(80f);
        document.add(image);

        document.add(new Paragraph(" "));
        document.add(new Paragraph("---------------------"));

        document.add(new Paragraph("DATOS DEL PACIENTE", fuente));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Apellidos y Nombre : "+ paciente.getApellidos() + ", " + paciente.getNombre()));
        document.add(new Paragraph("NIF : " + paciente.getNif()));
        document.add(new Paragraph("NSS : " + paciente.getNumSS()));
        document.add(new Paragraph("Direccion : " + paciente.getDireccion()));
        document.add(new Paragraph("Telefono : " + paciente.getTelefono()));
        document.add(new Paragraph("Email : " + paciente.getEmail()));
        document.add(new Paragraph("ID Paciente : " + idPaciente));

        document.add(new Paragraph(" "));
        document.add(new Paragraph("---------------------"));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("DATOS CLÍNICOS", fuente));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Diagnóstico : "));
        document.add(new Paragraph(Indicaciones));
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Tratamiento : "));
        document.add(new Paragraph(Medicamentos));
        document.add(new Paragraph(" "));

        document.add(new Paragraph(" "));

        absText(writer, time, 450, 50);

        document.close();
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
