/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.servlet;

import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.domain.PostFacade; 
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.presentation.BusquedaView;
import es.uma.inftel.blog.presentation.BusquedaViewFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "BusquedaServlet", urlPatterns = {"/busqueda"})
public class BusquedaServlet extends HttpServlet {
    @EJB
    private PostFacade postFacade;
    @EJB
    private EtiquetaFacade etiquetaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String page = request.getParameter("page");
        int currentPage = 1;
        if (page != null) {
            try {
                currentPage = Integer.parseInt(page);
            } catch (Exception e) {
            }
        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/busqueda.jsp");
        
        BusquedaViewFacade busquedaViewFacade = new BusquedaViewFacade(5, 256, postFacade, etiquetaFacade, usuarioFacade);
        BusquedaView busquedaView;
        
        String etiqueta = request.getParameter("etiqueta");
        String cadena = request.getParameter("cadena");
        String usuario = request.getParameter("usuario");
        if (etiqueta == null && cadena == null && usuario == null) {
            requestDispatcher.forward(request, response);
            return;
        }
        if (etiqueta != null) {
            busquedaView = busquedaViewFacade.createBusquedaViewPorEtiqueta(currentPage,etiqueta);
        } else if (cadena != null){
            busquedaView = busquedaViewFacade.createBusquedaViewPorTitulo(currentPage,cadena);
        } else {
            busquedaView = busquedaViewFacade.createBusquedaViewPorUsuario(currentPage,usuario);
        }        
        request.setAttribute("busquedaView", busquedaView);        
        requestDispatcher.forward(request, response);
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
