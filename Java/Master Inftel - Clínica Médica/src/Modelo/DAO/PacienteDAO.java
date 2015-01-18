/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Paciente;
import Modelo.Clases.Persona;
import consultamedica.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Blackproxy
 */
public class PacienteDAO {
    private static Paciente paciente =null;
    private static List <Paciente> listaPacientes = null;
    static Connection con = null;

    public PacienteDAO() {
    }
    
    public static List<Paciente> getAllPacientes() throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        listaPacientes= new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Paciente pa inner join Persona per where pa.Persona_idPersona = per.idPersona");
                while (rs.next()) {
                paciente = new Paciente(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getInt(6), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getDate(12), rs.getInt(13), rs.getString(14), rs.getString(15), rs.getInt(16));
                
                listaPacientes.add(paciente);
            }
            System.out.println(listaPacientes.toString());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return listaPacientes;
        
        
    }
    
    public static void insertarPaciente(Paciente pa) throws InstantiationException, IllegalAccessException{
        
        Persona per = new Persona(0, pa.getNombre(), pa.getApellidos(), pa.getNif(), pa.getDireccion(),
                pa.getFechaNacimiento(), pa.getTelefono(), pa.getEmail(), pa.getContrasena(), pa.getPerfil());
        PersonaDAO.insertarPersona(per);
        per = PersonaDAO.getPersonaByNIF(pa.getNif());
        con = Conexion.conectar();
        paciente = pa;
        try{
            PreparedStatement pstmt =  con.prepareStatement("insert into Paciente (NumeroSS,OperacionesQuirurgicas,Alergias,Tratamientos,Persona_idPersona)"
                    + " values (?,?,?,?,?)");
            pstmt.setInt(1, pa.getNumSS());
            pstmt.setString(2, pa.getOpQuirurgicas());
            pstmt.setString(3, pa.getOpQuirurgicas());
            pstmt.setString(4,pa.getTratamientos());
            pstmt.setInt(5, per.getIdPersona());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void actualizarPaciente(Paciente pa) throws InstantiationException, IllegalAccessException{
        
        Persona per = new Persona(pa.getIdPersona(), pa.getNombre(), pa.getApellidos(), pa.getNif(), pa.getDireccion(),
                pa.getFechaNacimiento(), pa.getTelefono(), pa.getEmail(), pa.getContrasena(), pa.getPerfil());
        PersonaDAO.actualizarPersona(per);
        con = Conexion.conectar();
        paciente = pa;
        try{
            PreparedStatement pstmt =  con.prepareStatement("update Paciente set NumeroSS=?,OperacionesQuirurgicas=?,Alergias=?,Tratamientos=?,Persona_idPersona=? where idPaciente=?");
            pstmt.setInt(1, pa.getNumSS());
            pstmt.setString(2, pa.getOpQuirurgicas());
            pstmt.setString(3, pa.getOpQuirurgicas());
            pstmt.setString(4,pa.getTratamientos());
            pstmt.setInt(5, pa.getIdPersona());
            pstmt.setInt(6, pa.getIdPaciente());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static Paciente getPacienteByIdPersona(int idPersona) throws InstantiationException, IllegalAccessException{
        
        con = Conexion.conectar();
        paciente = null;
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from Paciente pa inner join Persona per where pa.Persona_idPersona = per.idPersona and per.idPersona=?");
            pstmt.setInt(1, idPersona);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                paciente = new Paciente(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getInt(6), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getDate(12), rs.getInt(13), rs.getString(14), rs.getString(15), rs.getInt(16));
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return paciente;
    }
    
    public static Paciente getPacienteById(int idPaciente) throws InstantiationException, IllegalAccessException{
        
        con = Conexion.conectar();
        paciente = null;
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from Paciente pa inner join Persona per where pa.Persona_idPersona = per.idPersona and pa.idPaciente=?");
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                paciente = new Paciente(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getInt(6), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getDate(12), rs.getInt(13), rs.getString(14), rs.getString(15), rs.getInt(16));
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return paciente;
    }
    
}
