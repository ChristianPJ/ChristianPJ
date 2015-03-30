
package sn.ui;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sn.entity.Friend;
import sn.services.FriendService;

@Component
@Scope("request")
public class FriendBean {

    @Autowired
    private FriendService friendService;
    @Autowired
    private SessionBean sessionBean;
    @Autowired
    private UsuarioBean usuarioBean;

    private boolean isFriend;

    @PostConstruct
    public void checkFriend() {
        Friend friend = friendService.findFriendByEmails(sessionBean.getUsuario().getEmail(), usuarioBean.getUsuario().getEmail());
        isFriend = friend != null;
    }

    public String addFriend() {
        Friend friend = new Friend(
                sessionBean.getUsuario().getEmail(),
                usuarioBean.getUsuario().getEmail(),
                usuarioBean.getUsuario().getNombre(),
                usuarioBean.getUsuario().getFoto());
        friendService.create(friend);
        return "userProfile?faces-redirect=true&email=" + usuarioBean.getUsuario().getEmail();
    }

    public String removeFriend() {
        friendService.deleteFriendByEmails(sessionBean.getUsuario().getEmail(), usuarioBean.getUsuario().getEmail());
        return "userProfile?faces-redirect=true&email=" + usuarioBean.getUsuario().getEmail();
    }

    public boolean getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }
}
