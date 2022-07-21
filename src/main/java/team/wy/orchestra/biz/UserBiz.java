package team.wy.orchestra.biz;

import team.wy.orchestra.bean.User;
import team.wy.orchestra.dao.UserDao;

import java.sql.SQLException;

/**
 * @className: UserBiz
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/11
 **/
public class UserBiz {

    UserDao userDao = new UserDao();

    public User getUser(String name, String pwd) {
        User user = null;
        try {
            user  = userDao.getUser(name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int modifyPwd(long id, String pwd) {
        int count = 0;
        try {
            count = userDao.modifyPwd(id, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

}
