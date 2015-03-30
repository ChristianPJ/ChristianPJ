package sn.services;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sn.entity.Groups;

@Component
@Service
public interface GroupsService {

    public void create(Groups groups);

    public void delete(Groups groups);

    public Groups search(String email);

    public List<Groups> findAll();

    public List<Groups> findByName(String name);

    public List<Groups> encontrarPosiblesGrupos(String email);

    public List<Groups> gruposPertenece(String email);

    public Groups findGroup(String name);

    public List<Groups> deleteByEmailAndGroup(String email, String name);
}
