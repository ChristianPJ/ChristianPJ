/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultamedica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Blackproxy
 */
public class Conexion {

    private static Connection con=null; // atribut per a guardar l’objecte connexió.
    private static final String url = "jdbc:mysql://localhost:3306/clinicabd";
 
    /**Método constructor que ejecuta el método para conectar con la base de datos
     *
     */
    
//    con = DriverManager.getConnection(url,"admin","admin");
    public Conexion(){
    }
    
    public static Connection conectar() throws InstantiationException, IllegalAccessException {
        if (con==null){
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(url,"admin","admin");
                if (con!=null)
                    System.out.println("Conexión con la base de datos extablecida");
            }
            catch (SQLException ex){
                System.out.println("Hubo un problema al conectar con la base de datos");
            }
            catch (ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        return con;
    }
    
    public static void desconectar(){
        if (con!=null){
            try{
                con.close();
            }
            catch ( SQLException ex){
                System.out.println("No se pudo desconectar correctamente");
            }
            
        }
    }
    
    
 
}
