/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.File;

/**
 *
 * @author inftel18
 */
public interface VistaInformeCrear {
    
    public static final String BotonInformeVolver = "BOTON_IR_A_INFORME";
    public static final String BotonInformeCrear = "BOTON_IR_A_CREARINFORME";

    public void cambiarLabel(String string);
    
    public String infDatos();
    
    public String infTratamiento();
    
    public String infDiagnostico();
    
    public File getAdjunto();
    
    public boolean checkPDF();
    
    public boolean checkEmail();
    
    public void mError(String e);
    
}
