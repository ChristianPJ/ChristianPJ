/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author inftel21
 */
@ManagedBean
@SessionScoped
public class IdiomaBean {
    
    private String locale;

    public IdiomaBean() {
        this.locale = "es_ES";
    }
    
    public String cambiarIdioma(String locale) {
        setLocale(locale);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String referer = externalContext.getRequestHeaderMap().get("referer");
        int slashIndex = referer.lastIndexOf("/");
        if (slashIndex >= 0 && slashIndex < referer.length() - 1) {
            referer = referer.substring(slashIndex + 1);
        }
        referer += ((referer.contains("?")) ? "&" : "?") + "faces-redirect=true";
        return referer;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
    
}
