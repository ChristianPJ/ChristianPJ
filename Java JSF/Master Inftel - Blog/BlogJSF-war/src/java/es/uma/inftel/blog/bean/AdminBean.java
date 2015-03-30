/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Usuario;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ChristianPJ
 */
@ManagedBean(name="adminBean")
@RequestScoped
public class AdminBean implements Serializable {
    
    @EJB
    private UsuarioFacade usuarioFacade;

    private List<Usuario> usuarios;
    
    private final static Integer[] tipos;
    public String tiposNombre;
    public Integer tiposId;

    static {
        tipos = new Integer[4];
        tipos[0] = Usuario.TIPO_ADMIN;
        tipos[1] = Usuario.TIPO_POSTER;
        tipos[2] = Usuario.TIPO_NORMAL;
        tipos[3] = Usuario.TIPO_NULO;   
    }
    
    public AdminBean() {
    }

    public String converterString(Integer tipo){
        switch (tipo) {
            case 0:
                tiposNombre = "administrador";
                break;
            case 1:
                tiposNombre = "escritor";
                break;
            case 2:
                tiposNombre = "normal";
                break;
            case 3:
                tiposNombre = "sancionado";
                break;
            default:
                tiposNombre = "error";
                break;
        }
        return tiposNombre;
    }
    
    @PostConstruct
    public void init() {
        usuarios = usuarioFacade.findByNameLike("");
    }
    
    public void buscarUsuarios(String usuario){
        usuarios = usuarioFacade.findByNameLike(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Integer> getTipos() {
        return Arrays.asList(tipos);
    }
    
    public void onRowEdit(RowEditEvent event) {
        String username = ((Usuario) event.getObject()).getUsername();
        Integer tipo = ((Usuario) event.getObject()).getTipo();
        usuarioFacade.updateUser(username,tipo);
    }   
}
