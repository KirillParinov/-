package service;

import domain.Children;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceChildren implements Service<Children>{
    private final Repository<Children> repository;

    public ServiceChildren(Repository<Children> repository) {
        this.repository = repository;
    }


    @Override
    public Children find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Children> list() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Children obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Children obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Children obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Children> getListPoIdGroup(Long id) throws SQLException {
        return repository.getListPoIdGroup(id);
    }
}
