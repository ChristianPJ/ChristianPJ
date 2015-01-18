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
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Imagen;
import es.uma.inftel.blog.model.Mapa;
import es.uma.inftel.blog.model.Post;
import es.uma.inftel.blog.model.Usuario;
import es.uma.inftel.blog.presentation.BaseView;
import es.uma.inftel.blog.presentation.BaseViewFacade;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author maramec
 */
@MultipartConfig
@WebServlet(name = "PostServlet", urlPatterns = {"/crear-post"})
public class PostServlet extends HttpServlet {
    @EJB
    private EtiquetaFacade etiquetaFacade;
    @EJB
    private ImagenFacade imagenFacade;
    @EJB
    private MapaFacade mapaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
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
        String tituloP = request.getParameter("tituloPost");
        String textoP = request.getParameter("textoPost");
        
        RequestDispatcher rd = request.getRequestDispatcher("/crearPost.jsp");
        if(tituloP == null && textoP==null){
            BaseView crearPostView = new BaseView();
            BaseViewFacade<BaseView> crearPostViewFacade = new BaseViewFacade<>(postFacade);
            crearPostViewFacade.initView(crearPostView);
            request.setAttribute("crearPostView", crearPostView);
            rd.forward(request, response);
            return;
        }
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        Post post = crearPost(tituloP, textoP, usuario);
        postFacade.create(post);
        
        String etiquetas = request.getParameter("etiqueta");
        insertarEtiquetas(etiquetas, post);
        if(!request.getParameter("lat").isEmpty()){
            crearMapa(request, post);
        }
        //Crea Fotos
        insertarImagen(request, post);
        
        response.sendRedirect("post?id=" + post.getId());
    }

    private Post crearPost(String tituloPost, String textoPost, Usuario u) {
        
        Post post = new Post();        
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        Date fechaCreacion = date;
        Date fechaModificacion = date;
        post.setTitulo(tituloPost);
        post.setTexto(textoPost);
        post.setFechaCreacion(fechaCreacion);
        post.setFechaModificacion(fechaModificacion);
        post.setUsuarioId(u);

        return post;
    }

    private Mapa crearMapa(HttpServletRequest request, Post idPost) throws ServletException, IOException {
        Mapa mapa = new Mapa();
        if ((request.getParameter("address").compareTo("") != 0)&& (request.getParameter("address").compareTo("No se encuentra resultados") !=0)) {
            String latitud = request.getParameter("lat");
            String longitud = request.getParameter("lng");
            Double lat = Double.parseDouble(latitud);
            Double lng = Double.parseDouble(longitud);
            mapa.setLatitud(lat);
            mapa.setLongitud(lng);
            mapa.setPostId(idPost);
            mapaFacade.create(mapa);
        }
        return mapa;
    }

    private void insertarImagen(HttpServletRequest request, Post idPost) throws ServletException, IOException {
         int numeroFotos,i;
        numeroFotos = Integer.parseInt(request.getParameter("numFotos"));
        for(i=0;i<numeroFotos+1;i++){
            Part filePart = request.getPart("foto-"+i);
            if(filePart != null){
                if (!filePart.getSubmittedFileName().isEmpty()) {
                Imagen imagen = new Imagen();
                InputStream inputStream = filePart.getInputStream();
                byte[] foto = IOUtils.toByteArray(inputStream);
                imagen.setPostId(idPost);
                imagen.setFoto(foto);
                imagenFacade.create(imagen);
            }
            }
        }
            
        }
    
    public void insertarEtiquetas(String etiquetas, Post post){
        List<String> listEtiquetas = getEtiquetas(etiquetas);
        for (String nombreEtiqueta : listEtiquetas){
            Etiqueta etiquetaBd = etiquetaFacade.findEtiquetaNombre(nombreEtiqueta);
            if(etiquetaBd==null){
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
    
    public List<String> getEtiquetas(String etiquetas){

        List<String> listEtiquetas = new ArrayList();
        StringTokenizer st = new StringTokenizer(etiquetas," =,;");

        while(st.hasMoreTokens()) {
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
