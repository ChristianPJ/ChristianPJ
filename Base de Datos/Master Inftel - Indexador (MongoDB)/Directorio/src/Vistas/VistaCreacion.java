/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.ActionListener;
import java.io.File;

/**
 *
 * @author inftel15
 */
public interface VistaCreacion  {
    
    public static final String BotonSeleccionarCarpetas = "BOTON_SELECCIONAR_CARPETAS";
    
    public File[] abrirSelectDir();
    
    public void mostrarTerminado(String menssage);
    
    public void controlador(ActionListener ctr);
}
