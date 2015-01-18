/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Persona;
import Modelo.DAO.PersonaDAO;
import Vista.PanelEditarUsuario;
import Vista.PanelLogin;
import Vista.PanelNuevoUsuario;
import Vista.VistaAdmin;
import com.aeat.valida.Validador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author inftel15
 */
public class ControladorAdmin implements ActionListener {
    
    private final VistaAdmin vista;

    public ControladorAdmin(VistaAdmin vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        
        try{
            switch(cmd){
                case VistaAdmin.BotonCrearUsuario:{
                    
                    PanelNuevoUsuario panelNuevoUsuario = new PanelNuevoUsuario();
                    ControladorNuevoUsuario controladorNuevoUsuario = new ControladorNuevoUsuario(panelNuevoUsuario);
                    panelNuevoUsuario.controlador(controladorNuevoUsuario);
                    ControladorPrincipal.cambiarPanel(panelNuevoUsuario);   
                    break;
                }
                case VistaAdmin.BotonEditarUsuario:{
                    if(validarNifNIe(vista.gettxtNif())){
                        Persona per = PersonaDAO.getPersonaByNIF(vista.gettxtNif());
                        if (per!=null){
                            PanelEditarUsuario panelEditarUsuario = new PanelEditarUsuario(per);
                            ControladorEditarUsuario controladorEditarUsuario = new ControladorEditarUsuario(panelEditarUsuario,per);
                            panelEditarUsuario.controlador(controladorEditarUsuario);
                            ControladorPrincipal.cambiarPanel(panelEditarUsuario);
                        }
                        else{
                            vista.mensajeError("No hay ninguna persona con ese NIF en la base de datos");
                        }
                        
                    }
                    else{
                        vista.mensajeError("El NIF no es válido");
                    }
                    break;
                }
                case VistaAdmin.BotonCerrarSesion:
                {
                    PanelLogin panelLogin = new PanelLogin();
                    ControladorLogin controladorLogin = new ControladorLogin(panelLogin);
                    panelLogin.controlador(controladorLogin);

                    ControladorPrincipal.cambiarPanel(panelLogin);
                }
            }
        } catch (InstantiationException | IllegalAccessException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static boolean validarNifNIe(String nif){
        Validador validador = new Validador();
        int e = validador.checkNif(nif.toUpperCase());
        boolean res=false;
        if (e > 0)
            res=true;
        return res;
    }
    
}
