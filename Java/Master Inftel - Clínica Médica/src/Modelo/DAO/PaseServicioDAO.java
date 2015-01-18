package Modelo.DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alfredo
 */


import Modelo.Clases.PaseServicio;
import consultamedica.Conexion;
import java.io.IOException;
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
public class PaseServicioDAO {
    
    private PaseServicio paseservicio=null;
    Connection con= null;
    public static final String SQL_NUEVO_PASE =
        "INSERT INTO paseservicio " +
        " (`Prueba`,`Causa`,`Cita_idCita`,`Cita_Paciente_idPaciente`, `Cita_Paciente_Persona_idPersona`) " +
        " VALUES " +
        "( ? , ? , ? , ?, ?);";    
     public static final String SQL_PASE =
        "SELECT * " +
        "FROM paseservicio P " +
        "WHERE P.Cita_Paciente_idPaciente = ? ";
    public PaseServicioDAO() {
    }
    private List <PaseServicio> listaPaseservicio=null;
    public List<PaseServicio> getAllPaseservicio() throws InstantiationException, IllegalAccessException{
        
        con=Conexion.conectar();
        listaPaseservicio= new ArrayList<>();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from paseservicio");
            ResultSetMetaData rsmd = rs.getMetaData();
            int number = rsmd.getColumnCount();
            System.out.println(number);
            while (rs.next()) {
                paseservicio = new PaseServicio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listaPaseservicio.add(paseservicio);
            }
            System.out.println(listaPaseservicio.toString());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listaPaseservicio;

    }
    public void crearPase(String Prueba, String Causa, Integer idCita, Integer idPaciente, Integer idPersona) throws SQLException, InstantiationException, IllegalAccessException, IOException{

        con=Conexion.conectar();
             
        try (PreparedStatement ps = con.prepareStatement(SQL_NUEVO_PASE)) {
          
            ps.setString(1, Prueba);
            ps.setString(2, Causa);
            ps.setInt(3, idCita);
            ps.setInt(4, idPaciente);
            ps.setInt(5, idPersona);  
            ps.executeUpdate();
            System.out.println(ps);

        }
    }
   
        public List<PaseServicio> leerPases(Integer Cita_Paciente_idPaciente) throws SQLException, InstantiationException, IllegalAccessException{
        
        con=Conexion.conectar();        

        PreparedStatement ps =null;
        ResultSet rs = null;
        List<PaseServicio> ListaPaseServicio=new ArrayList<PaseServicio>();
        
        try  {
            ps = (PreparedStatement)con.prepareStatement(SQL_PASE);
            ps.setInt(1, Cita_Paciente_idPaciente);
            rs = ps.executeQuery();
            while (rs.next()) {
                PaseServicio pase = new PaseServicio(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ListaPaseServicio.add(pase);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            if (ps !=null){
               ps.close(); 
            } 
            if (rs!=null){
               rs.close(); 
            }           
        }
        
        return ListaPaseServicio;
    }
    /* public DefaultTableModel leerPases(Integer Cita_Paciente_idPaciente) throws SQLException, InstantiationException, IllegalAccessException{
        
        con=Conexion.conectar();        
    
        DefaultTableModel dtm;
        
        try (PreparedStatement ps = con.prepareStatement(SQL_PASE)) {
            ps.setInt(1, Cita_Paciente_idPaciente);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            dtm = dibujarTabla(rs);
        }
        return dtm;
    }
    public DefaultTableModel dibujarTabla(ResultSet rs) throws SQLException{
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        ResultSetMetaData rsMd = rs.getMetaData();
        //La cantidad de columnas que tiene la consulta
        int cantidadColumnas = rsMd.getColumnCount();
        //Establecer como cabezeras el nombre de las colimnas
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(rsMd.getColumnLabel(i));
        }
        //Creando las filas para el JTable
        while (rs.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i]=rs.getObject(i+1);
            }
            modelo.addRow(fila);
        }
        return modelo;
    }*/
    
    
}
