/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.util.Date;

/**
 *
 * @author Blackproxy
 */
public interface VistaNuevoUsuario {
    
    public static final String BotonCrearUsuario = "BOTON_CREAR_USUARIO";
    public static final String BotonCancelar = "BOTON_CANCELAR";
    
    public void controlador(ActionListener ctr);
    
    public String getNombre();
    
    public String getApellidos();
    
    public String getDireccion();
    
    public Date getFecha();
    
    public String getNIF();
    
    public String getTelefono();
    
    public String getEmail();
    
    public String getContrasena();
    
    public String getContrasena2();
    
    public int getPerfil();
    
    public String getTratamientos();
    
    public String getOperaciones();
    
    public String getNumSS();
    
    public String getAlergias();
    
    public String getEspecialidad();
    
    public String getHorarioInicio();
    
    public String getHorarioFin();
    
    public void mensajeError(String message);
}
