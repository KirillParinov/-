package repository;



import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    T find (Long id) throws SQLException;

    void save(T source) throws SQLException;

    void delete(T target) throws SQLException;

    List<T> list() throws SQLException;
    void update (T obj) throws SQLException;
    List<T> getListPoIdGroup(Long id) throws SQLException;

}
