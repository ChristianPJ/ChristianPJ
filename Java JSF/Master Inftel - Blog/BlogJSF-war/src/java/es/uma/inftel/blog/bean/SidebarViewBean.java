/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.util.ResumenPost;
import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.model.Post;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author miguel
 */
@ManagedBean
public class SidebarViewBean {
    
    @EJB
    private PostFacade postFacade;
    
    private String cadena;
    private Map<Integer, Map<Integer, List<ResumenPost>>> postsArchive;
    
    public SidebarViewBean() {
    }

    @PostConstruct
    public void init() {
        loadPostsArchive();
    }
    
    public String buscarPostsPorTitulo() {
        return "busqueda?faces-redirect=true&cadena=" + cadena;
    }
    
    protected void loadPostsArchive() {
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
        this.postsArchive = postsByMonthByYear;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public Map<Integer, Map<Integer, List<ResumenPost>>> getPostsArchive() {
        return postsArchive;
    }

    public void setPostsArchive(Map<Integer, Map<Integer, List<ResumenPost>>> postsArchive) {
        this.postsArchive = postsArchive;
    }
    
    public <T, S> List<Map.Entry<T, S>> mapToList(Map<T, S> map) {
        if (map == null) {
            return null;
        }
        List<Map.Entry<T, S>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        return list;
    }
    
}
