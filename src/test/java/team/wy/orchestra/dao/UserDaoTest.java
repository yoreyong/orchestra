package team.wy.orchestra.dao;

import org.junit.Test;
import team.wy.orchestra.bean.User;

import java.sql.SQLException;

/**
 * @className: UserDaoTest
 * @description: UserDao Unit test
 * @author: YORE
 * @date: 2022/7/11
 **/
public class UserDaoTest {

    @Test
    public void getUserTest() {
        User user = null;
        try {
            user = new UserDao().getUser("super", "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }


    @Test
    public void modifyPwdTest() {
        int count = -1;
        try {
            count = new UserDao().modifyPwd(1, "123");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(count > 0) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

}
