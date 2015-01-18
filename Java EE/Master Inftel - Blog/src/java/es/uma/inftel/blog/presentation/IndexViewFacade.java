/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class IndexViewFacade extends PaginatedViewFacade<IndexView> {
    
    public IndexViewFacade(int maxPostPage, int maxLengthResumen, PostFacade postFacade) {
        super(maxPostPage, maxLengthResumen, postFacade);
    }
    
    @Override
    protected void initView(IndexView view, int currentPage, int numItems) {
        super.initView(view, currentPage, numItems);
        
        view.setCurrentPagePostSummaries(getPageOfPostSummaries(currentPage));
    }
    
    public IndexView createIndexView(int currentPage) {
        IndexView indexView = new IndexView();
        initView(indexView, currentPage, getPostFacade().count());
        return indexView;
    }
    
    public List<ResumenPost> getPageOfPostSummaries(int page) {
        List<ResumenPost> resumenesPostsPagina = new ArrayList<>();
        List<Post> posts = getPostFacade().findRangeOfPostsOrderedByCreationDateDesc((page - 1) * getMaxPostsPage(), getMaxPostsPage());
        for (Post post : posts) {
            resumenesPostsPagina.add(new ResumenPost(post, getMaxLengthResumen()));
        }
        return resumenesPostsPagina;
    }
    
}
