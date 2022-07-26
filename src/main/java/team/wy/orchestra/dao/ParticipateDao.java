package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.Participate;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: ParticipateDao
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class ParticipateDao {

    QueryRunner runner = new QueryRunner();

    public int add (String SSN, long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into participate(SSN, conId) values(?, ?)";
        int count = runner.update(conn, sql, SSN, conId);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from participate where id=?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, String SSN, long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update participate set SSN=?, conId=? where id=?";
        int count = runner.update(conn, sql, SSN, conId, id);
        DBHelper.close(conn);
        return count;
    }

    public List<Participate> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from participate";
        List<Participate> participates = runner.query(conn, sql, new BeanListHandler<Participate>(Participate.class));
        DBHelper.close(conn);
        return participates;
    }

    public Participate getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from participate where id = ?";
        Participate participate = runner.query(conn, sql, new BeanHandler<Participate>(Participate.class), id);
        DBHelper.close(conn);
        return participate;
    }

    public long getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from participate";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.longValue();
    }

    public List<Participate> getBySSN(String SSN) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from participate where SSN=?";
        List<Participate> participates = runner.query(conn, sql, new BeanListHandler<Participate>(Participate.class), SSN);
        DBHelper.close(conn);
        return participates;
    }

    public long getCountBySSN(String SSN) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from participate where SSN=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), SSN);
        DBHelper.close(conn);
        return data.longValue();
    }

    public  List<Participate> getByConId(long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from participate where conId=?";
        List<Participate> participates = runner.query(conn, sql, new BeanListHandler<Participate>(Participate.class), conId);
        DBHelper.close(conn);
        return participates;
    }

    public long getCountByConId(long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from participate where conId=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), conId);
        DBHelper.close(conn);
        return data.longValue();
    }

}
