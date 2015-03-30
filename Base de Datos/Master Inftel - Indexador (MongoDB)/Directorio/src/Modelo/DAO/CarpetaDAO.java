/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import directorio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inftel15
 */
public class CarpetaDAO {
    
    private Connection con= null;
    
    private Map<Integer, String> carpetas = null;
    
    public static final String SQL_GET_CARPETA =
        "SELECT * " +
        "FROM Carpeta ";
    
    public static final String SQL_NUEVA_CARP =
        "INSERT INTO Carpeta " +
        " ( Id , NombreCarpeta, Fecha)" + 
        " VALUES " +
        "( SQL_INC_DIR.NEXTVAL, ?, ?)" ;
    
    public static final String SQL_BUSCAR_CARP =
        "SELECT * " +
        "FROM Carpeta " +
        "WHERE NombreCarpeta = ? ";
    
    public static final String SQL_FECHA_CARP =
        "SELECT Fecha " +
        "FROM Carpeta " +
        "WHERE NombreCarpeta = ? ";
    
    public Map<Integer,String> getCarpetas() throws InstantiationException, IllegalAccessException, SQLException{
        
        Conexion c = new Conexion();
        con=c.conectar();
        carpetas = new HashMap<>();
        
        PreparedStatement ps =null;
        ResultSet rs = null;

        try{            
            ps = (PreparedStatement)con.prepareStatement(SQL_GET_CARPETA);
            rs = ps.executeQuery();
            while (rs.next()) {
                carpetas.put(rs.getInt(1), rs.getString(2));
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
        
        return carpetas;
    }
    
    public void crearCarpeta(String ruta, Long fecha, Conexion con) throws SQLException, InstantiationException, IllegalAccessException{
        
        Date d = new Date(fecha);
        
        try (PreparedStatement ps = con.getCon().prepareStatement(SQL_NUEVA_CARP)) {             
            
            ps.setString(1, ruta); 
            ps.setTimestamp(2,new java.sql.Timestamp(d.getTime())); 
            ps.executeUpdate();
        } 
    }
    
    public int leerCarpeta(String dir, Conexion con) throws SQLException, InstantiationException, IllegalAccessException{
       
        PreparedStatement ps =null;
        ResultSet rs = null;
        
        int existe = -1;

        try{
            
            ps = con.getCon().prepareStatement(SQL_BUSCAR_CARP);
            ps.setString(1, dir);
            rs = ps.executeQuery();            
            
            if (rs.next()) {
               existe = rs.getInt(1);
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
        return existe;
    }
    
    public Timestamp fechaCarpeta(String dir) throws SQLException, InstantiationException, IllegalAccessException{
        
        PreparedStatement ps =null;
        ResultSet rs = null;
        
        Timestamp fech = null;

        try{
            
            ps = con.prepareStatement(SQL_FECHA_CARP);
            ps.setString(1, dir);
            rs = ps.executeQuery();            
            
            if (rs.next()) {
               fech = rs.getTimestamp(1);
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
        return fech;
    }
}
