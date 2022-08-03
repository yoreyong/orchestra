package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.PlaysInstr;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicianPlaysInstrDao
 * @description:
 * @author: YORE
 * @date: 2022/7/31
 **/
public class PlaysInstrDao {

    QueryRunner runner = new QueryRunner();

    public int add(String SSN, long instrNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into plays(SSN, instrNum) values(?, ?)";
        int count = runner.update(conn, sql, SSN, instrNum);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from plays where id=?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, String SSN, long instrNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update plays set SSN=?, instrNum=? where id=?";
        int count = runner.update(conn, sql, SSN, instrNum, id);
        DBHelper.close(conn);
        return count;
    }

    public List<PlaysInstr> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from plays";
        List<PlaysInstr> playsInstrs = runner.query(conn, sql, new BeanListHandler<PlaysInstr>(PlaysInstr.class));
        DBHelper.close(conn);
        return playsInstrs;
    }

    public PlaysInstr getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from plays where id = ?";
        PlaysInstr playsInstr = runner.query(conn, sql, new BeanHandler<PlaysInstr>(PlaysInstr.class), id);
        DBHelper.close(conn);
        return playsInstr;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from plays";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.intValue();
    }

    public List<PlaysInstr> getBySSN(String SSN) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from plays where SSN=?";
        List<PlaysInstr> playsInstrs = runner.query(conn, sql, new BeanListHandler<PlaysInstr>(PlaysInstr.class), SSN);
        DBHelper.close(conn);
        return playsInstrs;
    }

    public long getCountBySSN(String SSN) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from plays where SSN=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), SSN);
        DBHelper.close(conn);
        return data.longValue();
    }

    public List<PlaysInstr> getByInstrNum(long instrNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from plays where instrNum=?";
        List<PlaysInstr> playsInstrs = runner.query(conn, sql, new BeanListHandler<PlaysInstr>(PlaysInstr.class), instrNum);
        DBHelper.close(conn);
        return playsInstrs;
    }

    public long getCountByInstrNum(long instrNum) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from plays where instrNum=?";
        Number data = runner.query(conn, sql, new ScalarHandler<>(), instrNum);
        DBHelper.close(conn);
        return data.longValue();
    }

}
