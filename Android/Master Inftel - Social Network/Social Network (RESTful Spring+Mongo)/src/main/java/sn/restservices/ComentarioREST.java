/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.restservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sn.entity.Comentario;
import sn.services.ComentarioServiceImp;

/**
 *
 * @author inftel12
 */
@RestController
@RequestMapping("/comentario")
public class ComentarioREST {
    
    @Autowired 
    private ComentarioServiceImp comentarioService;
    
    public ComentarioREST(){
        
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Comentario comentario){
        comentarioService.create(comentario);
    }
    
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Comentario comentario) {
        comentarioService.delete(comentario);
    }
    
    
    
    @RequestMapping(value = "/find/{email}",method = RequestMethod.GET)
    public Comentario find(@PathVariable String email) {
        return comentarioService.search(email);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }
    
    
    @RequestMapping(value = "/findall/{email}",method = RequestMethod.GET)
    public List<Comentario> findAllByEmail(@PathVariable String email) {
        return comentarioService.findAllByEmail(email);
    }

    
    @RequestMapping(value = "/findgroup/{grupo}",method = RequestMethod.GET)
    public List<Comentario> findByGroup(@PathVariable String grupo) {
        return comentarioService.findByGroup(grupo);

    }

    @RequestMapping(value = "/findemailtipo/{email}/{tipo}",method = RequestMethod.GET)
    public List<Comentario> findByEmailAndPrivate(@PathVariable String email,@PathVariable boolean tipo) {
        return comentarioService.findByEmailAndPrivate(email, tipo);
    }

    @RequestMapping(value = "/findid/{id}",method = RequestMethod.GET)
    public Comentario findById(@PathVariable String id) {
        return comentarioService.findById(id);
    }

    @RequestMapping(value = "/findprofile/{perfil}/{email}/{texto}/{imagen}/{video}/",method = RequestMethod.GET)
    public List<Comentario> findByProfileAndContent(@PathVariable String perfil,@PathVariable String email,@PathVariable String texto,@PathVariable String imagen,@PathVariable String video) {
        return comentarioService.findByProfileAndContent(perfil, email, texto, imagen, video);
    }
    
    
}
