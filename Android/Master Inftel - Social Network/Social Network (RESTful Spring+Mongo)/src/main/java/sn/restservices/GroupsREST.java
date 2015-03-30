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
import sn.entity.Groups;
import sn.services.GroupsServiceImp;

/**
 *
 * @author inftel12
 */
@RestController
@RequestMapping("/groups")
public class GroupsREST {
    
    @Autowired 
    private GroupsServiceImp groupsService;
     
     
    public GroupsREST(){
        
    } 
    
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Groups groups) {
        groupsService.create(groups);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Groups groups) {
        groupsService.delete(groups);
    }

    
    @RequestMapping(value = "/find/{email}",method = RequestMethod.GET)
    public Groups search(@PathVariable String email) {
        return groupsService.search(email);
    }
    

    @RequestMapping(method = RequestMethod.GET)
    public List<Groups> findAll() {
        return groupsService.findAll();
    }
    
    @RequestMapping(value = "/findbyname/{name}",method = RequestMethod.GET)
    public List<Groups> findByName(@PathVariable String name) {
        return groupsService.findByName(name);
    }

    @RequestMapping(value = "/findpossiblegroups/{email}",method = RequestMethod.GET)
    public List<Groups> encontrarPosiblesGrupos(@PathVariable String email) {
        return groupsService.encontrarPosiblesGrupos(email);
    }

          
    @RequestMapping(value = "/findgroups/{email}",method = RequestMethod.GET)
    public List<Groups> gruposPertenece(@PathVariable String email) {
        return groupsService.gruposPertenece(email);
    }

    @RequestMapping(value = "/findgroupsbyname/{name}",method = RequestMethod.GET)
    public Groups findGroup(@PathVariable String name) {
        return groupsService.findGroup(name);
    }

    @RequestMapping(value = "/deletebyemailandname/{email}/{name}",method = RequestMethod.DELETE)
    public List<Groups> deleteByEmailAndGroup(@PathVariable String email, @PathVariable String name) {
        return groupsService.deleteByEmailAndGroup(email, name);
    }

     
}
