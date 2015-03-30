/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import com.drew.metadata.Directory;
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
public class DirectorioDAO {
    
    private Connection con= null;
    private Map<Integer,String> direcciones = null;
    
    public static final String SQL_NUEVA_DIR =
        "INSERT INTO Directorio " +
        " ( Id , Nombre)" + 
        " VALUES " +
        "( SQL_INC_DIR.NEXTVAL, ?)" ;
    
    public static final String SQL_BUSCAR_DIR =
        "SELECT Id, Nombre" +
        " FROM Directorio " +
        "WHERE Nombre = ? ";
    
    public static final String SQL_GET_DIRECTORIOS =
        "SELECT * " +
        "FROM Directorio";
    
    
    public DirectorioDAO (){
        
    }

    public Map<Integer,String> getDirectorios() throws InstantiationException, IllegalAccessException, SQLException{
        
        Conexion c = new Conexion();
        con=c.conectar();
        direcciones = new HashMap<>();
        
        PreparedStatement ps =null;
        ResultSet rs = null;

        try{            
            ps = (PreparedStatement)con.prepareStatement(SQL_GET_DIRECTORIOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                direcciones.put(rs.getInt(1), rs.getString(2));
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
        return direcciones;
    }
    
}
