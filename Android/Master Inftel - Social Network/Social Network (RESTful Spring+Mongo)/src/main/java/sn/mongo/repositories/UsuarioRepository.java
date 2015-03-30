package sn.mongo.repositories;

import sn.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Query(value = "{ 'email' : ?0 }")
    public Usuario findByEmail(String email);

}
