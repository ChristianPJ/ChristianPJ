/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import java.util.List;

/**
 *
 * @author Miguel
 */
public class IndexView extends PaginatedView {
    
    private List<ResumenPost> currentPagePostSummaries;

    public IndexView() {
    }
    
    public List<ResumenPost> getCurrentPagePostSummaries() {
        return currentPagePostSummaries;
    }

    public void setCurrentPagePostSummaries(List<ResumenPost> currentPagePostSummaries) {
        this.currentPagePostSummaries = currentPagePostSummaries;
    }
    
}
