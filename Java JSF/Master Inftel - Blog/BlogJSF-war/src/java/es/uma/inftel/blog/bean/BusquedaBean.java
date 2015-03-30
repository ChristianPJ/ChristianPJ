/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.util.ResumenPost;
import es.uma.inftel.blog.util.TipoBusqueda;
import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Post;
import es.uma.inftel.blog.model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author inftel21
 */
@ManagedBean
public class BusquedaBean extends PaginatedBean {

    @EJB
    private EtiquetaFacade etiquetaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    
    private String etiqueta;
    private String cadena;
    private String username;
    private TipoBusqueda tipoBusqueda;
    private String valor;
    private Collection<Post> postsUser;
    private Collection<Post> postsEtiq;
    private Collection<Post> postsCadena;
    private List<ResumenPost> resultadosBusqueda;

    /**
     * Creates a new instance of BusquedaBean
     */
    public BusquedaBean() {
    }
    
    @PostConstruct
    public void init() {
        setMaxPostsPage(5);
        setMaxLengthResumen(256);
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String usernameParam = externalContext.getRequestParameterMap().get("username");
        String etiquetaParam = externalContext.getRequestParameterMap().get("etiqueta");
        String cadenaParam = externalContext.getRequestParameterMap().get("cadena");
        String currentPageParam = externalContext.getRequestParameterMap().get("currentPage");
        buscar(usernameParam, etiquetaParam, cadenaParam, currentPageParam);
    }
    
    public void buscar(String usernameParam, String etiquetaParam, String cadenaParam, String currentPageParam){
        if ((currentPageParam != null) && (!currentPageParam.equals(""))) {
            int currentPage = Integer.parseInt(currentPageParam);
            setCurrentPage(currentPage);
        } 
        if ((usernameParam != null) && (!usernameParam.equals(""))) {
            username = usernameParam;
            buscarPorUsuario();
        } else if ((etiquetaParam != null) && (!etiquetaParam.equals(""))) {
            etiqueta = etiquetaParam;
            buscarPorEtiqueta();
        } else if ((cadenaParam != null) && (!cadenaParam.equals(""))) {
            cadena = cadenaParam;
            buscarPorTitulo();
        }
    }
    
    public void buscarPorUsuario() {
        Usuario autor = usuarioFacade.findByName(username);
        int currentPage = 0;
        setCurrentPage(currentPage);
        
        if (autor != null) {
            postsUser = autor.getPostCollection();

            int lastPage = getLastPage(postsUser.size());
            setLastPage(lastPage);

            currentPage = Math.max(1, getCurrentPage());
            currentPage = Math.min(currentPage, lastPage);
            setCurrentPage(currentPage);

            setResultadosBusqueda(getPageOfPostSummaries(getCurrentPage(), postsUser));
        }

        setTipoBusqueda(TipoBusqueda.USUARIO);
        setValor(username);
    }

    public void buscarPorEtiqueta() {
        Etiqueta tag = etiquetaFacade.findEtiquetaNombre(etiqueta);
        int currentPage = 0;
        setCurrentPage(currentPage);

        if (tag != null) {
            postsEtiq = tag.getPostCollection();

            int lastPage = getLastPage(postsEtiq.size());
            setLastPage(lastPage);

            currentPage = Math.max(1, getCurrentPage());
            currentPage = Math.min(currentPage, lastPage);
            setCurrentPage(currentPage);

            setResultadosBusqueda(getPageOfPostSummaries(getCurrentPage(), postsEtiq));
        }

        setTipoBusqueda(TipoBusqueda.ETIQUETA);
        setValor(etiqueta);
    }
    
