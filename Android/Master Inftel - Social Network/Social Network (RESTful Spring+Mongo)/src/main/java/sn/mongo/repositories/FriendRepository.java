package sn.mongo.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import sn.entity.Friend;

@Repository
public interface FriendRepository extends MongoRepository<Friend, String> {

    @Query(value = "{ 'userEmail' : ?0 }")
    public List<Friend> findFriendsByEmail(String userEmail);

    @Query(value = "{ 'userEmail' : ?0, 'friendEmail' : ?1 }")
    public Friend findFriendByEmails(String userEmail, String friendEmail);

    @Query(value = "{'userEmail' : ?0, 'friendEmail' : ?1 }", delete = true)
    public List<Friend> deleteFriendByEmails(String userEmail, String friendEmail);
}
