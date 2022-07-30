package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.Repertoire;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: RepertoireDao
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/30
 **/
public class RepertoireDao {

    QueryRunner runner = new QueryRunner();

    public int add(long concertId, long musicalWorkId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into repertoire(id, concertId, musicalWorkId) values(null, ?, ?)";
        int count = runner.update(conn, sql, concertId, musicalWorkId);
        conn.close();
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from repertoire where id = ?";
        int count = runner.update(conn, sql, id);
        conn.close();
        return count;
    }

    public int modify(long id, long concertId, long musicalWorkId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update repertoire set concertId = ?, musicalWorkId = ? where id=?";
        int count = runner.update(conn, sql, concertId, musicalWorkId, id);
        conn.close();
        return count;
    }

    public List<Repertoire> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire";
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class));
        conn.close();
        return repertoires;
    }

    public Repertoire getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire where id = ?";
        Repertoire repertoire = runner.query(conn, sql, new BeanHandler<Repertoire>(Repertoire.class), id);
        conn.close();
        return repertoire;
    }

    public List<Repertoire> getByConcertId(long concertId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire where concertId = ?";
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class), concertId);
        conn.close();
        return repertoires;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from repertoire";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        conn.close();
        return data.intValue();
    }

}
