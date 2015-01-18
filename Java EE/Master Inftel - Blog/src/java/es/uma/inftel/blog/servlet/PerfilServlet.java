/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.servlet;

import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Usuario;
import es.uma.inftel.blog.presentation.BaseView;
import es.uma.inftel.blog.presentation.BaseViewFacade;
import java.io.IOException;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author miguel
 */
@MultipartConfig
@WebServlet(name = "PerfilServlet", urlPatterns = {"/perfil"})
public class PerfilServlet extends HttpServlet {
    @EJB
    private PostFacade postFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        
        BaseView baseView = new BaseView();
        BaseViewFacade<BaseView> baseViewFacade = new BaseViewFacade<>(postFacade);
        baseViewFacade.initView(baseView);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("perfil.jsp");
        String password = request.getParameter("password");
        if (password == null) {
            request.setAttribute("perfilView", baseView);
            requestDispatcher.forward(request, response);
        }

        String email = request.getParameter("email");      
        
       
        Part filePart = request.getPart("avatar");
        byte[] avatar = null;
        if (!filePart.getSubmittedFileName().isEmpty()) {
            InputStream inputStream = filePart.getInputStream();
            avatar = IOUtils.toByteArray(inputStream);
        }

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
      
        modificarUsuario(usuario, password, email, avatar);
        response.sendRedirect("perfil");
        
    }

    private Usuario modificarUsuario(Usuario usuario, String password, String email, byte[] avatar) {
        if(password!=null){
            usuario.setPassword(password);   
        }
        if(email!=null){
            usuario.setEmail(email);  
        }
        if(avatar!=null){
            usuario.setAvatar(avatar);
        }
        
        usuarioFacade.modifyUser(usuario);
        return usuario;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
