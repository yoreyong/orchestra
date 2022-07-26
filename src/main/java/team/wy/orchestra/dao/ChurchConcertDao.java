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


    /**
     *
     * @param id
     * @param conId
     * @param churchName
     * @return
     * @throws SQLException
     */
    public int add(long conId, String churchName) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into churchconcert(id, conId, churchName) values(null, ?, ?)";
        int count = runner.update(conn, sql, conId, churchName);
        conn.close();
        return count;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from churchconcert where id = ?";
        int count = runner.update(conn, sql, id);
        conn.close();
        return count;
    }

    /**
     *
     * @param id
     * @param conId
     * @param churchName
     * @return count
     * @throws SQLException
     */
    public int modify(long id, long conId, String churchName) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update churchconcert set conId = ?, churchName = ? where id=?";
        int count = runner.update(conn, sql, id, conId, churchName);
        conn.close();
        return count;
    }


    /**
     * 根据ID获取Church concert信息
     * @param id -
     * @return Church concert class
     * @throws SQLException
     */
    public ChurchConcert getChurchConcertById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from churchconcert where id = ?";
        ChurchConcert churchConcert = runner.query(conn, sql, new BeanHandler<>(ChurchConcert.class), id);
        conn.close();
        return churchConcert;
    }

    /**
     * 获取全部Church concert信息
     * @return - list of church concerts
     * @throws SQLException
     */
    public List<ChurchConcert> getAllChurchConcert() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from churchconcert";
        List<ChurchConcert> churchConcerts = runner.query(conn, sql, new BeanListHandler<>(ChurchConcert.class));
        conn.close();
        return churchConcerts;
    }

    /**
     * 通过church Name来获取church concert信息，注意：可能会返回多个信息，因此使用List
     * @param churchName
     * @return
     * @throws SQLException
     */
    public List<ChurchConcert> getAllChurchConcertByChurchName(String churchName) throws SQLException {
        Connection conn  = DBHelper.getConnection();
        String sql = "select * from churchconcert where churchName = ?";
        List<ChurchConcert> churchConcerts = runner.query(conn, sql, new BeanListHandler<ChurchConcert>(ChurchConcert.class), churchName);
        conn.close();
        return churchConcerts;
    }
}
