/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.inftel.blog.bean;

import es.uma.inftel.blog.domain.ComentarioFacade;
import es.uma.inftel.blog.domain.EtiquetaFacade;
import es.uma.inftel.blog.domain.ImagenFacade;
import es.uma.inftel.blog.domain.MapaFacade;
import es.uma.inftel.blog.domain.PostFacade;
import es.uma.inftel.blog.domain.UsuarioFacade;
import es.uma.inftel.blog.model.Comentario;
import es.uma.inftel.blog.model.Etiqueta;
import es.uma.inftel.blog.model.Imagen;
import es.uma.inftel.blog.model.Mapa;
import es.uma.inftel.blog.model.Post;
import es.uma.inftel.blog.model.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author maramec
 */
@ManagedBean(name = "postBean")
@ViewScoped
public class PostBean implements Serializable {
    @EJB
    private ImagenFacade imagenFacade;
    @EJB
    private MapaFacade mapaFacade;
    @EJB
    private EtiquetaFacade etiquetaFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private PostFacade postFacade;
    @EJB
    private ComentarioFacade comentarioFacade;
    
    
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;

    //atributos del Post
    private String titulo;
    private Usuario autorPost;
    private String texto;
    private String etiqueta;
    private String comentariosTexto;
    private Collection<Etiqueta> listaEtiquetas;
    private List<Comentario> listaComentarios;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private int idUsuario;
    private int idPost;
    private List<String> parrafosPost;
    //atributos del mapa
    private String latitud;
    private String longitud;
    private String direccion;
    //atributos de las fotos
    //Las fotos se meterán más tarde, generar fotos
    private int numFotos;
    private Collection<Imagen> imagenes;
    private final List<UploadedFile> fotos;
   // private Usuario usuario;
    private Post post;
    private Mapa mapa;
    
    Long idp;

    /**
     * Creates a new instance of PostBean
     */
    
    public PostBean() {
         this.fotos = new ArrayList<>();
    }
    
