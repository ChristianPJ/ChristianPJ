/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author loubna
 */
public interface VistaReceta {
    
    public static final String BotonCrearReceta = "BOTON_IR_A_CREAR_RECETA";
    public static final String BotonMostrarReceta = "Boton_Mostrar_todas_Receta";
     public static final String BotonVolverAtras = "BOTON_VOLVER_A_RECETAS";
    public static final String GenerarPDF = "Generar_Receta_en_pdf";
    
    public void cargarRecetas(String Indicaciones, Integer Medicamento);
    public String getIdIndecacionesOfSelectedRow();
    public String getIdIMedicamentoOfSelectedRow();
    public void mostrarMensaje1(String mensaje1);
    public void mostrarMensaje2(String mensaje2);
    public String recogerIndecaciones();   
    public String recogerMedicamento();
   public List<String>  ImpremirCampo() ;
   
    public void insertarFila(String a,String b);
   
    
    public void controlador(ActionListener ctr);
}
