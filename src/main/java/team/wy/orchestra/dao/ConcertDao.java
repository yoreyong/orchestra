package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @className: ConcertDao
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/18
 **/
public class ConcertDao {
    QueryRunner runner = new QueryRunner();

    /**
     *
     * @param id
     * @return
     */
    public Concert getConcertById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from concert where id = ?";
        Concert concert = runner.query(conn, sql, new BeanHandler<Concert>(Concert.class), id);
        conn.close();
        return concert;
    }

}
