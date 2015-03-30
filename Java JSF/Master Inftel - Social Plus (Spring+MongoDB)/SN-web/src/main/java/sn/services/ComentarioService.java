package sn.services;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sn.entity.Comentario;

@Component
@Service
public interface ComentarioService {

    public void create(Comentario comentario);

    public void delete(Comentario comentario);

    public Comentario search(String email);

    public List<Comentario> findAll();

    public List<Comentario> findAllByEmail(String email);

    public List<Comentario> findByGroup(String grupo);

    public List<Comentario> findByEmailAndPrivate(String email, boolean tipo);

    public Comentario findById(String id);

    public List<Comentario> findByProfileAndContent(String perfil, String email, String texto, String imagen, String video);
}
