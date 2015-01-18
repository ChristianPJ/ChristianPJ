
package Modelo.DAO;

import Modelo.Clases.Cita;
import com.mysql.jdbc.PreparedStatement;
import consultamedica.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Clase DAO (Data Access Object) del modelo para el acceso a objetos Cita
 */
public class CitaDAO{
    
    public static final String SQL_CITAS_MEDICO =        
        "SELECT * " +
        "FROM cita " +
        "WHERE Medico_idMedico = ? " + 
        "AND DATE(FechaHora)= ?";
    
    public static final String SQL_INSERT_CITA =
        "INSERT INTO cita " +
        "(`FechaHora`,`Paciente_idPaciente`,`Paciente_Persona_idPersona`,`Medico_idMedico`,`Medico_Persona_idPersona`) " +
        "VALUES " +
        "( ? , ? , ? , ? , ?);";
    
    public static final String SQL_CITAS_PACIENTE =        
        "SELECT * " +
        "FROM cita " +
        "WHERE Paciente_idPaciente = ? ";
    
    public static final String SQL_BORRAR_CITA =        
        "DELETE " +
        "FROM cita " +
        "WHERE idCita = ? ";
    
    /*
    * Consulta de las citas que tiene un médico en un día dado.
    * @parametros: día y identificardor del médico
    * @return: lista ordenada de objetos cita
    */
    
    public SortedSet<Cita> getCitasDelDia(Date dia, int idMedico) throws InstantiationException, IllegalAccessException, SQLException{
        
        DateFormat dateFormatDia = new SimpleDateFormat("YYYY-MM-dd");
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con=Conexion.conectar();
        SortedSet<Cita> listaCitasDia = new TreeSet<>();
        
        try{
            ps = (PreparedStatement)con.prepareStatement(SQL_CITAS_MEDICO);
            ps.setInt(1,idMedico);
            ps.setString(2, dateFormatDia.format(dia));
            //ps.setString(2, "2014/11/15");
            rs = ps.executeQuery();           
            while (rs.next()) {
                Cita cita = new Cita(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(5));
                listaCitasDia.add(cita);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            if (ps !=null){
               ps.close(); 
            } 
            if (rs!=null){
               rs.close(); 
            }           
        }
        
        return listaCitasDia;
    }
    
    /*
    * Inserta una cita en la BD.
    */
        
    public void insertCita(Date fecha, int idPaciente, int idPersonaPaciente, int idMedico, int idPersonaMedico) throws InstantiationException, IllegalAccessException, SQLException{
        
        Connection con=Conexion.conectar();
        try(PreparedStatement ps = (PreparedStatement)con.prepareStatement(SQL_INSERT_CITA)) {
            ps.setTimestamp(1, new java.sql.Timestamp(fecha.getTime()));
            ps.setInt(2, idPaciente);
            ps.setInt(3, idPersonaPaciente);
            ps.setInt(4, idMedico);
            ps.setInt(5, idPersonaMedico);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    * Borrar una cita de la BD.
    */
    
    public void borrarCita(int idCita) throws InstantiationException, IllegalAccessException, SQLException{
        
        Connection con=Conexion.conectar();
        try(PreparedStatement ps = (PreparedStatement)con.prepareStatement(SQL_BORRAR_CITA)) {
            ps.setInt(1, idCita);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /*
    * Consulta de las citas que tiene un paciente.
    * @parametros: identificardor del paciente
    * @return: lista ordenada de objetos cita
    */
    
    public SortedSet<Cita> getCitasPaciente(int idPaciente) throws InstantiationException, IllegalAccessException, SQLException{
        
        Connection con = Conexion.conectar();
        SortedSet<Cita> listaCitas= new TreeSet<>();
        PreparedStatement ps =null;
        ResultSet rs = null;
        
        try{
            ps = (PreparedStatement)con.prepareStatement(SQL_CITAS_PACIENTE);
            ps.setInt(1,idPaciente);
            rs = ps.executeQuery();           
            while (rs.next()) {
                Cita cita = new Cita(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(5));
                listaCitas.add(cita);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            if (ps !=null){
               ps.close(); 
            } 
            if (rs!=null){
               rs.close(); 
            }           
        }
        
        return listaCitas;
    }
    
    
    
}
