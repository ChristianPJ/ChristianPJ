/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.model.Etiqueta;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author inftel21
 */
@ManagedBean
@RequestScoped
public class EtiquetasBean {
    
    @EJB
    private EtiquetaFacade etiquetaFacade;
    
    private List<Etiqueta> listaEtiquetas;

    /**
     * Creates a new instance of EtiquetasBean
     */
    public EtiquetasBean() {
    }
    
    private TagCloudModel model;
     
    @PostConstruct
    public void init() {
        listaEtiquetas = etiquetaFacade.findTrendingEtiquetas();
        listaEtiquetas = listaEtiquetas.subList(0, Math.min(10, listaEtiquetas.size()));
        Integer maxCloud = listaEtiquetas.get(0).getPostCollection().size();
        Integer minCloud = listaEtiquetas.get(Math.min(9, listaEtiquetas.size())).getPostCollection().size();
        Collections.shuffle(listaEtiquetas);
        model = new DefaultTagCloudModel();
        for(Etiqueta e:listaEtiquetas){
            Integer sizeTag = calculateTagCloudSize(e.getPostCollection().size(),minCloud,maxCloud);
            model.addTag(new DefaultTagCloudItem(e.getNombre(),"busqueda.jsf?etiqueta=" + e.getNombre(), sizeTag));
        }  
    }
    
    public Integer calculateTagCloudSize(Integer valor, Integer minCloud, Integer maxCloud){
        Integer resultado = 1;
        Integer division = ((maxCloud - minCloud) / 3);
        
        if (Objects.equals(valor, maxCloud)){
            resultado = 5;
        } else if (Objects.equals(valor, minCloud)){
            resultado = 1;
        } else if (valor>(maxCloud-division)){
            resultado = 4;
        } else if (valor>(maxCloud-division*2)){
            resultado = 3;
        } else {
            resultado = 2;
        }
        return resultado;   
    }
 
    public TagCloudModel getModel() {
        return model;
    }
}

