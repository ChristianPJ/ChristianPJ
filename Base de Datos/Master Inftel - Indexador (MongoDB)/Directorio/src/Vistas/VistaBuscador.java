/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;

public interface VistaBuscador {
    
    public static final String BotonBuscar = "BOTON_BUSCAR";
    public static final String BotonCamara = "BOTON_CAMARA";
    public static final String BotonPhotoshop = "BOTON_PHOTOSHOP";
    public static final String BotonFecha = "BOTON_FECHA";
    public static final String BotonTamanio = "BOTON_TAMANIO";
    public static final String BotonFlash = "BOTON_FLASH";
    public static final String BotonElegirMarca = "BOTON_ELEGIR_MARCA";
    public static final String BotonElegirModelo = "BOTON_ELEGIR_MODELO";
    
    public String getMarca();
    
    public String getModelo();
    
    public void rellenarMarca(String marca);
    
    public void rellenarModelo(String marca);
    
    public void VaciarModelo();
    
    public void VaciarMarca();
    
    public boolean isPhotoshopSISelected();
    
    public boolean isPhotoshopNOSelected();
    
    public boolean isFlashSISelected();
    
    public boolean isFlashNOSelected();
    
    public void mensajeError(String message);
    
    public Date getFechaInicio();
    
    public Date getFechaFin();
    
    public String getAlto();
    
    public String getAncho();
    
    public JFrame getPadre();
    
    public void controlador(ActionListener ctr);
}
