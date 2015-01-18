/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.presentation;

import es.uma.inftel.blog.domain.PostFacade;

/**
 *
 * @author Miguel
 */
public class RegistroViewFacade extends BaseViewFacade<RegistroView>{

    public RegistroViewFacade(PostFacade postFacade) {
        super(postFacade);
    }
    
    public RegistroView createView(boolean errorRegistro) {
        RegistroView registroView = new RegistroView();
        initView(registroView);
        registroView.setErrorRegistro(errorRegistro);
        return registroView;
    }
    
}
