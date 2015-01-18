/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Post;
import es.uma.inftel.blog.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author inftel07
 */
public class BusquedaViewFacade extends PaginatedViewFacade<BusquedaView> {
    
    private final EtiquetaFacade etiquetaFacade;
    private final UsuarioFacade usuarioFacade;

    public BusquedaViewFacade(int maxPostPage, int maxLengthResumen, PostFacade postFacade, EtiquetaFacade etiquetaFacade, UsuarioFacade usuarioFacade) {
        super(maxPostPage, maxLengthResumen, postFacade);
        this.etiquetaFacade = etiquetaFacade;
        this.usuarioFacade = usuarioFacade;
    }
    
    public BusquedaView createBusquedaViewPorEtiqueta(int currentPage, String nombreEtiqueta) {
        BusquedaView busquedaView = new BusquedaView();
        
        Etiqueta etiqueta = etiquetaFacade.findEtiquetaNombre(nombreEtiqueta);
        Collection<Post> postsEtiq = etiqueta.getPostCollection();
        busquedaView.setResultadosBusqueda(getPageOfPostSummaries(currentPage, postsEtiq));
        
        initView(busquedaView, currentPage, postsEtiq.size());
        
        busquedaView.setTipoBusqueda(TipoBusqueda.ETIQUETA);
        busquedaView.setValor(nombreEtiqueta);
        
        return busquedaView;
    }
    
    public BusquedaView createBusquedaViewPorTitulo(int currentPage, String cadena) {
        BusquedaView busquedaView = new BusquedaView();
        
        initView(busquedaView, currentPage, (int) getPostFacade().countPostBusqueda(cadena));
        
        busquedaView.setResultadosBusqueda(getPageOfPostSummariesByTitleSearch(currentPage, cadena));
        
        busquedaView.setTipoBusqueda(TipoBusqueda.CADENA_TITULO);
        busquedaView.setValor(cadena);
        
        return busquedaView;
    }
    
    public BusquedaView createBusquedaViewPorUsuario(int currentPage, String cadena) {
        BusquedaView busquedaView = new BusquedaView();
        Usuario usuario = usuarioFacade.findByName(cadena);
        Collection<Post> postsUser = usuario.getPostCollection();
        busquedaView.setResultadosBusqueda(getPageOfPostSummaries(currentPage, postsUser)); 
        
        initView(busquedaView, currentPage, postsUser.size());
        
        busquedaView.setTipoBusqueda(TipoBusqueda.USUARIO);
        busquedaView.setValor(cadena);
        
        return busquedaView;
    }
    
    private List<ResumenPost> getPageOfPostSummariesByTitleSearch(int page, String cadena){
        List<ResumenPost> resumenesPostsPagina = new ArrayList<>();
        List<Post> posts = getPostFacade().findPostBusqueda(cadena,(page - 1) * getMaxPostsPage(), getMaxPostsPage());
        for (Post post : posts) {
            resumenesPostsPagina.add(new ResumenPost(post, getMaxLengthResumen()));
        }
        return resumenesPostsPagina;
    }
    
    private List<ResumenPost> getPageOfPostSummaries(int page, Collection<Post> posts) {
        List<ResumenPost> resumenesPostsPagina = new ArrayList<>();
        List<Post> listPostsEtiq = new ArrayList(posts);
        int inicio = (page - 1) * getMaxPostsPage();
        int fin = Math.min(listPostsEtiq.size(), inicio + getMaxPostsPage());
        for (int i = inicio; i < fin; i++) {
            resumenesPostsPagina.add(new ResumenPost(listPostsEtiq.get(i), getMaxLengthResumen()));
        }
        return resumenesPostsPagina;
    }
  
}
