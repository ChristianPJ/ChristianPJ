/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blogREST.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author maramec
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(es.uma.inftel.blogREST.service.ComentarioFacadeREST.class);
        resources.add(es.uma.inftel.blogREST.service.EtiquetaFacadeREST.class);
        resources.add(es.uma.inftel.blogREST.service.ImagenFacadeREST.class);
        resources.add(es.uma.inftel.blogREST.service.MapaFacadeREST.class);
        resources.add(es.uma.inftel.blogREST.service.PostFacadeREST.class);
        resources.add(es.uma.inftel.blogREST.service.UsuarioFacadeREST.class);
    }
    
}
