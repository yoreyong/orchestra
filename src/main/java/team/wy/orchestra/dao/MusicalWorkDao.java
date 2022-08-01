package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.MusicalWork;
import team.wy.orchestra.util.DBHelper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicalWorkDao
 * @description:
 * @author: YORE
 * @date: 2022/7/25
 **/
public class MusicalWorkDao implements Serializable {

    QueryRunner runner = new QueryRunner();

    /**
     *
     * @param
     * @return
     * @throws SQLException
     */
    public int add(String name, String author, String desc, long typeId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into musicalwork(id, `name`, author, `desc`, typeId) values(null, ?, ?, ?, ?)";
        int count = runner.update(conn, sql, name, author, desc, typeId);
        DBHelper.close(conn);
        return count;
    }

    /**
     * Delete by id
     * @param id -
     * @return count -
     * @throws SQLException
     */
    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from musicalwork where id = ?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    /**
     *
     * @param
     * @return
     * @throws SQLException
     */
    public int modify(long id, String name, String author, String desc, long typeId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update musicalwork set `name` = ?, author = ?, `desc` = ?, typeId = ? where id=?";
        int count = runner.update(conn, sql, name, author, desc, typeId, id);
        DBHelper.close(conn);
        return count;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public MusicalWork getMusicalWorkById(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musicalwork where id = ?";
        MusicalWork musicalWork = runner.query(conn, sql, new BeanHandler<MusicalWork>(MusicalWork.class), id);
        DBHelper.close(conn);
        return musicalWork;
    }

    /**
     * Query musical work by page
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<MusicalWork> getMusicalWorkByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musicalwork limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<MusicalWork> musicalWorks = runner.query(conn, sql, new BeanListHandler<MusicalWork>(MusicalWork.class), offset, pageSize);
        DBHelper.close(conn);
        return musicalWorks;
    }

    /**
     * 获取Musical Work中元素的数量
     * @return
     * @throws SQLException
     */
    public int getMusicalWorkCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from musicalwork";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        DBHelper.close(conn);
        return data.intValue();
    }

    /**
     * Query musical work by name,
     * since there could be musical works with a same name,
     * return a List of musical work
     * @param name
     * @return
     * @throws SQLException
     */
    public List<MusicalWork> getMusicalWorkByName(String name) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musicalwork where name = ?";
        List<MusicalWork> musicalWorks = runner.query(conn, sql, new BeanListHandler<MusicalWork>(MusicalWork.class), name);
        DBHelper.close(conn);
        return musicalWorks;
    }


    public List<MusicalWork> getMusicalWorkByAuthor(String author) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from musicalwork where author = ?";
        List<MusicalWork> musicalWorks = runner.query(conn, sql, new BeanListHandler<MusicalWork>(MusicalWork.class), author);
        DBHelper.close(conn);
        return musicalWorks;
    }

}
