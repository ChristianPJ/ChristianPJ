/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.servlet;

import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.domain.ImagenFacade;
import es.uma.inftel.blog.domain.MapaFacade;
import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Post;
import es.uma.inftel.blog.presentation.PostView;
import es.uma.inftel.blog.presentation.PostViewFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maramec
 */
@MultipartConfig
@WebServlet(name = "EditarPostServlet", urlPatterns = {"/editar-post"})
public class EditarPostServlet extends HttpServlet {

    @EJB
    private EtiquetaFacade etiquetaFacade;
    @EJB
    private ImagenFacade imagenFacade;
    @EJB
    private MapaFacade mapaFacade;
    @EJB
    private PostFacade postFacade;

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
        String id = request.getParameter("id");
        Long i = Long.parseLong(id);

        PostViewFacade postViewfacade = new PostViewFacade(postFacade, imagenFacade, mapaFacade);
        PostView postView = postViewfacade.createPostView(i);
        request.setAttribute("postView", postView);
        RequestDispatcher rd = request.getRequestDispatcher("/editarPost.jsp");
        String titulo = request.getParameter("tituloPost");
        if(titulo==null){
            rd.forward(request, response);
            return;
        }
        String texto = request.getParameter("textoPost");
        String etiquetas = request.getParameter("etiqueta");
        editarPost(titulo, texto, etiquetas, i);
        response.sendRedirect("post?id="+i);
    }

    private void editarPost(String tituloPost, String textoPost, String etiquetas, Long id) {
        Post p = postFacade.find(id);
        Date date = new Date();
        Date fechaModificacion = date;
        p.setFechaModificacion(fechaModificacion);
        p.setTitulo(tituloPost);
        p.setTexto(textoPost);
        if (p.getEtiquetaCollection() == null) {
            insertarEtiquetas(etiquetas, p);
        } else {
            eliminarEtiquetas(p);
            p.getEtiquetaCollection().clear();
        }
        
        postFacade.edit(p);
    }

    public void insertarEtiquetas(String etiquetas, Post post) {
        List<String> listEtiquetas = getEtiquetas(etiquetas);
        for (String nombreEtiqueta : listEtiquetas) {
            Etiqueta etiquetaBd = etiquetaFacade.findEtiquetaNombre(nombreEtiqueta);
            if (etiquetaBd == null) {
                etiquetaBd = new Etiqueta();
                etiquetaBd.setNombre(nombreEtiqueta);
                Collection<Post> postCollection = etiquetaBd.getPostCollection();
                if (postCollection == null) {
                    postCollection = new ArrayList<>();
                    etiquetaBd.setPostCollection(postCollection);
                }
                etiquetaBd.getPostCollection().add(post);
                etiquetaFacade.create(etiquetaBd);
            } else {
                etiquetaBd.getPostCollection().add(post);
                etiquetaFacade.edit(etiquetaBd);
            }
        }
    }
    
    public void eliminarEtiquetas(Post post) {
        for (Etiqueta etiqueta : post.getEtiquetaCollection()) {
            etiqueta.getPostCollection().remove(post);
            etiquetaFacade.edit(etiqueta);
        }
    }

    public List<String> getEtiquetas(String etiquetas) {

        List<String> listEtiquetas = new ArrayList();
        StringTokenizer st = new StringTokenizer(etiquetas, " =,;");
        while (st.hasMoreTokens()) {
            String etiq = st.nextToken();
            listEtiquetas.add(etiq.toLowerCase());
        }

        return listEtiquetas;
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
