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
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author inftel12
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {
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
        
        String userName = request.getParameter("username");
        
        if(userName==null){
            BaseView adminView = new BaseView();
            BaseViewFacade<BaseView> adminViewFacade = new BaseViewFacade(postFacade);
            adminViewFacade.initView(adminView);
            request.setAttribute("adminView", adminView);
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
            return;
        }
        
        response.setContentType("application/json");
        response.getWriter().write(getUsuariosJSON(userName));
    }
    
    private String getUsuariosJSON(String userName) {
        JSONObject json      = new JSONObject();
        JSONArray  jusuarios = new JSONArray();
        JSONObject juser;
        List<Usuario> listaUsuarios = usuarioFacade.findByNameLike(userName);
        try
        {   
            for(Usuario u : listaUsuarios){
                juser = new JSONObject();
                juser.put("nombre", u.getUsername());
                juser.put("tipo", u.getTipo());
                jusuarios.put(juser);
            }
            
            json.put("usuarios", jusuarios);
        
        } catch (JSONException jse){ 
        }
        return json.toString();
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
