/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.servlet;

import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.model.Etiqueta;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author inftel07
 */
@WebServlet(name = "EtiquetaTrendingServlet", urlPatterns = {"/EtiquetaTrendingServlet"})
public class EtiquetaTrendingServlet extends HttpServlet {
    @EJB
    private EtiquetaFacade etiquetaFacade;

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
        
        JSONObject json      = new JSONObject();
        JSONArray  jtags = new JSONArray();
        JSONObject jtag;

        List<Etiqueta> listaEtiquetas = etiquetaFacade.findTrendingEtiquetas();
        try
        {   
            Etiqueta e;
            for(int i=0; i<10; i++){
                e = listaEtiquetas.get(i);
                jtag = new JSONObject();
                jtag.put("nombre", e.getNombre());
                jtags.put(jtag);
            }
            
            json.put("etiquetas", jtags);
        
        } catch (JSONException jse){ 

        }
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        
        
        
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