     @PostConstruct
    public void inicializar()
    {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String idParam = externalContext.getRequestParameterMap().get("id");
        if(idParam==null || idParam.equals("")){
            return ;
        }
        idp= Long.valueOf(idParam);
        post = postFacade.findPostById(idp);
        if(post == null){
            try {
                HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
                response.sendRedirect("index.jsf");
            } catch (IOException ex) {
                Logger.getLogger(PostBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            autorPost = post.getUsuarioId();
            titulo = post.getTitulo();
            texto = post.getTexto();
            parrafosPost = Arrays.asList(post.getTexto().split("\\n"));
            fechaCreacion = post.getFechaCreacion();
            fechaModificacion = post.getFechaModificacion();
            listaEtiquetas = post.getEtiquetaCollection();
            etiqueta = getEtiquetas();
            listaComentarios = new ArrayList<>(post.getComentarioCollection());
            Collections.sort(listaComentarios);
            imagenes = post.getImagenCollection();
            mapa = mapaFacade.findMapaPost(idp);
            if(mapa!=null){
                longitud = mapa.getLongitud().toString();
                latitud = mapa.getLatitud().toString();
            }
        }
        
    }
    
    public String crearPost() {
        Post pCreado = insertarPost();
        insertarEtiqueta(pCreado, etiqueta);
        insertarMapa(pCreado);
        insertarFotos(pCreado);
        idp= postFacade.findPostTitulo(pCreado.getTitulo()).getId();
        return "post.jsf?id="+idp+"&faces-redirect=true";
    }

    public String getEtiquetas(){
        Collection<Etiqueta> cEtiqueta = post.getEtiquetaCollection();
        if(cEtiqueta == null){
            return " ";
        }
        if(!cEtiqueta.isEmpty()){
            String et="";
            for (Etiqueta etq : cEtiqueta){
                et = et+ " "+ etq.getNombre();
            } 
            return et;
        }
        return null;
    }
    
    public String editarPost(){
        Post p;
        p = postFacade.find(idp);
        Date date = new Date();
        fechaModificacion = date;
        p.setFechaModificacion(fechaModificacion);
        p.setTitulo(titulo);
        p.setTexto(texto);
        if (p.getEtiquetaCollection() != null || !p.getEtiquetaCollection().isEmpty()){
            eliminarEtiquetas(p);
            p.getEtiquetaCollection().clear();
        }
        insertarEtiqueta( p, etiqueta);
        postFacade.edit(p);
        
        return "post.jsf?id="+idp+"&faces-redirect=true";
    }
    
    public Post insertarPost() {
        Date date = new Date();
        Usuario usuario = usuarioBean.getUsuario();
        fechaCreacion = date;
        fechaModificacion = date;
        post = new Post();
        post.setTitulo(titulo);
        post.setTexto(texto);
        post.setFechaCreacion(fechaCreacion);
        post.setFechaModificacion(fechaModificacion);
        post.setUsuarioId(usuario);
        postFacade.create(post);
        return post;
    }
    
    public void insertarMapa(Post p) {
        if (latitud.equals("") || longitud.equals("") || direccion.equals("") || direccion.equals("No se encuentra resultados")) {
            return;
        }
        Mapa map = new Mapa();
        Double lat = Double.parseDouble(latitud);
        Double lng = Double.parseDouble(longitud);
        map.setLatitud(lat);
        map.setLongitud(lng);
        map.setPostId(p);
        mapaFacade.create(map);
    }
    
    public void upload(FileUploadEvent event) {  
        fotos.add(event.getFile());
    }
    
    public void insertarFotos(Post post) {
        for (UploadedFile file : fotos) {
            try {
                Imagen imagen = new Imagen();
                InputStream inputStream = file.getInputstream();
                byte[] foto = IOUtils.toByteArray(inputStream);
                imagen.setPostId(post);
                imagen.setFoto(foto);
                imagenFacade.create(imagen);
            } catch (IOException ex) {
                Logger.getLogger(PostBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void insertarEtiqueta(Post p, String stringEtiquetas) {
        List<String> listEtiquetas = getEtiquetas(stringEtiquetas);
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
                etiquetaBd.getPostCollection().add(p);
                etiquetaFacade.create(etiquetaBd);
            } else {
                etiquetaBd.getPostCollection().add(p);
                etiquetaFacade.edit(etiquetaBd);
            }
        }
    }
    
    public List<String> getEtiquetas(String et) {
        List<String> listEtiquetas = new ArrayList();
        StringTokenizer st = new StringTokenizer(et, " =,;");
        
        while (st.hasMoreTokens()) {
            String etiq = st.nextToken();
            listEtiquetas.add(etiq.toLowerCase());
        }
        return listEtiquetas;
    }
    public String crearComentario(){
        Date fecha=new Date();
        Usuario usuario = usuarioBean.getUsuario();
        Comentario comentario = new Comentario();

        comentario.setTexto(comentariosTexto);
        comentario.setPostId(post);
        comentario.setFechaCreacion(fecha);
        comentario.setUsuarioId(usuario);
        comentarioFacade.create(comentario);
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String referer = externalContext.getRequestHeaderMap().get("referer");
        int slashIndex = referer.lastIndexOf("/");
        if (slashIndex >= 0 && slashIndex < referer.length() - 1) {
            referer = referer.substring(slashIndex + 1);
        }
        referer += ((referer.contains("?")) ? "&" : "?") + "faces-redirect=true";
        return referer;
    }
    
    public void borrarComentario(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        
        String idComentarioParam = externalContext.getRequestParameterMap().get("idComentario");
        Long idComment = Long.valueOf(idComentarioParam);
        Comentario comentario = comentarioFacade.find(idComment);
        comentarioFacade.remove(comentario); 
        
        post.getComentarioCollection().remove(comentario);
        postFacade.edit(post);
    }
    
    public void eliminarEtiquetas(Post post) {
        for (Etiqueta etiqueta : post.getEtiquetaCollection()) {
            etiqueta.getPostCollection().remove(post);
            etiquetaFacade.edit(etiqueta);
        }
    }
    
    public String borrarPost() {
        Collection<Comentario> comentarios = post.getComentarioCollection();
        for (Comentario c:comentarios){
            comentarioFacade.remove(c);
        }
        postFacade.remove(post);   
        return "index.jsf?faces-redirect=true";
    }
        
    public int getNumFotos() {
        return numFotos;
    }
    
    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getTexto() {
        return texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String getEtiqueta() {
        return etiqueta;
    }
    
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getLatitud() {
        return latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    
    public String getLongitud() {
        return longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<String> getParrafosPost() {
        return parrafosPost;
    }

    public void setParrafosPost(List<String> parrafosPost) {
        this.parrafosPost = parrafosPost;
    }
    
    public Collection<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(Collection<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Usuario getAutorPost() {
        return autorPost;
    }

    public void setAutorPost(Usuario autorPost) {
        this.autorPost = autorPost;
    }

    public Collection<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Collection<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public String getComentariosTexto() {
        return comentariosTexto;
    }

    public void setComentariosTexto(String comentariosTexto) {
        this.comentariosTexto = comentariosTexto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }
 
}
