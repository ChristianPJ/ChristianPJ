/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorio;

import Controladores.ControladorBuscador;
import Controladores.ControladorCreacion;
import Vistas.FramePrincipal;
import Vistas.PanelBuscador;
import Vistas.PanelFoto;
import Vistas.PanelCreacion;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author inftel15
 */
public class MainBusqueda {
    
    public static void main(String[] args) throws IOException{
        
        PanelBuscador panel = new PanelBuscador();
        ControladorBuscador controlador = new ControladorBuscador(panel);
        panel.controlador(controlador);
        //PanelPedirCita panel = new PanelPedirCita();
        //ControladorPedirCita controlador = new ControladorPedirCita(panel);
        //panel.controlador(controlador);
       
        
        FramePrincipal ventana = new FramePrincipal();
        //ControladorPrincipal.setFrame(ventana);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane((JPanel) panel);
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
    }
    
}
