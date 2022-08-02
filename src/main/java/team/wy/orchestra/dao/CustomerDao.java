package team.wy.orchestra.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.wy.orchestra.bean.Customer;
import team.wy.orchestra.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerDao {
    QueryRunner runner = new QueryRunner();


    /**
     * Get customer Info by id
     * @param id - customer id
     * @return Customer Info
     * @throws SQLException
     */
    public Customer getCustomerByid(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from Customer where id=?";
        Customer Customer = runner.query(conn, sql, new BeanHandler<Customer>(Customer.class), id);
        conn.close();
        return Customer;
    }

    /**
     * Get Customer Info by gender
     * @param username
     * @return List of Customer
     * @throws SQLException
     */
    public List<Customer> getCustomersByusername(String username) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from Customer where username=?";
        List<Customer> Customers = runner.query(conn, sql, new BeanListHandler<Customer>(Customer.class), username);
        conn.close();
        return Customers;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int add(String username, String fname, String lname, String email,String address, String phoneNum
                    ) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "insert into Customer(username, fname, lname, email, address, phoneNum) " +
                "values( ?, ?, ?, ?, ?, ?)";
        int count = runner.update(conn, sql, username, fname, lname, email, address, phoneNum);
        conn.close();
        return count;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int remove(long id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "delete from Customer where id=?";
        int count = runner.update(conn, sql, id);
        conn.close();
        return count;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public int modify(long id, String fname, String lname, String email, String address, String phoneNum
                         ) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "update Customer set fname=?, lname=?, email=?, address=?, phoneNum=? " +
                "where id=?";
        int count = runner.update(conn, sql, fname, lname, email, address,phoneNum,id);
        conn.close();
        return count;
    }

    /**
     * Get Customer Info by pages
     * @param pageIndex - page index, start from 1
     * @param pageSize - rows shown in one page
     * @return
     * @throws SQLException
     */
    public List<Customer> getCustomersByPage(int pageIndex, int pageSize) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select * from Customer limit ?, ?";
        int offset = (pageIndex - 1) * pageSize;
        List<Customer> Customers = runner.query(conn, sql, new BeanListHandler<Customer>(Customer.class), offset, pageSize);
        conn.close();
        return Customers;
    }

    /**
     * Get number of Customers
     * @return
     * @throws SQLException
     */
    public int getCustomerCount() throws SQLException {
        Connection conn = DBHelper.getConnection();
        String sql = "select count(*) from Customer";
        Number data = runner.query(conn, sql, new ScalarHandler<>());
        conn.close();
        return data.intValue();
    }

}