    public void buscarPorTitulo() {
        long countPostBusqueda = getPostFacade().countPostBusqueda(cadena);
        
        int lastPage = getLastPage((int) countPostBusqueda);
        setLastPage(lastPage);
        
        int currentPage = Math.max(1, getCurrentPage());
        currentPage = Math.min(currentPage, lastPage);
        setCurrentPage(currentPage);
        
        setResultadosBusqueda(getPageOfPostSummariesByTitleSearch(getCurrentPage(), cadena));

        setTipoBusqueda(TipoBusqueda.CADENA_TITULO);
        setValor(cadena);
    }
    
    public String obtainCurrentPagePosts() {
        switch (tipoBusqueda) {
            case USUARIO:
                return obtainCurrentPagePosts(postsUser, "busqueda?username=" + username);
            case ETIQUETA:
                return obtainCurrentPagePosts(postsEtiq, "busqueda?etiqueta=" + etiqueta);
            case CADENA_TITULO:
                return obtainCurrentPagePostsByTitleSearch(getNumPosts(), "busqueda?cadena=" + cadena);
            default:
                throw new IllegalArgumentException("Tipo de busqueda no valido");
        }
    }
    
    private String obtainCurrentPagePosts(Collection<Post> posts, String destUrl) {
        int lastPage = getLastPage(posts.size());
        setLastPage(lastPage);
        setResultadosBusqueda(getPageOfPostSummaries(getCurrentPage(), posts));
        return destUrl;
    }
    
    private String obtainCurrentPagePostsByTitleSearch(int numPosts, String destUrl) {
        int lastPage = getLastPage(numPosts);
        setLastPage(lastPage);
        setResultadosBusqueda(getPageOfPostSummariesByTitleSearch(getCurrentPage(), cadena));
        return destUrl;
    }
    
    public String obtainNextPagePosts() {
        int lastPage = getLastPage(getNumPosts());
        int nextPage = Math.min(getCurrentPage() + 1, lastPage);
        setCurrentPage(nextPage);
        return obtainCurrentPagePosts();
    }
    
    public String obtainPreviousPagePosts() {
        int previousPage = Math.max(1, getCurrentPage() - 1);
        setCurrentPage(previousPage);
        return obtainCurrentPagePosts();
    }
    
    public String obtainFirstPagePosts() {
        setCurrentPage(1);
        return obtainCurrentPagePosts();
    }
    
    public String obtainLastPagePosts() {
        int lastPage = getLastPage(getNumPosts());
        setCurrentPage(lastPage);
        return obtainCurrentPagePosts();
    }
    
    private int getNumPosts() {
        if (tipoBusqueda == TipoBusqueda.CADENA_TITULO) {
            return (int) getPostFacade().countPostBusqueda(cadena);
        }
        return getPosts().size();
    }
    
    private Collection<Post> getPosts() {
        switch (tipoBusqueda) {
            case USUARIO:
                return postsUser;
            case ETIQUETA:
                return postsEtiq;
            case CADENA_TITULO:
                return postsCadena;
            default:
                throw new IllegalArgumentException("Tipo de busqueda no valido");
        }
    }
    
    private List<ResumenPost> getPageOfPostSummariesByTitleSearch(int page, String cadena){
        List<ResumenPost> resumenesPostsPagina = new ArrayList<>();
        postsCadena = getPostFacade().findPostBusqueda(cadena, (page - 1) * getMaxPostsPage(), getMaxPostsPage());
        for (Post post : postsCadena) {
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
    
    public List<ResumenPost> getResultadosBusqueda() {
        return resultadosBusqueda;
    }

    public void setResultadosBusqueda(List<ResumenPost> currentPagePostSummaries) {
        this.resultadosBusqueda = currentPagePostSummaries;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TipoBusqueda getTipoBusqueda() {
        return tipoBusqueda;
    }
    
    public void setTipoBusqueda(TipoBusqueda tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getValor() {
        return valor;
    }
    
    public void setValor(String cadena) {
        this.valor = cadena;
    }

    public Collection<Post> getPostsUser() {
        return postsUser;
    }

    public void setPostsUser(Collection<Post> postsUser) {
        this.postsUser = postsUser;
    }

      
    
}
