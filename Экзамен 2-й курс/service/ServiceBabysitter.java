package service;

import domain.Babysitter;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceBabysitter implements Service<Babysitter>{
    private final Repository<Babysitter> repository;

    public ServiceBabysitter(Repository<Babysitter> repository) {
        this.repository = repository;
    }

    @Override
    public Babysitter find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Babysitter> list() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Babysitter obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Babysitter obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Babysitter obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Babysitter> getListPoIdGroup(Long id) throws SQLException {
        return repository.getListPoIdGroup(id);
    }
}
