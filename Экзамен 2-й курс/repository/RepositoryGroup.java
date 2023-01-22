package repository;

import domain.Group;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryGroup implements Repository<Group>{
    private final DBWorker connector;

    public RepositoryGroup() {
        this.connector = new DBWorker();
    }

    @Override
    public Group find(Long id) throws SQLException {
        String find = "SELECT * FROM dedsad.group where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");

        return new Group(id,name);
    }

    @Override
    public void save(Group source) throws SQLException {
        String save ="INSERT INTO dedsad.group (name) VALUES (?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1, source.getName() );

        preparedStatement.execute();
    }

    @Override
    public void delete(Group target) throws SQLException {
        String delete = "DELETE FROM dedsad.group WHERE id = "+target.getId();
        String update = "UPDATE dedsad.children SET id_group = 0 WHERE id_group = "+target.getId();
        String update2 = "UPDATE dedsad.babysitter SET id_group = 0 WHERE id_group = "+target.getId();
        String update3 = "UPDATE dedsad.mentor SET id_group = 0 WHERE id_group = "+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(update);
        statement.execute(update2);
        statement.execute(update3);
    }

    @Override
    public List<Group> list() throws SQLException {
        List<Group> list = new ArrayList<>();

        String show = "SELECT * FROM dedsad.group";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");

            list.add(new Group(id,name));
        }
        return list;
    }

    @Override
    public void update(Group obj) throws SQLException {
        String update = "UPDATE dedsad.group SET name = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());

        preparedStatement.execute();
    }

    @Override
    public List<Group> getListPoIdGroup(Long id) throws SQLException {
        return null;
    }
}
