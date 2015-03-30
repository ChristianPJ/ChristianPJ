/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.PostFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author inftel21
 */
@ManagedBean
@RequestScoped
public class PaginatedBean {
    
    @EJB
    private PostFacade postFacade;
    
    private int currentPage;
    private int lastPage;
    private int maxPostsPage;
    private int maxLengthResumen;

    public PaginatedBean() {
        this.currentPage = 1;
    }

    public PostFacade getPostFacade() {
        return postFacade;
    }
    
    public int getLastPage(int numResults) {
        int numPosts = numResults;
        int lastPage = numPosts / maxPostsPage;
        return (numPosts % maxPostsPage == 0) ? lastPage : lastPage + 1;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getMaxPostsPage() {
        return maxPostsPage;
    }

    public void setMaxPostsPage(int maxPostsPage) {
        this.maxPostsPage = maxPostsPage;
    }

    public int getMaxLengthResumen() {
        return maxLengthResumen;
    }

    public void setMaxLengthResumen(int maxLengthResumen) {
        this.maxLengthResumen = maxLengthResumen;
    }
    
}
