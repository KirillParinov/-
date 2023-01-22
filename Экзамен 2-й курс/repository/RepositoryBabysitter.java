package repository;

import domain.Babysitter;
import domain.Mentor;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryBabysitter implements Repository<Babysitter>{
    private final DBWorker connector;

    public RepositoryBabysitter() {
        this.connector = new DBWorker();
    }

    @Override
    public Babysitter find(Long id) throws SQLException {
        String find ="SELECT * FROM dedsad.babysitter where id="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");
        float age = resultSet.getFloat("age");
        String pol = resultSet.getString("pol");
        int zp = resultSet.getInt("zp");
        long id_group = resultSet.getLong("id_group");

        return new Babysitter(id,name,age,pol,zp,id_group);
    }

    @Override
    public void save(Babysitter source) throws SQLException {
        String save = "INSERT INTO `dedsad`.`babysitter` (`name`, `age`, `pol`, `zp`, `id_group`) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1, source.getName());
        preparedStatement.setFloat(2,source.getAge());
        preparedStatement.setString(3,source.getPol());
        preparedStatement.setInt(4,source.getZp());
        preparedStatement.setLong(5,source.getId_group());

        preparedStatement.execute();
    }

    @Override
    public void delete(Babysitter target) throws SQLException {
        String delete = "DELETE FROM `dedsad`.`babysitter` WHERE id ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Babysitter> list() throws SQLException {
        List<Babysitter> list = new ArrayList<>();
        String show = "SELECT * FROM dedsad.babysitter";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            float age = resultSet.getFloat("age");
            String pol = resultSet.getString("pol");
            int zp = resultSet.getInt("zp");
            long id_group = resultSet.getLong("id_group");

            list.add(new Babysitter(id,name,age,pol,zp,id_group));
        }
        return list;
    }

    @Override
    public void update(Babysitter obj) throws SQLException {
        String update ="UPDATE `dedsad`.`babysitter` SET `name` = ?, `age` = ?, `pol` = ?, `zp` = ?, `id_group` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1,obj.getName());
        preparedStatement.setFloat(2,obj.getAge());
        preparedStatement.setString(3,obj.getPol());
        preparedStatement.setInt(4,obj.getZp());
        preparedStatement.setLong(5,obj.getId_group());

        preparedStatement.execute();
    }

    @Override
    public List<Babysitter> getListPoIdGroup(Long id) throws SQLException {
        List<Babysitter> list = new ArrayList<>();
        String show="SELECT * FROM dedsad.babysitter where id_group="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id1 = resultSet.getLong("id");
            String name = resultSet.getString("name");
            float age = resultSet.getFloat("age");
            String pol = resultSet.getString("pol");
            int zp = resultSet.getInt("zp");
            long id_group = resultSet.getLong("id_group");

            list.add(new Babysitter(id1,name,age,pol,zp,id_group));
        }
        return list;
    }
}
