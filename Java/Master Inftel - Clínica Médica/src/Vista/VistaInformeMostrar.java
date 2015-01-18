/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.sql.Blob;

/**
 *
 * @author inftel18
 */
public interface VistaInformeMostrar {
    
    public static final String BotonInformeVolver = "BOTON_IR_A_INFORME";

    public void cambiarLabel(String string);
    
    public void setInfo(String dia, String trat, String dat, Blob file);
    
}
