/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.ImagenFacade;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author miguel
 */
@ManagedBean
public class ImagenesPostBean {
    
    @EJB
    private ImagenFacade imagenFacade;
    
    public ImagenesPostBean() {
    }
    
    public DefaultStreamedContent getPostImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        String idImagenParam = context.getExternalContext().getRequestParameterMap().get("idImagen");
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        Long idImagen = Long.valueOf(idImagenParam);
        byte[] foto = imagenFacade.find(idImagen).getFoto();
        InputStream inputStream = new ByteArrayInputStream(foto);
        return new DefaultStreamedContent(inputStream, "image/png");
    }
    
}
