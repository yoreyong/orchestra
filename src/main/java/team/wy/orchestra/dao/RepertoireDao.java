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
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from repertoire where id = ?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, long concertId, long musicalWorkId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update repertoire set concertId = ?, musicalWorkId = ? where id=?";
        int count = runner.update(conn, sql, concertId, musicalWorkId, id);
        DBHelper.close(conn);
        return count;
    }

    public List<Repertoire> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire";
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class));
        DBHelper.close(conn);
        return repertoires;
    }

    public List<Repertoire> getByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class), offset, pageSize);
        DBHelper.close(conn);
        return repertoires;
    }

    public List<Repertoire> getByPageAndConId(int pageIndex, int pageSize, long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire where concertId=? limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class), conId, offset, pageSize);
        DBHelper.close(conn);
        return repertoires;
    }

    public Repertoire getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire where id = ?";
        Repertoire repertoire = runner.query(conn, sql, new BeanHandler<Repertoire>(Repertoire.class), id);
        DBHelper.close(conn);
        return repertoire;
    }

    public List<Repertoire> getByConcertId(long concertId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire where concertId = ?";
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class), concertId);
        DBHelper.close(conn);
        return repertoires;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from repertoire";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.intValue();
    }

    public  List<Repertoire> getByConId(long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from repertoire where concertId=?";
        List<Repertoire> repertoires = runner.query(conn, sql, new BeanListHandler<Repertoire>(Repertoire.class), conId);
        DBHelper.close(conn);
        return repertoires;
    }

    public long getCountByConId(long conId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from repertoire where concertId=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), conId);
        DBHelper.close(conn);
        return data.longValue();
    }

}
