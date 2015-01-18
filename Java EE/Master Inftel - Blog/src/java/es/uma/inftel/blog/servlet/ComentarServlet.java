/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.servlet;


import es.uma.inftel.blog.domain.ComentarioFacade;
import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Comentario;
import es.uma.inftel.blog.model.Post;
import es.uma.inftel.blog.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alfredo
 */
@WebServlet(name = "ComentarServlet", urlPatterns = {"/ComentarServlet"})
public class ComentarServlet extends HttpServlet {
    @EJB
    private PostFacade postFacade;
    @EJB
    private ComentarioFacade comentarioFacade;


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
        long idPost=Long.parseLong(request.getParameter("idpost"));
        Comentario comentario = comentarTexto(request, idPost);
        response.sendRedirect("post?id="+idPost);
    }
    private Comentario comentarTexto(HttpServletRequest request, long idPost) throws ServletException, IOException {
       

        String texto = request.getParameter("texto");
        Date fecha=new Date();

        Post post = postFacade.find(idPost);
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        Comentario comentario = new Comentario();
        comentario.setTexto(texto);
        comentario.setPostId(post);
        comentario.setFechaCreacion(fecha);
        comentario.setUsuarioId(usuario);
        comentarioFacade.create(comentario);
        return comentario;
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