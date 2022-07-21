package team.wy.orchestra.biz;

import org.junit.Test;
import team.wy.orchestra.bean.User;

import java.util.List;

/**
 * @className: UserBizTest
 * @description: UserBiz Unit test
 * @author: YORE
 * @date: 2022/7/16
 **/
public class UserBizTest {

    @Test
    public void getAllTest() {
        User user = new UserBiz().getUser("super", "123");
        System.out.println(user);
    }

    @Test
    public void modifyPwdTest() {
        int count = new UserBiz().modifyPwd(1, "123456");
        System.out.println(count);
    }

}
