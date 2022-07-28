package team.wy.orchestra.biz;

import team.wy.orchestra.bean.PrivateParty;
import team.wy.orchestra.dao.PrivatePartyDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: PrivatePartyBiz
 * @description: TODO 类描述
 * @author: YORE
 * @date: 2022/7/28
 **/
public class PrivatePartyBiz {

    PrivatePartyDao privatePartyDao = new PrivatePartyDao();

    public int add (long condId, String theme) {
        int count = 0;
        try {
            count = privatePartyDao.add(condId, theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int remove(long id) {
        int count = 0;
        try {
            count = privatePartyDao.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int modify(long id, long conId, String theme) {
        int count = 0;
        try {
            count = privatePartyDao.modify(id, conId, theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<PrivateParty> getByPage(int pageIndex, int pageSize) {

    }


    public int getPageCount(int pageSize)

    public PrivateParty getById(int id)


    public List<PrivateParty> getByTheme(String theme)


}
