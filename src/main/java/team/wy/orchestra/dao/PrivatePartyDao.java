package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.PrivateParty;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: PrivatePartyDao
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class PrivatePartyDao {

    QueryRunner runner = new QueryRunner();

    public int add (long condId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into privateParty(conId) values(?)";
        int count = runner.update(conn, sql, condId);
        conn.close();
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from privateParty where id=?";
        int count = runner.update(conn, sql, id);
        conn.close();
        return count;
    }

    public int modify(long id, long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update privateParty set conId=? where id=?";
        int count = runner.update(conn, sql, conId, id);
        conn.close();
        return count;
    }

    public List<PrivateParty> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from privateParty";
        List<PrivateParty> privateParties = runner.query(conn, sql, new BeanListHandler<PrivateParty>(PrivateParty.class));
        conn.close();
        return privateParties;
    }

    public PrivateParty getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from privateParty where id = ?";
        PrivateParty privateParty = runner.query(conn, sql, new BeanHandler<PrivateParty>(PrivateParty.class), id);
        conn.close();
        return privateParty;
    }

    public List<PrivateParty> getByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from privateParty limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<PrivateParty> privateParties = runner.query(conn, sql,
                new BeanListHandler<PrivateParty>(PrivateParty.class), offset, pageSize);
        conn.close();
        return privateParties;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from privateParty";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        conn.close();
        return data.intValue();
    }
}
