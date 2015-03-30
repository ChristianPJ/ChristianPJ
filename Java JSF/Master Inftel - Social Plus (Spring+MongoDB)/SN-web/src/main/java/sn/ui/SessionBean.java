
package sn.ui;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.entity.Usuario;

@Component
@Scope("session")
public class SessionBean implements Serializable{

    private Usuario usuario;
    private String accessToken;
    
    private String emailUserFinded;

    public SessionBean() {  
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getEmailUserFinded() {
        return emailUserFinded;
    }

    public void setEmailUserFinded(String emailUserFinded) {
        this.emailUserFinded = emailUserFinded;
    } 
}
