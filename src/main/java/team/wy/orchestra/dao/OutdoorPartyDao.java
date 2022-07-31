package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.OutdoorParty;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: OutdoorParty
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class OutdoorPartyDao {

    QueryRunner runner = new QueryRunner();

    public int add(long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into outdoorParty(id, conId) values(null, ?)";
        int count = runner.update(conn, sql, conId);
        conn.close();
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from outdoorParty where id = ?";
        int count = runner.update(conn, sql, id);
        conn.close();
        return count;
    }

    public int modify(long id, long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update outdoorParty set conId = ? where id=?";
        int count = runner.update(conn, sql, conId, id);
        conn.close();
        return count;
    }

    public List<OutdoorParty> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from outdoorParty";
        List<OutdoorParty> outdoorParties = runner.query(conn, sql,
                new BeanListHandler<OutdoorParty>(OutdoorParty.class));
        conn.close();
        return outdoorParties;
    }

    public OutdoorParty getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from outdoorParty where id = ?";
        OutdoorParty outdoorParty = runner.query(conn, sql,
                new BeanHandler<OutdoorParty>(OutdoorParty.class), id);
        conn.close();
        return outdoorParty;
    }

    public List<OutdoorParty> getByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from outdoorParty limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<OutdoorParty> outdoorParties = runner.query(conn, sql,
                new BeanListHandler<OutdoorParty>(OutdoorParty.class), offset, pageSize);
        conn.close();
        return outdoorParties;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from outdoorParty";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        conn.close();
        return data.intValue();
    }

}
