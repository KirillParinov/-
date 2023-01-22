package service;

import domain.WorkGroup;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceWorkGroup implements Service<WorkGroup>{
    private final Repository<WorkGroup> repository;

    public ServiceWorkGroup(Repository<WorkGroup> repository) {
        this.repository = repository;
    }

    @Override
    public WorkGroup find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<WorkGroup> list() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(WorkGroup obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(WorkGroup obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(WorkGroup obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<WorkGroup> getListPoIdGroup(Long id) throws SQLException {
        return null;
    }
}
