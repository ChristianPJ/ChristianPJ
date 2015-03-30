package sn.mongo.repositories;

import java.util.List;
import sn.entity.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String> {

    @Query(value = "{ 'perfil' : ?0 }")
    public List<Comentario> findByEmail(String email);

    @Query(value = "{ 'nombreGrupo' : ?0 }")
    public List<Comentario> findByGroup(String grupo);

    @Query(value = "{'perfil' : ?0 ,'privado' : ?1 }")
    public List<Comentario> findByEmailAndPrivate(String email, boolean tipo);

    @Query(value = "{ '_id' : ?0 }")
    public Comentario findById(String id);

    @Query(value = "{ 'perfil' : ?0, 'emailUsuario' : ?1, 'texto' : ?2, 'imagen' : ?3, 'video' : ?4 }")
    public List<Comentario> findByProfileAndContent(String perfil, String email, String texto, String imagen, String video);
}
