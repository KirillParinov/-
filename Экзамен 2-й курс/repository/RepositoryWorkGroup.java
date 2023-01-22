package repository;

import domain.Group;
import domain.WorkGroup;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryWorkGroup implements Repository<WorkGroup>{
    private final DBWorker connector;

    public RepositoryWorkGroup() {
        this.connector = new DBWorker();
    }

    @Override
    public WorkGroup find(Long id) throws SQLException {
        String find = "SELECT * FROM dedsad.worker_group where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");

        return new WorkGroup(id,name);
    }

    @Override
    public void save(WorkGroup source) throws SQLException {
        String save ="INSERT INTO `dedsad`.`worker_group` (`name`) VALUES (?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1, source.getName() );

        preparedStatement.execute();
    }

    @Override
    public void delete(WorkGroup target) throws SQLException {
        String delete = "DELETE FROM dedsad.worker_group WHERE id = "+target.getId();
        String update = "UPDATE `dedsad`.`worker` SET `id_work` = '0' WHERE id_work = "+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(update);
    }

    @Override
    public List<WorkGroup> list() throws SQLException {
        List<WorkGroup> list = new ArrayList<>();

        String show = "SELECT * FROM dedsad.worker_group";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");

            list.add(new WorkGroup(id,name));
        }
        return list;
    }

    @Override
    public void update(WorkGroup obj) throws SQLException {
        String update = "UPDATE dedsad.worker_group SET name = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());

        preparedStatement.execute();
    }

    @Override
    public List<WorkGroup> getListPoIdGroup(Long id) throws SQLException {
        return null;
    }
}
