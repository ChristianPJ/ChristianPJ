/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author inftel11
 */
public final class ControladorDialog {
    
    private static JDialog dialogo = null;

    public ControladorDialog(JDialog dialog) {
        this.dialogo = dialog;
    }

    public static void setDialogo(JDialog dialogo) {
        ControladorDialog.dialogo = dialogo;
    }

    public static void cargarPanelDialogo(JPanel panel){
        
        dialogo.getContentPane().removeAll();
        dialogo.setContentPane(panel);
        dialogo.validate();
        dialogo.repaint();
        dialogo.setVisible(true);
    }
    
}
