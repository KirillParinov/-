package service;

import domain.Worker;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceWorker implements Service<Worker>{
    private final Repository<Worker> repository;

    public ServiceWorker(Repository<Worker> repository) {
        this.repository = repository;
    }

    @Override
    public Worker find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Worker> list() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Worker obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Worker obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Worker obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Worker> getListPoIdGroup(Long id) throws SQLException {
        return null;
    }
}
