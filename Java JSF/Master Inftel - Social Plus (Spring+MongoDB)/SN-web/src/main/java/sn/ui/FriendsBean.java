
package sn.ui;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.entity.Friend;
import sn.entity.Usuario;
import sn.services.FriendService;

@Component
@Scope("request")
public class FriendsBean {

    @Autowired
    private FriendService friendService;
    @Autowired
    private SessionBean sessionBean;

    private List<Friend> friends;

    public FriendsBean() {
    }

    @PostConstruct
    public void initFriends() {
        Usuario usuario = sessionBean.getUsuario();
        if(usuario == null) {
            return;
        }
        String email = usuario.getEmail();
        friends = friendService.findFriendsByEmail(email);
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
