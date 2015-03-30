package sn.services;

import java.util.List;
import sn.entity.Comentario;
import sn.mongo.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ComentarioServiceImp implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public void create(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void delete(Comentario comentario) {
        comentarioRepository.delete(comentario);
    }

    
     @Override
    public void deleteid(String id) {
        comentarioRepository.deleteid(id);
        
    }
    
    
    
    @Override
    public Comentario search(String email) {
        return comentarioRepository.findOne(email);
    }

    @Override
    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comentario> findAllByEmail(String email) {
        return comentarioRepository.findByEmail(email);
    }

    @Override
    public List<Comentario> findByGroup(String grupo) {
        return comentarioRepository.findByGroup(grupo);

    }

    @Override
    public List<Comentario> findByEmailAndPrivate(String email, boolean tipo) {
        return comentarioRepository.findByEmailAndPrivate(email, tipo);
    }

    @Override
    public Comentario findById(String id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public List<Comentario> findByProfileAndContent(String perfil, String email, String texto, String imagen, String video) {
        return comentarioRepository.findByProfileAndContent(perfil, email, texto, imagen, video);
    }

}
