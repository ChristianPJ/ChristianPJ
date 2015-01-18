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
import Vista.VistaNuevoUsuario;
import com.aeat.valida.Validador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Blackproxy
 */
public class ControladorNuevoUsuario implements ActionListener {

    private VistaNuevoUsuario vista;
    
    public ControladorNuevoUsuario(VistaNuevoUsuario vista){
        this.vista= vista;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch(cmd){
            case(VistaNuevoUsuario.BotonCrearUsuario):{
                if (comprobarContrasenas(vista.getContrasena(), vista.getContrasena2())){
                    String msg = verificarPersona(vista.getNombre(), vista.getApellidos(),vista.getNIF(),vista.getFecha(), vista.getTelefono(), vista.getEmail());
                    if (msg.compareTo("")==0){
                        try{
                            Persona per = PersonaDAO.getPersonaByNIF(vista.getNIF());
                            if(per!=null){
                                vista.mensajeError("Ya existe una persona con ese DNI");
                            }
                            else{
                                crearUsuario();
                                PanelAdmin panelAdmin = new PanelAdmin();
                                ControladorAdmin controladorAdmin = new ControladorAdmin(panelAdmin);
                                panelAdmin.controlador(controladorAdmin);
                                ControladorPrincipal.cambiarPanel(panelAdmin);
                                
                            }
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
            case (VistaNuevoUsuario.BotonCancelar):{
                PanelAdmin panelAdmin = new PanelAdmin();
                ControladorAdmin controladorAdmin = new ControladorAdmin(panelAdmin);
                panelAdmin.controlador(controladorAdmin);
                ControladorPrincipal.cambiarPanel(panelAdmin);
                break;
            }
        }
    }
    
    public void crearPersona() throws InstantiationException, IllegalAccessException{
        Persona per;
        per = new Persona(0, vista.getNombre(), vista.getApellidos(), vista.getNIF(), vista.getDireccion(),
                vista.getFecha(), Integer.parseInt(vista.getTelefono()), vista.getEmail(), vista.getContrasena(), vista.getPerfil());
        PersonaDAO.insertarPersona(per);
    }
    
    public void crearMedico(Date horaInicio,Date horaFin) throws InstantiationException, IllegalAccessException{
        Medico med;
        med = new Medico(0, vista.getEspecialidad(), horaInicio, horaFin,0, vista.getNombre(), vista.getApellidos(), 
                vista.getNIF(), vista.getDireccion(),vista.getFecha(), Integer.parseInt(vista.getTelefono()),
                vista.getEmail(), vista.getContrasena(), vista.getPerfil());
        MedicoDAO.insertarMedico(med);
    }
    
    public void crearPaciente() throws InstantiationException, IllegalAccessException{
        Paciente pac;
        pac = new Paciente(0, Integer.parseInt(vista.getNumSS()), vista.getOperaciones(), vista.getAlergias(), vista.getTratamientos(), 0,
                vista.getNombre(), vista.getApellidos(), vista.getNIF(), vista.getDireccion(), vista.getFecha(),
                Integer.parseInt(vista.getTelefono()), vista.getEmail(), vista.getContrasena(), vista.getPerfil());
        PacienteDAO.insertarPaciente(pac);
        
    }
    
    
    public void crearUsuario(){
        
        int tipoUsuario = vista.getPerfil();
        try{
            switch(tipoUsuario){
                case 2:{
                    crearPersona();
                    break;
                }
                case 1:{
                    crearPaciente();
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
                        crearMedico(horaInicio,horaFin);
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
    
}
