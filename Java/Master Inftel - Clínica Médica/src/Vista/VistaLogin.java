/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author inftel15
 */
public interface VistaLogin {

    public static final String BotonLoguearse = "BOTON_LOGUEARSE";
    
    public static final String Esp = "IDIOMA_ESPAÑOL";
    public static final String Usa = "IDIOMA_INGLES";
    
    public String getUsuario();
    
    public String getContrasenia();
    
    public JFrame getPadre();

    public void controlador(ActionListener ctr);

    public void mError(String msg);
    
    public void limpiar();

}
