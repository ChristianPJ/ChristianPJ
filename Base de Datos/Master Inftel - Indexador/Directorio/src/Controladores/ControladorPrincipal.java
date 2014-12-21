/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Blackproxy
 */
public final class ControladorPrincipal {

    private static JFrame frame = null;

    public ControladorPrincipal(JFrame frame) {
        ControladorPrincipal.frame = frame;
    }

    public static void cambiarPanel(JPanel panel) {
        
        frame.getContentPane().removeAll();
        frame.setContentPane(panel);
        frame.validate();
        frame.repaint();
        frame.setVisible(true);
    }

    public static void setFrame(JFrame frame) {
        ControladorPrincipal.frame = frame;
    }
}
