package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.Customer;
import team.wy.orchestra.dao.CustomerDao;


import java.sql.SQLException;
import java.util.List;
public class CustomerBizTest {
    @Test
    public void getCustomerByidTest() {
            long id = 1;
            Customer customer = null;
            try {
                customer = new CustomerBiz().getCustomerByid(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(customer);

        }

    @Test
    public void getCustomersByUsernameTest() {
        String username = "kmerck1";
        List<Customer> customers = null;
        try {
            customers = new CustomerBiz().getCustomersByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(customers.size());
        for(Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void addTest() {
        int count = 0;
        try {
            count = new CustomerBiz().add("test1", "juju",
                    "Wilton", "juju@gmail.com", "6235 candletree ln",
                    "713-981-8035");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = 0;
        try {
            count = new CustomerBiz().remove(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = 0;
        try {
            count = new CustomerBiz().modify(1, "austin",
                    "filed","austinfield@gmail.com", "1234 plano road",
                    "469-889-9867");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    @Test
    public void getCustomersByPageTest() {
        List<Customer> customers = null;
        try {
            customers = new CustomerBiz().getCustomersByPage(1, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(customers.size());
        for(Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void getCustomerPageCountTest() {
        int number = 0;
        try {
            number = new CustomerBiz().getCustomerPageCount(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }

}



