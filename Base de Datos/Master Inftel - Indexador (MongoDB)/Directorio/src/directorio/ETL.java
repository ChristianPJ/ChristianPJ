/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio;

import Modelo.Clases.Etiqueta;
import Modelo.Clases.Foto;
import Modelo.Clases.Info;
import Modelo.DAO.CarpetaDAO;
import Modelo.DAO.DirectorioDAO;
import Modelo.DAO.EtiquetaDAO;
import Modelo.DAO.FotoDAO;
import Modelo.DAO.InfoDAO;
import Modelo.DAO.MongoDAO;
import com.mongodb.BasicDBObject;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samu
 */
public class ETL {

    static List<Foto> fotos = null;
    static Map<Integer, String> directorios;
    static Map<Integer, String> carpetas;
    static Map<Integer, Etiqueta> etiquetas;
    static List<Info> info;
    static boolean tienePhotoshop;

    public static void ETL() throws UnknownHostException, ParseException {

        try {
            FotoDAO f = new FotoDAO();
            fotos = f.getFotos();
            DirectorioDAO d = new DirectorioDAO();
            directorios = d.getDirectorios();
            CarpetaDAO c = new CarpetaDAO();
            carpetas = c.getCarpetas();
            etiquetas = EtiquetaDAO.getEtiquetas();
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(ETL.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Foto foto : fotos) {

            System.out.println("\n\n" + "nombreFoto: " + foto.getNombreFoto());
            System.out.println("\n" + "ruta: " + carpetas.get(foto.getIdCarpeta()));
            System.out.println("\n" + "tamaño: " + foto.getTamanio());
           
            tienePhotoshop = false;
            try {
                InfoDAO i = new InfoDAO();
                info = i.getInfo(foto.getIdFoto());
            } catch (InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(ETL.class.getName()).log(Level.SEVERE, null, ex);
            }

            BasicDBObject fotoo = new BasicDBObject("nombre", foto.getNombreFoto())
                    .append("ruta", carpetas.get(foto.getIdCarpeta()))
                    .append("tamaño", foto.getTamanio());

            for (Info infoo : info) {
                Etiqueta etiqueta = etiquetas.get(infoo.getIdEqtiqueta());
                if (etiqueta != null) {

                    if (directorios.get(etiqueta.getIdDirectorio()).equals("Photoshop")) {
                        tienePhotoshop = true;
                    }

                    switch (etiqueta.getNombre()) {
                        case "Image Height":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("Jpeg")) {
                                String valor = infoo.getValor();
                                String[] partes = valor.split(" ");
                                fotoo.append("alto", Integer.parseInt(partes[0]));
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "alto" + ": " + partes[0]);
                            }
                            break;
                        case "Image Width":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("Jpeg")) {
                                String valor = infoo.getValor();
                                String[] partes = valor.split(" ");
                                fotoo.append("ancho", Integer.parseInt(partes[0]));
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "ancho" + ": " + partes[0]);
                            }
                            break;
                        case "Flash":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("Exif SubIFD")) {
                                boolean flash = true;
                                if(infoo.getValor().equals("Flash did not fire") || 
                                        infoo.getValor().equals("Flash did not fire, auto")){
                                    flash = false;
                                }                                
                                fotoo.append(etiqueta.getNombre(), flash);
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + etiqueta.getNombre() + ": " + flash);
                            }
                            break;
                        case "Make":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("Exif IFD0")) {
                                fotoo.append("marca", infoo.getValor());
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "marca" + ": " + infoo.getValor());
                            }
                            break;
                        case "Model":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("Exif IFD0")) {
                                fotoo.append("modelo", infoo.getValor());
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "modelo" + ": " + infoo.getValor());
                            }
                            break;
                        case "Date/Time":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("Exif IFD0")) {
                                DateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
                                Date fecha = format.parse(infoo.getValor());
                                fotoo.append("fecha", fecha);
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "fecha" + ": " + infoo.getValor() + " " + fecha);
                            }
                            break;
                        case "GPS Latitude Ref":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("GPS")) {
                                fotoo.append("latitudRef", infoo.getValor());
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "latitudRef" + ": " + infoo.getValor());
                            }
                            break;
                        case "GPS Latitude":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("GPS")) {
                                String valor = infoo.getValor();
                                String[] partes = valor.split(" ");
                                String grados = partes[0];
                                String minutos = partes[1];
                                String segundos = partes[2];
                                String[] partesGrados = grados.split("\\.");
                                String[] partesMinutos = minutos.split("\\.");
                                String[] partesSegundos = segundos.split("\\.");
                                String gradosFinal = partesGrados[0] + "º";
                                String minutosFinal = partesMinutos[0] + "'";
                                String segundosFinal = partesSegundos[0];
                                String latitud = gradosFinal + minutosFinal + segundosFinal;
                                fotoo.append("latitud", latitud);
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "latitud" + ": " + latitud);
                            }
                            break;
                        case "GPS Longitude Ref":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("GPS")) {
                                fotoo.append("longitudRef", infoo.getValor());
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "longitudRef" + ": " + infoo.getValor());
                            }
                            break;                       
                        case "GPS Longitude":
                            if (directorios.get(etiqueta.getIdDirectorio()).equals("GPS")) {
                                String valor = infoo.getValor();
                                String[] partes = valor.split(" ");
                                String grados = partes[0];
                                String minutos = partes[1];
                                String segundos = partes[2];
                                String[] partesGrados = grados.split("\\.");
                                String[] partesMinutos = minutos.split("\\.");
                                String[] partesSegundos = segundos.split("\\.");
                                String gradosFinal = partesGrados[0] + "º";
                                String minutosFinal = partesMinutos[0] + "'";
                                String segundosFinal = partesSegundos[0];
                                String longitud = gradosFinal + minutosFinal + segundosFinal;
                                fotoo.append("longitud", longitud);
                                System.out.println("\n" + directorios.get(etiqueta.getIdDirectorio()) + ": "
                                        + "longitud" + ": " + longitud);
                            }
                            break;
                    }
                }
            }

            if (tienePhotoshop) {
                fotoo.append("Photoshop", true);
                System.out.println("\n" + "Photoshop" + ": " + "true");
            } else {
                fotoo.append("Photoshop", false);
                System.out.println("\n" + "Photoshop" + ": " + "false");
            }
            
            MongoDAO.insertarFoto(fotoo);
        }
    }
}
