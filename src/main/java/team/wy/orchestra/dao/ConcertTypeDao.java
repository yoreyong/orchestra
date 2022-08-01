package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.wy.orchestra.bean.ConcertType;
import team.wy.orchestra.util.DBHelper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: ConcertTypeDao
 * @description:
 * @author: YORE
 * @date: 2022/7/28
 **/
public class ConcertTypeDao implements Serializable {

    QueryRunner runner = new QueryRunner();

    public int add(String name, long parentId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert concerttype values (null, ?, ?)";
        int count = runner.update(conn, sql, name, parentId);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from concerttype where id=?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, String name, long parentId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update concerttype set name=?, parentId=? where id=?";
        int count = runner.update(conn, sql, name, parentId, id);
        DBHelper.close(conn);
        return count;
    }

    public List<ConcertType> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select id,name,parentId from concerttype";
        List<ConcertType> types = runner.query(conn, sql, new BeanListHandler<ConcertType>(ConcertType.class));
        DBHelper.close(conn);
        return types;
    }

    public ConcertType getById(long typeId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select id,name,parentId from concerttype where id=?";
        ConcertType type = runner.query(conn, sql, new BeanHandler<ConcertType>(ConcertType.class), typeId);
        DBHelper.close(conn);
        return type;
    }
}
