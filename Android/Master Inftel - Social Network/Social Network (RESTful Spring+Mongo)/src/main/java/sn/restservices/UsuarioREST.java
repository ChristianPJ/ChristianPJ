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
import sn.entity.Usuario;
import sn.services.UsuarioServiceImp;

/**
 *
 * @author inftel12
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioREST {
    
    @Autowired 
    private UsuarioServiceImp usuarioService;
    
    public UsuarioREST(){
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Usuario usuario) {
        usuarioService.create(usuario);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Usuario usuario) {
        usuarioService.delete(usuario);
    }

    
    
    @RequestMapping(value = "/find/{email}",method = RequestMethod.GET)
    public Usuario search(@PathVariable String email) {
        return usuarioService.search(email);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @RequestMapping(value = "/findbyemail/{email}",method = RequestMethod.GET)
    public Usuario findByEmail(@PathVariable String email) {
        return usuarioService.findByEmail(email);
    }
    
}
