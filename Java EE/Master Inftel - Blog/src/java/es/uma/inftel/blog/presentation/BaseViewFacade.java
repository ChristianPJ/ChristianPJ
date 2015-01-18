/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author miguel
 * @param <T>
 */
public class BaseViewFacade<T extends BaseView> {
    
    private final PostFacade postFacade;

    public BaseViewFacade(PostFacade postFacade) {
        this.postFacade = postFacade;
    }
    
    public void initView(T view) {
        view.setPostsArchive(getPostArchive());
    } 
    
    protected Map<Integer, Map<Integer, List<ResumenPost>>> getPostArchive() {
        Map<Integer, Map<Integer, List<ResumenPost>>> postsByMonthByYear = new LinkedHashMap<>();
        List<Post> postsOrderedByCreationDateDesc = postFacade.findAllPostsOrderedByCreationDateDesc();
        for (Post post : postsOrderedByCreationDateDesc) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(post.getFechaCreacion());
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = calendar.get(Calendar.MONTH) + 1;
            
            Map<Integer, List<ResumenPost>> postsByMonth = postsByMonthByYear.get(year);
            if (postsByMonth == null) {
                postsByMonth = new LinkedHashMap<>();
                postsByMonthByYear.put(year, postsByMonth);
            }
            List<ResumenPost> posts = postsByMonth.get(month);
            if (posts == null) {
                posts = new ArrayList<>();
                postsByMonth.put(month, posts);
            }
            posts.add(new ResumenPost(post, 0));
        }
        return postsByMonthByYear;
    }

    public PostFacade getPostFacade() {
        return postFacade;
    }
    
}
