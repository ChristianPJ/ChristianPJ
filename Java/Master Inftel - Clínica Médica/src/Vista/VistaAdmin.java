/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author inftel15
 */
public interface VistaAdmin {
    
    public static final String BotonCrearUsuario="BOTON_CREAR_USUARIO";
    public static final String BotonEditarUsuario="BOTON_EDITAR_USUARIO";
    public static final String BotonCerrarSesion="BOTON_CERRAR_SESIÓN";
    
    public void controlador(ActionListener ctr);
    
    public String gettxtNif();
    
    public void mensajeError(String message);
}
