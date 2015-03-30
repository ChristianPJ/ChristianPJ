package sn.mongo.repositories;

import java.util.List;
import sn.entity.Groups;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository

public interface GroupsRepository extends MongoRepository<Groups, String> {

    @Query(value = "{ 'name' : ?0 }")
    public List<Groups> findByName(String name);

    @Query(value = "{ 'email' : ?0 }")
    public List<Groups> findPossibleGroups(String email);

    @Query(value = "{ 'email' : ?0 }")
    public List<Groups> findGroups(String email);

    @Query(value = "{ 'name' : ?0 }")
    public Groups findGroup(String name);

    @Query(value = "{ 'email' : ?0, 'name' : ?1 }", delete = true)
    public List<Groups> deleteByEmailAndGroup(String email, String name);

}
