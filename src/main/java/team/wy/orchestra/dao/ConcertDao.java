package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.Concert;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * @className: ConcertDao
 * @description:
 * @author: YORE
 * @date: 2022/7/18
 **/
public class ConcertDao {
    QueryRunner runner = new QueryRunner();

    public int add(String concertName, String place, String concertDate, String startTime,
                   String desc, long typeId, double price) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into concert(concert_name, place, concert_date, start_time, description, typeId, price) " +
                "values(?, ?, ?, ?, ?, ?, ?)";
        int count = runner.update(conn, sql, concertName, place, Date.valueOf(concertDate),
                Time.valueOf(startTime), desc, typeId, price);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from concert where id=?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, String concertName, String place, String concertDate, String startTime,
                      String desc, long typeId, double price) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update concert set concert_name=?, place=?, concert_date=?, start_time=?, description=?, " +
                "typeId=?, price=? where id=?";
        int count = runner.update(conn, sql, concertName, place, Date.valueOf(concertDate),
                Time.valueOf(startTime), desc, typeId, price, id);
        DBHelper.close(conn);
        return count;
    }

    public List<Concert> getByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from concert limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<Concert> concerts = runner.query(conn, sql, new BeanListHandler<Concert>(Concert.class), offset, pageSize);
        DBHelper.close(conn);
        return concerts;
    }

    public Concert getById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from concert where id = ?";
        Concert concert = runner.query(conn, sql, new BeanHandler<Concert>(Concert.class), id);
        DBHelper.close(conn);
        return concert;
    }

    public int getCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(id) from concert";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.intValue();
    }

    public List<Concert> getByName(String concertName) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from concert where concert_name=?";
        List<Concert> concerts = runner.query(conn, sql, new BeanListHandler<Concert>(Concert.class), concertName);
        DBHelper.close(conn);
        return concerts;
    }

    public List<Concert> getByTypeId(long typeId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from concert where typeId=?";
        List<Concert> concerts = runner.query(conn, sql, new BeanListHandler<Concert>(Concert.class), typeId);
        DBHelper.close(conn);
        return concerts;
    }

}
