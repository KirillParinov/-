package repository;

import domain.Mentor;
import domain.Worker;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryWorker implements Repository<Worker>{
    private final DBWorker connector;

    public RepositoryWorker() {
        this.connector = new DBWorker();
    }

    @Override
    public Worker find(Long id) throws SQLException {
        String find ="select w.id,w.name,w.age,w.pol,w.zp,w.id_work,wg.name work from worker w \n" +
                "left join worker_group wg on w.id_work=wg.id\n" +
                "where w.id = "+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        String name = resultSet.getString("name");
        float age = resultSet.getFloat("age");
        String pol = resultSet.getString("pol");
        int zp = resultSet.getInt("zp");
        long id_work = resultSet.getLong("id_work");
        String work = resultSet.getString("work");

        return new Worker(id,id_work,name,age,pol,zp,work);
    }

    @Override
    public void save(Worker source) throws SQLException {
        String save = "INSERT INTO `dedsad`.`worker` (`id_work`, `name`, `age`, `pol`, `zp`) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setLong(1,source.getId_work());
        preparedStatement.setString(2, source.getName());
        preparedStatement.setFloat(3,source.getAge());
        preparedStatement.setString(4,source.getPol());
        preparedStatement.setInt(5,source.getZp());


        preparedStatement.execute();
    }

    @Override
    public void delete(Worker target) throws SQLException {
        String delete = "DELETE FROM `dedsad`.`worker` WHERE id ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Worker> list() throws SQLException {
        List<Worker> list = new ArrayList<>();
        String show = "select w.id,w.name,w.age,w.pol,w.zp,w.id_work,wg.name work from worker w \n" +
                "left join worker_group wg on w.id_work=wg.id";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            long id_work = resultSet.getLong("id_work");
            String name = resultSet.getString("name");
            float age = resultSet.getFloat("age");
            String pol = resultSet.getString("pol");
            int zp = resultSet.getInt("zp");
            String work = resultSet.getString("work");

            list.add(new Worker(id,id_work,name,age,pol,zp,work));
        }
        return list;
    }

    @Override
    public void update(Worker obj) throws SQLException {
        String update ="UPDATE `dedsad`.`worker` SET `id_work` = ?, `name` = ?, `age` = ?, `pol` = ?, `zp` = ? WHERE id = "+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setLong(1,obj.getId_work());
        preparedStatement.setString(2,obj.getName());
        preparedStatement.setFloat(3,obj.getAge());
        preparedStatement.setString(4,obj.getPol());
        preparedStatement.setInt(5,obj.getZp());

        preparedStatement.execute();
    }

    @Override
    public List<Worker> getListPoIdGroup(Long id) throws SQLException {
        return null;
    }
}
