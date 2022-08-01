package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.wy.orchestra.bean.MusicalWorkType;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: MusicalTypeDao
 * @description:
 * @author: YORE
 * @date: 2022/7/26
 **/
public class MusicalWorkTypeDao {

    QueryRunner runner = new QueryRunner();

    public int add(String name, long parentId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert musicalworktype values (null, ?, ?)";
        int count = runner.update(conn, sql, name, parentId);
        DBHelper.close(conn);
        return count;
    }

    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from musicalworktype where id=?";
        int count = runner.update(conn, sql, id);
        DBHelper.close(conn);
        return count;
    }

    public int modify(long id, String name, long parentId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update musicalworktype set name=?, parentId=? where id=?";
        int count = runner.update(conn, sql, name, parentId, id);
        DBHelper.close(conn);
        return count;
    }

    public List<MusicalWorkType> getAllTypes() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select id,`name`,parentId from musicalworktype";
        List<MusicalWorkType> musicalWorkTypes = runner.query(conn, sql, new BeanListHandler<MusicalWorkType>(MusicalWorkType.class));
        DBHelper.close(conn);
        return musicalWorkTypes;
    }

    public MusicalWorkType getTypeById(long typeId) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select id,`name`,parentId from musicalworktype where id=?";
        MusicalWorkType musicalWorkType = runner.query(conn, sql, new BeanHandler<MusicalWorkType>(MusicalWorkType.class), typeId);
        DBHelper.close(conn);
        return musicalWorkType;
    }

}
