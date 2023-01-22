package service;

import domain.Mentor;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceMentor implements Service<Mentor>{
    private final Repository<Mentor> repository;

    public ServiceMentor(Repository<Mentor> repository) {
        this.repository = repository;
    }

    @Override
    public Mentor find(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Mentor> list() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Mentor obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Mentor obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Mentor obj) throws SQLException {
        repository.delete(obj);
    }

    @Override
    public List<Mentor> getListPoIdGroup(Long id) throws SQLException {
        return repository.getListPoIdGroup(id);
    }
}
