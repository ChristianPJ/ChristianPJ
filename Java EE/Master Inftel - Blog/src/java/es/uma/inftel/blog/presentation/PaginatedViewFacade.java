/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.domain.PostFacade;

/**
 *
 * @author inftel07
 * @param <T>
 */
public class PaginatedViewFacade<T extends PaginatedView> extends BaseViewFacade<T> {
    
    private final int maxPostsPage;
    private final int maxLengthResumen;

    public PaginatedViewFacade(int maxPostPage, int maxLengthResumen, PostFacade postFacade) {
        super(postFacade);
        this.maxPostsPage = maxPostPage;
        this.maxLengthResumen = maxLengthResumen;
    }
    
    protected void initView(T view, int currentPage, int maxItems) {
        initView(view);
        
        int lastPage = getLastPage(maxItems);
        view.setLastPage(lastPage);
        
        if (currentPage <= 0 || currentPage > lastPage) {
            currentPage = 1;
        }
        view.setCurrentPage(currentPage);
    }

    public int getMaxPostsPage() {
        return maxPostsPage;
    }
    
    public int getMaxLengthResumen() {
        return maxLengthResumen;
    }
    
    public int getLastPage(int numResults) {
        int numPosts = numResults;
        int lastPage = numPosts / maxPostsPage;
        return (numPosts % maxPostsPage == 0) ? lastPage : lastPage + 1;
    }
    
}