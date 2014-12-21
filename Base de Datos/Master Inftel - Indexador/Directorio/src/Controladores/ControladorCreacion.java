/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.DAO.MongoDAO;
import Vistas.VistaCreacion;
import com.drew.imaging.ImageProcessingException;
import directorio.Consulta;
import directorio.ETL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inftel15
 */
public class ControladorCreacion implements ActionListener {

    private final VistaCreacion vista;

    public ControladorCreacion(VistaCreacion vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case VistaCreacion.BotonSeleccionarCarpetas: {

                File[] archivos = vista.abrirSelectDir();
                for (File archivo : archivos) {
                    System.out.println(archivo.getAbsolutePath());
                    if (archivo.exists()) { 
                     // Directorio existe
                     // ConsultaDAO c = new ConsultaDAO();

                     // c.leerFoto();
                     Consulta c=new Consulta();   
                        try {
                            c.ListarDirectorio(archivo);
                        } catch (ImageProcessingException | IOException | SQLException | InstantiationException | IllegalAccessException ex) {
                            Logger.getLogger(ControladorCreacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     } else { //Directorio no existe }
                     System.out.println("El directorio no existe");
                     }
                }
            try {
                // Mostrar Dialog
                MongoDAO.borrarMongo();
                ETL.ETL();
            } catch (UnknownHostException | ParseException ex) {
                Logger.getLogger(ControladorCreacion.class.getName()).log(Level.SEVERE, null, ex);
            }
                vista.mostrarTerminado("EL proceso ha terminado satisfactoriamente");
            }
            break;
        }
    }
}
