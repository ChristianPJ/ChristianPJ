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
public class LoginViewFacade extends BaseViewFacade<LoginView>{

    public LoginViewFacade(PostFacade postFacade) {
        super(postFacade);
    }
    
    public LoginView createView(boolean errorLogin) {
        LoginView loginView = new LoginView();
        initView(loginView);
        loginView.setErrorLogin(errorLogin);
        return loginView;
    }
    
}