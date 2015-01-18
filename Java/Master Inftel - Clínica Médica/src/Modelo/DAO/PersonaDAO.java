/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

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
public class PersonaDAO {
    private static Persona persona=null;
    static Connection con= null;
    private static List <Persona> listaPersonas=null;
    
    public PersonaDAO() {
    }
    
    
    public static List<Persona> getAllPersonas() throws InstantiationException, IllegalAccessException{
        
        con=Conexion.conectar();
        listaPersonas= new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from persona");
            ResultSetMetaData rsmd = rs.getMetaData();
            int number = rsmd.getColumnCount();
            System.out.println(number);
            while (rs.next()) {
                persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                listaPersonas.add(persona);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return listaPersonas;

    }
    
    public static Persona getPersonaByNIF(String nif) throws InstantiationException, IllegalAccessException{
        con=Conexion.conectar();
        listaPersonas= new ArrayList<>();
        persona=null;
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from persona where NIF=?");
            pstmt.setString(1, nif);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int number = rsmd.getColumnCount();
            System.out.println(number);
            while (rs.next()) {
                persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return persona;
    }
    
     public static void insertarPersona(Persona per) throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        persona = per;
        try{
            PreparedStatement pstmt =  con.prepareStatement("insert into Persona (Nombre,Apellidos,NIF,Direccion,FechaNacimiento,Telefono,Email,Contraseña,Perfil)"
                    + " values (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, per.getNombre());
            pstmt.setString(2, per.getApellidos());
            pstmt.setString(3, per.getNif());
            pstmt.setString(4,per.getDireccion());
            pstmt.setDate(5, new java.sql.Date(per.getFechaNacimiento().getTime()));
            pstmt.setInt(6,per.getTelefono());
            pstmt.setString(7,per.getEmail());
            pstmt.setString(8,per.getContrasena());
            pstmt.setInt(9, per.getPerfil());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
     public static void actualizarPersona(Persona per) throws InstantiationException, IllegalAccessException{
        con = Conexion.conectar();
        persona = per;
        try{
            PreparedStatement pstmt =  con.prepareStatement("update Persona set Nombre=?,Apellidos=?,NIF=?,Direccion=?,FechaNacimiento=?,Telefono=?,Email=?,Contraseña=?,Perfil=? where idPersona=?");
            pstmt.setString(1, per.getNombre());
            pstmt.setString(2, per.getApellidos());
            pstmt.setString(3, per.getNif());
            pstmt.setString(4,per.getDireccion());
            pstmt.setDate(5, new java.sql.Date(per.getFechaNacimiento().getTime()));
            pstmt.setInt(6,per.getTelefono());
            pstmt.setString(7,per.getEmail());
            pstmt.setString(8,per.getContrasena());
            pstmt.setInt(9, per.getPerfil());
            pstmt.setInt(10, per.getIdPersona());
            pstmt.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}