/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio;

import Modelo.DAO.CarpetaDAO;
import Modelo.DAO.DirectorioDAO;
import Modelo.DAO.EtiquetaDAO;
import Modelo.DAO.FotoDAO;
import Modelo.DAO.InfoDAO;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class Consulta {
    
    Conexion con = new Conexion();
        
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public void ListarDirectorio(File f) throws ImageProcessingException, IOException, SQLException, InstantiationException, IllegalAccessException
    {
        File[] ficheros = f.listFiles();
        CarpetaDAO car = new CarpetaDAO();
        Date d;
        
            for (File fichero : ficheros) {
                
                if (fichero.isDirectory()){
                    System.out.println("");
                    UltimaModificacion(fichero);
                    System.out.println("Carpeta:" + fichero.getName());

                    /*d = new Date(fichero.lastModified());
                    if(d!=car.fechaCarpeta(fichero.getParent())){
                    }*/
                        
                    ListarDirectorio(fichero);  // <--

                    
                } else {
                    con = new Conexion();
                    con.conectar();
                    UltimaModificacion(fichero);
                    String extension = getFileExtension(fichero);
                    
                    System.out.println(ANSI_RED+fichero.getName()+" ("+extension+")"+ANSI_RESET);
                    
                    
                    
                    if (extension.equals(".jpg")){
                        SacarInfo(fichero,extension);
                    }
                    
                }
            }   
            System.out.println("");
    }
    
    public void UltimaModificacion(File f){
        long ms = f.lastModified();
        Date d = new Date(ms);
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        String annio = Integer.toString(c.get(Calendar.YEAR));
        String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(c.get(Calendar.MINUTE));
        String segundo = Integer.toString(c.get(Calendar.SECOND)); 
        System.out.print(hora+":"+minuto+":"+segundo+" "+dia+"/"+mes+"/"+annio+" -> ");   
    }
    
    public void SacarInfo(File f, String ext) throws SQLException, InstantiationException, IllegalAccessException, IOException, JpegProcessingException
    {
        System.out.println(f.getName());
        Metadata metadata = JpegMetadataReader.readMetadata(f);
        FotoDAO foto = new FotoDAO(); 
        EtiquetaDAO c = new EtiquetaDAO();
        DirectorioDAO d = new DirectorioDAO();
        InfoDAO i = new InfoDAO();
        CarpetaDAO car = new CarpetaDAO();

        int existeE,existeD, existeI, existeC;
        Tag etiq;
        Directory dir;
        int idfoto;
        
        existeC = car.leerCarpeta(f.getParent(),con);
                
        if(existeC == -1){ // No existe Carpeta  
        
            car.crearCarpeta(f.getParent(),f.lastModified(),con);
            existeC = car.leerCarpeta(f.getParent(),con);
        }


        idfoto=foto.crearFoto(f.getName(),ext,f.length(),f.lastModified(), existeC, con);
        
        
        for (Directory directory : metadata.getDirectories()) {            
       
            
            for (Tag tag : directory.getTags()){  
                

                if(((tag.getDescription() == null) || (tag.getDescription().length()>3999))) {
                    System.out.println("Omito");
                } else {
                    i.InsertMetadata(idfoto, directory.getName(), tag.getTagName(), tag.getDescription(), con);
                }
                
            }
            for (String error : directory.getErrors())
                System.err.println("ERROR: " + error);
        } 
        
        con.desconectar();
 
    }
    
    public String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
    
    

    
}
