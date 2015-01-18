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
public interface VistaEditarUsuario {
    
    public static final String BotonActualizarUsuario = "BOTON_ACTUALIZAR_USUARIO";
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
    
    public String getTratamientos();
    
    public String getOperaciones();
    
    public String getNumSS();
    
    public String getAlergias();
    
    public String getEspecialidad();
    
    public String getHorarioInicio();
    
    public String getHorarioFin();
    
    public void mensajeError(String message);
    
    public void setNombre(String nombre);
    
    public void setApellido(String apellidos);
    
    public void setDireccion (String direccion);
    
    public void setFecha (Date fecha);
    
    public void setNif (String nif);
    
    public void setTelefono (String telefono);
    
    public void setEmail(String email);
    
    public void setContrasena(String contrasena);
    
    public void setContrasena2(String contrasena);
    
    public void setTratamientos(String tratamientos);
    
    public void setOperaciones(String operaciones);
    
    public void setNumSS(String numSS);
    
    public void setAlergias(String alergias);
    
    public void setEspecialidad(String especialidad);
    
    public void setHorarioInicio(String horarioInicio);
    
    public void setHorarioFin(String horarioFin);
    
}
