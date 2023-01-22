package repository;

import domain.Children;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryChildren implements Repository<Children>{

    private final DBWorker connector;

    public RepositoryChildren() {
        this.connector = new DBWorker();
    }

    @Override
    public Children find(Long id) throws SQLException {
        String find = "SELECT * FROM dedsad.children where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");
        float age = resultSet.getFloat("age");
        String pol = resultSet.getString("pol");
        long id_group = resultSet.getLong("id_group");

        return new Children(id,name,age,pol,id_group);
    }

    @Override
    public void save(Children source) throws SQLException {
        String save = "INSERT INTO dedsad.children (name, age, pol, id_group) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1, source.getName());
        preparedStatement.setFloat(2,source.getAge());
        preparedStatement.setString(3,source.getPol());
        preparedStatement.setLong(4,source.getId_group());

        preparedStatement.execute();
    }

    @Override
    public void delete(Children target) throws SQLException {
        String delete = "DELETE FROM dedsad.children WHERE id = "+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Children> list() throws SQLException {
        List<Children> list = new ArrayList<>();
        String show="SELECT * FROM dedsad.children";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            float age = resultSet.getFloat("age");
            String pol = resultSet.getString("pol");
            long id_group = resultSet.getLong("id_group");

            list.add(new Children(id,name,age,pol,id_group));
        }

        return list;
    }

    @Override
    public void update(Children obj) throws SQLException {
        String update = "UPDATE dedsad.children SET name = ?, age = ?, pol = ?, id_group = ? WHERE id = "+ obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setFloat(2,obj.getAge());
        preparedStatement.setString(3,obj.getPol());
        preparedStatement.setLong(4,obj.getId_group());

        preparedStatement.execute();
    }

    @Override
    public List<Children> getListPoIdGroup(Long id) throws SQLException {
        List<Children> list = new ArrayList<>();
        String show = "select * from children where id_group ="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id1 = resultSet.getLong("id");
            String name = resultSet.getString("name");
            float age = resultSet.getFloat("age");
            String pol = resultSet.getString("pol");
            long id_group = resultSet.getLong("id_group");

            list.add(new Children(id1,name,age,pol,id_group));
        }
        return list;
    }
}
