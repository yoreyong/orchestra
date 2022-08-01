package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.Instrument;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: InstrumentDao
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/31
 **/
public class InstrumentDao {

    QueryRunner runner = new QueryRunner();

    public int add(String name, String type, boolean status) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into instrument(name, type, status) values(?, ?, ?)";
        int count = runner.update(conn, sql, name, type, status);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from instrument where id = ?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, String name, String type, boolean status) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update instrument set name=?, type=?, status=? where id=?";
        int count = runner.update(conn, sql, name, type, status, id);
        DBHelper.close(conn);
        return count;
    }

    public List<Instrument> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from instrument";
        List<Instrument> instruments = runner.query(conn, sql,
                new BeanListHandler<Instrument>(Instrument.class));
        DBHelper.close(conn);
        return instruments;
    }

    public long getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from instrument";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.longValue();
    }

    public Instrument getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from instrument where id = ?";
        Instrument instrument = runner.query(conn, sql,
                new BeanHandler<Instrument>(Instrument.class), id);
        DBHelper.close(conn);
        return instrument;
    }

    public List<Instrument> getByName(String name) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from instrument where name=?";
        List<Instrument> instruments = runner.query(conn, sql,
                new BeanListHandler<Instrument>(Instrument.class), name);
        DBHelper.close(conn);
        return instruments;
    }

    public long getCountByName(String name) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from instrument where name=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), name);
        DBHelper.close(conn);
        return data.longValue();
    }

    public List<Instrument> getByType(String type) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from instrument where type=?";
        List<Instrument> instruments = runner.query(conn, sql,
                new BeanListHandler<Instrument>(Instrument.class), type);
        DBHelper.close(conn);
        return instruments;
    }

    public long getCountByType(String type) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from instrument where type=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), type);
        DBHelper.close(conn);
        return data.longValue();
    }

    public List<Instrument> getByStatus(boolean status) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from instrument where status=?";
        List<Instrument> instruments = runner.query(conn, sql,
                new BeanListHandler<Instrument>(Instrument.class), status);
        DBHelper.close(conn);
        return instruments;
    }

    public long getCountByStatus(boolean status) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from instrument where status=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), status);
        DBHelper.close(conn);
        return data.longValue();
    }

}
