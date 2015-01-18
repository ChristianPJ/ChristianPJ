/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author loubna
 */
public interface VistaRecetaCrear {
    
    public static final String BotonCrearRecetaBD = "BOTON_RECETA_EN_BASE_DATOS";
     public static final String BotonVolverAtras = "BOTON_VOLVER_A_RECETAS";
    public List<String> recogerDatos() ;
    public void controlador(ActionListener ctr);
    
}
