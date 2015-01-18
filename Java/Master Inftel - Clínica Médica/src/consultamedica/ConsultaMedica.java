/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultamedica;

import Controlador.ControladorPrincipal;
import Controlador.ControladorLogin;
import Vista.FramePrincipal;
import Vista.PanelLogin;
import java.text.ParseException;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Blackproxy
 */
public class ConsultaMedica {
    
    public static ResourceBundle myBundle;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ParseException {
        // TODO code application logic here
        setBundle(0);
        
        PanelLogin panel = new PanelLogin();
        ControladorLogin controlador = new ControladorLogin(panel);
        panel.controlador(controlador);
        //PanelPedirCita panel = new PanelPedirCita();
        //ControladorPedirCita controlador = new ControladorPedirCita(panel);
        //panel.controlador(controlador);
       
        
        FramePrincipal ventana = new FramePrincipal();
        ControladorPrincipal.setFrame(ventana);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane((JPanel) panel);
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setVisible(true);
    }
    
    public static ResourceBundle getBundle(){
        return myBundle;
    }
    
    public static void setBundle(int i){
        if(i==1){
            myBundle = ResourceBundle.getBundle("Vista/internationalization_en_US");
        } else {
            myBundle = ResourceBundle.getBundle("Vista/internationalization");
        }
    }
}
