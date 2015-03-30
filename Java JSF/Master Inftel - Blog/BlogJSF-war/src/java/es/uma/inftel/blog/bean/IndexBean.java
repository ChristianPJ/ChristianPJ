/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.util.ResumenPost;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Miguel
 */
@ManagedBean
public class IndexBean extends PaginatedBean {
    
    private List<ResumenPost> currentPagePostSummaries;
    private String cadena;

    public IndexBean() {
    }
    
    @PostConstruct
    public void init() {
        setMaxPostsPage(5);
        setMaxLengthResumen(256);
        int lastPage = getLastPage(getPostFacade().count());
        setLastPage(lastPage);
        setCurrentPagePostSummaries(getPageOfPostSummaries(getCurrentPage()));
    }
    
    public String obtainCurrentPagePosts() {
        int lastPage = getLastPage(getPostFacade().count());
        setLastPage(lastPage);
        setCurrentPagePostSummaries(getPageOfPostSummaries(getCurrentPage()));
        return "index";
    }
    
    public String obtainNextPagePosts() {
        int lastPage = getLastPage(getPostFacade().count());
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
        int lastPage = getLastPage(getPostFacade().count());
        setCurrentPage(lastPage);
        return obtainCurrentPagePosts();
    }
    
    public List<ResumenPost> getPageOfPostSummaries(int page) {
        List<ResumenPost> resumenesPostsPagina = new ArrayList<>();
        List<Post> posts = getPostFacade().findRangeOfPostsOrderedByCreationDateDesc((page - 1) * getMaxPostsPage(), getMaxPostsPage());
        for (Post post : posts) {
            resumenesPostsPagina.add(new ResumenPost(post, getMaxLengthResumen()));
        }
        return resumenesPostsPagina;
    }
    
    public String buscarPostsPorTitulo() {
        return "busqueda?faces-redirect=true&cadena=" + cadena;
    }
    
    public List<ResumenPost> getCurrentPagePostSummaries() {
        return currentPagePostSummaries;
    }

    public void setCurrentPagePostSummaries(List<ResumenPost> currentPagePostSummaries) {
        this.currentPagePostSummaries = currentPagePostSummaries;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
