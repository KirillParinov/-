package service;

import domain.Group;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;


public class ServiceGroup implements Service<Group>{
    private  final Repository<Group> repository;

    public ServiceGroup(Repository<Group> repository) {
        this.repository = repository;
    }


    @Override
    public Group find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Group> list() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Group obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Group obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Group obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Group> getListPoIdGroup(Long id) throws SQLException {
        return null;
    }
}
