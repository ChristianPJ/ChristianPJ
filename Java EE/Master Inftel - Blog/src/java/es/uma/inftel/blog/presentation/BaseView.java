/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author miguel
 */
public class BaseView implements Serializable {
    
    private Map<Integer, Map<Integer, List<ResumenPost>>> postsArchive;
    
    public BaseView() {
    }
    
    public Map<Integer, Map<Integer, List<ResumenPost>>> getPostsArchive() {
        return postsArchive;
    }

    public void setPostsArchive(Map<Integer, Map<Integer, List<ResumenPost>>> postsArchive) {
        this.postsArchive = postsArchive;
    }
    
}
