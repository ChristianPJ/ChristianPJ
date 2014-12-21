/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.Clases.Foto;
import directorio.Conexion;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FotoDAO {
    
    private Connection con= null;
    static List<Foto> fotos = null;
    
    public static final String SQL_NUEVA_FOTO =
        "INSERT INTO Fotos " +
        " ( Id , NombreFoto, Extension, Tam, Carpeta_Id, Fecha)" + 
        " VALUES " +
        "( SQL_INC_FOTO.NEXTVAL, ?, ?, ?, ?, ?)" ; 
    
    public static final String SQL_BUSCAR_FOTO =
        "SELECT *" +
        " FROM Fotos " +
        "WHERE NombreFoto = ? AND Carpeta_Id = ?";
    
    public static final String SQL_GET_FOTOS =
        "SELECT * " +
        "FROM Fotos";
            
    
    public FotoDAO (){
        
    }
    
    public int crearFoto(String Nombre, String Extension, Long tam, Long fecha, int Carpeta, Conexion con) throws SQLException, InstantiationException, IllegalAccessException, IOException{
      
        Date d = new Date(fecha);
        
        int i = Integer.parseInt(tam.toString());        

        CallableStatement cs = con.getCon().prepareCall("{? = call INSERTIMAGE (?,?,?,?,?)}");
        cs.setInt(2, Carpeta); // Ruta
        cs.setString(3, Nombre); // Nombre
        cs.setString(4, Extension); // Extension
        cs.setInt(5, i);  // Tam
        cs.setDate(6, d);
        cs.registerOutParameter(1, Types.INTEGER);
        cs.executeQuery();
        
        Integer valor = cs.getInt(1);

        return valor;
        
    }
    
    public int leerFoto(String Nombre, String Carpeta) throws SQLException, InstantiationException, IllegalAccessException{
     
        //con=Conexion.conectar(); 
        
        PreparedStatement ps =null;
        ResultSet rs = null;
        
        int res=0;

        try{
            
            ps = con.prepareStatement(SQL_BUSCAR_FOTO);
            ps.setString(1, Nombre);
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                res= rs.getInt(1);    
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
        return res;
    }
    
    public List<Foto> getFotos() throws InstantiationException, IllegalAccessException, SQLException{
        
        Conexion c = new Conexion();
        con=c.conectar();
        fotos = new ArrayList<>();
        
        PreparedStatement ps =null;
        ResultSet rs = null;

        try{            
            ps = (PreparedStatement)con.prepareStatement(SQL_GET_FOTOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Foto foto = new Foto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6));
                fotos.add(foto);
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
        return fotos;
    }
    
}
