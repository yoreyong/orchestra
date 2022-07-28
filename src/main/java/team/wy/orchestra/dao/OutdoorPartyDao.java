package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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

    public int add(long conId, String type) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into outdoorParty(id, conId, type) values(null, ?, ?)";
        int count = runner.update(conn, sql, conId, type);
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

    public int modify(long id, long conId, String type) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update outdoorParty set conId = ?, type = ? where id=?";
        int count = runner.update(conn, sql, conId, type, id);
        conn.close();
        return count;
    }

    public List<OutdoorPartyDao> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from outdoorParty";
        List<OutdoorPartyDao> outdoorParties = runner.query(conn, sql,
                new BeanListHandler<OutdoorPartyDao>(OutdoorPartyDao.class));
        conn.close();
        return outdoorParties;
    }

    public OutdoorPartyDao getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from outdoorParty where id = ?";
        OutdoorPartyDao outdoorParty = runner.query(conn, sql,
                new BeanHandler<OutdoorPartyDao>(OutdoorPartyDao.class), id);
        conn.close();
        return outdoorParty;
    }

    public List<OutdoorPartyDao> getByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from outdoorParty limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<OutdoorPartyDao> outdoorParties = runner.query(conn, sql,
                new BeanListHandler<OutdoorPartyDao>(OutdoorPartyDao.class), offset, pageSize);
        conn.close();
        return outdoorParties;
    }

    public List<OutdoorPartyDao> getByChurchName(String churchName) throws SQLException {
        Connection conn  = DBHelper.getConnection();
        String sql = "select * from outdoorParty where churchName = ?";
        List<OutdoorPartyDao> outdoorParties = runner.query(conn, sql,
                new BeanListHandler<OutdoorPartyDao>(OutdoorPartyDao.class), churchName);
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
