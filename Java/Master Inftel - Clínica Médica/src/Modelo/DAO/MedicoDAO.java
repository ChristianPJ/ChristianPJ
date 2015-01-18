/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Medico;
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
public class MedicoDAO {
    
    private static Medico medico=null;
    private static List <Medico> listaMedicos=null;
    static Connection con=null;
    
    public MedicoDAO(){
    }
    
    public static List<Medico> getAllMedicos() throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        listaMedicos= new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Medico me inner join Persona per where me.Persona_idPersona = per.idPersona");
            ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                medico = new Medico(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getInt(15));
                
                listaMedicos.add(medico);
            }
            System.out.println(listaMedicos.toString());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return listaMedicos;
    }
    
    public static void insertarMedico (Medico med) throws InstantiationException, IllegalAccessException{
        
        Persona per = new Persona(0, med.getNombre(), med.getApellidos(), med.getNif(), med.getDireccion(),
                med.getFechaNacimiento(), med.getTelefono(), med.getEmail(), med.getContrasena(), med.getPerfil());
        PersonaDAO.insertarPersona(per);
        per = PersonaDAO.getPersonaByNIF(med.getNif());
        con = Conexion.conectar();
        medico = med;
        try{
            PreparedStatement pstmt =  con.prepareStatement("insert into Medico (Especialidad,HorarioInicio,HorarioFin,Persona_idPersona)"
                    + " values (?,?,?,?)");
            pstmt.setString(1, med.getEspecialiad());
            pstmt.setTimestamp(2, new java.sql.Timestamp(med.getHorarioInicio().getTime()));
            pstmt.setTimestamp(3, new java.sql.Timestamp(med.getHorarioFin().getTime()));
            pstmt.setInt(4, per.getIdPersona());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void actualizarMedico (Medico med) throws InstantiationException, IllegalAccessException{
        
        Persona per = new Persona(med.getIdPersona(), med.getNombre(), med.getApellidos(), med.getNif(), med.getDireccion(),
                med.getFechaNacimiento(), med.getTelefono(), med.getEmail(), med.getContrasena(), med.getPerfil());
        PersonaDAO.actualizarPersona(per);
        con = Conexion.conectar();
        medico = med;
        try{
            PreparedStatement pstmt =  con.prepareStatement("update Medico set Especialidad=?,HorarioInicio=?,HorarioFin=?,Persona_idPersona=? where idMedico=?");
            pstmt.setString(1, med.getEspecialiad());
            pstmt.setTimestamp(2, new java.sql.Timestamp(med.getHorarioInicio().getTime()));
            pstmt.setTimestamp(3, new java.sql.Timestamp(med.getHorarioFin().getTime()));
            pstmt.setInt(4, med.getIdPersona());
            pstmt.setInt(5, med.getIdMedico());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static List<Medico> getMedicosByEspecialidad (String especialidad) throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        listaMedicos = new ArrayList<>();
        try{
            PreparedStatement pstmm = con.prepareStatement("select * from Medico me inner join Persona per where me.Persona_idPersona = per.idPersona and especialidad =?");
            pstmm.setString(1, especialidad);
            ResultSet rs = pstmm.executeQuery();
            while (rs.next()) {
                medico = new Medico(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getInt(5),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getInt(15));
                listaMedicos.add(medico);
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listaMedicos;
    }
    
    public static Medico getMedicoByIdPersona (int idPersona) throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        medico = null;
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from Medico me inner join Persona per where me.Persona_idPersona = per.idPersona and per.idPersona=?");
            pstmt.setInt(1, idPersona);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                medico = new Medico(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4),
                        rs.getInt(5),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getDate(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getInt(15));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return medico;
    }
    
    public static Medico getMedicoById (int idMedico) throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        medico = null;
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from Medico me inner join Persona per where me.Persona_idPersona = per.idPersona and me.idMedico=?");
            pstmt.setInt(1, idMedico);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                medico = new Medico(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4),
                        rs.getInt(5),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getDate(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getInt(15));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return medico;
    }
    
     public static List<String> getEspecialidades () throws InstantiationException, IllegalAccessException{
        List<String> especialidades = new ArrayList<>(); 
        con = Conexion.conectar();
        try{
            PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT Especialidad FROM Medico");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                especialidades.add(rs.getString(1));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return especialidades;
     }
    
}
