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
import sn.entity.Friend;
import sn.services.FriendService;

/**
 *
 * @author inftel12
 */
@RestController
@RequestMapping("/friend")
public class FriendREST {
    
    @Autowired 
    private FriendService friendService;
     

    public FriendREST(){
        
    } 
    
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Friend friend) {
        friendService.create(friend);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Friend friend) {
        friendService.delete(friend);
    }

    @RequestMapping(value = "/find/{email}",method = RequestMethod.GET)
    public Friend search(@PathVariable String email) {
        return friendService.search(email);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Friend> findAll() {
        return friendService.findAll();
    }

    @RequestMapping(value = "/findfriendsbyemail/{email}",method = RequestMethod.GET)
    public List<Friend> findFriendsByEmail(@PathVariable String email) {
        
        email = email.replaceAll("___", ".");
        
        return friendService.findFriendsByEmail(email);
    }

    @RequestMapping(value = "/findfriendbyemails/{email}/{friendEmail}",method = RequestMethod.GET)
    public Friend findFriendByEmails(@PathVariable String email, @PathVariable String friendEmail) {
        return friendService.findFriendByEmails(email, friendEmail);
    }

    @RequestMapping(value = "/deletefriendbyemails/{userEmail}/{friendEmail}",method = RequestMethod.DELETE)
    public void deleteFriendByEmails(@PathVariable String userEmail, @PathVariable String friendEmail) {
        friendService.deleteFriendByEmails(userEmail, friendEmail);
    }
}
