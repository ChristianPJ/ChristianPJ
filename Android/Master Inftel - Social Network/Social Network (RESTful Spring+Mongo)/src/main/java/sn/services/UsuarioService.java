package sn.services;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sn.entity.Usuario;

@Component
@Service
public interface UsuarioService {

    public void create(Usuario usuario);

    public void delete(Usuario usuario);

    public Usuario search(String email);

    public List<Usuario> findAll();

    public Usuario findByEmail(String email);
}
