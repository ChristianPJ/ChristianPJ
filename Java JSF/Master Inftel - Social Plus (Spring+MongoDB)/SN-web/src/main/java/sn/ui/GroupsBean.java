
package sn.ui;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import sn.entity.Groups;
import sn.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.services.ComentarioServiceImp;
import sn.services.GroupsService;
import sn.services.UsuarioServiceImp;

@Component
@Scope("request")
public class GroupsBean {

    @Autowired
    UsuarioServiceImp usuarioService;
    
    @Autowired
    GroupsService groupService;
    
    @Autowired   
    ComentarioServiceImp comentarioServiceImpl;
    
    @Autowired
    private SessionBean sessionBean;
    
    @Autowired
    private UsuarioBean usuarioBean;
    
    private String name;
    private String imageUrl;
    private String email;
    private String error;

    @PostConstruct
    public void init() {

        System.out.println(sessionBean.getEmailUserFinded());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String grupo = externalContext.getRequestParameterMap().get("grupo");
        List<Groups> l = groupService.findByName(grupo);
        if (!l.isEmpty()) {
            this.name = l.get(0).getName();
            imageUrl = l.get(0).getImageUrl();
            email = l.get(0).getEmail();
        }
    }

    public String crearGroup() {
        Groups group = new Groups();
        group.setImageUrl(imageUrl);
        group.setName(name);
        group.setEmail(sessionBean.getUsuario().getEmail());
        group.setUserName(sessionBean.getUsuario().getNombre());
        group.setFotoUrl(sessionBean.getUsuario().getFoto());
        group.setCreador(true);
        groupService.create(group);

        return "group.xhtml?faces-redirect=true&grupo=" + name;
    }

    public void agregarUsuario(Groups grupo) {
        Usuario usuario = usuarioService.findByEmail(usuarioBean.getUsuario().getEmail());
        Groups group = new Groups();
        group.setImageUrl(grupo.getImageUrl());
        group.setName(grupo.getName());
        group.setEmail(usuario.getEmail());
        group.setUserName(usuario.getNombre());
        group.setFotoUrl(usuario.getFoto());
        group.setCreador(false);
        groupService.create(group);
    }

    public String leaveGroup() {
        groupService.deleteByEmailAndGroup(sessionBean.getUsuario().getEmail(), name);
        return "index?faces-redirect=true";
    }

    public List<Groups> obtenerMiembrosGrupo() {
        return groupService.findByName(this.name);
    }

    public List<Groups> obtenerGrupos() {
        if (sessionBean.getUsuario() == null) {
            return null;
        }
        return groupService.encontrarPosiblesGrupos(sessionBean.getUsuario().getEmail());
    }

    public List<Groups> obtenerPosiblesGrupo() {
        List<Groups> lista = obtenerGrupos();
        List<Groups> pertenece = groupService.gruposPertenece(usuarioBean.getUsuario().getEmail());
        List<Groups> resultado = new ArrayList();
        boolean encontrado = false;
        for (Groups g : lista) {
            for (Groups h : pertenece) {
                if (g.getName().equals(h.getName())) {
                    encontrado = true;
                }
            }
            if (encontrado == false) {
                resultado.add(g);
            }
            encontrado = false;
        }
        return resultado;
    }

    public void existeGroup() {

        Groups group = groupService.findGroup(name);
        if (group == null) {
            crearGroup();
        } else {
            error = " Este grupo ya existe ";
        }
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public GroupsService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupsService groupService) {
        this.groupService = groupService;
    }

    public ComentarioServiceImp getComentarioServiceImpl() {
        return comentarioServiceImpl;
    }

    public void setComentarioServiceImpl(ComentarioServiceImp comentarioServiceImpl) {
        this.comentarioServiceImpl = comentarioServiceImpl;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioServiceImp getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }
}  
