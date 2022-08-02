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
            customer = new CustomerBiz().getCustomerByid(id);
            System.out.println(customer);

        }

    @Test
    public void getCustomersByUsernameTest() {
        String username = "kmerck1";
        List<Customer> customers = null;
        customers = new CustomerBiz().getCustomersByUsername(username);
        System.out.println(customers.size());
        for(Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void addTest() {
        int count = 0;
        count = new CustomerBiz().add("test1", "juju",
                "Wilton", "juju@gmail.com", "6235 candletree ln",
                "713-981-8035");
        System.out.println(count);
    }

    @Test
    public void removeTest() {
        int count = 0;
        count = new CustomerBiz().remove(4);
        System.out.println(count);
    }

    @Test
    public void modifyTest() {
        int count = 0;
        count = new CustomerBiz().modify(1, "austin",
                "filed","austinfield@gmail.com", "1234 plano road",
                "469-889-9867");
        System.out.println(count);
    }

    @Test
    public void getCustomersByPageTest() {
        List<Customer> customers = null;
        customers = new CustomerBiz().getCustomersByPage(1, 2);
        System.out.println(customers.size());
        for(Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void getCustomerPageCountTest() {
        int number = 0;
        number = new CustomerBiz().getCustomerPageCount(1);
        System.out.println(number);
    }

}



