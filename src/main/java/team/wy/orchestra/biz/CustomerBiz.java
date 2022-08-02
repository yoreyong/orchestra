package team.wy.orchestra.biz;

import team.wy.orchestra.bean.Customer;
import team.wy.orchestra.dao.CustomerDao;

import java.sql.SQLException;
import java.util.List;

public class CustomerBiz {
    CustomerDao CustomerDao = new CustomerDao();

    /**
     *
     * @param id
     * @return Customer
     */

    public Customer getCustomerByid(long id) {
        try {
            return CustomerDao.getCustomerByid(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * getCustomersByusername
     * @param username
     * @return List<Customer> Customers
     */
    public List<Customer> getCustomersByUsername(String username) {
        try {
            return CustomerDao.getCustomersByusername(username);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Add a new Customer.
     * @param
     * @return count - 1:success, 0:failed
     */
    public int add(String username, String fname, String lname, String email,String address, String phoneNum) {
        int count = 0;
        try {
            count = CustomerDao.add(username, fname, lname, email,address,
                     phoneNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Add a new Customer.
     * @param customer - class Customer
     * @return count - 1:success, 0:failed
     */
    public int add(Customer customer) {
        int count = 0;
        try {
            count = CustomerDao.add(customer.getUsername(), customer.getFname(),
                    customer.getLname(), customer.getEmail(),customer.getAddress(), customer.getPhoneNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Remove a Customer from database.
     * @param id - id number
     * @return count - 1:success, 0:failed
     */
    public int remove(long id) {
        int count = 0;
        try {
            // TODO - 增加FK检测功能，若存在外键，则不能阐述
            // 最好能返回页面提示 throw new exception
            count = CustomerDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @param
     * @return count - 1:success, 0:failed
     */
    public int modify(long id, String fname, String lname, String email, String address,
                      String phoneNum) {
        int count = 0;
        try {
            count = CustomerDao.modify(id, fname, lname, email, address, phoneNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     *
     * @param customer
     * @return
     */
    public int modify(Customer customer) {
        int count = 0;
        try {
            count = CustomerDao.modify(customer.getId(), customer.getFname(),
                    customer.getLname(), customer.getEmail(),customer.getAddress(),
                    customer.getPhoneNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * TODO - 后面可能还要增加指向User的Foreign key实体
     * @param pageIndex -
     * @param pageSize -
     * @return - List<Customer> Customers
     */
    public List<Customer> getCustomersByPage(int pageIndex, int pageSize) {
        List<Customer> Customers = null;
        try {
            Customers = CustomerDao.getCustomersByPage(pageIndex, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Customers;
    }

    /**
     * Get page numbers based on row number
     * @param pageSize -
     * @return pageCount - number of pages
     */
    public int getCustomerPageCount(int pageSize) {
        int pageCount = 0;
        try {
            int rowCount = CustomerDao.getCustomerCount();
            pageCount = (rowCount - 1) / pageSize + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageCount;
    }

}
