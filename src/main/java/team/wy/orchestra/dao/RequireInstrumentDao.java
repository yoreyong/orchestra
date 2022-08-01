package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.RequireInstrument;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: RequireInstrumentDao
 * @description:
 * @author: YORE
 * @date: 2022/7/30
 **/
public class RequireInstrumentDao {

    QueryRunner runner = new QueryRunner();

    public int add (long settingNum, long MWorkNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into `require` (settingNum, MWorkNum) values (?, ?);";
        int count = runner.update(conn, sql, settingNum, MWorkNum);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from `require` where id=?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, long settingNum, long MWorkNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update `require` set settingNum=?, MWorkNum=? where id=?";
        int count = runner.update(conn, sql, settingNum, MWorkNum, id);
        DBHelper.close(conn);
        return count;
    }

    public List<RequireInstrument> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from `require`";
        List<RequireInstrument> requires = runner.query(conn, sql, new BeanListHandler<RequireInstrument>(RequireInstrument.class));
        DBHelper.close(conn);
        return requires;
    }

    public RequireInstrument getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from `require` where id = ?";
        RequireInstrument require = runner.query(conn, sql, new BeanHandler<RequireInstrument>(RequireInstrument.class), id);
        DBHelper.close(conn);
        return require;
    }

    public long getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from `require`";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.longValue();
    }

    public List<RequireInstrument> getByInstrument(long settingNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from `require` where settingNum=?";
        List<RequireInstrument> requires = runner.query(conn, sql, new BeanListHandler<RequireInstrument>(RequireInstrument.class), settingNum);
        DBHelper.close(conn);
        return requires;
    }

    public long getCountByInstrument(long settingNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from `require` where settingNum=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), settingNum);
        DBHelper.close(conn);
        return data.longValue();
    }

    public  List<RequireInstrument> getByMusicalWork(long MWorkNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from `require` where MWorkNum=?";
        List<RequireInstrument> requires = runner.query(conn, sql, new BeanListHandler<RequireInstrument>(RequireInstrument.class), MWorkNum);
        DBHelper.close(conn);
        return requires;
    }

    public long getCountByMusicalWork(long MWorkNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from `require` where MWorkNum=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), MWorkNum);
        DBHelper.close(conn);
        return data.longValue();
    }

}
