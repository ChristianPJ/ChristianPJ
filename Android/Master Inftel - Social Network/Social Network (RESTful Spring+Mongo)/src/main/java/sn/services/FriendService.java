package sn.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sn.entity.Friend;
import sn.mongo.repositories.FriendRepository;

@Component
@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public void create(Friend friend) {
        friendRepository.save(friend);
    }

    public void delete(Friend friend) {
        friendRepository.delete(friend);
    }

    public Friend search(String email) {
        return friendRepository.findOne(email);
    }

    public List<Friend> findAll() {
        return friendRepository.findAll();
    }

    public List<Friend> findFriendsByEmail(String email) {
        return friendRepository.findFriendsByEmail(email);
    }

    public Friend findFriendByEmails(String email, String friendEmail) {
        return friendRepository.findFriendByEmails(email, friendEmail);
    }

    public void deleteFriendByEmails(String userEmail, String friendEmail) {
        friendRepository.deleteFriendByEmails(userEmail, friendEmail);
    }
}
