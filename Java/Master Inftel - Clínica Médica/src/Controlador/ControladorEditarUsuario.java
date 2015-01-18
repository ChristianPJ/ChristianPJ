/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.Clases.Persona;
import Modelo.DAO.MedicoDAO;
import Modelo.DAO.PacienteDAO;
import Modelo.DAO.PersonaDAO;
import Vista.PanelAdmin;
import Vista.VistaEditarUsuario;
import com.aeat.valida.Validador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Blackproxy
 */
public class ControladorEditarUsuario implements ActionListener{
    private VistaEditarUsuario vista=null;
    private Persona persona;
    
    public ControladorEditarUsuario (VistaEditarUsuario vista,Persona persona) throws InstantiationException, IllegalAccessException{
        
        this.vista = vista;
        this.persona = persona;
        rellenarCampos(persona);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd){
            case(VistaEditarUsuario.BotonActualizarUsuario):{
                if (comprobarContrasenas(vista.getContrasena(), vista.getContrasena2())){
                    String msg = verificarPersona(vista.getNombre(), vista.getApellidos(),vista.getNIF(),vista.getFecha(), vista.getTelefono(), vista.getEmail());
                    if (msg.compareTo("")==0){
                        try{
                            actualizarUsuario();
                            PanelAdmin panelAdmin = new PanelAdmin();
                            ControladorAdmin controladorAdmin = new ControladorAdmin(panelAdmin);
                            panelAdmin.controlador(controladorAdmin);
                            ControladorPrincipal.cambiarPanel(panelAdmin);
                        }
                        catch(Exception exp){
                            System.out.println(exp.getMessage());
                        }
                        
                        
                    }
                    else{
                        vista.mensajeError(msg);
                    }
                }
                else {
                    vista.mensajeError("Las contraseñas no coinciden");
                }
                break;
            }
            case (VistaEditarUsuario.BotonCancelar):{
                PanelAdmin panelAdmin = new PanelAdmin();
                ControladorAdmin controladorAdmin = new ControladorAdmin(panelAdmin);
                panelAdmin.controlador(controladorAdmin);
                ControladorPrincipal.cambiarPanel(panelAdmin);
                break;
            }
        }
    }
    public void actualizarPersona() throws InstantiationException, IllegalAccessException{
        persona.setNombre(vista.getNombre());
        persona.setApellidos(vista.getApellidos());
        persona.setContrasena(vista.getContrasena());
        persona.setDireccion(vista.getDireccion());
        persona.setEmail(vista.getEmail());
        persona.setFechaNacimiento(vista.getFecha());
        persona.setNif(vista.getNIF());
        persona.setTelefono(Integer.parseInt(vista.getTelefono()));
        PersonaDAO.actualizarPersona(persona);
    }
    
    public void actualizarMedico(Date horaInicio,Date horaFin) throws InstantiationException, IllegalAccessException{
        Medico med = MedicoDAO.getMedicoByIdPersona(persona.getIdPersona());
        med.setNombre(vista.getNombre());
        med.setApellidos(vista.getApellidos());
        med.setContrasena(vista.getContrasena());
        med.setDireccion(vista.getDireccion());
        med.setEmail(vista.getEmail());
        med.setEspecialiad(vista.getEspecialidad());
        med.setFechaNacimiento(vista.getFecha());
        med.setHorarioInicio(horaInicio);
        med.setHorarioFin(horaFin);
        med.setNif(vista.getNIF());
        med.setTelefono(Integer.parseInt(vista.getTelefono()));
        actualizarPersona();
        MedicoDAO.actualizarMedico(med);
    }
    
    public void actualizarPaciente() throws InstantiationException, IllegalAccessException{
        Paciente pac = PacienteDAO.getPacienteByIdPersona(persona.getIdPersona());
        
        pac.setNombre(vista.getNombre());
        pac.setApellidos(vista.getApellidos());
        pac.setContrasena(vista.getContrasena());
        pac.setDireccion(vista.getDireccion());
        pac.setEmail(vista.getEmail());
        pac.setFechaNacimiento(vista.getFecha());
        pac.setAlergias(vista.getAlergias());
        pac.setNif(vista.getNIF());
        pac.setNumSS(Integer.parseInt(vista.getNumSS()));
        pac.setOpQuirurgicas(vista.getOperaciones());
        pac.setTelefono(Integer.parseInt(vista.getTelefono()));
        pac.setTratamientos(vista.getTratamientos());
        actualizarPersona();
        PacienteDAO.actualizarPaciente(pac);
        
    }
    
    
    public void actualizarUsuario(){
        try{
            switch(persona.getPerfil()){
                case 2:{
                    actualizarPersona();
                    break;
                }
                case 1:{
                    actualizarPaciente();
                    break;
                }
                case 0:{
                    Date horaInicio,horaFin;
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String horarioInicioStr = "1000-00-00 "+vista.getHorarioInicio();
                    String horarioFinStr = "1000-00-00 "+vista.getHorarioFin();
                    horaInicio = dateformat.parse(horarioInicioStr);
                    horaFin = dateformat.parse(horarioFinStr);
                    if (horaInicio.before(horaFin)){
                        actualizarMedico(horaInicio,horaFin);
                    }
                    else{
                        vista.mensajeError("La hora de inicio debe ser menor que la de fin");
                    }
                    break;
                }
            }
        }
        catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        
    }
    
    
    public boolean comprobarContrasenas(String pass1, String pass2){
        return (pass1.compareTo(pass2)==0);
    }
    
    public boolean campoVacio(String str){
        return str.compareTo("")==0;
    }
    
    public boolean fechaValida(Date fecha){
        return (fecha !=null);
    }
    
    public String verificarPersona(String nombre, String apellidos, String nif, Date fecha, String telefono, String email){
        String res="";
        if(campoVacio(nombre)|| campoVacio(apellidos) || !validarAlfaNumericos(apellidos) || !validarAlfaNumericos(apellidos)){
            res+="Nombre y apellidos deben ser alfanuméricos (SIN ACENTOS) \n";
        }
        if (campoVacio(nif) || !validarNifNIe(nif))
            res+="NIF en formato incorrecto \n";
        if (campoVacio(telefono) || !validarNumericos(telefono))
            res+="Telefono debe ser numérico \n";
        if (campoVacio(email) || !validarEmail(email))
            res+="Email en formato no válido \n";
        if (!fechaValida(fecha))
            res+="Fecha no válida";
        return res;
    }
    
    public static boolean validarEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean validarNifNIe(String nif){
        Validador validador = new Validador();
        int e = validador.checkNif(nif.toUpperCase());
        boolean res=false;
        if (e > 0)
            res=true;
        return res;
    }
    
    public static boolean validarAlfaNumericos(String str) { 
        boolean respuesta = false; 
        if ((str).matches("([a-z]|[A-Z]|\\s)+")) { 
            respuesta = true; 
        } 
        return respuesta; 
    }

    public static boolean validarNumericos(String str){ 
        boolean respuesta = false; 
        if ((str).matches("([0-9]|\\-)+")) { 
            respuesta = true; 
        } 
        return respuesta; 
    } 
    
    public void rellenarCampos(Persona per) throws InstantiationException, IllegalAccessException{
        switch(per.getPerfil()){
            case 0 :{
                try{
                    Medico med = MedicoDAO.getMedicoByIdPersona(per.getIdPersona());
                    rellenarPersona();
                    rellenarMedico(med);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 1:{
                try{
                    Paciente pac = PacienteDAO.getPacienteByIdPersona(per.getIdPersona());
                    rellenarPersona();
                    rellenarPaciente(pac);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 2:{
                rellenarPersona();
                break;
            }
        }
    }
    
    public void rellenarMedico(Medico med){
        vista.setEspecialidad(med.getEspecialiad());
        DateFormat dateFormatHora = new SimpleDateFormat("HH:mm");
        String horaInicioStr= dateFormatHora.format(med.getHorarioInicio());
        String horaFinStr= dateFormatHora.format(med.getHorarioFin());
        vista.setHorarioInicio(horaInicioStr);
        vista.setHorarioFin(horaFinStr);
    }
    
    public void rellenarPaciente(Paciente pa){
        vista.setNumSS(Integer.toString(pa.getNumSS()));
        vista.setAlergias(pa.getAlergias());
        vista.setOperaciones(pa.getOpQuirurgicas());
        vista.setTratamientos(pa.getTratamientos());
    }
    
    public void rellenarPersona(){
        vista.setNombre(persona.getNombre());
        vista.setApellido(persona.getApellidos());
        vista.setDireccion(persona.getDireccion());
        vista.setFecha(persona.getFechaNacimiento());
        vista.setNif(persona.getNif());
        vista.setContrasena(persona.getContrasena());
        vista.setContrasena2(persona.getContrasena());
        vista.setEmail(persona.getEmail());
        vista.setTelefono(Integer.toString(persona.getTelefono()));
    }
}
