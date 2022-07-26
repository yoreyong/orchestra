package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.Musician;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicianDao
 * @description: Musician Class
 * @author: YORE
 * @date: 2022/7/17
 **/
public class MusicianDao {
    QueryRunner runner = new QueryRunner();


    /**
     * Get musician Info by SSN
     * @param SSN - musician SSN
     * @return musician Info
     * @throws SQLException
     */
    public Musician getMusicianBySSN(String SSN) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musician where SSN=?";
        Musician musician = runner.query(conn, sql, new BeanHandler<Musician>(Musician.class), SSN);
        conn.close();
        return musician;
    }

    /**
     * Get musician Info by gender
     * @param gender
     * @return List of musician
     * @throws SQLException
     */
    public List<Musician> getMusiciansByGender(String gender) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musician where gender=?";
        List<Musician> musicians = runner.query(conn, sql, new BeanListHandler<Musician>(Musician.class), gender);
        conn.close();
        return musicians;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int add(String SSN, long accountId, String fname, String lname, String gender, String phoneNum,
                   String state, String city, String address,  String zip, String pic) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into musician(SSN, accountId, fname, lname, gender, phoneNum, `state`, city, address, zip, pic) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int count = runner.update(conn, sql, SSN, accountId, fname, lname, gender, phoneNum, state, city, address, zip, pic);
        conn.close();
        return count;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int remove(String SSN) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from musician where SSN=?";
        int count = runner.update(conn, sql, SSN);
        conn.close();
        return count;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int modify(String SSN, long accountId, String fname, String lname, String gender, String phoneNum,
                      String state, String city, String address,  String zip, String pic) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update musician set accountId=?, fname=?, lname=?, gender=?, phoneNum=?, " +
                "`state`=?, city=?, address=?,  zip=?, pic=? where SSN=?";
        int count = runner.update(conn, sql, accountId, fname, lname, gender, phoneNum, state, city, address, zip, pic, SSN);
        conn.close();
        return count;
    }

    /**
     * Get musician Info by pages
     * @param pageIndex - page index, start from 1
     * @param pageSize - rows shown in one page
     * @return
     * @throws SQLException
     */
    public List<Musician> getMusiciansByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musician limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<Musician> musicians = runner.query(conn, sql, new BeanListHandler<Musician>(Musician.class), offset, pageSize);
        conn.close();
        return musicians;
    }

    /**
     * Get number of musicians
     * @return
     * @throws SQLException
     */
    public int getMusicianCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from musician";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        conn.close();
        return data.intValue();
    }

}
