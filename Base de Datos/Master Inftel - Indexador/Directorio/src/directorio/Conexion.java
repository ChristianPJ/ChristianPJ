/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio;

import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Blackproxy
 */
public class Conexion {

    private Connection con=null; // atribut per a guardar l’objecte connexió.
    private MongoClient conMongo=null;
    private final String url = "jdbc:oracle:thin:@olimpia.lcc.uma.es:1521:edgar";

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    /**Método constructor que ejecuta el método para conectar con la base de datos
     *
     */
    
//    con = DriverManager.getConnection(url,"admin","admin");
    public Conexion(){
    }
    
    public Connection conectar() throws InstantiationException, IllegalAccessException {
        if (con==null){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(url,"inftel14_16","psts");
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
    
    public void desconectar(){
        if (con!=null){
            try{
                con.close();
            }
            catch ( SQLException ex){
                System.out.println("No se pudo desconectar correctamente");
            }
            
        }
    }
    
    public MongoClient conectarMongo() throws UnknownHostException{
        if (conMongo==null){
            conMongo = new MongoClient( "localhost" , 27017 );
        }        
        return conMongo;
    }
 
}
