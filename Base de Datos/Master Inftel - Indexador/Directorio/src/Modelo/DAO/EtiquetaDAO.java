/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Etiqueta;
import com.drew.metadata.Tag;
import directorio.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class EtiquetaDAO {
    
    static Connection con= null;
    static Map<Integer,Etiqueta> etiquetas;
    
    public static final String SQL_NUEVA_ETIQ =
        "INSERT INTO Etiqueta " +
        " ( Id , Nombre, Directorio_ID)" + 
        " VALUES " +
        "( SQL_INC_ETIQ.NEXTVAL, ?, ?)" ;
    
    public static final String SQL_BUSCAR_ETIQ =
        "SELECT Id, Nombre, Directorio_ID" +
        " FROM Etiqueta " +
        "WHERE Nombre = ? AND Directorio_ID = ?";
    
    public static final String SQL_GET_ETIQUETA =
        "SELECT * " +
        "FROM Etiqueta " +
        "WHERE ID = ?";
    
    public static final String SQL_GET_ETIQUETAS =
        "SELECT * " +
        "FROM Etiqueta"; 
    
    public EtiquetaDAO (){
        
    }
    
    public static Etiqueta getEtiqueta(int idEtiqueta) throws InstantiationException, IllegalAccessException, SQLException{
        
        Conexion c = new Conexion();
        con=c.conectar();
        Etiqueta etiqueta = null;
        
        PreparedStatement ps =null;
        ResultSet rs = null;

        try{            
            ps = (PreparedStatement)con.prepareStatement(SQL_GET_ETIQUETA);
            ps.setInt(1, idEtiqueta);
            rs = ps.executeQuery();
            while (rs.next()) {
                etiqueta = new Etiqueta(rs.getInt(1),rs.getString(2),rs.getInt(3));
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
        return etiqueta;
    }
    
    public static Map<Integer,Etiqueta> getEtiquetas() throws InstantiationException, IllegalAccessException, SQLException{
        
        etiquetas = new HashMap<>();
        Conexion c = new Conexion();
        con=c.conectar();
        PreparedStatement ps =null;
        ResultSet rs = null;

        try{            
            ps = (PreparedStatement)con.prepareStatement(SQL_GET_ETIQUETAS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Etiqueta etiqueta = new Etiqueta(rs.getInt(1),rs.getString(2),rs.getInt(3));
                etiquetas.put(rs.getInt(1), etiqueta);
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
        return etiquetas;
    }
    
    
}
