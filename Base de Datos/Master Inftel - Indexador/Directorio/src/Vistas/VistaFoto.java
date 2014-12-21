/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import com.mongodb.BasicDBObject;
import java.awt.event.ActionListener;

/**
 *
 * @author inftel07
 */
public interface VistaFoto {
    
    public static final String BotonMas = "BOTON_MAS";
    public static final String BotonMenos = "BOTON_MENOS";
    public static final String BotonMapa = "BOTON_MAPA";
    public static final String BotonFoto = "BOTON_FOTO";
    
    public void controlador(ActionListener ctr);
    
    public void mensajeError(String message);
    
    public void rellenarCampos(BasicDBObject obj, int posi, int l);
    
}
