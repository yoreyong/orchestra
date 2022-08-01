package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import team.wy.orchestra.bean.User;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @className: UserDao
 * @description: 用户表的数据操作对象
 * @author: YORE
 * @date: 2022/7/11
 **/
public class UserDao {

    QueryRunner runner = new QueryRunner();

    public User getUser(String name, String pwd) throws SQLException {

         // 创建QueryRunner对象getUser方法：
         // 1. 调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
         // 2. 准备执行SQL语句
        String sql = "select * from user where name = ? and pwd = ? and state = 1";
         // 3. 调用查询方法，将查询的数据封装成User对象
        User user = runner.query(conn, sql, new BeanHandler<User>(User.class), name, pwd);
        // 4. 关闭连接对象
        DBHelper.close(conn);
         // 5. 返回user
        return user;
    }


    /**
     * 修改密码
     * @param id    需要修改密码的用户编号
     * @param pwd   新的密码
     * @return 修改的数据行
     */
    public int modifyPwd(long id, String pwd) throws SQLException {
        String sql = "update user set pwd=? where id=?";
        Connection conn = DBHelper.getConnection();
        int count = runner.update(conn, sql, pwd, id);
        DBHelper.close(conn);

        return count;
    }

}
