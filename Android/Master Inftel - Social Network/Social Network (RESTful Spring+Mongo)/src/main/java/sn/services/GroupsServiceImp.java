package sn.services;

import java.util.List;
import sn.entity.Groups;
import sn.mongo.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class GroupsServiceImp implements GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;

    @Override
    public void create(Groups groups) {
        groupsRepository.save(groups);
    }

    @Override
    public void delete(Groups groups) {
        groupsRepository.delete(groups);
    }

    @Override
    public Groups search(String email) {
        return groupsRepository.findOne(email);
    }

    @Override
    public List<Groups> findAll() {
        return groupsRepository.findAll();
    }

    @Override
    public List<Groups> findByName(String name) {
        return groupsRepository.findByName(name);
    }

    @Override
    public List<Groups> encontrarPosiblesGrupos(String email) {
        return groupsRepository.findPossibleGroups(email);
    }

    @Override
    public List<Groups> gruposPertenece(String email) {
        return groupsRepository.findGroups(email);
    }

    @Override
    public Groups findGroup(String name) {
        return groupsRepository.findGroup(name);
    }

    @Override
    public List<Groups> deleteByEmailAndGroup(String email, String name) {
        return groupsRepository.deleteByEmailAndGroup(email, name);
    }

}
