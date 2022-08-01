package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.ChurchConcert;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: ChurchConcertDao
 * @description: Church Concert Dao
 * @author: YORE
 * @date: 2022/7/25
 **/
public class ChurchConcertDao {

    QueryRunner runner = new QueryRunner();

    public int add(long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into churchconcert(id, conId) values(null, ?)";
        int count = runner.update(conn, sql, conId);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from churchconcert where id = ?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update churchconcert set conId = ? where id=?";
        int count = runner.update(conn, sql, conId, id);
        DBHelper.close(conn);
        return count;
    }

    public List<ChurchConcert> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from churchconcert";
        List<ChurchConcert> churchConcerts = runner.query(conn, sql,
                new BeanListHandler<ChurchConcert>(ChurchConcert.class));
        DBHelper.close(conn);
        return churchConcerts;
    }

    public ChurchConcert getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from churchconcert where id = ?";
        ChurchConcert churchConcert = runner.query(conn, sql,
                new BeanHandler<ChurchConcert>(ChurchConcert.class), id);
        DBHelper.close(conn);
        return churchConcert;
    }

    public List<ChurchConcert> getByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from churchconcert limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<ChurchConcert> churchConcerts = runner.query(conn, sql,
                new BeanListHandler<ChurchConcert>(ChurchConcert.class), offset, pageSize);
        DBHelper.close(conn);
        return churchConcerts;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from churchconcert";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.intValue();
    }
}
