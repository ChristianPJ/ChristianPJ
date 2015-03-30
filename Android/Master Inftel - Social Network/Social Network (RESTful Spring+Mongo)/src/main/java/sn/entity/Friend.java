package sn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "friends")
public class Friend {

    @Id
    private String id;
    private String userEmail;
    private String friendEmail;
    private String friendName;
    private String friendPhoto;

    public Friend(String userEmail, String friendEmail, String friendName, String friendPhoto) {
        this.userEmail = userEmail;
        this.friendEmail = friendEmail;
        this.friendName = friendName;
        this.friendPhoto = friendPhoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendPhoto() {
        return friendPhoto;
    }

    public void setFriendPhoto(String friendPhoto) {
        this.friendPhoto = friendPhoto;
    }
}
