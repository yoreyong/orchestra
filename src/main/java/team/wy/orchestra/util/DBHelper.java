package team.wy.orchestra.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @className: DBHelper
 * @description: DB utils: geyConnection, close
 * @author: YORE
 * @date: 2022/7/16
 **/
public class DBHelper {
    static ComboPooledDataSource ds = new ComboPooledDataSource("mysql-orchestra");
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * getConnection
     * @return conn
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        if(conn != null) {
            return conn;
        }

        conn = ds.getConnection();
        return conn;
    }

    /**
     *
     * @param conn
     * @param st
     * @param rs
     * @throws SQLException
     */
    public static void close(Connection conn, Statement st, ResultSet rs) throws SQLException {
        Connection tlConn = tl.get();
        if(conn == tlConn) {
            return;
        }

        if(rs != null) {
            rs.close();
        }
        if(st != null) {
            st.close();
        }
        if(conn != null) {
            conn.close();
        }
    }

    /**
     * Close connection
     * @param conn
     * @throws SQLException
     */
    public static void close(Connection conn) throws SQLException {
        Connection tlConn = tl.get();
        if(tlConn == conn) {
            return;
        }

        if(conn != null) {
            conn.close();
        }
    }


    /**
     *
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        Connection conn = tl.get();
        if(conn != null) {
            throw new RuntimeException("事务已启动");
        }
        conn = getConnection();
        tl.set(conn);
        conn.setAutoCommit(false);
    }


    public static void commitTransaction() throws SQLException {
        Connection conn = tl.get();
        if(conn == null) {
            throw new RuntimeException("没有事务，提交失败！");
        }
        conn.commit();
        tl.remove();
        conn.close();
    }


    public static void rollbackTransaction() throws SQLException {
        Connection conn = tl.get();
        if(conn == null) {
            throw new RuntimeException("没有事务，回滚失败!");
        }
        conn.rollback();
        tl.remove();
        conn.close();
    }

    @Test
    public void getConnectTest() {
        try {
            Connection connection = DBHelper.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
