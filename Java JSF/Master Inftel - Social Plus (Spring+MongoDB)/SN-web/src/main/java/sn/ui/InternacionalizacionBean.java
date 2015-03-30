package sn.ui;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class InternacionalizacionBean implements Serializable{

    private Locale locale = FacesContext.getCurrentInstance()
            .getViewRoot().getLocale();
    private static final long serialVersionUID = 1L;
    
    public InternacionalizacionBean() {
    }
    
    public String cambiarLocale(String idioma) {

        locale = new Locale(idioma);
        FacesContext.getCurrentInstance()
                .getViewRoot().setLocale(locale);

        return "index?faces-redirect=true";  
    }
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    
}

   
