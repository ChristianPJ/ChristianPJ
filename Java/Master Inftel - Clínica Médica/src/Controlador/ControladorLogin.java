
package Controlador;

import Modelo.Clases.Medico;
import Modelo.Clases.Paciente;
import Modelo.Clases.Persona;
import Modelo.DAO.MedicoDAO;
import Modelo.DAO.PacienteDAO;
import Modelo.DAO.PersonaDAO;
import Vista.PanelAdmin;
import Vista.PanelMedico;
import Vista.PanelPaciente;
import Vista.VistaLogin;
import consultamedica.ConsultaMedica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ControladorLogin implements ActionListener{
    
    private final VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }

    public Persona loginCorrecto(String nif, String contrasena) throws InstantiationException, IllegalAccessException{
        
        System.out.println(contrasena);
        Persona per = PersonaDAO.getPersonaByNIF(nif);
        String msg = null;
        if (per==null){
            msg="El NIF es incorrecto";
            vista.mError(msg);
            vista.limpiar();
        }
        else if((contrasena.compareTo(per.getContrasena())!=0) || (contrasena.compareTo("")==0)){
            msg="La contraseña es incorrecta";
            vista.mError(msg);
            per=null;
        }        
        return per;
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        try {
            switch (cmd) {
                case VistaLogin.BotonLoguearse:
                    {
                        String user = vista.getUsuario();
                        String password = vista.getContrasenia();
                            Persona persona = loginCorrecto(user, password);
                            if (persona !=null){
                                int tipoUsuario = persona.getPerfil();
                                switch (tipoUsuario){
                                    case (0):{
                                        PanelMedico panelMedico = new PanelMedico();
                                        Medico medico= MedicoDAO.getMedicoByIdPersona(persona.getIdPersona());
                                        ControladorMedico controladorMedico = new ControladorMedico(panelMedico,medico);
                                        panelMedico.controlador(controladorMedico);
                                        ControladorPrincipal.cambiarPanel(panelMedico);
                                       break; 
                                    }
                                    case (1):{
                                        PanelPaciente panelPaciente = new PanelPaciente();
                                        Paciente paciente= PacienteDAO.getPacienteByIdPersona(persona.getIdPersona());
                                        ControladorPaciente controladorPaciente = new ControladorPaciente(panelPaciente,paciente);
                                        panelPaciente.controlador(controladorPaciente);
                                        ControladorPrincipal.cambiarPanel(panelPaciente);                                        
                                       break; 
                                    }
                                    case (2):{
                                        PanelAdmin panelAdmin = new PanelAdmin();
                                        ControladorAdmin controladorAdmin = new ControladorAdmin(panelAdmin);
                                        panelAdmin.controlador(controladorAdmin);
                                        ControladorPrincipal.cambiarPanel(panelAdmin);
                                       break; 
                                    }
                                }
                            }
                        }                        
                case VistaLogin.Esp:
                {
                    ConsultaMedica.setBundle(0);
                    break;
                }  
                case VistaLogin.Usa:
                {
                    
                    ConsultaMedica.setBundle(1);
                    break;
                }
            }
        } catch (InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
