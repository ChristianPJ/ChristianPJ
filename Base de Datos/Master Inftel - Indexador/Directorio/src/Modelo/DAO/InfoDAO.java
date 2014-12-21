/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Info;
import directorio.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class InfoDAO {
    
    private Connection con= null;
    private List<Info> info = null;
    
    public static final String SQL_NUEVA_INF =
        "INSERT INTO Info " +
        " ( Fotos_Id , Etiqueta_Id, Etiqueta_Directorio_Id, Valor)" + 
        " VALUES " +
        "( ?, ?, ?, ?)" ;
    
    public static final String SQL_GET_INFO =
        "SELECT * " +
        "FROM Info " +
        "WHERE Fotos_ID = ?";
    
    public static final String SQL_BUSCAR_INFO =
        "SELECT *" +
        "FROM Info " +
        "WHERE Fotos_ID = ? AND Etiqueta_ID = ? ";
    
    
    public InfoDAO (){
        
    }    
    
    public List<Info> getInfo(int idFoto) throws InstantiationException, IllegalAccessException, SQLException{
        
        
        Conexion con = new Conexion();
        con.conectar();
        info = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{            
            ps = con.getCon().prepareStatement(SQL_GET_INFO);
            ps.setInt(1, idFoto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Info infoo = new Info(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                info.add(infoo);
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
        return info;
    }
    
    
    public void InsertMetadata (int idfoto, String dir, String etiq, String valor, Conexion con) throws SQLException, InstantiationException, IllegalAccessException{

        System.out.println(con.toString());
        
        System.out.println(idfoto+" "+dir+" "+etiq+" "+valor);
        
        CallableStatement cs = con.getCon().prepareCall("{call INSERTMETADATA (?,?,?,?)}");
        cs.setInt(1, idfoto);
        cs.setString(2, dir); 
        cs.setString(3, etiq); 
        cs.setString(4, valor); 
        cs.executeUpdate();
 
    }

    
}
